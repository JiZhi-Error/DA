package com.tencent.mm.plugin.finder.report;

import com.facebook.appevents.AppEventsConstants;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.g.a.ia;
import com.tencent.mm.g.b.a.di;
import com.tencent.mm.g.b.a.dl;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.e;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.plugin.finder.upload.q;
import com.tencent.mm.plugin.finder.utils.al;
import com.tencent.mm.plugin.finder.utils.s;
import com.tencent.mm.plugin.finder.utils.w;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.recordvideo.jumper.RecordMediaReportInfo;
import com.tencent.mm.protocal.protobuf.FinderFeedReportObject;
import com.tencent.mm.protocal.protobuf.FinderMediaReportInfo;
import com.tencent.mm.protocal.protobuf.axt;
import com.tencent.mm.protocal.protobuf.cjj;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.protocal.protobuf.cng;
import com.tencent.mm.protocal.protobuf.cnl;
import com.tencent.mm.protocal.protobuf.cod;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.n.n;
import kotlin.x;
import org.json.JSONArray;
import org.json.JSONObject;

public final class i {
    private static final String TAG = TAG;
    private static FinderFeedReportObject vfk;
    private static final long vfl = 2;
    private static q vfm = new a();
    private static final int vfn = 14;
    public static final i vfo = new i();

    static {
        AppMethodBeat.i(166575);
        AppMethodBeat.o(166575);
    }

    private i() {
    }

    public static final /* synthetic */ JSONObject c(JSONObject jSONObject, String str, int i2) {
        AppMethodBeat.i(250621);
        JSONObject b2 = b(jSONObject, str, i2);
        AppMethodBeat.o(250621);
        return b2;
    }

    public static String getTAG() {
        return TAG;
    }

    public static FinderFeedReportObject dnX() {
        return vfk;
    }

    public static void as(int i2, boolean z) {
        AppMethodBeat.i(250602);
        vfk = new FinderFeedReportObject();
        if (z) {
            FinderFeedReportObject finderFeedReportObject = vfk;
            if (finderFeedReportObject != null) {
                d.c(TAG, new c(finderFeedReportObject, z, i2));
                AppMethodBeat.o(250602);
                return;
            }
            AppMethodBeat.o(250602);
            return;
        }
        FinderFeedReportObject finderFeedReportObject2 = vfk;
        if (finderFeedReportObject2 != null) {
            finderFeedReportObject2.sessionId = ((com.tencent.mm.plugin.expt.b.c) g.af(com.tencent.mm.plugin.expt.b.c.class)).cMD();
            finderFeedReportObject2.enterScene = i2;
            finderFeedReportObject2.draft = z ? 1 : 0;
            AppMethodBeat.o(250602);
            return;
        }
        AppMethodBeat.o(250602);
    }

    public static void Ko(int i2) {
        FinderFeedReportObject finderFeedReportObject = vfk;
        if (finderFeedReportObject != null) {
            finderFeedReportObject.soundTrackType = i2;
        }
    }

    public static void Kp(int i2) {
        FinderFeedReportObject finderFeedReportObject = vfk;
        if (finderFeedReportObject != null) {
            finderFeedReportObject.musicType = i2;
        }
    }

    public static void auE(String str) {
        AppMethodBeat.i(250603);
        p.h(str, "musicId");
        FinderFeedReportObject finderFeedReportObject = vfk;
        if (finderFeedReportObject != null) {
            finderFeedReportObject.videoMusicId = str;
            AppMethodBeat.o(250603);
            return;
        }
        AppMethodBeat.o(250603);
    }

    public static void Kq(int i2) {
        FinderFeedReportObject finderFeedReportObject = vfk;
        if (finderFeedReportObject != null) {
            finderFeedReportObject.draftType = i2;
        }
    }

    public static void auF(String str) {
        AppMethodBeat.i(250604);
        p.h(str, "followId");
        FinderFeedReportObject finderFeedReportObject = vfk;
        if (finderFeedReportObject != null) {
            finderFeedReportObject.followSoundTrackId = str;
            AppMethodBeat.o(250604);
            return;
        }
        AppMethodBeat.o(250604);
    }

    public static void Kr(int i2) {
        FinderFeedReportObject finderFeedReportObject = vfk;
        if (finderFeedReportObject != null) {
            finderFeedReportObject.videoSource = i2;
        }
    }

