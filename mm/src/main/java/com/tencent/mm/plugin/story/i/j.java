package com.tencent.mm.plugin.story.i;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.g.c.en;
import com.tencent.mm.model.cl;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.story.e.a;
import com.tencent.mm.plugin.story.f.i;
import com.tencent.mm.plugin.story.f.q;
import com.tencent.mm.plugin.story.i.a;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.edu;
import com.tencent.mm.protocal.protobuf.eea;
import com.tencent.mm.protocal.protobuf.eek;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0012\n\u0002\b\n\u0018\u0000 ]2\u00020\u0001:\u0001]B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u000bJ\u000e\u00104\u001a\u0002022\u0006\u00105\u001a\u00020\u000bJ\u0006\u00106\u001a\u00020\u001dJ\u0006\u00107\u001a\u00020\u001dJ\u0006\u00108\u001a\u00020\u001dJ\u0006\u00109\u001a\u000202J\u0006\u0010:\u001a\u000202J\u0010\u0010;\u001a\u0002022\u0006\u0010<\u001a\u00020=H\u0016J\b\u0010>\u001a\u00020?H\u0014J\u0006\u0010@\u001a\u00020AJ\u0006\u0010B\u001a\u00020CJ\u0006\u0010D\u001a\u00020\u001dJ\u0006\u0010E\u001a\u00020\u001dJ\u0006\u0010F\u001a\u00020\u001dJ\u0006\u0010G\u001a\u00020\u001dJ\u0006\u0010H\u001a\u00020\u001dJ\u0016\u0010I\u001a\u00020\u001d2\u0006\u0010J\u001a\u00020\u000b2\u0006\u0010K\u001a\u00020#J\u0006\u0010L\u001a\u00020\u001dJ\u000e\u0010M\u001a\u0002022\u0006\u00103\u001a\u00020\u000bJ\u000e\u0010N\u001a\u0002022\u0006\u00105\u001a\u00020\u000bJ\u000e\u0010O\u001a\u00020\u001d2\u0006\u0010P\u001a\u00020CJ\u0006\u0010Q\u001a\u000202J\u000e\u0010R\u001a\u0002022\u0006\u0010S\u001a\u00020TJ\u0006\u0010U\u001a\u000202J\u0006\u0010V\u001a\u000202J\u0006\u0010W\u001a\u000202J\u0006\u0010X\u001a\u000202J\u0006\u0010Y\u001a\u000202J\u000e\u0010Z\u001a\u0002022\u0006\u0010[\u001a\u00020CJ\u0006\u0010\\\u001a\u000202R\"\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b8F@FX\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\"\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0007\"\u0004\b\u0016\u0010\tR\u001c\u0010\u0017\u001a\u00020\u000b8FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000e\"\u0004\b\u0019\u0010\u0010R$\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b8F@FX\u000e¢\u0006\f\u001a\u0004\b\u001b\u0010\u000e\"\u0004\b\u001c\u0010\u0010R$\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\n\u001a\u00020\u001d8F@FX\u000e¢\u0006\f\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R$\u0010$\u001a\u00020#2\u0006\u0010\n\u001a\u00020#8F@FX\u000e¢\u0006\f\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R$\u0010)\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b8F@FX\u000e¢\u0006\f\u001a\u0004\b*\u0010\u000e\"\u0004\b+\u0010\u0010R(\u0010,\u001a\u0004\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u00058F@FX\u000e¢\u0006\f\u001a\u0004\b-\u0010.\"\u0004\b/\u00100¨\u0006^"}, hxF = {"Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "Lcom/tencent/mm/autogen/table/BaseMMStoryInfo;", "()V", "blackList", "", "", "getBlackList", "()Ljava/util/List;", "setBlackList", "(Ljava/util/List;)V", "value", "", "createTime", "getCreateTime", "()I", "setCreateTime", "(I)V", FFmpegMetadataRetriever.METADATA_KEY_DATE, "getDate", "setDate", "groupList", "getGroupList", "setGroupList", ch.COL_LOCALID, "getLocalId", "setLocalId", "readCount", "getReadCount", "setReadCount", "", "showIndicator", "getShowIndicator", "()Z", "setShowIndicator", "(Z)V", "", "storyId", "getStoryId", "()J", "setStoryId", "(J)V", "type", "getType", "setType", "userName", "getUserName", "()Ljava/lang/String;", "setUserName", "(Ljava/lang/String;)V", "addSourceFlag", "", "mmsourceType", "addStoryItemFlag", "storyItemFlag", "checkFavorite", "checkNotifySns", "checkVisiableSelfOnly", "cleanPostFinish", "clearItemDie", "convertFrom", "cu", "Landroid/database/Cursor;", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getPostInfo", "Lcom/tencent/mm/protocal/protobuf/StoryMediaPostInfo;", "getTimeLine", "Lcom/tencent/mm/protocal/protobuf/StoryTimelineObject;", "isDeprecated", "isDeprecatedForFav", "isItemDie", "isItemFinish", "isReadStatus", "isTimeLimit", "tryCount", "startTime", "isUnreadStatus", "removeSourceFlag", "removeStoryItemFlag", "setContent", "contentObj", "setItemDie", "setPostBuf", "postBuf", "", "setPostFinish", "setPostMixFinish", "setPostMixWaiting", "setPostWaiting", "setReadStatus", "setTimeLine", "timeline", "setUnreadStatus", "Companion", "plugin-story_release"})
public final class j extends en {
    private static final String COL_ROWID = "rowid";
    private static final String Fwq = Fwq;
    private static final String Fwr = Fwr;
    public static final a Fws = new a((byte) 0);
    private static final String TABLEINDEXUSERNAME = TABLEINDEXUSERNAME;
    private static final String TAG = TAG;
    private static final IAutoDBItem.MAutoDBInfo info = en.ajs();
    private List<String> EZY = new ArrayList();
    private List<String> FjN = new ArrayList();
    public int Fwp;
    public int ecf;

