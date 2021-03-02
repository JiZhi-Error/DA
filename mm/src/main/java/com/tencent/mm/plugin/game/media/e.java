package com.tencent.mm.plugin.game.media;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cx;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public final class e extends cx {
    protected static IAutoDBItem.MAutoDBInfo info;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    static {
        AppMethodBeat.i(40951);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[13];
        mAutoDBInfo.columns = new String[14];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "taskId";
        mAutoDBInfo.colsMap.put("taskId", "TEXT PRIMARY KEY ");
        sb.append(" taskId TEXT PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "taskId";
        mAutoDBInfo.columns[1] = "createTime";
        mAutoDBInfo.colsMap.put("createTime", "LONG");
        sb.append(" createTime LONG");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "publishSource";
        mAutoDBInfo.colsMap.put("publishSource", "INTEGER");
        sb.append(" publishSource INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "mediaType";
        mAutoDBInfo.colsMap.put("mediaType", "INTEGER");
        sb.append(" mediaType INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "localIdList";
        mAutoDBInfo.colsMap.put("localIdList", "TEXT");
        sb.append(" localIdList TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "mediaList";
        mAutoDBInfo.colsMap.put("mediaList", "TEXT");
        sb.append(" mediaList TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[6] = "BusinessData";
        mAutoDBInfo.colsMap.put("BusinessData", "TEXT");
        sb.append(" BusinessData TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[7] = "uploadState";
        mAutoDBInfo.colsMap.put("uploadState", "INTEGER default '0' ");
        sb.append(" uploadState INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[8] = "publishState";
        mAutoDBInfo.colsMap.put("publishState", "INTEGER default '0' ");
        sb.append(" publishState INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[9] = "compressImg";
        mAutoDBInfo.colsMap.put("compressImg", "INTEGER default 'true' ");
        sb.append(" compressImg INTEGER default 'true' ");
        sb.append(", ");
        mAutoDBInfo.columns[10] = "mixState";
        mAutoDBInfo.colsMap.put("mixState", "INTEGER default '0' ");
        sb.append(" mixState INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[11] = "bgMixTaskId";
        mAutoDBInfo.colsMap.put("bgMixTaskId", "TEXT");
        sb.append(" bgMixTaskId TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[12] = "sourceSceneId";
        mAutoDBInfo.colsMap.put("sourceSceneId", "INTEGER default '0' ");
        sb.append(" sourceSceneId INTEGER default '0' ");
        mAutoDBInfo.columns[13] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(40951);
    }
}