    public static void dz(String str, int i2) {
        AppMethodBeat.i(250605);
        p.h(str, "topicId");
        FinderFeedReportObject finderFeedReportObject = vfk;
        if (finderFeedReportObject != null) {
            finderFeedReportObject.topicActivityId = str;
            finderFeedReportObject.topicActivityType = i2;
            AppMethodBeat.o(250605);
            return;
        }
        AppMethodBeat.o(250605);
    }

    public static void auG(String str) {
        AppMethodBeat.i(250606);
        p.h(str, "appId");
        FinderFeedReportObject finderFeedReportObject = vfk;
        if (finderFeedReportObject != null) {
            finderFeedReportObject.forwardingAppId = str;
            AppMethodBeat.o(250606);
            return;
        }
        AppMethodBeat.o(250606);
    }

    public static void a(int i2, axt axt) {
        FinderFeedReportObject finderFeedReportObject = vfk;
        if (finderFeedReportObject != null) {
            finderFeedReportObject.lbsFlag = i2;
            finderFeedReportObject.selectLocation = axt;
        }
    }

    public static void c(ArrayList<cjj> arrayList, int i2, int i3) {
        int i4;
        AppMethodBeat.i(250607);
        FinderFeedReportObject finderFeedReportObject = vfk;
        if (finderFeedReportObject != null) {
            if (arrayList != null) {
                HashSet hashSet = new HashSet();
                Iterator<cjj> it = arrayList.iterator();
                while (it.hasNext()) {
                    String str = it.next().username;
                    if (str == null) {
                        str = "";
                    }
                    hashSet.add(str);
                }
                finderFeedReportObject.mentionCount = hashSet.size();
            }
            finderFeedReportObject.clickMentionCount = i2;
            finderFeedReportObject.clickSucMentionCount = i3;
            if (arrayList != null) {
                i4 = arrayList.size();
            } else {
                i4 = 0;
            }
            finderFeedReportObject.mentionRepeatCount = i4;
            AppMethodBeat.o(250607);
            return;
        }
        AppMethodBeat.o(250607);
    }

    public static void a(RecordMediaReportInfo recordMediaReportInfo) {
        int i2 = 1;
        AppMethodBeat.i(250608);
        p.h(recordMediaReportInfo, "reportInfo");
        FinderFeedReportObject finderFeedReportObject = vfk;
        if (finderFeedReportObject != null) {
            Object y = recordMediaReportInfo.y("KEY_RECORD_IS_BEAUTIFY", Boolean.FALSE);
            p.g(y, "reportInfo.getReportValu…ECORD_IS_BEAUTIFY, false)");
            finderFeedReportObject.isBeauty = ((Boolean) y).booleanValue() ? 1 : 0;
            Object y2 = recordMediaReportInfo.y("KEY_ORIGIN_MEDIA_DURATION_MS_LONG", 0L);
            p.g(y2, "reportInfo.getReportValu…DIA_DURATION_MS_LONG, 0L)");
            finderFeedReportObject.videoRecordTime = ((Number) y2).longValue();
            finderFeedReportObject.videoSource = ((Number) recordMediaReportInfo.y("KEY_MEDIA_SOURCE_INT", 0)).intValue() + 1;
            finderFeedReportObject.videoMusicId = String.valueOf(((Number) recordMediaReportInfo.y("KEY_MUSIC_REQ_ID_INT", 0)).intValue());
            Object y3 = recordMediaReportInfo.y("KEY_SEARCH_MUSIC_INT", 0);
            p.g(y3, "reportInfo.getReportValue(KEY_SEARCH_MUSIC_INT, 0)");
            finderFeedReportObject.videoMusicSearch = ((Number) y3).intValue();
            Object y4 = recordMediaReportInfo.y("KEY_MUSIC_INDEX_INT", 0);
            p.g(y4, "reportInfo.getReportValue(KEY_MUSIC_INDEX_INT, 0)");
            finderFeedReportObject.videoMusicIndex = ((Number) y4).intValue();
            Object y5 = recordMediaReportInfo.y("KEY_ADD_EMOJI_COUNT_INT", 0);
            p.g(y5, "reportInfo.getReportValu…Y_ADD_EMOJI_COUNT_INT, 0)");
            finderFeedReportObject.videoEmojiCount = ((Number) y5).intValue();
            Object y6 = recordMediaReportInfo.y("KEY_ADD_TEXT_COUNT_INT", 0);
            p.g(y6, "reportInfo.getReportValu…EY_ADD_TEXT_COUNT_INT, 0)");
            finderFeedReportObject.videoWordingCount = ((Number) y6).intValue();
            Object y7 = recordMediaReportInfo.y("KEY_ENTER_EDIT_PAGE_TIME_MS_LONG", 0L);
            p.g(y7, "reportInfo.getReportValu…IT_PAGE_TIME_MS_LONG, 0L)");
            finderFeedReportObject.enterVideoEditTime = ((Number) y7).longValue();
            Object y8 = recordMediaReportInfo.y("KEY_ENTER_TIME_MS_LONG", 0L);
            p.g(y8, "reportInfo.getReportValu…Y_ENTER_TIME_MS_LONG, 0L)");
            finderFeedReportObject.enterTakePhotoTime = ((Number) y8).longValue();
            Object y9 = recordMediaReportInfo.y("KEY_IS_SUB_RECORD_BOOLEAN", Boolean.FALSE);
            p.g(y9, "reportInfo.getReportValu…UB_RECORD_BOOLEAN, false)");
            if (!((Boolean) y9).booleanValue()) {
                i2 = 0;
            }
            finderFeedReportObject.isMultiShot = i2;
            Object y10 = recordMediaReportInfo.y("KEY_CHANGE_SUB_RECORD_TAB_INT", 0);
            p.g(y10, "reportInfo.getReportValu…GE_SUB_RECORD_TAB_INT, 0)");
            finderFeedReportObject.multiShotChangeCnt = ((Number) y10).intValue();
            Object y11 = recordMediaReportInfo.y("KEY_SUB_VIDEO_RECORD_CLICK_INT", 0);
            p.g(y11, "reportInfo.getReportValu…IDEO_RECORD_CLICK_INT, 0)");
            finderFeedReportObject.multiShotClickCnt = ((Number) y11).intValue();
            Object y12 = recordMediaReportInfo.y("KEY_SUB_VIDEO_RECORD_SUCCESS_INT", 0);
            p.g(y12, "reportInfo.getReportValu…EO_RECORD_SUCCESS_INT, 0)");
            finderFeedReportObject.multiShotSuccessCnt = ((Number) y12).intValue();
            Object y13 = recordMediaReportInfo.y("KEY_SUB_VIDEO_NUM_INT", 0);
            p.g(y13, "reportInfo.getReportValu…KEY_SUB_VIDEO_NUM_INT, 0)");
            finderFeedReportObject.multiShotVideoCnt = ((Number) y13).intValue();
            AppMethodBeat.o(250608);
            return;
        }
        AppMethodBeat.o(250608);
    }

