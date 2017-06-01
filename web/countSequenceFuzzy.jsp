<%-- 
    Document   : countSequenceCrisp.jsp
    Created on : 28 May, 2017, 7:39:00 PM
    Author     : AksHaY
--%>

<%@page import="java.text.DecimalFormat"%>
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
            DecimalFormat df = new DecimalFormat("#0.000");
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
                <%                    Double countAminoAcid[][] = new Double[proteinSequence.size()][20];
                    int count = 0;
                    double total_A = 0;
                    double total_R = 0;
                    double total_N = 0;
                    double total_D = 0;
                    double total_C = 0;
                    double total_E = 0;
                    double total_Q = 0;
                    double total_G = 0;
                    double total_H = 0;
                    double total_I = 0;
                    double total_L = 0;
                    double total_K = 0;
                    double total_M = 0;
                    double total_F = 0;
                    double total_P = 0;
                    double total_S = 0;
                    double total_T = 0;
                    double total_W = 0;
                    double total_Y = 0;
                    double total_V = 0;
                    double total_len = 0;
                    for (String key : proteinSequence.keySet()) {
                        int total = proteinSequence.get(key).toString().length();
                        double A = (double) Util.countMatches(proteinSequence.get(key).toString(), 'A') / total;
                        countAminoAcid[count][0] = A;
                        double R = (double) Util.countMatches(proteinSequence.get(key).toString(), 'R') / total;
                        countAminoAcid[count][1] = R;
                        double N = (double) Util.countMatches(proteinSequence.get(key).toString(), 'N') / total;
                        countAminoAcid[count][2] = N;
                        double D = (double) Util.countMatches(proteinSequence.get(key).toString(), 'D') / total;
                        countAminoAcid[count][3] = D;
                        double C = (double) Util.countMatches(proteinSequence.get(key).toString(), 'C') / total;
                        countAminoAcid[count][4] = C;
                        double E = (double) Util.countMatches(proteinSequence.get(key).toString(), 'E') / total;
                        countAminoAcid[count][5] = E;
                        double Q = (double) Util.countMatches(proteinSequence.get(key).toString(), 'Q') / total;
                        countAminoAcid[count][6] = Q;
                        double G = (double) Util.countMatches(proteinSequence.get(key).toString(), 'G') / total;
                        countAminoAcid[count][7] = G;
                        double H = (double) Util.countMatches(proteinSequence.get(key).toString(), 'H') / total;
                        countAminoAcid[count][8] = H;
                        double I = (double) Util.countMatches(proteinSequence.get(key).toString(), 'I') / total;
                        countAminoAcid[count][9] = I;
                        double L = (double) Util.countMatches(proteinSequence.get(key).toString(), 'L') / total;
                        countAminoAcid[count][10] = L;
                        double K = (double) Util.countMatches(proteinSequence.get(key).toString(), 'K') / total;
                        countAminoAcid[count][11] = K;
                        double M = (double) Util.countMatches(proteinSequence.get(key).toString(), 'M') / total;
                        countAminoAcid[count][12] = M;
                        double F = (double) Util.countMatches(proteinSequence.get(key).toString(), 'F') / total;
                        countAminoAcid[count][13] = F;
                        double P = (double) Util.countMatches(proteinSequence.get(key).toString(), 'P') / total;
                        countAminoAcid[count][14] = P;
                        double S = (double) Util.countMatches(proteinSequence.get(key).toString(), 'S') / total;
                        countAminoAcid[count][15] = S;
                        double T = (double) Util.countMatches(proteinSequence.get(key).toString(), 'T') / total;
                        countAminoAcid[count][16] = T;
                        double W = (double) Util.countMatches(proteinSequence.get(key).toString(), 'W') / total;
                        countAminoAcid[count][17] = W;
                        double Y = (double) Util.countMatches(proteinSequence.get(key).toString(), 'Y') / total;
                        countAminoAcid[count][18] = Y;
                        double V = (double) Util.countMatches(proteinSequence.get(key).toString(), 'V') / total;
                        countAminoAcid[count][19] = V;

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

            <td><% out.println(df.format(A));%></td>
            <td><% out.println(df.format(R));%></td>
            <td><% out.println(df.format(N));%></td>
            <td><% out.println(df.format(D));%></td>
            <td><% out.println(df.format(C));%></td>
            <td><% out.println(df.format(Q));%></td>
            <td><% out.println(df.format(E));%></td>
            <td><% out.println(df.format(G));%></td>
            <td><% out.println(df.format(H));%></td>
            <td><% out.println(df.format(I));%></td>
            <td><% out.println(df.format(L));%></td>
            <td><% out.println(df.format(K));%></td>
            <td><% out.println(df.format(M));%></td>
            <td><% out.println(df.format(F));%></td>
            <td><% out.println(df.format(P));%></td>
            <td><% out.println(df.format(S));%></td>
            <td><% out.println(df.format(T));%></td>
            <td><% out.println(df.format(W));%></td>
            <td><% out.println(df.format(Y));%></td>
            <td><% out.println(df.format(V));%></td>
            <td><%=total%></td>
            <% out.println("<tr>");
                }
                double total_ = total_A + total_R + total_N
                        + total_D + total_C + total_Q + total_E + total_G + total_H + total_I + total_L
                        + total_K + total_M + total_F + total_P + total_S + total_T + total_W + total_Y + total_V;
            %>
            <tr>
                <td>----</td>
                <td>----</td>
                <td><%  out.println(df.format(total_A));%></td>
                <td><%  out.println(df.format(total_R));%></td>
                <td><%  out.println(df.format(total_N));%></td>
                <td><%  out.println(df.format(total_D));%></td>
                <td><%  out.println(df.format(total_C));%></td>
                <td><%  out.println(df.format(total_Q));%></td>
                <td><%  out.println(df.format(total_E));%></td>
                <td><%  out.println(df.format(total_G));%></td>
                <td><%  out.println(df.format(total_H));%></td>
                <td><%  out.println(df.format(total_I));%></td>
                <td><%  out.println(df.format(total_L));%></td>
                <td><%  out.println(df.format(total_K));%></td>
                <td><%  out.println(df.format(total_M));%></td>
                <td><%  out.println(df.format(total_F));%></td>
                <td><%  out.println(df.format(total_P));%></td>
                <td><%  out.println(df.format(total_S));%></td>
                <td><%  out.println(df.format(total_T));%></td>
                <td><%  out.println(df.format(total_W));%></td>
                <td><%  out.println(df.format(total_Y));%></td>
                <td><%  out.println(df.format(total_V));%></td>
                <td><%  out.println(df.format(total_) + " / " + (total_len));%></td>
            </tr>
        </table>

        <%
                String frqSeq = "";

                if (((total_A / total_) * 100) >= 5) {
                    frqSeq += "A,";
                }
                if (((total_R / total_) * 100) >= 5) {
                    frqSeq += "R,";
                }
                if (((total_N / total_) * 100) >= 5) {
                    frqSeq += "N,";
                }
                if (((total_D / total_) * 100) >= 5) {
                    frqSeq += "D,";
                }
                if (((total_C / total_) * 100) >= 5) {
                    frqSeq += "C,";
                }
                if (((total_Q / total_) * 100) >= 5) {
                    frqSeq += "Q,";
                }
                if (((total_E / total_) * 100) >= 5) {
                    frqSeq += "E,";
                }
                if (((total_G / total_) * 100) >= 5) {
                    frqSeq += "G,";
                }
                if (((total_H / total_) * 100) >= 5) {
                    frqSeq += "H,";
                }
                if (((total_I / total_) * 100) >= 5) {
                    frqSeq += "I,";
                }
                if (((total_L / total_) * 100) >= 5) {
                    frqSeq += "L,";
                }
                if (((total_K / total_) * 100) >= 5) {
                    frqSeq += "K,";
                }
                if (((total_M / total_) * 100) >= 5) {
                    frqSeq += "M,";
                }
                if (((total_F / total_) * 100) >= 5) {
                    frqSeq += "F,";
                }
                if (((total_P / total_) * 100) >= 5) {
                    frqSeq += "P,";
                }
                if (((total_S / total_) * 100) >= 5) {
                    frqSeq += "S,";
                }
                if (((total_T / total_) * 100) >= 5) {
                    frqSeq += "T,";
                }
                if (((total_W / total_) * 100) >= 5) {
                    frqSeq += "W,";
                }
                if (((total_Y / total_) * 100) >= 5) {
                    frqSeq += "Y,";
                }
                if (((total_V / total_) * 100) >= 5) {
                    frqSeq += "V,";
                }

                ses.setAttribute("FREQ_SEQ", frqSeq.substring(0, frqSeq.length() - 1));
                ses.setAttribute("COUNT_AMINOACID", countAminoAcid);
                ses.setAttribute("TOTAL_SEQ", proteinSequence.size());
                ses.setAttribute("TOTAL_LEN", total_);

            } catch (Exception e) {
                request.setAttribute("ERROR", "Session Expired");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        %>
    <center> <form action="fuzzySet.jsp">
            <button type="submit" title="Calculate Frequent Amino Acid" class="btn btn-primary">Calculate Frequent Sequences</button>
        </form>
    </center>
</body>
</html>
