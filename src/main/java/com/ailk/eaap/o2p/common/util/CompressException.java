package com.ailk.eaap.o2p.common.util;

/**
 *
 * Created by david on 15/1/2.
 */
public class CompressException extends Exception {
    private static final long serialVersionUID = -5700767483194052468L;

    public CompressException(String detail, Exception e) {
        super(detail, e);
    }

    public CompressException(String detail) {
        super(detail);
    }
}