    public static void b(RecordMediaReportInfo recordMediaReportInfo) {
        AppMethodBeat.i(250609);
        p.h(recordMediaReportInfo, "reportInfo");
        FinderFeedReportObject finderFeedReportObject = vfk;
        if (finderFeedReportObject != null) {
            finderFeedReportObject.videoMusicId = String.valueOf(((Number) recordMediaReportInfo.y("KEY_MUSIC_REQ_ID_INT", 0)).intValue());
            Object y = recordMediaReportInfo.y("KEY_SEARCH_MUSIC_INT", 0);
            p.g(y, "reportInfo.getReportValue(KEY_SEARCH_MUSIC_INT, 0)");
            finderFeedReportObject.videoMusicSearch = ((Number) y).intValue();
            Object y2 = recordMediaReportInfo.y("KEY_MUSIC_INDEX_INT", 0);
            p.g(y2, "reportInfo.getReportValue(KEY_MUSIC_INDEX_INT, 0)");
            finderFeedReportObject.videoMusicIndex = ((Number) y2).intValue();
            Object y3 = recordMediaReportInfo.y("KEY_ADD_EMOJI_COUNT_INT", 0);
            p.g(y3, "reportInfo.getReportValu…Y_ADD_EMOJI_COUNT_INT, 0)");
            finderFeedReportObject.videoEmojiCount = ((Number) y3).intValue();
            Object y4 = recordMediaReportInfo.y("KEY_ADD_TEXT_COUNT_INT", 0);
            p.g(y4, "reportInfo.getReportValu…EY_ADD_TEXT_COUNT_INT, 0)");
            finderFeedReportObject.videoWordingCount = ((Number) y4).intValue();
            Object y5 = recordMediaReportInfo.y("KEY_ENTER_EDIT_PAGE_TIME_MS_LONG", 0L);
            p.g(y5, "reportInfo.getReportValu…IT_PAGE_TIME_MS_LONG, 0L)");
            finderFeedReportObject.enterVideoEditTime = ((Number) y5).longValue();
            Object y6 = recordMediaReportInfo.y("KEY_VIDEO_SUB_TYPE_INT", 0);
            p.g(y6, "reportInfo.getReportValu…EY_VIDEO_SUB_TYPE_INT, 0)");
            finderFeedReportObject.videoSubType = ((Number) y6).intValue();
            finderFeedReportObject.postId = (String) recordMediaReportInfo.y("KEY_MULTI_MEDIA_POST_ID_STRING", "");
            finderFeedReportObject.editId = (String) recordMediaReportInfo.y("KEY_MULTI_MEDIA_EDIT_ID_STRING", "");
            Object y7 = recordMediaReportInfo.y("KEY_IS_SUB_RECORD_BOOLEAN", Boolean.FALSE);
            p.g(y7, "reportInfo.getReportValu…UB_RECORD_BOOLEAN, false)");
            finderFeedReportObject.isMultiShot = ((Boolean) y7).booleanValue() ? 1 : 0;
            Object y8 = recordMediaReportInfo.y("KEY_CHANGE_SUB_RECORD_TAB_INT", 0);
            p.g(y8, "reportInfo.getReportValu…GE_SUB_RECORD_TAB_INT, 0)");
            finderFeedReportObject.multiShotChangeCnt = ((Number) y8).intValue();
            Object y9 = recordMediaReportInfo.y("KEY_SUB_VIDEO_RECORD_CLICK_INT", 0);
            p.g(y9, "reportInfo.getReportValu…IDEO_RECORD_CLICK_INT, 0)");
            finderFeedReportObject.multiShotClickCnt = ((Number) y9).intValue();
            Object y10 = recordMediaReportInfo.y("KEY_SUB_VIDEO_RECORD_SUCCESS_INT", 0);
            p.g(y10, "reportInfo.getReportValu…EO_RECORD_SUCCESS_INT, 0)");
            finderFeedReportObject.multiShotSuccessCnt = ((Number) y10).intValue();
            Object y11 = recordMediaReportInfo.y("KEY_SUB_VIDEO_NUM_INT", 0);
            p.g(y11, "reportInfo.getReportValu…KEY_SUB_VIDEO_NUM_INT, 0)");
            finderFeedReportObject.multiShotVideoCnt = ((Number) y11).intValue();
            AppMethodBeat.o(250609);
            return;
        }
        AppMethodBeat.o(250609);
    }

