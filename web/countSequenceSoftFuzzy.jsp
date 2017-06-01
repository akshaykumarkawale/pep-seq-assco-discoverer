<%-- 
    Document   : countSequenceCrisp.jsp
    Created on : 28 May, 2017, 7:39:00 PM
    Author     : AksHaY
--%>

<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="psc.util.ProteinSequences"%>
<%@page import="java.io.File"%>
<%@page import="java.io.FileWriter"%>
<%@page import="psc.util.FastaUtil"%>
<%@page import="psc.util.Util"%>
<%@page import="java.util.Map"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        try {
            HttpSession ses = request.getSession(false);
            List<Integer> totalLenArray = new ArrayList<Integer>();

            Map<String, ProteinSequences> proteinSequence = (Map) ses.getAttribute("PROTEIN_SEQ");

            totalLenArray = Util.getTotalLenArray(proteinSequence);
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
    %>
    <head>
        <title>Protein Sequence Counting</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="css/bootstrap.css">
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.js"></script>
    </head>
    <body>

        <%
                if (lowSeqMap.size() != 0) {
                    Util.printSoftFuzzy("LOW", lowSeqMap, request, response);
                }
                if (midSeqMap.size() != 0) {
                    Util.printSoftFuzzy("MID", midSeqMap, request, response);
                }
                if (highSeqMap.size() != 0) {
                    Util.printSoftFuzzy("HIGH", highSeqMap, request, response);
                }
                ses.setAttribute("TOTAL_SEQ", proteinSequence.size());
                ses.setAttribute("TOTAL_LEN_ARRAY", totalLenArray);
            } catch (Exception e) {
                request.setAttribute("ERROR", "Session Expired");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }

        %>
    <center> <form action="fuzzySoftSet.jsp">
            <button type="submit" title="Calculate Frequent Amino Acid" class="btn btn-primary">Calculate Frequent Sequences</button>
        </form>
    </center>
</body>
</html>
