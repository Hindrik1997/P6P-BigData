package com.hindrik;

import java.util.regex.Matcher;

/**
 * Pattern for searching through series in locations.list
 */
class SeriePattern extends PatternSet {

    SeriePattern() {
        super("\"(.+)\"\\s+(?:\\((\\d{4}|\\?{4})(?:\\/([IVXCM]+))?\\))\\s+(?:\\{(.+)\\s+\\(#(\\d+)\\.(\\d+)\\)\\})?\\s+(.+)");
    }

    /**
     * Overriden function.See the base class.
     * @see SeriePattern#process(String, Matcher)
     * @param input input string to match
     * @param matcher input matcher
     * @return a pair of bool and a serie object.
     */
    @Override
    protected Object process(String input, Matcher matcher) {
        Serie s = new Serie();

        s.set_title(matcher.group(1));
        s.set_yearOfRelease(matcher.group(2));
        if(matcher.group(3) != null)
            s.set_quarter(matcher.group(3));
        if(matcher.group(4) != null)
            s.set_episodeName(matcher.group(4));
        if(matcher.group(5) != null)
            s.set_seasonNr(matcher.group(5));
        if(matcher.group(6) != null)
            s.set_episodeNr(matcher.group(6));

        s.set_location(matcher.group(7));

        return s;
    }
}
