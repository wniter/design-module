package TheadDsignPatterns.PipeLine.example;

import java.io.File;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

import TheadDsignPatterns.Promise.example.FTPUploader;


public class FileTransferTask implements Callable<File> {
    public final Future<FTPUploader> ftpUtilHodler;
    public final File file2Transfer;

    public FileTransferTask(Future<FTPUploader> ftpUtilHodler,
            File file2Transfer) {
        this.ftpUtilHodler = ftpUtilHodler;
        this.file2Transfer = file2Transfer;
    }


    @Override
    public File call() throws Exception {
        File transferedFile = null;
        ftpUtilHodler.get().upload(file2Transfer);
        transferedFile = file2Transfer;
        return transferedFile;
    }
}
