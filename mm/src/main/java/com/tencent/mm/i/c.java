package com.tencent.mm.i;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c {
    public long field_finishedLength;
    public boolean field_isUploadTask = false;
    public boolean field_mtlnotify;
    public int field_status;
    public long field_toltalLength;
    public String mediaId;

    public final String toString() {
        AppMethodBeat.i(120670);
        String format = String.format("id:%s total:%d finLen:%d status:%d,mtl:%b, upload:%b", this.mediaId, Long.valueOf(this.field_toltalLength), Long.valueOf(this.field_finishedLength), Integer.valueOf(this.field_status), Boolean.valueOf(this.field_mtlnotify), Boolean.valueOf(this.field_isUploadTask));
        AppMethodBeat.o(120670);
        return format;
    }
}
