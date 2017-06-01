<%-- 
    Document   : fileRead
    Created on : 28 May, 2017, 4:47:26 PM
    Author     : AksHaY
--%>

<%@page import="psc.util.ProteinSequences"%>
<%@page import="psc.util.FileUploadUtil"%>
<%@page import="java.io.IOException"%>
<%@page import="java.util.Map"%>
<%@page import="org.biojava.nbio.core.sequence.ProteinSequence"%>
<%@page import="psc.util.FastaUtil"%>
<%@page import="java.io.File"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%  final String UPLOAD_DIR = getServletContext().getRealPath("/") + "upload";
    new File(UPLOAD_DIR).mkdirs();
%>
<!DOCTYPE html>
<html>
    <head>
        <title>Protein Sequence Counting</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="css/bootstrap.css">
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.js"></script>
        <style>
            .button-container form,
            .button-container form div {
                display: inline;
            }

            .button-container button {
                display: inline;
                vertical-align: middle;
            }
        </style>
    </head>
    <body>
        <%
            Map<String, ProteinSequences> proteinSeqeunces = null;
            /*MultipartRequest multipartRequest = null;
            try {
                multipartRequest = new MultipartRequest(request, UPLOAD_DIR, 1024 * 1024 * 1024);
            } catch (IOException ie) {
                request.setAttribute("ERROR", "Session Expired");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }*/

            File uploadFile = FileUploadUtil.upload(request, response, UPLOAD_DIR);
            if (uploadFile != null) {
                if (FastaUtil.validFile(uploadFile.getName())) {

                    proteinSeqeunces = FastaUtil.readFile(uploadFile);
                    if (proteinSeqeunces.size() == 0) {
                        request.setAttribute("ERROR", "Only file containg protein sequence in FASTA format are allowed");
                        request.getRequestDispatcher("index.jsp").forward(request, response);
                    } else {
                        request.getSession().setAttribute("PROTEIN_SEQ", proteinSeqeunces);
                        request.getSession().setAttribute("FILE_PATH", uploadFile.getAbsolutePath());
        %> 
        <table class="table">
            <thead class="thead-default">
                <tr>
                    <th>Sequence Number</th>
                    <th>Accession Number</th>
                    <th>Protein Name</th>
                    <th>Seqeunce count</th>
                </tr>
                <%                    int count = 1;
                    for (String key : proteinSeqeunces.keySet()) {
                        out.println("<tr>");
                        out.println("<td>" + count + "</td>");

                %>
            <td><a href="https://www.ncbi.nlm.nih.gov/protein/<% out.println(FastaUtil.getAccessionNumber(key));%>"
                   target="_blank"><% out.println(psc.util.FastaUtil.getAccessionNumber(key)); %></a></td>

            <td><% out.println(psc.util.FastaUtil.getSequenceName(key)); %></td>
            <td><% out.println(proteinSeqeunces.get(key).toString().length() + " aa"); %></td>
        </tr>

        <%                            count++;
                        }
                        out.println("</table>");
                    }
                } else {
                    request.setAttribute("ERROR", "Only file with extension *.txt, *.fna,*.fasta are allowed");
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }

            } else {
                request.setAttribute("ERROR", "Error in uploading file");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }

        %>
        <center> 
            <div class="button-container">
                <form action="countSequenceCrisp.jsp">
                    <button type="submit" value="Count Sequence using Crisp" class="btn btn-success">Count Sequence using Apriori</button>
                </form>
                <form action="countSequenceFuzzy.jsp">
                    <button type="submit" value="Count Sequence using Fuzzy" class="btn btn-default">Count Sequence using Fuzzy</button>
                </form>
                <br><br>
                <form action="countSequenceSoftSet.jsp">
                    <button type="submit" value="Count Sequence using Soft-Set" class="btn btn-primary">Count Sequence using Soft-Set</button>
                </form>

                <form action="countSequenceSoftFuzzy.jsp">
                    <button type="submit" value="Count Sequence using SoftFuzzy" class="btn btn-danger">Count Sequence using SoftFuzzy</button>
                </form>

                <br><br>
                <form action="countSequenceDoublySoftSet.jsp">
                    <button type="submit" value="Count Sequence using Doubly Soft-Set" class="btn btn-warning">Count Sequence using Doubly Soft-Set</button>
                </form>

                <form action="countSequenceDoublySoftFuzzy.jsp">
                    <button type="submit" value="Count Sequence using Doubly SoftFuzzy" class="btn btn-info">Count Sequence using Doubly SoftFuzzy</button>
                </form>
                <br>
            </div>

        </center>
</body>
</html>
