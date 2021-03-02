package com.danikula.videocache.file;

import com.danikula.videocache.Logger;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/* access modifiers changed from: package-private */
public class Files {
    Files() {
    }

    static void makeDir(File file) {
        AppMethodBeat.i(223207);
        if (file.exists()) {
            if (!file.isDirectory()) {
                IOException iOException = new IOException("File " + file + " is not directory!");
                AppMethodBeat.o(223207);
                throw iOException;
            }
        } else if (!file.mkdirs()) {
            IOException iOException2 = new IOException(String.format("Directory %s can't be created", file.getAbsolutePath()));
            AppMethodBeat.o(223207);
            throw iOException2;
        }
        AppMethodBeat.o(223207);
    }

    static List<File> getLruListFiles(File file) {
        AppMethodBeat.i(223208);
        List<File> linkedList = new LinkedList<>();
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            linkedList = Arrays.asList(listFiles);
            Collections.sort(linkedList, new LastModifiedComparator());
        }
        AppMethodBeat.o(223208);
        return linkedList;
    }

    static void setLastModifiedNow(File file) {
        AppMethodBeat.i(223209);
        if (file.exists()) {
            long currentTimeMillis = System.currentTimeMillis();
            if (!file.setLastModified(currentTimeMillis)) {
                modify(file);
                if (file.lastModified() < currentTimeMillis) {
                    Logger.warn(String.format("Last modified date %s is not set for file %s", new Date(file.lastModified()), file.getAbsolutePath()));
                }
            }
        }
        AppMethodBeat.o(223209);
    }

    static void modify(File file) {
        AppMethodBeat.i(223210);
        long length = file.length();
        if (length == 0) {
            recreateZeroSizeFile(file);
            AppMethodBeat.o(223210);
            return;
        }
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rwd");
        randomAccessFile.seek(length - 1);
        byte readByte = randomAccessFile.readByte();
        randomAccessFile.seek(length - 1);
        randomAccessFile.write(readByte);
        randomAccessFile.close();
        AppMethodBeat.o(223210);
    }

    private static void recreateZeroSizeFile(File file) {
        AppMethodBeat.i(223211);
        if (!file.delete() || !file.createNewFile()) {
            IOException iOException = new IOException("Error recreate zero-size file ".concat(String.valueOf(file)));
            AppMethodBeat.o(223211);
            throw iOException;
        }
        AppMethodBeat.o(223211);
    }

    static final class LastModifiedComparator implements Comparator<File> {
        private LastModifiedComparator() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public final /* bridge */ /* synthetic */ int compare(File file, File file2) {
            AppMethodBeat.i(183625);
            int compare = compare(file, file2);
            AppMethodBeat.o(183625);
            return compare;
        }

        public final int compare(File file, File file2) {
            AppMethodBeat.i(223206);
            int compareLong = compareLong(file.lastModified(), file2.lastModified());
            AppMethodBeat.o(223206);
            return compareLong;
        }

        private int compareLong(long j2, long j3) {
            if (j2 < j3) {
                return -1;
            }
            return j2 == j3 ? 0 : 1;
        }
    }
}
