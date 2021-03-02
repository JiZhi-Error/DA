package com.tencent.mm.plugin.game.media;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.g.c.cw;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public final class c extends cw {
    protected static IAutoDBItem.MAutoDBInfo info;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    static {
        AppMethodBeat.i(40945);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[16];
        mAutoDBInfo.columns = new String[17];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = ch.COL_LOCALID;
        mAutoDBInfo.colsMap.put(ch.COL_LOCALID, "TEXT PRIMARY KEY ");
        sb.append(" localId TEXT PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = ch.COL_LOCALID;
        mAutoDBInfo.columns[1] = "mediaId";
        mAutoDBInfo.colsMap.put("mediaId", "TEXT");
        sb.append(" mediaId TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "mediaType";
        mAutoDBInfo.colsMap.put("mediaType", "INTEGER");
        sb.append(" mediaType INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "filePath";
        mAutoDBInfo.colsMap.put("filePath", "TEXT");
        sb.append(" filePath TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "compressPath";
        mAutoDBInfo.colsMap.put("compressPath", "TEXT");
        sb.append(" compressPath TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "thumbPath";
        mAutoDBInfo.colsMap.put("thumbPath", "TEXT");
        sb.append(" thumbPath TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[6] = "width";
        mAutoDBInfo.colsMap.put("width", "INTEGER");
        sb.append(" width INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[7] = "height";
        mAutoDBInfo.colsMap.put("height", "INTEGER");
        sb.append(" height INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[8] = FFmpegMetadataRetriever.METADATA_KEY_DURATION;
        mAutoDBInfo.colsMap.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, "INTEGER");
        sb.append(" duration INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[9] = "size";
        mAutoDBInfo.colsMap.put("size", "LONG");
        sb.append(" size LONG");
        sb.append(", ");
        mAutoDBInfo.columns[10] = "isGif";
        mAutoDBInfo.colsMap.put("isGif", "INTEGER");
        sb.append(" isGif INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[11] = "mediaUrl";
        mAutoDBInfo.colsMap.put("mediaUrl", "TEXT");
        sb.append(" mediaUrl TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[12] = "thumbPicUrl";
        mAutoDBInfo.colsMap.put("thumbPicUrl", "TEXT");
        sb.append(" thumbPicUrl TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[13] = "uploadState";
        mAutoDBInfo.colsMap.put("uploadState", "INTEGER default 'false' ");
        sb.append(" uploadState INTEGER default 'false' ");
        sb.append(", ");
        mAutoDBInfo.columns[14] = "hostTaskId";
        mAutoDBInfo.colsMap.put("hostTaskId", "TEXT");
        sb.append(" hostTaskId TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[15] = "editFlag";
        mAutoDBInfo.colsMap.put("editFlag", "INTEGER default '0' ");
        sb.append(" editFlag INTEGER default '0' ");
        mAutoDBInfo.columns[16] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(40945);
    }
}
