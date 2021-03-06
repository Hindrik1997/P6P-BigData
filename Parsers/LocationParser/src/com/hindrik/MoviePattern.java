package com.hindrik;

import java.util.regex.Matcher;

/**
 * Pattern for searching through movies in locations.list
 */
class MoviePattern extends PatternSet{

    MoviePattern() {
        super("([^\"]+)\\s+(?:\\((\\d{4}|\\?{4})(?:\\/([IVXCM]+))?\\))\\s+(?:\\(([A-Z]+)\\))?\\s+(?:\\{\\{(.+)\\}\\})?\\s+(.+)");
    }

    /**
     * Overriden function.See the base class.
     * @see SeriePattern#process(String, Matcher)
     * @param input input string to match
     * @param matcher input matcher
     * @return a pair of bool and a movie object.
     */
    @Override
    protected Object process(String input, Matcher matcher) {
        Movie m = new Movie();

        m.set_title(matcher.group(1));

        m.set_yearOfRelease(matcher.group(2));

        if(matcher.group(3) != null)
            m.set_quarter(matcher.group(3));

        if(matcher.group(4) != null)
            m.set_medium(matcher.group(4));

        if(matcher.group(5) != null)
            m.set_state(matcher.group(5));

        m.set_location(matcher.group(6));

        return m;
    }
}
