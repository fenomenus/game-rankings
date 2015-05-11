package com.walium.ing.gamerank.handlers;

/**
 * @author <a href="mailto:edganiukov@gmail.com">Ed Ganiukov</a>
 * @since 2015.05.09
 */
public interface IResultHandler {

    /**
     * Method tha calculate necessary rank and return output String with data.
     *
     * @return List of strings with calculated data.
     */
    String getResult();
}
