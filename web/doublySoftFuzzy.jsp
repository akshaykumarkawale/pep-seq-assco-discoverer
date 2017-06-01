<%-- 
    Document   : crispSet
    Created on : 29 May, 2017, 2:40:19 AM
    Author     : AksHaY
--%>

<%@page import="psc.servlet.modal.DoublyFuzzySoftModal"%>
<%@page import="psc.servlet.modal.CrispSoftModal"%>
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
                Map<String, ProteinSequences> bundi = (Map) ses.getAttribute("BUNDI");
                Map<String, ProteinSequences> zaire = (Map) ses.getAttribute("ZAIRE");
                Map<String, ProteinSequences> sudan = (Map) ses.getAttribute("SUDAN");
                Map<String, ProteinSequences> tai = (Map) ses.getAttribute("TAI");
                Map<String, ProteinSequences> reston = (Map) ses.getAttribute("RESTON");

                Map<String, ProteinSequences> lowSeqZaire = (Map) ses.getAttribute("LOW_ZAIRE");
                Map<String, ProteinSequences> midSeqZaire = (Map) ses.getAttribute("MID_ZAIRE");
                Map<String, ProteinSequences> highSeqZaire = (Map) ses.getAttribute("HIGH_ZAIRE");
                Map<String, ProteinSequences> lowSeqSudan = (Map) ses.getAttribute("LOW_SUDAN");
                Map<String, ProteinSequences> midSeqSudan = (Map) ses.getAttribute("MID_SUDAN");
                Map<String, ProteinSequences> highSeqSudan = (Map) ses.getAttribute("HIGH_SUDAN");
                Map<String, ProteinSequences> lowSeqReston = (Map) ses.getAttribute("LOW_RESTON");
                Map<String, ProteinSequences> midSeqReston = (Map) ses.getAttribute("MID_RESTON");
                Map<String, ProteinSequences> highSeqReston = (Map) ses.getAttribute("HIGH_RESTON");
                Map<String, ProteinSequences> lowSeqTai = (Map) ses.getAttribute("LOW_TAI");
                Map<String, ProteinSequences> midSeqTai = (Map) ses.getAttribute("MID_TAI");
                Map<String, ProteinSequences> highSeqTai = (Map) ses.getAttribute("HIGH_TAI");
                Map<String, ProteinSequences> lowSeqBundi = (Map) ses.getAttribute("LOW_BUNDI");
                Map<String, ProteinSequences> midSeqBundi = (Map) ses.getAttribute("MID_BUNDI");
                Map<String, ProteinSequences> highSeqBundi = (Map) ses.getAttribute("HIGH_BUNDI");

                String FILE_PATH = (String) ses.getAttribute("FILE_PATH");
                if (zaire.size() != 0) {
                    Util.printCategory("Zaire Ebola Virus", response);
                    if (lowSeqZaire.size() != 0) {
                        DoublyFuzzySoftModal dsm = new DoublyFuzzySoftModal("LOW_VALUE_RANGE", lowSeqZaire);
                        dsm.printResult(FILE_PATH, dsm.getResult(), response);

                    }
                    if (midSeqZaire.size() != 0) {
                        DoublyFuzzySoftModal dsm = new DoublyFuzzySoftModal("MID_VALUE_RANGE", midSeqZaire);
                        dsm.printResult(FILE_PATH, dsm.getResult(), response);

                    }
                    if (highSeqZaire.size() != 0) {
                        DoublyFuzzySoftModal dsm = new DoublyFuzzySoftModal("HIGH_VALUE_RANGE", highSeqZaire);
                        dsm.printResult(FILE_PATH, dsm.getResult(), response);

                    }
                    Util.printDiv(response);
                }

                if (sudan.size() != 0) {
                    Util.printCategory("Sudan Ebola Virus", response);
                    if (lowSeqSudan.size() != 0) {
                        DoublyFuzzySoftModal dsm = new DoublyFuzzySoftModal("LOW_VALUE_RANGE", lowSeqZaire);
                        dsm.printResult(FILE_PATH, dsm.getResult(), response);

                    }
                    if (midSeqSudan.size() != 0) {
                        DoublyFuzzySoftModal dsm = new DoublyFuzzySoftModal("MID_VALUE_RANGE", midSeqZaire);
                        dsm.printResult(FILE_PATH, dsm.getResult(), response);

                    }
                    if (highSeqSudan.size() != 0) {
                        DoublyFuzzySoftModal dsm = new DoublyFuzzySoftModal("HIGH_VALUE_RANGE", highSeqZaire);
                        dsm.printResult(FILE_PATH, dsm.getResult(), response);

                    }
                    Util.printDiv(response);
                }

                if (tai.size() != 0) {
                    Util.printCategory("Tai Forest Ebola Virus", response);
                    if (lowSeqTai.size() != 0) {
                        DoublyFuzzySoftModal dsm = new DoublyFuzzySoftModal("LOW_VALUE_RANGE", lowSeqZaire);
                        dsm.printResult(FILE_PATH, dsm.getResult(), response);

                    }
                    if (midSeqTai.size() != 0) {
                        DoublyFuzzySoftModal dsm = new DoublyFuzzySoftModal("MID_VALUE_RANGE", midSeqZaire);
                        dsm.printResult(FILE_PATH, dsm.getResult(), response);

                    }
                    if (highSeqTai.size() != 0) {
                        DoublyFuzzySoftModal dsm = new DoublyFuzzySoftModal("HIGH_VALUE_RANGE", highSeqZaire);
                        dsm.printResult(FILE_PATH, dsm.getResult(), response);

                    }
                    Util.printDiv(response);
                }

                if (reston.size() != 0) {
                    Util.printCategory("Reston Ebola Virus", response);
                    if (lowSeqReston.size() != 0) {
                        DoublyFuzzySoftModal dsm = new DoublyFuzzySoftModal("LOW_VALUE_RANGE", lowSeqZaire);
                        dsm.printResult(FILE_PATH, dsm.getResult(), response);

                    }
                    if (midSeqReston.size() != 0) {
                        DoublyFuzzySoftModal dsm = new DoublyFuzzySoftModal("MID_VALUE_RANGE", midSeqZaire);
                        dsm.printResult(FILE_PATH, dsm.getResult(), response);

                    }
                    if (highSeqReston.size() != 0) {
                        DoublyFuzzySoftModal dsm = new DoublyFuzzySoftModal("HIGH_VALUE_RANGE", highSeqZaire);
                        dsm.printResult(FILE_PATH, dsm.getResult(), response);

                    }
                    Util.printDiv(response);
                }

                if (bundi.size() != 0) {
                    Util.printCategory("Bundibugyo Ebola Virus", response);
                    if (lowSeqBundi.size() != 0) {
                        DoublyFuzzySoftModal dsm = new DoublyFuzzySoftModal("LOW_VALUE_RANGE", lowSeqZaire);
                        dsm.printResult(FILE_PATH, dsm.getResult(), response);

                    }
                    if (midSeqBundi.size() != 0) {
                        DoublyFuzzySoftModal dsm = new DoublyFuzzySoftModal("MID_VALUE_RANGE", midSeqZaire);
                        dsm.printResult(FILE_PATH, dsm.getResult(), response);

                    }
                    if (highSeqBundi.size() != 0) {
                        DoublyFuzzySoftModal dsm = new DoublyFuzzySoftModal("HIGH_VALUE_RANGE", highSeqZaire);
                        dsm.printResult(FILE_PATH, dsm.getResult(), response);

                    }
                    Util.printDiv(response);
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
