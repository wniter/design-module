package TheadDsignPatterns.PipeLine.example;

import java.io.IOException;

public interface RecordSource {

    void close() throws IOException;

    boolean hasNext();

    Record next();

}