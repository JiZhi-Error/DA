package com.tencent.mm.plugin.story.f.g;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.recordvideo.d.c;
import com.tencent.mm.plugin.sight.base.e;
import com.tencent.mm.plugin.story.e.a;
import com.tencent.mm.plugin.story.e.b;
import com.tencent.mm.plugin.story.f.g.c;
import com.tencent.mm.plugin.story.f.j;
import com.tencent.mm.plugin.story.f.m;
import com.tencent.mm.plugin.story.f.q;
import com.tencent.mm.plugin.story.i.a;
import com.tencent.mm.plugin.story.i.h;
import com.tencent.mm.plugin.story.i.j;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cly;
import com.tencent.mm.protocal.protobuf.dlg;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.eds;
import com.tencent.mm.protocal.protobuf.edt;
import com.tencent.mm.protocal.protobuf.edu;
import com.tencent.mm.protocal.protobuf.eea;
import com.tencent.mm.protocal.protobuf.eek;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 /2\u00020\u0001:\u0001/B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0006\u0010\u0011\u001a\u00020\u0012J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0010J\u001e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0010J\u0014\u0010\u0019\u001a\u00020\u000e2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00100\u001bJ\u000e\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u0012J\u0014\u0010!\u001a\u00020\u000e2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00100\u001bJ\u000e\u0010#\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020\u0014J\u0010\u0010%\u001a\u00020\u00002\b\u0010&\u001a\u0004\u0018\u00010'J\u000e\u0010(\u001a\u00020\u000e2\u0006\u0010)\u001a\u00020\u0010J\u000e\u0010*\u001a\u00020\u000e2\u0006\u0010+\u001a\u00020\u0012J\u000e\u0010,\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u0004J\u0014\u0010-\u001a\u00020\u000e2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00100\u001bR\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000¨\u00060"}, hxF = {"Lcom/tencent/mm/plugin/story/model/upload/UploadPackHelper;", "", "()V", IssueStorage.COLUMN_EXT_INFO, "Lcom/tencent/mm/protocal/protobuf/MMSightExtInfo;", "postInfo", "Lcom/tencent/mm/protocal/protobuf/StoryMediaPostInfo;", "storyInfo", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "storyObj", "Lcom/tencent/mm/protocal/protobuf/StoryObject;", "timelineInfo", "Lcom/tencent/mm/protocal/protobuf/StoryTimelineObject;", "checkToCreateDir", "", "newVideoPath", "", "commit", "", "createStory", "", "taskId", "thumbPath", "path", "videoMd5", "setBlackUserList", "blackList", "", "setEditorData", "editorInfo", "Lcom/tencent/mm/protocal/protobuf/StoryMediaEditorInfo;", "setFavorite", "favorite", "setGroupUserList", "groupList", "setImageVideo", "isImageVideo", "setLocation", FirebaseAnalytics.b.LOCATION, "Lcom/tencent/mm/protocal/protobuf/RecordLocationInfo;", "setPublishObjId", "publishObjId", "setScope", "scope", "setSightExtInfo", "setSrcMd5List", "srcMd5List", "Companion", "plugin-story_release"})
public final class d {
    public static final a FqJ = new a((byte) 0);
    private static final Pattern PATTERN = Pattern.compile("(\n){3,}");
    private static final String TAG = TAG;
    private cly EsS;
    private edu FqG;
    private eek FqH;
    private eea FqI = new eea();
    private j Fqr = new j();

