public boolean matches(String text, String regex) {
    try {
        return Pattern.compile(regex).matcher(text).matches();
    } catch (PatternSyntaxException e) {
        System.err.println("wrong regex syntax: " + regex);
        return false;
    }
}
