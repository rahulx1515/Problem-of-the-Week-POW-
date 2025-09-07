public class ValidNumInString{
    public boolean isNumber(String s) {
        s = s.trim();
        if (s.isEmpty()) return false;

        boolean seenDigit = false;
        boolean seenDot = false;
        boolean seenExp = false;
        boolean digitAfterExp = true; // meaningful only if exp appears

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                seenDigit = true;
                if (seenExp) digitAfterExp = true;
            } else if (ch == '+' || ch == '-') {
                // Sign only at start or just after exp
                if (i != 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E')
                    return false;
                // sign cannot be last char
                if (i == s.length() - 1)
                    return false;
            } else if (ch == '.') {
                // dot not allowed after exp and only once
                if (seenDot || seenExp) return false;
                seenDot = true;
            } else if (ch == 'e' || ch == 'E') {
                // exp only once and only if digit before
                if (seenExp || !seenDigit) return false;
                seenExp = true;
                digitAfterExp = false;
                // exp cannot be last char
                if (i == s.length() - 1) return false;
            } else {
                // invalid char
                return false;
            }
        }
        return seenDigit && digitAfterExp;
    }
}