    public j() {
        AppMethodBeat.i(119549);
        AppMethodBeat.o(119549);
    }

    public final List<String> avv() {
        AppMethodBeat.i(119530);
        eea eea = new eea();
        try {
            eea.parseFrom(this.field_attrBuf);
        } catch (Exception e2) {
            Log.printDebugStack("safeParser", "", e2);
        }
        ArrayList arrayList = new ArrayList();
        LinkedList<dqi> linkedList = eea.GroupUser;
        if (linkedList == null || linkedList.isEmpty()) {
            ArrayList arrayList2 = new ArrayList();
            AppMethodBeat.o(119530);
            return arrayList2;
        }
        LinkedList<dqi> linkedList2 = eea.GroupUser;
        p.g(linkedList2, "storyObj.GroupUser");
        for (T t : linkedList2) {
            p.g(t, LocaleUtil.ITALIAN);
            arrayList.add(t.MTo);
        }
        ArrayList arrayList3 = arrayList;
        AppMethodBeat.o(119530);
        return arrayList3;
    }

    public final List<String> frE() {
        AppMethodBeat.i(119531);
        eea eea = new eea();
        try {
            eea.parseFrom(this.field_attrBuf);
        } catch (Exception e2) {
            Log.printDebugStack("safeParser", "", e2);
        }
        ArrayList arrayList = new ArrayList();
        LinkedList<dqi> linkedList = eea.BlackList;
        if (linkedList == null || linkedList.isEmpty()) {
            ArrayList arrayList2 = new ArrayList();
            AppMethodBeat.o(119531);
            return arrayList2;
        }
        LinkedList<dqi> linkedList2 = eea.BlackList;
        p.g(linkedList2, "storyObj.BlackList");
        for (T t : linkedList2) {
            p.g(t, LocaleUtil.ITALIAN);
            arrayList.add(t.MTo);
        }
        ArrayList arrayList3 = arrayList;
        AppMethodBeat.o(119531);
        return arrayList3;
    }