    public d() {
        AppMethodBeat.i(119129);
        this.Fqr.setPostWaiting();
        j jVar = this.Fqr;
        a.C1768a aVar = com.tencent.mm.plugin.story.i.a.FvD;
        int i2 = com.tencent.mm.plugin.story.i.a.FuJ;
        a.C1768a aVar2 = com.tencent.mm.plugin.story.i.a.FvD;
        jVar.addSourceFlag(i2 | com.tencent.mm.plugin.story.i.a.FuL);
        j jVar2 = this.Fqr;
        j.b bVar = com.tencent.mm.plugin.story.f.j.Fmy;
        jVar2.field_userName = j.b.fau();
        this.Fqr.field_createTime = cl.aWB();
        this.FqG = new edu();
        this.EsS = new cly();
        edu edu = this.FqG;
        StringBuilder sb = new StringBuilder();
        j.b bVar2 = com.tencent.mm.plugin.story.f.j.Fmy;
        String sb2 = sb.append(j.b.fau()).append(Util.currentTicks()).append(cl.aWz()).toString();
        Charset charset = kotlin.n.d.UTF_8;
        if (sb2 == null) {
            t tVar = new t("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(119129);
            throw tVar;
        }
        byte[] bytes = sb2.getBytes(charset);
        p.g(bytes, "(this as java.lang.String).getBytes(charset)");
        edu.izX = g.getMessageDigest(bytes);
        q.a aVar3 = q.FmO;
        this.FqH = q.a.fox();
        eek eek = this.FqH;
        j.b bVar3 = com.tencent.mm.plugin.story.f.j.Fmy;
        eek.UserName = j.b.fau();
        this.FqH.CreateTime = this.Fqr.field_createTime;
        this.FqI.Nem = new SKBuiltinBuffer_t();
        c cVar = c.BXI;
        String ahj = c.eKX().ahj();
        ahj = ahj == null ? "" : ahj;
        p.h(ahj, "publishObjId");
        this.FqH.NeC = ahj;
        Log.d(TAG, "storyInfo.createTime=%s timelineInfo.CreateTime=%s", Integer.valueOf(this.Fqr.field_createTime), Integer.valueOf(this.FqH.CreateTime));
        AppMethodBeat.o(119129);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tXD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/story/model/upload/UploadPackHelper$Companion;", "", "()V", "PATTERN", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "getPATTERN", "()Ljava/util/regex/Pattern;", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(119130);
        AppMethodBeat.o(119130);
    }

    private static void aPG(String str) {
        AppMethodBeat.i(119121);
        s.boN(s.boZ(str));
        AppMethodBeat.o(119121);
    }

    public final int commit() {
        AppMethodBeat.i(119122);
        try {
            this.FqG.MsZ = (long) cl.aWB();
            this.FqG.ibG = 0;
            com.tencent.mm.plugin.story.i.j jVar = this.Fqr;
            byte[] byteArray = this.FqG.toByteArray();
            p.g(byteArray, "postInfo.toByteArray()");
            jVar.setPostBuf(byteArray);
            this.Fqr.field_attrBuf = this.FqI.toByteArray();
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
        }
        this.Fqr.b(this.FqH);
        j.b bVar = com.tencent.mm.plugin.story.f.j.Fmy;
        int f2 = j.b.foc().f(this.Fqr);
        j.b bVar2 = com.tencent.mm.plugin.story.f.j.Fmy;
        c foi = j.b.foi();
        com.tencent.mm.ac.d.h(new c.e(foi, f2));
        foi.checkPost();
        m.a aVar = m.FmL;
        com.tencent.mm.plugin.story.i.j jVar2 = this.Fqr;
        p.h(jVar2, "storyInfo");
        if (f2 != -1) {
            a.C1747a aVar2 = com.tencent.mm.plugin.story.e.a.Flw;
            String n = a.C1747a.n(Integer.valueOf(jVar2.field_createTime));
            Log.d(m.TAG, "insertByLocalStory date=".concat(String.valueOf(n)));
            j.b bVar3 = com.tencent.mm.plugin.story.f.j.Fmy;
            h aSy = j.b.foh().aSy(n);
            if (aSy == null) {
                aSy = new h();
            }
            p.h(n, "value");
            aSy.field_date = n;
            aSy.field_count++;
            Log.d(m.TAG, "storyHistory.count=" + aSy.field_count);
            j.b bVar4 = com.tencent.mm.plugin.story.f.j.Fmy;
            j.b.foh().a(aSy);
        }
        Log.d(TAG, "save story to db: ".concat(String.valueOf(f2)));
        AppMethodBeat.o(119122);
        return f2;
    }

    public final void hs(List<String> list) {
        AppMethodBeat.i(119123);
        p.h(list, "groupList");
        if (!(list.isEmpty())) {
            LinkedList linkedList = new LinkedList();
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                dqi dqi = new dqi();
                dqi.bhy(it.next());
                linkedList.add(dqi);
            }
            this.FqI.GroupUser.addAll(linkedList);
            this.FqI.GroupUserCount = linkedList.size();
        }
        AppMethodBeat.o(119123);
    }

