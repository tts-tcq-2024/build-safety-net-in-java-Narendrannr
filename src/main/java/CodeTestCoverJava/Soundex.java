package CodeTestCoverJava;

public class Soundex {

    public static String generateSoundex(String name) {
        if (name == null || name.isEmpty()) {
            return "";
        }

        StringBuilder soundex = new StringBuilder();
        soundex.append(Character.toUpperCase(name.charAt(0)));
        char prevCode = getSoundexCode(name.charAt(0));

        for (int i = 1; i < name.length() && soundex.length() < 4; i++) {
            char code = getSoundexCode(name.charAt(i));
            if (code != '0' && code != prevCode) {
                soundex.append(code);
                prevCode = code;
            }
        }

        while (soundex.length() < 4) {
            soundex.append('0');
        }

        return soundex.toString();
    }

    private static final char[] MAP = {
    /** Keeping the data primitive 
        A  B  C  D  E  F  G  H  I  J  K  L  M  N  O  P  Q  R  S  T  U  V  W  X  Y  Z */
       '0','1','2','3','0','1','2','0','0','2','2','4','5','5','0','1','2','6','2','3','0','1','0','2','0','2'
    };

    private static char getSoundexCode(char c) {
            c = Character.toUpperCase(c);
            if (c >= 'A' && c <= 'Z') {
                return MAP[c - 'A'];
            }
            return '0';
    }
}
