<%-- 
    Document   : crispSet
    Created on : 29 May, 2017, 2:40:19 AM
    Author     : AksHaY
--%>

<%@page import="pep.prop.PhysiochemicalProp"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.Map"%>
<%@page import="psc.util.Util"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="psc.servlet.modal.CrispModal"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <title>Protein Sequence Counting</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/bootstrap.css">
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.js"></script>
    <body>
    <center>
        <%
            try {

                HttpSession ses = request.getSession(false);
                Integer[][] countAminoAcid = ((Integer[][]) ses.getAttribute("COUNT_AMINOACID"));
                int total_len = (Integer) ses.getAttribute("TOTAL_LEN");
                int total_seq = (Integer) ses.getAttribute("TOTAL_SEQ");
                String frqSeq = (String) ses.getAttribute("FREQ_SEQ");

                int iteration = 2;
                List<String> freq = new ArrayList<String>();
                List<String> tmpFreq = new ArrayList<String>();
                CrispModal cm = new CrispModal(frqSeq, total_len, total_seq, countAminoAcid);

                for (int i = 0; i < total_seq; i++) {
                    while (iteration <= frqSeq.split(",").length) {
                        tmpFreq = cm.generateCandidate(iteration);
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

                Map<String, Double> support = cm.getSupport();

                List<String> frqs = new ArrayList<String>();
                String strr[] = Util.printCrispSet(frqSeq, response, freq, support).replace(",","").split(" ");

                for (String s : strr) {
                    if (!frqs.contains(s)) {
                        frqs.add(s);
                    }
                }

                PhysiochemicalProp.printProp((String) ses.getAttribute("FILE_PATH"), response, frqs);
            } catch (Exception e) {
                request.setAttribute("ERROR", "Session Expired");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        %>
        <form action="index.jsp">
            <button type="submit" value="Go to Home" class="btn btn-default">Go to Home</button>
        </form>

    </center>
</body>
</html>
