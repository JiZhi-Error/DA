package com.tencent.mm.plugin.story.f;

import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.story.e.a;
import com.tencent.mm.plugin.story.f.a.f;
import com.tencent.mm.plugin.story.f.a.m;
import com.tencent.mm.plugin.story.f.j;
import com.tencent.mm.plugin.story.f.q;
import com.tencent.mm.plugin.story.i.a;
import com.tencent.mm.plugin.story.i.h;
import com.tencent.mm.plugin.story.i.i;
import com.tencent.mm.plugin.story.i.j;
import com.tencent.mm.plugin.story.i.k;
import com.tencent.mm.protocal.protobuf.edk;
import com.tencent.mm.protocal.protobuf.edt;
import com.tencent.mm.protocal.protobuf.eea;
import com.tencent.mm.protocal.protobuf.eek;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.d;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, hxF = {"Lcom/tencent/mm/plugin/story/model/StoryInfoStorageLogic;", "", "()V", "Companion", "plugin-story_release"})
public final class n {
    public static final a FmM = new a((byte) 0);
    private static final String TAG = TAG;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0018\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0004J\u0006\u0010\u000e\u001a\u00020\u0006J\u000e\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\fJ\u0016\u0010\u0011\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\fJ\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u0004J\u0010\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0013J\u001e\u0010\u0017\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\fJ,\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00130\u001b2\u0006\u0010\b\u001a\u00020\u00042\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u001d2\u0006\u0010\u0019\u001a\u00020\fJ\u0016\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\fJ\u000e\u0010!\u001a\u00020\u001f2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\"\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0004J\u001e\u0010#\u001a\u00020\n2\u0006\u0010$\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\fJ&\u0010%\u001a\u00020\f2\u0006\u0010$\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u0004J\u0016\u0010&\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010'\u001a\u00020\fJ*\u0010(\u001a\u00020\u00062\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\n0\u001d2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\f0\u001d2\u0006\u0010'\u001a\u00020\u001fJ\u0016\u0010+\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010,\u001a\u00020\fJ&\u0010-\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010.\u001a\u00020\u001f2\u0006\u0010/\u001a\u00020\u001fJ\u001a\u00100\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u00042\b\u00101\u001a\u0004\u0018\u00010\u0004J2\u00102\u001a\u0004\u0018\u00010\u00132\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u00103\u001a\u00020\f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00152\u0006\u00104\u001a\u00020\u001fJ\u0016\u00105\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u00106\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u00067"}, hxF = {"Lcom/tencent/mm/plugin/story/model/StoryInfoStorageLogic$Companion;", "", "()V", "TAG", "", "cancelDeleteStory", "", "cleanHistoryFlag", "userName", "storyId", "", "deleteByUsername", "", ch.COL_USERNAME, "deleteDiedStoryByTime", "deleteLocalStory", ch.COL_LOCALID, "deleteRemoteStory", "getLastStory", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "getMergeStoryObjectWithCache", "Lcom/tencent/mm/protocal/protobuf/StoryObject;", "info", "insertStoryForHistory", "storyObj", "sourceType", "insertStoryList", "Ljava/util/LinkedList;", "list", "", "isStoryExist", "", "timeStamp", "isValidStoryId", "loadFavStoryFromRemote", "replace", "storyInfo", "replaceForHistory", "setStoryFavLocal", "favorite", "setStoryFavRemote", "idList", "localIdList", "setStoryPrivacyLocal", "visibility", "setStoryPrivacyRemote", ShareConstants.WEB_DIALOG_PARAM_PRIVACY, "deprecated", "updateNextAlbumSourceType", FFmpegMetadataRetriever.METADATA_KEY_DATE, "updateStoryBySync", "createTime", "isDelete", "updateStoryLocalFlag", "localFlag", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static LinkedList<j> b(String str, List<? extends eea> list, int i2) {
            AppMethodBeat.i(118742);
            p.h(str, "userName");
            if (list == null || list.isEmpty()) {
                LinkedList<j> linkedList = new LinkedList<>();
                AppMethodBeat.o(118742);
                return linkedList;
            }
            LinkedList<j> linkedList2 = new LinkedList<>();
            j.b bVar = j.Fmy;
            k foc = j.b.foc();
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                eea eea = (eea) list.get(i3);
                Log.d(n.TAG, "storyObj.id:" + eea.Id);
                com.tencent.mm.plugin.story.i.j Kx = foc.Kx(eea.Id);
                if (Kx == null) {
                    Kx = new com.tencent.mm.plugin.story.i.j();
                }
                if (!(a(Kx, eea, i2) == 0 || Kx.field_storyID == 0)) {
                    linkedList2.add(Kx);
                }
            }
            AppMethodBeat.o(118742);
            return linkedList2;
        }

        public static long a(com.tencent.mm.plugin.story.i.j jVar, eea eea, int i2) {
            AppMethodBeat.i(118743);
            p.h(jVar, "storyInfo");
            p.h(eea, "storyObj");
            if (eea.Nem == null || eea.Nem.getBuffer() == null) {
                Log.i(n.TAG, "object desc is null");
                long j2 = eea.Id;
                AppMethodBeat.o(118743);
                return j2;
            }
            byte[] byteArray = eea.Nem.getBuffer().toByteArray();
            p.g(byteArray, "storyObj.ObjDesc.getBuffer().toByteArray()");
            String str = new String(byteArray, d.UTF_8);
            q.a aVar = q.FmO;
            eek aSb = q.a.aSb(str);
            if (Util.isNullOrNil(str) || aSb == null) {
                long j3 = eea.Id;
                AppMethodBeat.o(118743);
                return j3;
            } else if (!jVar.c(aSb)) {
                long j4 = eea.Id;
                AppMethodBeat.o(118743);
                return j4;
            } else {
                Log.d(n.TAG, "from server xml ok " + eea.Id + " \n " + str);
                eea.Nem.setBuffer(new byte[0]);
                jVar.field_userName = eea.UserName;
                jVar.field_createTime = eea.CreateTime;
                jVar.field_storyID = eea.Id;
                jVar.field_attrBuf = eea.toByteArray();
                if (eea.Neq == 1) {
                    a.C1768a aVar2 = com.tencent.mm.plugin.story.i.a.FvD;
                    jVar.aaY(com.tencent.mm.plugin.story.i.a.Fvt);
                } else {
                    a.C1768a aVar3 = com.tencent.mm.plugin.story.i.a.FvD;
                    jVar.aaZ(com.tencent.mm.plugin.story.i.a.Fvt);
                }
                if (eea.Nej == 1) {
                    a.C1768a aVar4 = com.tencent.mm.plugin.story.i.a.FvD;
                    jVar.aaY(com.tencent.mm.plugin.story.i.a.Fvu);
                } else {
                    a.C1768a aVar5 = com.tencent.mm.plugin.story.i.a.FvD;
                    jVar.aaZ(com.tencent.mm.plugin.story.i.a.Fvu);
                }
                jVar.field_favoriteTime = eea.Ner;
                jVar.addSourceFlag(i2);
                eek frG = jVar.frG();
                frG.UserName = eea.UserName;
                jVar.b(frG);
                Log.d(n.TAG, "will replaceUserByPcId " + eea.Id);
                j.b bVar = j.Fmy;
                j.b.foc().e(jVar);
                long j5 = eea.Id;
                AppMethodBeat.o(118743);
                return j5;
            }
        }

        public static boolean fM(String str, int i2) {
            AppMethodBeat.i(118744);
            p.h(str, "userName");
            boolean z = false;
            j.b bVar = j.Fmy;
            k foc = j.b.foc();
            j.b bVar2 = j.Fmy;
            Iterator<T> it = foc.a(str, Util.isEqual(str, j.b.fau()), i2, true).iterator();
            while (it.hasNext()) {
                eek frG = it.next().frG();
                if (!(frG.NeB == null || frG.NeB.LoV.size() == 0)) {
                    z = true;
                }
            }
            AppMethodBeat.o(118744);
            return z;
        }

        public static void Z(long j2, int i2) {
            AppMethodBeat.i(118745);
            Log.d(n.TAG, "delete story item: " + i2 + ' ' + j2);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            a.C1768a aVar = com.tencent.mm.plugin.story.i.a.FvD;
            arrayList.add(new com.tencent.mm.plugin.story.f.a.l(j2, com.tencent.mm.plugin.story.i.a.Fvb));
            arrayList2.add(Integer.valueOf(i2));
            b aAg = g.aAg();
            p.g(aAg, "MMKernel.network()");
            aAg.azz().b(new f(arrayList, arrayList2));
            AppMethodBeat.o(118745);
        }

        public static void aaH(int i2) {
            String str;
            String str2;
            LinkedList<edt> linkedList;
            edt edt;
            LinkedList<edt> linkedList2;
            edt edt2;
            LinkedList<edt> linkedList3;
            edt edt3;
            String str3 = null;
            AppMethodBeat.i(118746);
            j.b bVar = j.Fmy;
            com.tencent.mm.plugin.story.i.j aba = j.b.foc().aba(i2);
            a.C1747a aVar = com.tencent.mm.plugin.story.e.a.Flw;
            String n = a.C1747a.n(aba != null ? Integer.valueOf(aba.field_createTime) : null);
            j.b bVar2 = j.Fmy;
            j.b.foc().Zs(i2);
            a aVar2 = n.FmM;
            j.b bVar3 = j.Fmy;
            com.tencent.mm.plugin.story.i.j aRZ = aRZ(j.b.fau());
            eek frG = aRZ.frG();
            edk edk = frG.NeB;
            if (edk == null || (linkedList3 = edk.LoV) == null || (edt3 = (edt) kotlin.a.j.L(linkedList3, 0)) == null) {
                str = null;
            } else {
                str = edt3.Msz;
            }
            edk edk2 = frG.NeB;
            if (edk2 == null || (linkedList2 = edk2.LoV) == null || (edt2 = (edt) kotlin.a.j.L(linkedList2, 0)) == null) {
                str2 = null;
            } else {
                str2 = edt2.Url;
            }
            edk edk3 = frG.NeB;
            float f2 = (edk3 == null || (linkedList = edk3.LoV) == null || (edt = (edt) kotlin.a.j.L(linkedList, 0)) == null) ? 0.0f : edt.Ned;
            k kVar = k.FmH;
            j.b bVar4 = j.Fmy;
            k.a(j.b.fau(), aRZ.field_storyID, aRZ.field_createTime, str, str2, (long) (f2 * 1000.0f));
            j.b bVar5 = j.Fmy;
            h aSy = j.b.foh().aSy(n);
            if (aSy != null) {
                aSy.field_count--;
                if (aSy.field_count <= 0) {
                    j.b bVar6 = j.Fmy;
                    i foh = j.b.foh();
                    p.h(n, FFmpegMetadataRetriever.METADATA_KEY_DATE);
                    foh.db.delete(i.TABLE, "date=?", new String[]{String.valueOf(n)});
                    AppMethodBeat.o(118746);
                    return;
                }
                if (aba != null) {
                    str3 = aba.field_userName;
                }
                if (!(str3 == null || n == null)) {
                    j.b bVar7 = j.Fmy;
                    k foc = j.b.foc();
                    a.C1747a aVar3 = com.tencent.mm.plugin.story.e.a.Flw;
                    List<com.tencent.mm.plugin.story.i.j> fN = foc.fN(str3, a.C1747a.aRN(n));
                    if (!fN.isEmpty()) {
                        a.C1768a aVar4 = com.tencent.mm.plugin.story.i.a.FvD;
                        fN.get(0).addSourceFlag(com.tencent.mm.plugin.story.i.a.FuL);
                        j.b bVar8 = j.Fmy;
                        j.b.foc().a((int) fN.get(0).systemRowid, fN.get(0));
                        Log.d(n.TAG, "update " + ((int) fN.get(0).systemRowid) + "'s sourceType to " + fN.get(0).field_sourceType + ' ');
                    }
                }
                j.b bVar9 = j.Fmy;
                j.b.foh().a(aSy);
            }
            AppMethodBeat.o(118746);
        }

        public static void c(long j2, int i2, boolean z, boolean z2) {
            AppMethodBeat.i(118747);
            Log.d(n.TAG, "setPrivacyRemote story item: " + j2 + " to " + z);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(Integer.valueOf(i2));
            int i3 = z ? 1 : 0;
            a.C1768a aVar = com.tencent.mm.plugin.story.i.a.FvD;
            arrayList.add(new m(j2, com.tencent.mm.plugin.story.i.a.Fvd, i3, z2));
            b aAg = g.aAg();
            p.g(aAg, "MMKernel.network()");
            aAg.azz().b(new f(arrayList, arrayList2));
            AppMethodBeat.o(118747);
        }

        public static void b(List<Long> list, List<Integer> list2, boolean z) {
            AppMethodBeat.i(118748);
            p.h(list, "idList");
            p.h(list2, "localIdList");
            Log.i(n.TAG, "setStoryFavRemote story count: " + list.size() + " to " + z);
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(list2);
            ArrayList arrayList2 = new ArrayList();
            int i2 = z ? 1 : 0;
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                long longValue = it.next().longValue();
                Log.d(n.TAG, "setStoryFavRemote story: " + longValue + " to " + z);
                a.C1768a aVar = com.tencent.mm.plugin.story.i.a.FvD;
                arrayList2.add(new com.tencent.mm.plugin.story.f.a.k(longValue, com.tencent.mm.plugin.story.i.a.Fve, i2));
            }
            b aAg = g.aAg();
            p.g(aAg, "MMKernel.network()");
            aAg.azz().b(new f(arrayList2, arrayList));
            AppMethodBeat.o(118748);
        }

        public static void jc(int i2, int i3) {
            AppMethodBeat.i(118749);
            Log.d(n.TAG, "setPrivacyLocal story item: " + i2 + " to " + i3);
            j.b bVar = j.Fmy;
            k foc = j.b.foc();
            com.tencent.mm.plugin.story.i.j aba = foc.aba(i2);
            if (aba != null) {
                if (i3 == 1) {
                    a.C1768a aVar = com.tencent.mm.plugin.story.i.a.FvD;
                    aba.aaY(com.tencent.mm.plugin.story.i.a.Fvt);
                } else {
                    a.C1768a aVar2 = com.tencent.mm.plugin.story.i.a.FvD;
                    aba.aaZ(com.tencent.mm.plugin.story.i.a.Fvt);
                }
                foc.replace(aba);
                AppMethodBeat.o(118749);
                return;
            }
            AppMethodBeat.o(118749);
        }

        public static void jd(int i2, int i3) {
            AppMethodBeat.i(118750);
            Log.d(n.TAG, "setStoryFavLocal story item: " + i2 + " to " + i3);
            j.b bVar = j.Fmy;
            k foc = j.b.foc();
            com.tencent.mm.plugin.story.i.j aba = foc.aba(i2);
            if (aba != null) {
                if (i3 == 1) {
                    a.C1768a aVar = com.tencent.mm.plugin.story.i.a.FvD;
                    aba.aaY(com.tencent.mm.plugin.story.i.a.Fvu);
                    aba.field_favoriteTime = cl.aWB();
                } else {
                    a.C1768a aVar2 = com.tencent.mm.plugin.story.i.a.FvD;
                    aba.aaZ(com.tencent.mm.plugin.story.i.a.Fvu);
                    aba.field_favoriteTime = 0;
                }
                foc.replace(aba);
                AppMethodBeat.o(118750);
                return;
            }
            AppMethodBeat.o(118750);
        }

        public static void fov() {
            AppMethodBeat.i(118751);
            b aAg = g.aAg();
            p.g(aAg, "MMKernel.network()");
            aAg.azz().cancel(764);
            AppMethodBeat.o(118751);
        }

        public static com.tencent.mm.plugin.story.i.j a(String str, long j2, int i2, eea eea, boolean z) {
            int i3;
            AppMethodBeat.i(118752);
            p.h(str, ch.COL_USERNAME);
            if (z) {
                j.b bVar = j.Fmy;
                j.b.foc().M(j2, str);
                AppMethodBeat.o(118752);
                return null;
            }
            j.b bVar2 = j.Fmy;
            com.tencent.mm.plugin.story.i.j Kx = j.b.foc().Kx(j2);
            if (Kx == null) {
                Kx = new com.tencent.mm.plugin.story.i.j();
            }
            Kx.field_storyID = j2;
            Kx.field_createTime = i2;
            Kx.field_userName = str;
            j.b bVar3 = j.Fmy;
            if (Util.isEqual(str, j.b.fau())) {
                a.C1768a aVar = com.tencent.mm.plugin.story.i.a.FvD;
                i3 = com.tencent.mm.plugin.story.i.a.FuJ;
            } else {
                a.C1768a aVar2 = com.tencent.mm.plugin.story.i.a.FvD;
                i3 = com.tencent.mm.plugin.story.i.a.FuK;
            }
            Kx.addSourceFlag(i3);
            if (eea != null) {
                a(Kx, eea, Kx.field_sourceType);
            } else {
                j.b bVar4 = j.Fmy;
                Kx.ecf = j.b.foc().f(Kx);
            }
            AppMethodBeat.o(118752);
            return Kx;
        }

        public static com.tencent.mm.plugin.story.i.j aRZ(String str) {
            AppMethodBeat.i(118753);
            p.h(str, ch.COL_USERNAME);
            j.b bVar = j.Fmy;
            k foc = j.b.foc();
            j.b bVar2 = j.Fmy;
            com.tencent.mm.plugin.story.i.j cx = foc.cx(str, Util.isEqual(j.b.fau(), str));
            AppMethodBeat.o(118753);
            return cx;
        }

        public static void aa(long j2, int i2) {
            AppMethodBeat.i(118754);
            j.b bVar = j.Fmy;
            k foc = j.b.foc();
            String str = "UPDATE " + k.TABLE + " SET localFlag = " + i2 + " Where storyID = '" + j2 + '\'';
            Log.d(k.TAG, "updateSourceTypeBefore sql ".concat(String.valueOf(str)));
            foc.db.execSQL(k.TABLE, str);
            AppMethodBeat.o(118754);
        }
    }

    static {
        AppMethodBeat.i(118755);
        AppMethodBeat.o(118755);
    }
}
