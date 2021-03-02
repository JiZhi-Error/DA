package com.tencent.mm.plugin.story.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.em;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0014J\b\u0010\u0018\u001a\u00020\u0004H\u0016R$\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u000e¢\u0006\f\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n8F@FX\u000e¢\u0006\f\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u001a"}, hxF = {"Lcom/tencent/mm/plugin/story/storage/StoryHistoryInfo;", "Lcom/tencent/mm/autogen/table/BaseMMStoryHistoryItem;", "()V", "value", "", FFmpegMetadataRetriever.METADATA_KEY_DATE, "getDate", "()Ljava/lang/String;", "setDate", "(Ljava/lang/String;)V", "", "storyCount", "getStoryCount", "()I", "setStoryCount", "(I)V", "storyInfo", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "getStoryInfo", "()Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "setStoryInfo", "(Lcom/tencent/mm/plugin/story/storage/StoryInfo;)V", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "toString", "Companion", "plugin-story_release"})
public final class h extends em {
    public static final a Fwn = new a((byte) 0);
    private static final String TAG = TAG;
    private static final IAutoDBItem.MAutoDBInfo info = em.ajs();
    public j Fqr = new j();

    public h() {
        AppMethodBeat.i(119522);
        AppMethodBeat.o(119522);
    }

    public final String frD() {
        AppMethodBeat.i(119519);
        String str = this.field_date;
        p.g(str, "field_date");
        AppMethodBeat.o(119519);
        return str;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u0011R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/story/storage/StoryHistoryInfo$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "info", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "kotlin.jvm.PlatformType", "getInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "fromItem", "Lcom/tencent/mm/plugin/story/storage/StoryHistoryInfo;", "item", "Lcom/tencent/mm/protocal/protobuf/StoryHistoryItem;", "fromStoryInfo", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(119523);
        AppMethodBeat.o(119523);
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        AppMethodBeat.i(119520);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = info;
        p.g(mAutoDBInfo, "StoryHistoryInfo.info");
        AppMethodBeat.o(119520);
        return mAutoDBInfo;
    }

    public final String toString() {
        AppMethodBeat.i(119521);
        StringBuilder sb = new StringBuilder("StoryHistoryInfo[localId:");
        j jVar = this.Fqr;
        String sb2 = sb.append((jVar != null ? Integer.valueOf((int) jVar.systemRowid) : null).intValue()).append(" date:").append(frD()).append(" count:").append(this.field_count).append(']').toString();
        AppMethodBeat.o(119521);
        return sb2;
    }
}
