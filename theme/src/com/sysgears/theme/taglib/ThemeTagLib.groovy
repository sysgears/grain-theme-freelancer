package com.sysgears.theme.taglib

import com.sysgears.grain.taglib.GrainTagLib

class ThemeTagLib {

    /**
     * Grain taglib reference.
     */
    private GrainTagLib taglib

    public ThemeTagLib(GrainTagLib taglib) {
        this.taglib = taglib
    }

    /**
     * Converts a date to XML date time format: 2013-12-31T12:49:00+07:00
     *
     * @attr date the date to convert
     */
    def xmlDateTime = { Map model ->
        if (!model.date) throw new IllegalArgumentException('Tag [xmlDateTime] is missing required attribute [date]')

        def tz = String.format('%tz', model.date)

        String.format("%tFT%<tT${tz.substring(0, 3)}:${tz.substring(3)}", model.date)
    }

    /**
     * Converts a string to snake case. For example: "Test String" -> test_string.
     *
     * @attr str the string to convert
     */
    def toSnakeCase = { Map model ->
        if (!model.str) throw new IllegalArgumentException('Tag [toSnakeCase] is missing required attribute [str]')

        model.str.replace(/ /, /-/).toLowerCase()
    }
}
