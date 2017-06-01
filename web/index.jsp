<%@page import="java.io.File"%>
<%@page import="psc.util.Util"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html lang="en">
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
            Util.deleteFiles(new File(getServletContext().getRealPath("/") + "upload"));
            HttpSession ses = request.getSession(false);
            if(!ses.isNew()){
                ses.invalidate();
            }
        %>
        <div class="container">
            <h2>Protein Sequence Counting</h2>
            <form action="fileRead.jsp" method="post" enctype="multipart/form-data">
                <div class="form-group">

                    <strong style="color: #F69">Choose a text file containing sequences in FASTA format</strong>
                    <%
                        if (request.getAttribute("ERROR") != null) {
                            out.println("<br><label class='control-label' for='inputError' style='color:#F00'>*" + request.getAttribute("ERROR") + "</label>");
                        }
                    %>
                    <input type="file" name="seqFile" id="seqFile">
                </div>
                <button type="submit" class="btn btn-default" >Submit</button>


                <button type="button" class="btn btn-success" data-toggle="modal" data-target="#helpModal">Help</button>



            </form>
        </div>

        <!--help model start
        <div class="modal fade solid" id="helpModal" role="dialog">
            <div class="modal-dialog model-lg">

                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h3 class="modal-title">Help</h3>
                    </div>
                    <div class="modal-body">
                        <p>Ohh!!! toh tumhe help chahiye.....</p>
                    </div>
                    <div class="modal-footer">
                        <strong data-dismiss="modal">Cute, beautiful and single girls, whatsapp me : <a>+91-9923174419</a><br>AksHaY</strong>
                    </div>
                </div>

            </div>
        </div>
        -->
        <!--help model end -->

        <!--submit model start --> 
        <div class="modal fade solid" id="submitModel" role="dialog">
            <div class="modal-dialog model-lg">

                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h3 class="modal-title">Submit</h3>
                    </div>
                    <div class="modal-body">
                        <p>Arre <strong>Bill Gates</strong>, Work in progress.</p>
                    </div>
                </div>

            </div>
        </div>

        <!--submit model end --> 

    </body>
</html>

