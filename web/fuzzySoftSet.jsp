<%-- 
    Document   : crispSet
    Created on : 29 May, 2017, 2:40:19 AM
    Author     : AksHaY
--%>

<%@page import="pep.prop.PhysiochemicalProp"%>
<%@page import="psc.servlet.modal.FuzzySoftModal"%>
<%@page import="java.util.HashMap"%>
<%@page import="psc.util.ProteinSequences"%>
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
                Map<String, ProteinSequences> proteinSequence = (Map) ses.getAttribute("PROTEIN_SEQ");
                List<Integer> totalLenArray = (List<Integer>) ses.getAttribute("TOTAL_LEN_ARRAY");
                int low_min = Util.getMinimumValue(totalLenArray);
                int high_max = Util.getMaxmumValue(totalLenArray);
                int low_max = (low_min + high_max) / 3;
                int mid_min = low_max + 1;
                int mid_max = 2 * (mid_min);

                Map<String, ProteinSequences> lowSeqMap = new HashMap<String, ProteinSequences>();
                Map<String, ProteinSequences> midSeqMap = new HashMap<String, ProteinSequences>();
                Map<String, ProteinSequences> highSeqMap = new HashMap<String, ProteinSequences>();

                for (String key : proteinSequence.keySet()) {
                    int len = proteinSequence.get(key).toString().length();
                    if (len >= low_min && len <= low_max) {
                        lowSeqMap.put(key, proteinSequence.get(key));
                    } else if (len >= mid_min && len <= mid_max) {
                        midSeqMap.put(key, proteinSequence.get(key));
                    } else {
                        highSeqMap.put(key, proteinSequence.get(key));
                    }
                }

                if (lowSeqMap.size() != 0) {
                    Map<String, String> res;
                    FuzzySoftModal csm = new FuzzySoftModal(lowSeqMap);
                    res = csm.getResult();
                    Util.printSoftSet(response, res.get("SEQUENCE"), res.get("CONFIDENCE"), res.get("SUPPORT"), "LOW_VALUE_RANGE");
                    List<String> frqs = new ArrayList<String>();
                    String strr[] = res.get("SEQUENCE").replace(",", "").split(" ");

                    for (String s : strr) {
                        if (!frqs.contains(s)) {
                            frqs.add(s);
                        }
                    }

                    PhysiochemicalProp.printProp((String) ses.getAttribute("FILE_PATH"), response, frqs);
                }

                if (midSeqMap.size() != 0) {
                    Map<String, String> res;
                    FuzzySoftModal csm = new FuzzySoftModal(midSeqMap);
                    res = csm.getResult();
                    Util.printSoftSet(response, res.get("SEQUENCE"), res.get("CONFIDENCE"), res.get("SUPPORT"), "MID_VALUE_RANGE");
                    List<String> frqs = new ArrayList<String>();
                    String strr[] = res.get("SEQUENCE").replace(",", "").split(" ");

                    for (String s : strr) {
                        if (!frqs.contains(s)) {
                            frqs.add(s);
                        }
                    }

                    PhysiochemicalProp.printProp((String) ses.getAttribute("FILE_PATH"), response, frqs);
                }

                if (highSeqMap.size() != 0) {
                    Map<String, String> res;
                    FuzzySoftModal csm = new FuzzySoftModal(highSeqMap);
                    res = csm.getResult();
                    Util.printSoftSet(response, res.get("SEQUENCE"), res.get("CONFIDENCE"), res.get("SUPPORT"), "HIGH_VALUE_RANGE");
                    List<String> frqs = new ArrayList<String>();
                    String strr[] = res.get("SEQUENCE").replace(",", "").split(" ");

                    for (String s : strr) {
                        if (!frqs.contains(s)) {
                            frqs.add(s);
                        }
                    }

                    PhysiochemicalProp.printProp((String) ses.getAttribute("FILE_PATH"), response, frqs);
                }
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
