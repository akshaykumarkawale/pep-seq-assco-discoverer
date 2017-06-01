<%-- 
    Document   : countSequenceCrisp.jsp
    Created on : 28 May, 2017, 7:39:00 PM
    Author     : AksHaY
--%>

<%@page import="psc.util.Ebola"%>
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
    <head>
        <title>Protein Sequence Counting</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="css/bootstrap.css">
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.js"></script>
    </head>
    <body>
    </center>
    <%

        try {
            HttpSession ses = request.getSession(false);

            Ebola ebola = new Ebola();
            List<Integer> totalLenArray = new ArrayList<Integer>();
            List<String> tai_forest = ebola.getTai_forest();
            List<String> zaire = ebola.getZaire();
            List<String> reston = ebola.getReston();
            List<String> sudan = ebola.getSudan();
            List<String> bundibugyo = ebola.getBundibugyo();
            Map<String, ProteinSequences> proteinSequence = (Map) ses.getAttribute("PROTEIN_SEQ");

            Map<String, ProteinSequences> zaireSeq = new HashMap<String, ProteinSequences>();
            Map<String, ProteinSequences> sudanSeq = new HashMap<String, ProteinSequences>();
            Map<String, ProteinSequences> restonSeq = new HashMap<String, ProteinSequences>();
            Map<String, ProteinSequences> taiSeq = new HashMap<String, ProteinSequences>();
            Map<String, ProteinSequences> bundibugyoSeq = new HashMap<String, ProteinSequences>();

            Map<String, ProteinSequences> lowSeqZaire = new HashMap<String, ProteinSequences>();
            Map<String, ProteinSequences> midSeqZaire = new HashMap<String, ProteinSequences>();
            Map<String, ProteinSequences> highSeqZaire = new HashMap<String, ProteinSequences>();
            Map<String, ProteinSequences> lowSeqSudan = new HashMap<String, ProteinSequences>();
            Map<String, ProteinSequences> midSeqSudan = new HashMap<String, ProteinSequences>();
            Map<String, ProteinSequences> highSeqSudan = new HashMap<String, ProteinSequences>();
            Map<String, ProteinSequences> lowSeqReston = new HashMap<String, ProteinSequences>();
            Map<String, ProteinSequences> midSeqReston = new HashMap<String, ProteinSequences>();
            Map<String, ProteinSequences> highSeqReston = new HashMap<String, ProteinSequences>();
            Map<String, ProteinSequences> lowSeqTai = new HashMap<String, ProteinSequences>();
            Map<String, ProteinSequences> midSeqTai = new HashMap<String, ProteinSequences>();
            Map<String, ProteinSequences> highSeqTai = new HashMap<String, ProteinSequences>();
            Map<String, ProteinSequences> lowSeqBundi = new HashMap<String, ProteinSequences>();
            Map<String, ProteinSequences> midSeqBundi = new HashMap<String, ProteinSequences>();
            Map<String, ProteinSequences> highSeqBundi = new HashMap<String, ProteinSequences>();

            for (String key : proteinSequence.keySet()) {
                String acc_no = FastaUtil.getAccessionNumber(key);
                if (sudan.contains(acc_no)) {
                    sudanSeq.put(key, proteinSequence.get(key));
                } else if (zaire.contains(acc_no)) {
                    zaireSeq.put(key, proteinSequence.get(key));
                } else if (reston.contains(acc_no)) {
                    restonSeq.put(key, proteinSequence.get(key));
                } else if (tai_forest.contains(acc_no)) {
                    taiSeq.put(key, proteinSequence.get(key));
                } else if (bundibugyo.contains(acc_no)) {
                    bundibugyoSeq.put(key, proteinSequence.get(key));
                }
            }

            if (zaireSeq.size() != 0) {
                List<Integer> lenArray = Util.getTotalLenArray(zaireSeq);
                int low_min = Util.getMinimumValue(lenArray);
                int high_max = Util.getMaxmumValue(lenArray);
                int low_max = (low_min + high_max) / 3;
                int mid_min = low_max + 1;
                int mid_max = 2 * (mid_min);

                for (String key : zaireSeq.keySet()) {
                    int len = zaireSeq.get(key).toString().length();
                    if (len >= low_min && len <= low_max) {
                        lowSeqZaire.put(key, zaireSeq.get(key));
                    } else if (len >= mid_min && len <= mid_max) {
                        midSeqZaire.put(key, zaireSeq.get(key));
                    } else {
                        highSeqZaire.put(key, zaireSeq.get(key));
                    }

                }

                Util.printCategory("Zaire Ebola Virus", response);
                if (lowSeqZaire.size() != 0) {
                    Util.printSoftFuzzy("LOW", lowSeqZaire, request, response);
                }
                if (midSeqZaire.size() != 0) {
                    Util.printSoftFuzzy("MID", midSeqZaire, request, response);
                }
                if (highSeqZaire.size() != 0) {
                    Util.printSoftFuzzy("HIGH", highSeqZaire, request, response);
                }
                Util.printDiv(response);

            }
            if (sudanSeq.size() != 0) {
                List<Integer> lenArray = Util.getTotalLenArray(sudanSeq);
                int low_min = Util.getMinimumValue(lenArray);
                int high_max = Util.getMaxmumValue(lenArray);
                int low_max = (low_min + high_max) / 3;
                int mid_min = low_max + 1;
                int mid_max = 2 * (mid_min);

                for (String key : sudanSeq.keySet()) {
                    int len = sudanSeq.get(key).toString().length();
                    if (len >= low_min && len <= low_max) {
                        lowSeqSudan.put(key, sudanSeq.get(key));
                    } else if (len >= mid_min && len <= mid_max) {
                        midSeqSudan.put(key, sudanSeq.get(key));
                    } else {
                        highSeqSudan.put(key, sudanSeq.get(key));
                    }

                }

                Util.printCategory("Sudan Ebola Virus", response);
                if (lowSeqSudan.size() != 0) {
                    Util.printSoftFuzzy("LOW", lowSeqSudan, request, response);
                }
                if (midSeqSudan.size() != 0) {
                    Util.printSoftFuzzy("MID", midSeqSudan, request, response);
                }
                if (highSeqSudan.size() != 0) {
                    Util.printSoftFuzzy("HIGH", highSeqSudan, request, response);
                }
                Util.printDiv(response);
            }
            if (restonSeq.size() != 0) {
                List<Integer> lenArray = Util.getTotalLenArray(restonSeq);
                int low_min = Util.getMinimumValue(lenArray);
                int high_max = Util.getMaxmumValue(lenArray);
                int low_max = (low_min + high_max) / 3;
                int mid_min = low_max + 1;
                int mid_max = 2 * (mid_min);

                for (String key : restonSeq.keySet()) {
                    int len = restonSeq.get(key).toString().length();
                    if (len >= low_min && len <= low_max) {
                        lowSeqReston.put(key, restonSeq.get(key));
                    } else if (len >= mid_min && len <= mid_max) {
                        midSeqReston.put(key, restonSeq.get(key));
                    } else {
                        highSeqReston.put(key, restonSeq.get(key));
                    }

                }

                Util.printCategory("Reston Ebola Virus", response);
                if (lowSeqReston.size() != 0) {
                    Util.printSoftFuzzy("LOW", lowSeqReston, request, response);
                }
                if (midSeqReston.size() != 0) {
                    Util.printSoftFuzzy("MID", midSeqReston, request, response);
                }
                if (highSeqReston.size() != 0) {
                    Util.printSoftFuzzy("HIGH", highSeqReston, request, response);
                }
                Util.printDiv(response);
            }
            if (taiSeq.size() != 0) {
                List<Integer> lenArray = Util.getTotalLenArray(taiSeq);
                int low_min = Util.getMinimumValue(lenArray);
                int high_max = Util.getMaxmumValue(lenArray);
                int low_max = (low_min + high_max) / 3;
                int mid_min = low_max + 1;
                int mid_max = 2 * (mid_min);

                for (String key : taiSeq.keySet()) {
                    int len = taiSeq.get(key).toString().length();
                    if (len >= low_min && len <= low_max) {
                        lowSeqTai.put(key, taiSeq.get(key));
                    } else if (len >= mid_min && len <= mid_max) {
                        midSeqTai.put(key, taiSeq.get(key));
                    } else {
                        highSeqTai.put(key, taiSeq.get(key));
                    }

                }

                Util.printCategory("Tai Forest Ebola Virus", response);
                if (lowSeqTai.size() != 0) {
                    Util.printSoftFuzzy("LOW", lowSeqTai, request, response);
                }
                if (midSeqTai.size() != 0) {
                    Util.printSoftFuzzy("MID", midSeqTai, request, response);
                }
                if (highSeqTai.size() != 0) {
                    Util.printSoftFuzzy("HIGH", highSeqTai, request, response);
                }
                Util.printDiv(response);
            }
            if (bundibugyoSeq.size() != 0) {
                List<Integer> lenArray = Util.getTotalLenArray(bundibugyoSeq);
                int low_min = Util.getMinimumValue(lenArray);
                int high_max = Util.getMaxmumValue(lenArray);
                int low_max = (low_min + high_max) / 3;
                int mid_min = low_max + 1;
                int mid_max = 2 * (mid_min);

                for (String key : bundibugyoSeq.keySet()) {
                    int len = bundibugyoSeq.get(key).toString().length();
                    if (len >= low_min && len <= low_max) {
                        lowSeqBundi.put(key, bundibugyoSeq.get(key));
                    } else if (len >= mid_min && len <= mid_max) {
                        midSeqBundi.put(key, bundibugyoSeq.get(key));
                    } else {
                        highSeqBundi.put(key, bundibugyoSeq.get(key));
                    }

                }

                Util.printCategory("Bundibugyo Ebola Virus", response);
                if (lowSeqBundi.size() != 0) {
                    Util.printSoftFuzzy("LOW", lowSeqBundi, request, response);
                }
                if (midSeqBundi.size() != 0) {
                    Util.printSoftFuzzy("MID", midSeqBundi, request, response);
                }
                if (highSeqBundi.size() != 0) {
                    Util.printSoftFuzzy("HIGH", highSeqBundi, request, response);
                }
                Util.printDiv(response);
            }

    %>


    <%        ses.setAttribute("ZAIRE", zaireSeq);
            ses.setAttribute("SUDAN", sudanSeq);
            ses.setAttribute("TAI", taiSeq);
            ses.setAttribute("RESTON", restonSeq);
            ses.setAttribute("BUNDI", bundibugyoSeq);

            ses.setAttribute("LOW_ZAIRE", lowSeqZaire);
            ses.setAttribute("MID_ZAIRE", midSeqZaire);
            ses.setAttribute("HIGH_ZAIRE", highSeqZaire);
            ses.setAttribute("LOW_SUDAN", lowSeqSudan);
            ses.setAttribute("MID_SUDAN", midSeqSudan);
            ses.setAttribute("HIGH_SUDAN", highSeqSudan);
            ses.setAttribute("LOW_RESTON", lowSeqReston);
            ses.setAttribute("MID_RESTON", midSeqReston);
            ses.setAttribute("HIGH_RESTON", highSeqReston);
            ses.setAttribute("LOW_TAI", lowSeqTai);
            ses.setAttribute("MID_TAI", midSeqTai);
            ses.setAttribute("HIGH_TAI", highSeqTai);
            ses.setAttribute("LOW_BUNDI", lowSeqBundi);
            ses.setAttribute("MID_BUNDI", midSeqBundi);
            ses.setAttribute("HIGH_BUNDI", highSeqBundi);
        } catch (Exception e) {
            request.setAttribute("ERROR", "Session Expired");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }

    %>


<center> <form action="doublySoftFuzzy.jsp">
        <button type="submit" title="Calculate Frequent Amino Acid" class="btn btn-primary">Calculate Frequent Sequences</button>
    </form>
</center>
</body>
</html>
