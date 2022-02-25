package tarea10;

public class Tarea10JSON {
    public void jsonAreEqual(String actualResult, String expectedResult, String error) throws Exception {
        if ((actualResult.isBlank() && !expectedResult.isBlank()) || (!actualResult.isBlank() && expectedResult.isBlank())) {
            throw new Exception(error);
        } else {
            String actualResultComp = actualResult.replaceAll("\r", "").replaceAll("\n", "");
            String expectedResultComp = expectedResult.replaceAll("\r", "").replaceAll("\n", "");
            if ((actualResultComp.length() == 2 && expectedResultComp.length() != 2)
                    || (actualResultComp.length() != 2 && expectedResultComp.length() == 2)) {
                throw new Exception(error);
            }
            String[] atributosActual = actualResultComp.substring(1, actualResultComp.length() - 1).split(",");
            String[] atributosExpected = expectedResultComp.substring(1, expectedResultComp.length() - 1).split(",");
            if (atributosActual.length != atributosExpected.length) {
                throw new Exception(error);
            }
            for (int i = 0; i < atributosActual.length; i++) {
                String atrActual = atributosActual[i].trim();
                String claveAct = atrActual.split(":")[0];
                String valorAct = atrActual.split(":")[1];
                if (valorAct.equals("\"IGNORE\"")) {
                    continue;
                }
                boolean claveEncontrada = false;
                for (int j = 0; j < atributosExpected.length; j++) {
                    String atrExpected = atributosActual[i].trim();
                    String claveExp = atrExpected.split(":")[0];
                    String valorExp = atrExpected.split(":")[1];
                    if (claveExp.equals(claveAct)) {
                        claveEncontrada = true;
                        if (valorExp.equals("\"IGNORE\"")) {
                            break;
                        }
                        if (!valorAct.equals(valorExp)) {
                            throw new Exception(error);
                        }
                    }
                }
                if (!claveEncontrada) {
                    throw new Exception(error);
                }
            }
        }
    }
}