    public final boolean frF() {
        AppMethodBeat.i(119532);
        int i2 = this.field_localFlag;
        a.d dVar = a.d.FvM;
        boolean cW = d.cW(i2, a.d.frp());
        AppMethodBeat.o(119532);
        return cW;
    }

    public final void vX(boolean z) {
        int frp;
        AppMethodBeat.i(119533);
        if (z) {
            int i2 = this.field_localFlag;
            a.d dVar = a.d.FvM;
            frp = i2 | a.d.frp();
        } else {
            int i3 = this.field_localFlag;
            a.d dVar2 = a.d.FvM;
            frp = i3 & (a.d.frp() ^ -1);
        }
        this.field_localFlag = frp;
        AppMethodBeat.o(119533);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0019\u0010\u000f\u001a\n \u0011*\u0004\u0018\u00010\u00100\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/plugin/story/storage/StoryInfo$Companion;", "", "()V", "COL_ROWID", "", "getCOL_ROWID", "()Ljava/lang/String;", "TABLEINDEXUSERNAME", "getTABLEINDEXUSERNAME", "TAG", "getTAG", "TableIndexUsernameCreateTime", "getTableIndexUsernameCreateTime", "TableIndexUsernameTime", "getTableIndexUsernameTime", "info", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "kotlin.jvm.PlatformType", "getInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(119550);
        AppMethodBeat.o(119550);
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        AppMethodBeat.i(119534);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = info;
        p.g(mAutoDBInfo, "info");
        AppMethodBeat.o(119534);
        return mAutoDBInfo;
    }