    public final void ht(List<String> list) {
        AppMethodBeat.i(119124);
        p.h(list, "blackList");
        if (!(list.isEmpty())) {
            LinkedList linkedList = new LinkedList();
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                dqi dqi = new dqi();
                dqi.bhy(it.next());
                linkedList.add(dqi);
            }
            this.FqI.BlackList.addAll(linkedList);
            this.FqI.BlackListCount = linkedList.size();
        }
        AppMethodBeat.o(119124);
    }

    public final void hu(List<String> list) {
        AppMethodBeat.i(222912);
        p.h(list, "srcMd5List");
        if (!(list.isEmpty())) {
            this.FqG.Nei.addAll(list);
        }
        AppMethodBeat.o(222912);
    }

    public final void a(cly cly) {
        AppMethodBeat.i(119125);
        p.h(cly, IssueStorage.COLUMN_EXT_INFO);
        this.EsS = cly;
        AppMethodBeat.o(119125);
    }

    public final d b(dlg dlg) {
        if (dlg != null) {
            this.FqH.NeA = dlg;
        }
        return this;
    }

    public final void a(eds eds) {
        AppMethodBeat.i(119126);
        p.h(eds, "editorInfo");
        this.FqG.Nef = eds;
        AppMethodBeat.o(119126);
    }

    public final void aaJ(int i2) {
        this.FqH.NeD = i2;
    }

    public final void vO(boolean z) {
        this.FqG.Neh = z;
    }

    public final boolean aV(String str, String str2, String str3) {
        AppMethodBeat.i(119127);
        p.h(str, "path");
        p.h(str2, "thumbPath");
        p.h(str3, "videoMd5");
        q.a aVar = q.FmO;
        edt edt = new edt();
        StringBuilder sb = new StringBuilder();
        b.a aVar2 = b.FlA;
        StringBuilder append = sb.append(b.Flx);
        String sb2 = new StringBuilder().append(cl.aWz()).append('-').append(Util.currentTicks()).toString();
        Charset charset = kotlin.n.d.UTF_8;
        if (sb2 == null) {
            t tVar = new t("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(119127);
            throw tVar;
        }
        byte[] bytes = sb2.getBytes(charset);
        p.g(bytes, "(this as java.lang.String).getBytes(charset)");
        edt.Id = append.append(g.getMessageDigest(bytes)).toString();
        com.tencent.mm.plugin.story.f.l lVar = com.tencent.mm.plugin.story.f.l.FmK;
        String aRW = com.tencent.mm.plugin.story.f.l.aRW(edt.Id);
        com.tencent.mm.plugin.story.f.l lVar2 = com.tencent.mm.plugin.story.f.l.FmK;
        String aRV = com.tencent.mm.plugin.story.f.l.aRV(edt.Id);
        com.tencent.mm.plugin.story.f.l lVar3 = com.tencent.mm.plugin.story.f.l.FmK;
        com.tencent.mm.plugin.story.f.l.aLP(aRW);
        com.tencent.mm.plugin.story.f.l lVar4 = com.tencent.mm.plugin.story.f.l.FmK;
        com.tencent.mm.plugin.story.f.l.aLP(aRV);
        aPG(aRW);
        aPG(aRV);
        s.nw(str, aRW);
        s.nw(str2, aRV);
        edt.Ned = ((float) e.aNx(aRW).videoDuration) / 1000.0f;
        this.FqH.NeB.LoV.add(edt);
        AppMethodBeat.o(119127);
        return true;
    }

    public final boolean kZ(String str, String str2) {
        AppMethodBeat.i(119128);
        p.h(str, "taskId");
        p.h(str2, "thumbPath");
        q.a aVar = q.FmO;
        edt edt = new edt();
        StringBuilder sb = new StringBuilder();
        b.a aVar2 = b.FlA;
        StringBuilder append = sb.append(b.Flx);
        String sb2 = new StringBuilder().append(cl.aWz()).append('-').append(Util.currentTicks()).toString();
        Charset charset = kotlin.n.d.UTF_8;
        if (sb2 == null) {
            t tVar = new t("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(119128);
            throw tVar;
        }
        byte[] bytes = sb2.getBytes(charset);
        p.g(bytes, "(this as java.lang.String).getBytes(charset)");
        edt.Id = append.append(g.getMessageDigest(bytes)).toString();
        com.tencent.mm.plugin.story.f.l lVar = com.tencent.mm.plugin.story.f.l.FmK;
        String aRV = com.tencent.mm.plugin.story.f.l.aRV(edt.Id);
        aPG(aRV);
        s.nw(str2, aRV);
        edt.taskId = str;
        this.FqH.NeB.LoV.add(edt);
        com.tencent.mm.plugin.story.i.j jVar = this.Fqr;
        int i2 = jVar.field_localFlag;
        a.d dVar = a.d.FvM;
        jVar.field_localFlag = i2 | a.d.fro();
        com.tencent.mm.plugin.story.i.j jVar2 = this.Fqr;
        int i3 = jVar2.field_localFlag;
        a.d dVar2 = a.d.FvM;
        jVar2.field_localFlag = i3 & (a.d.frm() ^ -1);
        AppMethodBeat.o(119128);
        return true;
    }
}