    public static /* synthetic */ void auH(String str) {
        AppMethodBeat.i(250611);
        gR(str, null);
        AppMethodBeat.o(250611);
    }

    public static void gR(String str, String str2) {
        AppMethodBeat.i(250610);
        p.h(str, ShareConstants.RESULT_POST_ID);
        FinderFeedReportObject finderFeedReportObject = vfk;
        if (finderFeedReportObject != null) {
            finderFeedReportObject.postId = str;
            if (str2 != null) {
                finderFeedReportObject.editId = str2;
            }
            AppMethodBeat.o(250610);
            return;
        }
        AppMethodBeat.o(250610);
    }

    public static void auI(String str) {
        AppMethodBeat.i(250612);
        p.h(str, "clickId");
        FinderFeedReportObject finderFeedReportObject = vfk;
        if (finderFeedReportObject != null) {
            finderFeedReportObject.clickId = str;
            AppMethodBeat.o(250612);
            return;
        }
        AppMethodBeat.o(250612);
    }

    public static /* synthetic */ void Ks(int i2) {
        AppMethodBeat.i(250614);
        at(i2, false);
        AppMethodBeat.o(250614);
    }

    public static void at(int i2, boolean z) {
        AppMethodBeat.i(250613);
        FinderFeedReportObject finderFeedReportObject = vfk;
        if (finderFeedReportObject != null) {
            finderFeedReportObject.exitPageId = i2;
            if (i2 == 4) {
                finderFeedReportObject.sendOrExitButtonTime = cl.aWA();
            }
            FinderFeedReportObject finderFeedReportObject2 = vfk;
            if (finderFeedReportObject2 != null) {
                d.c(TAG, new b(finderFeedReportObject2, z));
            }
            vfk = null;
            AppMethodBeat.o(250613);
            return;
        }
        AppMethodBeat.o(250613);
    }

    public static void Fa(long j2) {
        AppMethodBeat.i(166572);
        e.a aVar = e.vFX;
        FinderItem Fy = e.a.Fy(j2);
        if (Fy != null) {
            a(Fy, true);
            k kVar = k.vfA;
            k.g(Fy);
            AppMethodBeat.o(166572);
            return;
        }
        AppMethodBeat.o(166572);
    }