    @Override // com.tencent.mm.g.c.en, com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public final void convertFrom(Cursor cursor) {
        AppMethodBeat.i(119535);
        p.h(cursor, "cu");
        super.convertFrom(cursor);
        this.ecf = (int) this.systemRowid;
        a.C1747a aVar = com.tencent.mm.plugin.story.e.a.Flw;
        this.Fwp = a.C1747a.Ki(((long) this.field_createTime) * 1000);
        AppMethodBeat.o(119535);
    }

    public final eek frG() {
        AppMethodBeat.i(119536);
        if (this.field_content == null) {
            q.a aVar = q.FmO;
            eek fox = q.a.fox();
            AppMethodBeat.o(119536);
            return fox;
        }
        try {
            com.tencent.mm.bw.a parseFrom = new eek().parseFrom(this.field_content);
            if (parseFrom == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryTimelineObject");
                AppMethodBeat.o(119536);
                throw tVar;
            }
            eek eek = (eek) parseFrom;
            AppMethodBeat.o(119536);
            return eek;
        } catch (Exception e2) {
            Log.e(TAG, "error get storyinfo timeline!");
            q.a aVar2 = q.FmO;
            eek fox2 = q.a.fox();
            AppMethodBeat.o(119536);
            return fox2;
        }
    }

    public final void b(eek eek) {
        AppMethodBeat.i(119537);
        p.h(eek, "timeline");
        try {
            this.field_content = eek.toByteArray();
            AppMethodBeat.o(119537);
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
            AppMethodBeat.o(119537);
        }
    }

    public final void setPostBuf(byte[] bArr) {
        AppMethodBeat.i(119538);
        p.h(bArr, "postBuf");
        this.field_postBuf = bArr;
        AppMethodBeat.o(119538);
    }

    public final void setPostWaiting() {
        AppMethodBeat.i(119539);
        int i2 = this.field_localFlag;
        a.d dVar = a.d.FvM;
        this.field_localFlag = i2 | a.d.frm();
        AppMethodBeat.o(119539);
    }

    public final void setItemDie() {
        AppMethodBeat.i(119540);
        int i2 = this.field_localFlag;
        a.d dVar = a.d.FvM;
        this.field_localFlag = i2 | a.d.frn();
        AppMethodBeat.o(119540);
    }

    public final void clearItemDie() {
        AppMethodBeat.i(119541);
        int i2 = this.field_localFlag;
        a.d dVar = a.d.FvM;
        this.field_localFlag = i2 & (a.d.frn() ^ -1);
        AppMethodBeat.o(119541);
    }

    public final boolean frH() {
        AppMethodBeat.i(119542);
        int i2 = this.field_localFlag;
        a.d dVar = a.d.FvM;
        if ((i2 & a.d.frn()) != 0) {
            AppMethodBeat.o(119542);
            return true;
        }
        AppMethodBeat.o(119542);
        return false;
    }

    public final boolean c(eek eek) {
        AppMethodBeat.i(119543);
        p.h(eek, "contentObj");
        try {
            this.field_content = eek.toByteArray();
            AppMethodBeat.o(119543);
            return true;
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
            AppMethodBeat.o(119543);
            return false;
        }
    }

    public final edu frI() {
        AppMethodBeat.i(119544);
        edu edu = new edu();
        if (this.field_postBuf == null) {
            AppMethodBeat.o(119544);
            return edu;
        }
        try {
            com.tencent.mm.bw.a parseFrom = new edu().parseFrom(this.field_postBuf);
            if (parseFrom == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryMediaPostInfo");
                AppMethodBeat.o(119544);
                throw tVar;
            }
            edu edu2 = (edu) parseFrom;
            AppMethodBeat.o(119544);
            return edu2;
        } catch (Exception e2) {
            Log.e(TAG, "error get StoryMediaPostInfo " + this.field_storyID);
            edu edu3 = new edu();
            AppMethodBeat.o(119544);
            return edu3;
        }
    }

    public final void addSourceFlag(int i2) {
        this.field_sourceType |= i2;
    }

    public final void aaY(int i2) {
        this.field_itemStoryFlag |= i2;
    }

    public final void aaZ(int i2) {
        this.field_itemStoryFlag &= i2 ^ -1;
    }

    public final boolean frJ() {
        AppMethodBeat.i(119545);
        int i2 = this.field_itemStoryFlag;
        a.C1768a aVar = a.FvD;
        boolean cW = d.cW(i2, a.Fvt);
        AppMethodBeat.o(119545);
        return cW;
    }

    public final boolean frK() {
        AppMethodBeat.i(119546);
        int i2 = this.field_itemStoryFlag;
        a.C1768a aVar = a.FvD;
        boolean cW = d.cW(i2, a.Fvu);
        AppMethodBeat.o(119546);
        return cW;
    }

    public static boolean isTimeLimit(int i2, long j2) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(119547);
        if (ac.jPJ) {
            Log.i(TAG, "Android Test time limit fail " + ac.jPJ);
            AppMethodBeat.o(119547);
        } else {
            int aWB = cl.aWB() - ((int) j2);
            a.C1768a aVar = a.FvD;
            boolean z3 = aWB > a.Fvn;
            if (i2 > 5) {
                z = true;
            } else {
                z = false;
            }
            if (!z3 && !z) {
                z2 = false;
            }
            if (z2) {
                Log.i(TAG, "isTimeLimit " + z3 + "  " + z + " tryCount:" + i2 + " startTime " + j2 + "  svr: " + cl.aWB());
            }
            AppMethodBeat.o(119547);
        }
        return z2;
    }

    public final boolean frL() {
        AppMethodBeat.i(119548);
        int i2 = this.field_createTime;
        int aWB = cl.aWB();
        i.a aVar = i.Fmb;
        if (i2 <= aWB - i.FlY) {
            AppMethodBeat.o(119548);
            return true;
        }
        AppMethodBeat.o(119548);
        return false;
    }
}
