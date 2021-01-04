package org.ds.nocoding;

public class ProcessException extends RuntimeException {
    public ProcessException() {
        super("处理时发生异常");
    }
}
