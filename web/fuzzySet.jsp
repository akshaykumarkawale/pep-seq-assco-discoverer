<%-- 
    Document   : crispSet
    Created on : 29 May, 2017, 2:40:19 AM
    Author     : AksHaY
--%>

<%@page import="pep.prop.PhysiochemicalProp"%>
<%@page import="java.lang.Double"%>
<%@page import="psc.servlet.modal.FuzzyModal"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.Map"%>
<%@page import="psc.util.Util"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="psc.servlet.modal.FuzzyModal"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head><title>Protein Sequence Counting</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="css/bootstrap.css">
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.js"></script></head>
    <body>
    <center>
        <%

            try {
                HttpSession ses = request.getSession(true);
                DecimalFormat df = new DecimalFormat("#0.00");
                Double[][] countAminoAcid = ((Double[][]) ses.getAttribute("COUNT_AMINOACID"));
                double total_len = (Double) ses.getAttribute("TOTAL_LEN");
                int total_seq = (Integer) ses.getAttribute("TOTAL_SEQ");
                String frqSeq = (String) ses.getAttribute("FREQ_SEQ");
                //out.println(frqSeq);

                int iteration = 2;
                List<String> freq = new ArrayList<String>();
                List<String> tmpFreq = new ArrayList<String>();
                FuzzyModal fm = new FuzzyModal(frqSeq, total_len, total_seq, countAminoAcid);
                for (int i = 0; i < total_seq; i++) {
                    while (iteration <= frqSeq.split(",").length) {
                        tmpFreq = fm.generateCandidate(iteration);

                        if (tmpFreq.size() == 0) {
                            break;
                        } else {
                            freq.clear();
                            freq = Util.cloneList(tmpFreq);
                        }
                        iteration++;
                    }
                    tmpFreq.clear();
                }

                Map<String, Double> support = fm.getSupport();

                List<String> frqs = new ArrayList<String>();
                String strr[] = Util.printCrispSet(frqSeq, response, freq, support).replace(",","").split(" ");

                for (String s : strr) {
                    if (!frqs.contains(s)) {
                        frqs.add(s);
                    }
                }

                PhysiochemicalProp.printProp((String) ses.getAttribute("FILE_PATH"), response, frqs);
            } catch (Exception e) {
                if (e instanceof NullPointerException) {
                    e.printStackTrace();
                    request.setAttribute("ERROR", "Session Expired");
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }
            }
        %>
        <form action="index.jsp">
            <button type="submit" value="Go to Home" class="btn btn-default">Go to Home</button>
        </form>

    </center>
</body>
</html>
