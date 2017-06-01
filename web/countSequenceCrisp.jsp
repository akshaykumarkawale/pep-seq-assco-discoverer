<%-- 
    Document   : countSequenceCrisp.jsp
    Created on : 28 May, 2017, 7:39:00 PM
    Author     : AksHaY
--%>

<%@page import="psc.util.ProteinSequences"%>
<%@page import="java.io.File"%>
<%@page import="java.io.FileWriter"%>
<%@page import="psc.util.FastaUtil"%>
<%@page import="psc.util.Util"%>
<%@page import="org.biojava.nbio.core.sequence.ProteinSequence"%>
<%@page import="java.util.Map"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        try {
            HttpSession ses = request.getSession(false);

            Map<String, ProteinSequences> proteinSequence = (Map) ses.getAttribute("PROTEIN_SEQ");

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
        <table class="table">
            <thead class="thead-default">
                <tr>
                    <th>Sequence Number</th>
                    <th>Accession Number</th>
                    <th>A</th>
                    <th>R</th>
                    <th>N</th>
                    <th>D</th>
                    <th>C</th>
                    <th>Q</th>
                    <th>E</th>
                    <th>G</th>
                    <th>H</th>
                    <th>I</th>
                    <th>L</th>
                    <th>K</th>
                    <th>M</th>
                    <th>F</th>
                    <th>P</th>
                    <th>S</th>
                    <th>T</th>
                    <th>W</th>
                    <th>Y</th>
                    <th>V</th>
                    <th>Total Length</th>
                </tr>
            </thead>
            <tbody>
                <%                    Integer countAminoAcid[][] = new Integer[proteinSequence.size()][20];
                    int count = 0;
                    int total_A = 0;
                    int total_R = 0;
                    int total_N = 0;
                    int total_D = 0;
                    int total_C = 0;
                    int total_E = 0;
                    int total_Q = 0;
                    int total_G = 0;
                    int total_H = 0;
                    int total_I = 0;
                    int total_L = 0;
                    int total_K = 0;
                    int total_M = 0;
                    int total_F = 0;
                    int total_P = 0;
                    int total_S = 0;
                    int total_T = 0;
                    int total_W = 0;
                    int total_Y = 0;
                    int total_V = 0;
                    int total_len = 0;
                    for (String key : proteinSequence.keySet()) {
                        int A = (int) Util.countMatches(proteinSequence.get(key).toString(), 'A');
                        countAminoAcid[count][0] = A;
                        int R = (int) Util.countMatches(proteinSequence.get(key).toString(), 'R');
                        countAminoAcid[count][1] = R;
                        int N = (int) Util.countMatches(proteinSequence.get(key).toString(), 'N');
                        countAminoAcid[count][2] = N;
                        int D = (int) Util.countMatches(proteinSequence.get(key).toString(), 'D');
                        countAminoAcid[count][3] = D;
                        int C = (int) Util.countMatches(proteinSequence.get(key).toString(), 'C');
                        countAminoAcid[count][4] = C;
                        int E = (int) Util.countMatches(proteinSequence.get(key).toString(), 'E');
                        countAminoAcid[count][5] = E;
                        int Q = (int) Util.countMatches(proteinSequence.get(key).toString(), 'Q');
                        countAminoAcid[count][6] = Q;
                        int G = (int) Util.countMatches(proteinSequence.get(key).toString(), 'G');
                        countAminoAcid[count][7] = G;
                        int H = (int) Util.countMatches(proteinSequence.get(key).toString(), 'H');
                        countAminoAcid[count][8] = H;
                        int I = (int) Util.countMatches(proteinSequence.get(key).toString(), 'I');
                        countAminoAcid[count][9] = I;
                        int L = (int) Util.countMatches(proteinSequence.get(key).toString(), 'L');
                        countAminoAcid[count][10] = L;
                        int K = (int) Util.countMatches(proteinSequence.get(key).toString(), 'K');
                        countAminoAcid[count][11] = K;
                        int M = (int) Util.countMatches(proteinSequence.get(key).toString(), 'M');
                        countAminoAcid[count][12] = M;
                        int F = (int) Util.countMatches(proteinSequence.get(key).toString(), 'F');
                        countAminoAcid[count][13] = F;
                        int P = (int) Util.countMatches(proteinSequence.get(key).toString(), 'P');
                        countAminoAcid[count][14] = P;
                        int S = (int) Util.countMatches(proteinSequence.get(key).toString(), 'S');
                        countAminoAcid[count][15] = S;
                        int T = (int) Util.countMatches(proteinSequence.get(key).toString(), 'T');
                        countAminoAcid[count][16] = T;
                        int W = (int) Util.countMatches(proteinSequence.get(key).toString(), 'W');
                        countAminoAcid[count][17] = W;
                        int Y = (int) Util.countMatches(proteinSequence.get(key).toString(), 'Y');
                        countAminoAcid[count][18] = Y;
                        int V = (int) Util.countMatches(proteinSequence.get(key).toString(), 'V');
                        countAminoAcid[count][19] = V;
                        int total = proteinSequence.get(key).toString().length();
                        total_A += A;
                        total_R += R;
                        total_N += N;
                        total_D += D;
                        total_C += C;
                        total_E += E;
                        total_Q += Q;
                        total_G += G;
                        total_H += H;
                        total_I += I;
                        total_L += L;
                        total_K += K;
                        total_M += M;
                        total_F += F;
                        total_P += P;
                        total_S += S;
                        total_T += T;
                        total_W += W;
                        total_Y += Y;
                        total_V += V;
                        total_len += total;


                %>
            <td><%=++count%></td>
            <td><a href="https://www.ncbi.nlm.nih.gov/protein/<% out.println(FastaUtil.getAccessionNumber(key));%>"
                   onclick="window.open(this.href, 'Snopzer',
                                   'toolbar=1,resizable=0');
                           return false;"><% out.println(FastaUtil.getAccessionNumber(key));%></a></td>

            <td><%=A%></td>
            <td><%=R%></td>
            <td><%=N%></td>
            <td><%=D%></td>
            <td><%=C%></td>
            <td><%=Q%></td>
            <td><%=E%></td>
            <td><%=G%></td>
            <td><%=H%></td>
            <td><%=I%></td>
            <td><%=L%></td>
            <td><%=K%></td>
            <td><%=M%></td>
            <td><%=F%></td>
            <td><%=P%></td>
            <td><%=S%></td>
            <td><%=T%></td>
            <td><%=W%></td>
            <td><%=Y%></td>
            <td><%=V%></td>
            <td><%=total%></td>
            <% out.println("<tr>");
                }%>
            <tr>
                <td>----</td>
                <td>----</td>
                <td><%=total_A%></td>
                <td><%=total_R%></td>
                <td><%=total_N%></td>
                <td><%=total_D%></td>
                <td><%=total_C%></td>
                <td><%=total_Q%></td>
                <td><%=total_E%></td>
                <td><%=total_G%></td>
                <td><%=total_H%></td>
                <td><%=total_I%></td>
                <td><%=total_L%></td>
                <td><%=total_K%></td>
                <td><%=total_M%></td>
                <td><%=total_F%></td>
                <td><%=total_P%></td>
                <td><%=total_S%></td>
                <td><%=total_T%></td>
                <td><%=total_W%></td>
                <td><%=total_Y%></td>
                <td><%=total_V%></td>
                <td><%=total_len%></td>
            </tr>
        </table>

        <%
                String frqSeq = "";

                if ((((float) total_A / total_len) * 100) >= 5) {
                    frqSeq += "A,";
                }
                if ((((float) total_R / total_len) * 100) >= 5) {
                    frqSeq += "R,";
                }
                if ((((float) total_N / total_len) * 100) >= 5) {
                    frqSeq += "N,";
                }
                if ((((float) total_D / total_len) * 100) >= 5) {
                    frqSeq += "D,";
                }
                if ((((float) total_C / total_len) * 100) >= 5) {
                    frqSeq += "C,";
                }
                if ((((float) total_Q / total_len) * 100) >= 5) {
                    frqSeq += "Q,";
                }
                if ((((float) total_E / total_len) * 100) >= 5) {
                    frqSeq += "E,";
                }
                if ((((float) total_G / total_len) * 100) >= 5) {
                    frqSeq += "G,";
                }
                if ((((float) total_H / total_len) * 100) >= 5) {
                    frqSeq += "H,";
                }
                if ((((float) total_I / total_len) * 100) >= 5) {
                    frqSeq += "I,";
                }
                if ((((float) total_L / total_len) * 100) >= 5) {
                    frqSeq += "L,";
                }
                if ((((float) total_K / total_len) * 100) >= 5) {
                    frqSeq += "K,";
                }
                if ((((float) total_M / total_len) * 100) >= 5) {
                    frqSeq += "M,";
                }
                if ((((float) total_F / total_len) * 100) >= 5) {
                    frqSeq += "F,";
                }
                if ((((float) total_P / total_len) * 100) >= 5) {
                    frqSeq += "P,";
                }
                if ((((float) total_S / total_len) * 100) >= 5) {
                    frqSeq += "S,";
                }
                if ((((float) total_T / total_len) * 100) >= 5) {
                    frqSeq += "T,";
                }
                if ((((float) total_W / total_len) * 100) >= 5) {
                    frqSeq += "W,";
                }
                if ((((float) total_Y / total_len) * 100) >= 5) {
                    frqSeq += "Y,";
                }
                if ((((float) total_V / total_len) * 100) >= 5) {
                    frqSeq += "V,";
                }

                ses.setAttribute("FREQ_SEQ", frqSeq.substring(0, frqSeq.length() - 1));
                ses.setAttribute("COUNT_AMINOACID", countAminoAcid);
                ses.setAttribute("TOTAL_SEQ", proteinSequence.size());
                ses.setAttribute("TOTAL_LEN", total_len);

            } catch (Exception e) {
                request.setAttribute("ERROR", "Session Expired");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        %>
    <center> <form action="crispSet.jsp">
            <button type="submit" title="Calculate Frequent Amino Acid" class="btn btn-primary">Calculate Frequent Sequences</button>
        </form>
    </center>
</body>
</html>