    private static void a(FinderItem finderItem, boolean z) {
        LinkedList<cod> linkedList;
        cod cod;
        LinkedList<cod> linkedList2;
        cod cod2;
        int i2 = 1;
        int i3 = 0;
        AppMethodBeat.i(178388);
        String str = "";
        LinkedList<cjl> mediaList = finderItem.getMediaList();
        ArrayList arrayList = new ArrayList(j.a(mediaList, 10));
        int i4 = 0;
        for (T t : mediaList) {
            str = str + t.mediaType + ';' + t.videoDuration + '#';
            i4 = Util.isNullOrNil(t.coverUrl) ? 0 : 1;
            arrayList.add(x.SXb);
        }
        FinderFeedReportObject finderFeedReportObject = finderItem.field_reportObject;
        if (finderFeedReportObject != null) {
            dl dlVar = new dl();
            dlVar.oM(finderFeedReportObject.sessionId);
            dlVar.kS(finderFeedReportObject.enterScene);
            if (!z) {
                i2 = 0;
            }
            dlVar.kT(i2);
            k kVar = k.vfA;
            dlVar.oN(k.Fg(finderItem.getId()));
            dlVar.kU(finderFeedReportObject.exitPageId);
            dlVar.jJ(finderFeedReportObject.enterTakePhotoTime);
            dlVar.jK(finderFeedReportObject.enterVideoEditTime);
            dlVar.jL(finderFeedReportObject.sendOrExitButtonTime);
            dlVar.jM(finderFeedReportObject.videoRecordTime);
            dlVar.jN((long) finderFeedReportObject.videoSource);
            dlVar.jO((long) finderFeedReportObject.videoEmojiCount);
            dlVar.jP((long) finderFeedReportObject.videoWordingCount);
            String str2 = finderFeedReportObject.videoMusicId;
            if (str2 == null) {
                str2 = "";
            }
            dlVar.oO(str2);
            dlVar.jQ((long) finderFeedReportObject.videoMusicIndex);
            dlVar.jR((long) finderFeedReportObject.videoMusicSearch);
            dlVar.jS((long) finderFeedReportObject.videoPostType);
            dlVar.oP(str);
            dlVar.jT((long) finderFeedReportObject.existDesc);
            dlVar.jU((long) finderFeedReportObject.descCount);
            String str3 = finderFeedReportObject.actionTrace;
            if (str3 == null) {
                str3 = "";
            }
            dlVar.oQ(str3);
            dlVar.jV((long) finderFeedReportObject.lbsFlag);
            String str4 = finderFeedReportObject.link;
            if (str4 == null) {
                str4 = "";
            }
            dlVar.oR(str4);
            dlVar.jW((long) finderFeedReportObject.draft);
            w wVar = w.vXp;
            dlVar.oS(n.j(w.z(finderItem), ",", ";", false));
            dlVar.oT("");
            dlVar.jX(BuildInfo.DEBUG ? 0 : vfl);
            dlVar.kW(finderFeedReportObject.mentionCount);
            dlVar.jY((long) finderFeedReportObject.clickMentionCount);
            dlVar.jZ((long) finderFeedReportObject.clickSucMentionCount);
            dlVar.ka((long) finderFeedReportObject.mentionRepeatCount);
            dlVar.oU("");
            dlVar.kV(i4);
            dlVar.pc(finderFeedReportObject.forwardingAppId);
            dlVar.pd(finderFeedReportObject.topicActivityId);
            dlVar.ki((long) finderFeedReportObject.topicActivityType);
            String jSONObject = b(b(b(b(b(null, "IsMultiShot", finderFeedReportObject.isMultiShot), "MultiShotChangeCnt", finderFeedReportObject.multiShotChangeCnt), "MultiShotClickCnt", finderFeedReportObject.multiShotClickCnt), "MultiShotSuccessCnt", finderFeedReportObject.multiShotSuccessCnt), "MultiShotVideoCnt", finderFeedReportObject.multiShotVideoCnt).toString();
            p.g(jSONObject, "recordInfo.toString()");
            dlVar.oV(n.j(jSONObject, ",", ";", false));
            dlVar.kb((long) finderFeedReportObject.videoSubType);
            dlVar.oW(finderFeedReportObject.postId);
            dlVar.oX(finderFeedReportObject.editId);
            dlVar.oZ(finderFeedReportObject.clickId);
            axt location = finderItem.getLocation();
            if (location != null) {
                y yVar = y.vXH;
                dlVar.oY(y.hg(location.fuK, location.kHV));
            }
            dlVar.kc((long) finderFeedReportObject.remuxType);
            dlVar.kg((long) finderFeedReportObject.musicType);
            dlVar.pb(finderFeedReportObject.followSoundTrackId);
            dlVar.kh((long) finderFeedReportObject.soundTrackType);
            cng megaVideo = finderItem.getMegaVideo();
            if (megaVideo != null) {
                dlVar.pa(d.zs(megaVideo.id));
                cnl cnl = megaVideo.MtG;
                dlVar.kd((long) ((cnl == null || (linkedList2 = cnl.media) == null || (cod2 = (cod) j.kt(linkedList2)) == null) ? 0 : cod2.Mur));
                cjl cjl = (cjl) j.kt(finderItem.getMediaList());
                dlVar.ke((long) (cjl != null ? cjl.fileSize : 0));
                cnl cnl2 = megaVideo.MtG;
                if (!(cnl2 == null || (linkedList = cnl2.media) == null || (cod = (cod) j.kt(linkedList)) == null)) {
                    i3 = cod.fileSize;
                }
                dlVar.kf((long) i3);
            }
            dlVar.bfK();
            k kVar2 = k.vfA;
            k.a(dlVar);
        }
        b(finderItem, z);
        AppMethodBeat.o(178388);
    }

