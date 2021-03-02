package com.google.android.gms.common.data;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class DataBufferUtils {
    public static final String KEY_NEXT_PAGE_TOKEN = "next_page_token";
    public static final String KEY_PREV_PAGE_TOKEN = "prev_page_token";
    public static final String PAGE_PLACEHOLDER_TOKEN = "has_local_data";

    private DataBufferUtils() {
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.util.ArrayList<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public static <T, E extends Freezable<T>> ArrayList<T> freezeAndClose(DataBuffer<E> dataBuffer) {
        AppMethodBeat.i(11561);
        ArrayList<T> arrayList = (ArrayList<T>) new ArrayList(dataBuffer.getCount());
        try {
            for (E e2 : dataBuffer) {
                arrayList.add(e2.freeze());
            }
            return arrayList;
        } finally {
            dataBuffer.close();
            AppMethodBeat.o(11561);
        }
    }

    public static boolean hasData(DataBuffer<?> dataBuffer) {
        AppMethodBeat.i(11564);
        if (dataBuffer == null || dataBuffer.getCount() <= 0) {
            AppMethodBeat.o(11564);
            return false;
        }
        AppMethodBeat.o(11564);
        return true;
    }

    public static boolean hasNextPage(DataBuffer<?> dataBuffer) {
        AppMethodBeat.i(11562);
        Bundle metadata = dataBuffer.getMetadata();
        if (metadata == null || metadata.getString(KEY_NEXT_PAGE_TOKEN) == null) {
            AppMethodBeat.o(11562);
            return false;
        }
        AppMethodBeat.o(11562);
        return true;
    }

    public static boolean hasPrevPage(DataBuffer<?> dataBuffer) {
        AppMethodBeat.i(11563);
        Bundle metadata = dataBuffer.getMetadata();
        if (metadata == null || metadata.getString(KEY_PREV_PAGE_TOKEN) == null) {
            AppMethodBeat.o(11563);
            return false;
        }
        AppMethodBeat.o(11563);
        return true;
    }
}