    private static JSONObject b(JSONObject jSONObject, String str, int i2) {
        AppMethodBeat.i(250615);
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            jSONObject.put(str, i2);
        } catch (Exception e2) {
        }
        AppMethodBeat.o(250615);
        return jSONObject;
    }

    public static void Fb(long j2) {
        AppMethodBeat.i(166573);
        c.a aVar = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
        FinderItem FS = c.a.FS(j2);
        if (FS != null) {
            a(FS, false);
            AppMethodBeat.o(166573);
            return;
        }
        AppMethodBeat.o(166573);
    }

    public static void j(long j2, int i2, int i3) {
        AppMethodBeat.i(250616);
        Log.i(TAG, "savePostError " + j2 + ", " + i2 + ", " + i3);
        c.a aVar = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
        FinderItem FS = c.a.FS(j2);
        if (FS != null) {
            FinderFeedReportObject finderFeedReportObject = FS.field_reportObject;
            if (finderFeedReportObject != null) {
                finderFeedReportObject.cgiErrorType = i2;
            }
            FinderFeedReportObject finderFeedReportObject2 = FS.field_reportObject;
            if (finderFeedReportObject2 != null) {
                finderFeedReportObject2.cgiErrorCode = i3;
            }
            c.a aVar2 = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
            c.a.r(FS);
            AppMethodBeat.o(250616);
            return;
        }
        AppMethodBeat.o(250616);
    }

    public static FinderFeedReportObject dnY() {
        FinderFeedReportObject finderFeedReportObject = vfk;
        vfk = null;
        return finderFeedReportObject;
    }

    public static final class a implements q {
        a() {
        }

        @Override // com.tencent.mm.plugin.finder.upload.q
        public final void onPostStart(long j2) {
        }

        @Override // com.tencent.mm.plugin.finder.upload.q
        public final void onPostEnd(long j2, boolean z) {
            AppMethodBeat.i(166567);
            i iVar = i.vfo;
            i.Fb(j2);
            ia iaVar = new ia();
            iaVar.dMC.localId = j2;
            iaVar.dMC.dMD = false;
            EventCenter.instance.publish(iaVar);
            AppMethodBeat.o(166567);
        }

        @Override // com.tencent.mm.plugin.finder.upload.q
        public final void onPostOk(long j2, long j3) {
            AppMethodBeat.i(166568);
            i iVar = i.vfo;
            i.Fa(j3);
            e.a aVar = e.vFX;
            FinderItem Fy = e.a.Fy(j3);
            if (Fy != null) {
                ia iaVar = new ia();
                iaVar.dMC.localId = j2;
                iaVar.dMC.dMD = true;
                ia.a aVar2 = iaVar.dMC;
                s.a aVar3 = s.vWt;
                aVar2.dME = s.a.c(Fy, true);
                EventCenter.instance.publish(iaVar);
                AppMethodBeat.o(166568);
                return;
            }
            AppMethodBeat.o(166568);
        }

        @Override // com.tencent.mm.plugin.finder.upload.q
        public final void onPostNotify(long j2, boolean z) {
            AppMethodBeat.i(250599);
            if (!z) {
                ia iaVar = new ia();
                iaVar.dMC.localId = j2;
                iaVar.dMC.dMD = false;
                EventCenter.instance.publish(iaVar);
            }
            AppMethodBeat.o(250599);
        }
    }

    public static q dnZ() {
        return vfm;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:116:0x03f6, code lost:
        if (r2 == null) goto L_0x03f8;
     */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0396  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x03db  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x0490  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x04f4  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x0585  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x05bd  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x0686  */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x0694  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x069b  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x069e  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x06a5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void b(com.tencent.mm.plugin.finder.storage.FinderItem r30, boolean r31) {
        /*
        // Method dump skipped, instructions count: 1726
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.report.i.b(com.tencent.mm.plugin.finder.storage.FinderItem, boolean):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:96:0x03d2, code lost:
        if (r2 == null) goto L_0x03d4;
     */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x03f4  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x0461  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x046c  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x036f  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x03b7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void e(com.tencent.mm.plugin.finder.storage.FinderItem r21) {
        /*
        // Method dump skipped, instructions count: 1146
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.report.i.e(com.tencent.mm.plugin.finder.storage.FinderItem):void");
    }

    private static String ep(List<? extends FinderMediaReportInfo> list) {
        AppMethodBeat.i(250618);
        JSONArray jSONArray = new JSONArray();
        for (T t : list) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("w", t.width);
            jSONObject.put("h", t.height);
            jSONObject.put("fps", t.fps);
            jSONObject.put("audiobitrate", t.audioBitrate);
            jSONObject.put("videobitrate", t.videoBitrate);
            jSONArray.put(jSONObject);
        }
        String jSONArray2 = jSONArray.toString();
        p.g(jSONArray2, "array.toString()");
        AppMethodBeat.o(250618);
        return jSONArray2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00b5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void H(boolean r10, int r11) {
        /*
        // Method dump skipped, instructions count: 183
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.report.i.H(boolean, int):void");
    }

    public static void j(int i2, long j2, long j3) {
        AppMethodBeat.i(250620);
        di diVar = new di();
        FinderFeedReportObject finderFeedReportObject = vfk;
        if (finderFeedReportObject != null) {
            diVar.oG(finderFeedReportObject.postId);
            diVar.oH(finderFeedReportObject.editId);
            diVar.jx((long) finderFeedReportObject.videoSource);
            diVar.jy((long) i2);
            diVar.jz(j2);
            diVar.jA(j3);
            diVar.bfK();
            k kVar = k.vfA;
            k.a(diVar);
            AppMethodBeat.o(250620);
            return;
        }
        AppMethodBeat.o(250620);
    }

    public static final class c extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ FinderFeedReportObject vfp;
        final /* synthetic */ boolean vfr;
        final /* synthetic */ int vfs;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(FinderFeedReportObject finderFeedReportObject, boolean z, int i2) {
            super(0);
            this.vfp = finderFeedReportObject;
            this.vfr = z;
            this.vfs = i2;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            int i2;
            AppMethodBeat.i(250601);
            if (this.vfr) {
                try {
                    StringBuilder sb = new StringBuilder();
                    al alVar = al.waC;
                    String sb2 = sb.append(al.dEF()).append("postdraft.info").toString();
                    if (com.tencent.mm.vfs.s.YS(sb2)) {
                        this.vfp.parseFrom(com.tencent.mm.vfs.s.aW(sb2, 0, -1));
                    }
                } catch (Exception e2) {
                    i iVar = i.vfo;
                    Log.printErrStackTrace(i.getTAG(), e2, "", new Object[0]);
                }
                i iVar2 = i.vfo;
                Log.i(i.getTAG(), "read draft " + this.vfp.lbsFlag);
            }
            this.vfp.sessionId = ((com.tencent.mm.plugin.expt.b.c) g.af(com.tencent.mm.plugin.expt.b.c.class)).cMD();
            this.vfp.enterScene = this.vfs;
            FinderFeedReportObject finderFeedReportObject = this.vfp;
            if (this.vfr) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            finderFeedReportObject.draft = i2;
            x xVar = x.SXb;
            AppMethodBeat.o(250601);
            return xVar;
        }
    }

    public static final class b extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ FinderFeedReportObject vfp;
        final /* synthetic */ boolean vfq;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(FinderFeedReportObject finderFeedReportObject, boolean z) {
            super(0);
            this.vfp = finderFeedReportObject;
            this.vfq = z;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            long j2;
            AppMethodBeat.i(250600);
            dl dlVar = new dl();
            dlVar.oM(this.vfp.sessionId);
            dlVar.kS(this.vfp.enterScene);
            dlVar.kT(this.vfq ? 3 : 2);
            dlVar.oN(AppEventsConstants.EVENT_PARAM_VALUE_NO);
            dlVar.kU(this.vfp.exitPageId);
            dlVar.jJ(this.vfp.enterTakePhotoTime);
            dlVar.jK(this.vfp.enterVideoEditTime);
            dlVar.jL(this.vfp.sendOrExitButtonTime);
            dlVar.jM(this.vfp.videoRecordTime);
            dlVar.jN((long) this.vfp.videoSource);
            dlVar.jO((long) this.vfp.videoEmojiCount);
            dlVar.jP((long) this.vfp.videoWordingCount);
            String str = this.vfp.videoMusicId;
            if (str == null) {
                str = "";
            }
            dlVar.oO(str);
            dlVar.jQ((long) this.vfp.videoMusicIndex);
            dlVar.jR((long) this.vfp.videoMusicSearch);
            dlVar.jS((long) this.vfp.videoPostType);
            String str2 = this.vfp.videoMediaInfo;
            if (str2 == null) {
                str2 = "";
            }
            dlVar.oP(str2);
            dlVar.jT((long) this.vfp.existDesc);
            dlVar.jU((long) this.vfp.descCount);
            String str3 = this.vfp.actionTrace;
            if (str3 == null) {
                str3 = "";
            }
            dlVar.oQ(str3);
            dlVar.jV((long) this.vfp.lbsFlag);
            String str4 = this.vfp.link;
            if (str4 == null) {
                str4 = "";
            }
            dlVar.oR(str4);
            dlVar.jW((long) this.vfp.draft);
            dlVar.oS("");
            dlVar.oT("");
            if (BuildInfo.DEBUG) {
                j2 = 0;
            } else {
                i iVar = i.vfo;
                j2 = i.vfl;
            }
            dlVar.jX(j2);
            dlVar.kW(this.vfp.mentionCount);
            dlVar.jY((long) this.vfp.clickMentionCount);
            dlVar.jZ((long) this.vfp.clickSucMentionCount);
            dlVar.ka((long) this.vfp.mentionRepeatCount);
            dlVar.oU("");
            dlVar.pc(this.vfp.forwardingAppId);
            dlVar.pd(this.vfp.topicActivityId);
            dlVar.ki((long) this.vfp.topicActivityType);
            i iVar2 = i.vfo;
            JSONObject c2 = i.c((JSONObject) null, "IsMultiShot", this.vfp.isMultiShot);
            i iVar3 = i.vfo;
            JSONObject c3 = i.c(c2, "MultiShotChangeCnt", this.vfp.multiShotChangeCnt);
            i iVar4 = i.vfo;
            JSONObject c4 = i.c(c3, "MultiShotClickCnt", this.vfp.multiShotClickCnt);
            i iVar5 = i.vfo;
            JSONObject c5 = i.c(c4, "MultiShotSuccessCnt", this.vfp.multiShotSuccessCnt);
            i iVar6 = i.vfo;
            String jSONObject = i.c(c5, "MultiShotVideoCnt", this.vfp.multiShotVideoCnt).toString();
            p.g(jSONObject, "recordInfo.toString()");
            dlVar.oV(n.j(jSONObject, ",", ";", false));
            dlVar.kb((long) this.vfp.videoSubType);
            dlVar.oW(this.vfp.postId);
            dlVar.oX(this.vfp.editId);
            dlVar.oZ(this.vfp.clickId);
            axt axt = this.vfp.selectLocation;
            if (axt != null) {
                y yVar = y.vXH;
                dlVar.oY(y.hg(axt.fuK, axt.kHV));
            }
            dlVar.kc((long) this.vfp.remuxType);
            dlVar.kg((long) this.vfp.musicType);
            dlVar.pb(this.vfp.followSoundTrackId);
            dlVar.kh((long) this.vfp.soundTrackType);
            dlVar.bfK();
            k kVar = k.vfA;
            k.a(dlVar);
            if (this.vfq) {
                StringBuilder sb = new StringBuilder();
                al alVar = al.waC;
                String sb2 = sb.append(al.dEF()).append("postdraft.info").toString();
                if (com.tencent.mm.vfs.s.YS(sb2)) {
                    com.tencent.mm.vfs.s.deleteFile(sb2);
                }
                com.tencent.mm.vfs.s.C(sb2, this.vfp.toByteArray());
                i iVar7 = i.vfo;
                Log.i(i.getTAG(), "saveDraftToFile ".concat(String.valueOf(sb2)));
            }
            x xVar = x.SXb;
            AppMethodBeat.o(250600);
            return xVar;
        }
    }
}
