package com.tencent.mm.plugin.handoff.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.aoe;
import com.tencent.mm.protocal.protobuf.cru;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.o;

@Keep
@l(hxD = {1, 1, 16}, hxE = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b+\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 Y2\u00020\u0001:\u0001YB±\u0001\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\n\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\n\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0014\u001a\u00020\b\u0012\b\b\u0002\u0010\u0015\u001a\u00020\n\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0003¢\u0006\u0002\u0010\u0019B\u0007\b\u0016¢\u0006\u0002\u0010\u001aB\u000f\b\u0016\u0012\u0006\u0010\t\u001a\u00020\u001b¢\u0006\u0002\u0010\u001cJ\b\u0010C\u001a\u00020\u0003H\u0015J\b\u0010D\u001a\u00020\u0001H\u0016J\b\u0010E\u001a\u00020\nH\u0016J\n\u0010F\u001a\u0004\u0018\u00010GH\u0014J\u0016\u0010H\u001a\u0010\u0012\u0004\u0012\u00020J\u0012\u0004\u0012\u00020K\u0018\u00010IH\u0014J\b\u0010L\u001a\u00020\nH\u0016J\u000e\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020GJ\u0010\u0010P\u001a\u00020N2\b\u0010Q\u001a\u0004\u0018\u00010RJ\b\u0010S\u001a\u00020\u0003H\u0016J\u0010\u0010T\u001a\u00020N2\u0006\u0010U\u001a\u00020\u0001H\u0016J\u0018\u0010V\u001a\u00020N2\u0006\u0010W\u001a\u00020\u001b2\u0006\u0010X\u001a\u00020\nH\u0016R\u001a\u0010\u000e\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010\u0011\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001e\"\u0004\b\"\u0010 R\u001a\u0010\u000f\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001e\"\u0004\b$\u0010 R\u001a\u0010\r\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001e\"\u0004\b&\u0010 R\u001a\u0010\f\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u001e\"\u0004\b(\u0010 R\u001a\u0010\u0010\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u001e\"\u0004\b.\u0010 R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u001e\"\u0004\b0\u0010 R\u001a\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u001e\"\u0004\b2\u0010 R\u001a\u0010\u0013\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u001e\"\u0004\b4\u0010 R\u001a\u0010\u0012\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010*\"\u0004\b6\u0010,R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010*\"\u0004\b<\u0010,R\u001a\u0010\u000b\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u001e\"\u0004\b>\u0010 R\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\u001e\"\u0004\b@\u0010 R\u001a\u0010\u0014\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u00108\"\u0004\bB\u0010:¨\u0006Z"}, hxF = {"Lcom/tencent/mm/plugin/handoff/model/HandOffFile;", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "fullPath", "", "fileType", "title", "md5", "size", "", "source", "", "svrId", "extId", "cdnURL", "aesKey", "authKey", "fileStatus", "appId", "sdkVersion", "mediaId", "uploadedSize", "handOffType", "from", "to", "key", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;JILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "()V", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getAesKey", "()Ljava/lang/String;", "setAesKey", "(Ljava/lang/String;)V", "getAppId", "setAppId", "getAuthKey", "setAuthKey", "getCdnURL", "setCdnURL", "getExtId", "setExtId", "getFileStatus", "()I", "setFileStatus", "(I)V", "getFileType", "setFileType", "getFullPath", "setFullPath", "getMd5", "setMd5", "getMediaId", "setMediaId", "getSdkVersion", "setSdkVersion", "getSize", "()J", "setSize", "(J)V", "getSource", "setSource", "getSvrId", "setSvrId", "getTitle", "setTitle", "getUploadedSize", "setUploadedSize", "body", "copy", "describeContents", "doCreateBallInfo", "Lcom/tencent/mm/plugin/ball/model/BallInfo;", "doCreateMultiTaskInfo", "Lkotlin/Pair;", "Lcom/tencent/mm/protocal/protobuf/MultiTaskShowData;", "", "getDataType", "saveToBallInfo", "", "ballInfo", "saveToMultiTaskInfo", "multiTaskInfo", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "toString", "update", "newHandOff", "writeToParcel", "dest", "flags", "Companion", "api-handoff_release"})
public final class HandOffFile extends HandOff {
    public static final Parcelable.Creator<HandOffFile> CREATOR = new b();
    public static final a Companion = new a((byte) 0);
    private static final String KAesKey = "handoff#aesKey";
    private static final String KAppId = "handoff#appId";
    private static final String KAuthKey = "handoff#authKey";
    private static final String KCdnURL = "handoff#cdnURL";
    private static final String KExtId = "handoff#extId";
    private static final String KFileStatus = "handoff#fileStatus";
    private static final String KFileType = "handoff#fileType";
    private static final String KFrom = "handoff#from";
    private static final String KFullPath = "handoff#fullPath";
    private static final String KKey = "handoff#key";
    private static final String KMd5 = "handoff#md5";
    private static final String KMediaId = "handoff#KmediaId";
    private static final String KSdkVersion = "handoff#sdkVersion";
    private static final String KSize = "handoff#size";
    private static final String KSource = "handoff#source";
    private static final String KSvrId = "handoff#svrId";
    private static final String KTitle = "handoff#title";
    private static final String KTo = "handoff#to";
    private static final String KUploadedSize = "handoff#KUploadedSize";
    private String aesKey;
    private String appId;
    private String authKey;
    private String cdnURL;
    private String extId;
    private int fileStatus;
    private String fileType;
    private String fullPath;
    private String md5;
    private String mediaId;
    private int sdkVersion;
    private long size;
    private int source;
    private String svrId;
    private String title;
    private long uploadedSize;

    public HandOffFile(String str, String str2, String str3, String str4, long j2, int i2, String str5, String str6, String str7, String str8, String str9, int i3, String str10, int i4, String str11) {
        this(str, str2, str3, str4, j2, i2, str5, str6, str7, str8, str9, i3, str10, i4, str11, 0, 0, null, null, null, 1015808, null);
    }

    public HandOffFile(String str, String str2, String str3, String str4, long j2, int i2, String str5, String str6, String str7, String str8, String str9, int i3, String str10, int i4, String str11, long j3) {
        this(str, str2, str3, str4, j2, i2, str5, str6, str7, str8, str9, i3, str10, i4, str11, j3, 0, null, null, null, 983040, null);
    }

    public HandOffFile(String str, String str2, String str3, String str4, long j2, int i2, String str5, String str6, String str7, String str8, String str9, int i3, String str10, int i4, String str11, long j3, int i5) {
        this(str, str2, str3, str4, j2, i2, str5, str6, str7, str8, str9, i3, str10, i4, str11, j3, i5, null, null, null, 917504, null);
    }

    public HandOffFile(String str, String str2, String str3, String str4, long j2, int i2, String str5, String str6, String str7, String str8, String str9, int i3, String str10, int i4, String str11, long j3, int i5, String str12) {
        this(str, str2, str3, str4, j2, i2, str5, str6, str7, str8, str9, i3, str10, i4, str11, j3, i5, str12, null, null, 786432, null);
    }

    public HandOffFile(String str, String str2, String str3, String str4, long j2, int i2, String str5, String str6, String str7, String str8, String str9, int i3, String str10, int i4, String str11, long j3, int i5, String str12, String str13) {
        this(str, str2, str3, str4, j2, i2, str5, str6, str7, str8, str9, i3, str10, i4, str11, j3, i5, str12, str13, null, 524288, null);
    }

    public static final HandOffFile fromBallInfo(BallInfo ballInfo) {
        AppMethodBeat.i(121711);
        HandOffFile fromBallInfo = a.fromBallInfo(ballInfo);
        AppMethodBeat.o(121711);
        return fromBallInfo;
    }

    public static final HandOffFile fromFavItem(aml aml, String str) {
        AppMethodBeat.i(238046);
        HandOffFile a2 = a.a(aml, null, str, 6);
        AppMethodBeat.o(238046);
        return a2;
    }

    public static final HandOffFile fromFavItem(aml aml, String str, ca caVar, String str2) {
        AppMethodBeat.i(238044);
        HandOffFile fromFavItem = a.fromFavItem(aml, str, caVar, str2);
        AppMethodBeat.o(238044);
        return fromFavItem;
    }

    public static final HandOffFile fromFavItem(aml aml, String str, String str2) {
        AppMethodBeat.i(238045);
        HandOffFile a2 = a.a(aml, str, str2, 4);
        AppMethodBeat.o(238045);
        return a2;
    }

    public static final HandOffFile fromMultiTask(MultiTaskInfo multiTaskInfo) {
        AppMethodBeat.i(238047);
        HandOffFile fromMultiTask = a.fromMultiTask(multiTaskInfo);
        AppMethodBeat.o(238047);
        return fromMultiTask;
    }

    public static final boolean isSupportOpenFile(String str) {
        AppMethodBeat.i(238048);
        boolean isSupportOpenFile = a.isSupportOpenFile(str);
        AppMethodBeat.o(238048);
        return isSupportOpenFile;
    }

    public final String getFullPath() {
        return this.fullPath;
    }

    public final void setFullPath(String str) {
        AppMethodBeat.i(121696);
        p.h(str, "<set-?>");
        this.fullPath = str;
        AppMethodBeat.o(121696);
    }

    public final String getFileType() {
        return this.fileType;
    }

    public final void setFileType(String str) {
        AppMethodBeat.i(238033);
        p.h(str, "<set-?>");
        this.fileType = str;
        AppMethodBeat.o(238033);
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        AppMethodBeat.i(238034);
        p.h(str, "<set-?>");
        this.title = str;
        AppMethodBeat.o(238034);
    }

    public final String getMd5() {
        return this.md5;
    }

    public final void setMd5(String str) {
        AppMethodBeat.i(238035);
        p.h(str, "<set-?>");
        this.md5 = str;
        AppMethodBeat.o(238035);
    }

    public final long getSize() {
        return this.size;
    }

    public final void setSize(long j2) {
        this.size = j2;
    }

    public final int getSource() {
        return this.source;
    }

    public final void setSource(int i2) {
        this.source = i2;
    }

    public final String getSvrId() {
        return this.svrId;
    }

    public final void setSvrId(String str) {
        AppMethodBeat.i(238036);
        p.h(str, "<set-?>");
        this.svrId = str;
        AppMethodBeat.o(238036);
    }

    public final String getExtId() {
        return this.extId;
    }

    public final void setExtId(String str) {
        AppMethodBeat.i(238037);
        p.h(str, "<set-?>");
        this.extId = str;
        AppMethodBeat.o(238037);
    }

    public final String getCdnURL() {
        return this.cdnURL;
    }

    public final void setCdnURL(String str) {
        AppMethodBeat.i(121697);
        p.h(str, "<set-?>");
        this.cdnURL = str;
        AppMethodBeat.o(121697);
    }

    public final String getAesKey() {
        return this.aesKey;
    }

    public final void setAesKey(String str) {
        AppMethodBeat.i(121698);
        p.h(str, "<set-?>");
        this.aesKey = str;
        AppMethodBeat.o(121698);
    }

    public final String getAuthKey() {
        return this.authKey;
    }

    public final void setAuthKey(String str) {
        AppMethodBeat.i(238038);
        p.h(str, "<set-?>");
        this.authKey = str;
        AppMethodBeat.o(238038);
    }

    public final int getFileStatus() {
        return this.fileStatus;
    }

    public final void setFileStatus(int i2) {
        this.fileStatus = i2;
    }

    public final String getAppId() {
        return this.appId;
    }

    public final void setAppId(String str) {
        AppMethodBeat.i(238039);
        p.h(str, "<set-?>");
        this.appId = str;
        AppMethodBeat.o(238039);
    }

    public final int getSdkVersion() {
        return this.sdkVersion;
    }

    public final void setSdkVersion(int i2) {
        this.sdkVersion = i2;
    }

    public final String getMediaId() {
        return this.mediaId;
    }

    public final void setMediaId(String str) {
        AppMethodBeat.i(238040);
        p.h(str, "<set-?>");
        this.mediaId = str;
        AppMethodBeat.o(238040);
    }

    public final long getUploadedSize() {
        return this.uploadedSize;
    }

    public final void setUploadedSize(long j2) {
        this.uploadedSize = j2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ HandOffFile(java.lang.String r28, java.lang.String r29, java.lang.String r30, java.lang.String r31, long r32, int r34, java.lang.String r35, java.lang.String r36, java.lang.String r37, java.lang.String r38, java.lang.String r39, int r40, java.lang.String r41, int r42, java.lang.String r43, long r44, int r46, java.lang.String r47, java.lang.String r48, java.lang.String r49, int r50, kotlin.g.b.j r51) {
        /*
        // Method dump skipped, instructions count: 111
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.handoff.model.HandOffFile.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, long, int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, java.lang.String, int, java.lang.String, long, int, java.lang.String, java.lang.String, java.lang.String, int, kotlin.g.b.j):void");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HandOffFile(String str, String str2, String str3, String str4, long j2, int i2, String str5, String str6, String str7, String str8, String str9, int i3, String str10, int i4, String str11, long j3, int i5, String str12, String str13, String str14) {
        super(i5, str12, str13, str14, null, 0, 48, null);
        p.h(str, "fullPath");
        p.h(str2, "fileType");
        p.h(str3, "title");
        p.h(str4, "md5");
        p.h(str5, "svrId");
        p.h(str6, "extId");
        p.h(str7, "cdnURL");
        p.h(str8, "aesKey");
        p.h(str9, "authKey");
        p.h(str10, "appId");
        p.h(str11, "mediaId");
        p.h(str12, "from");
        p.h(str13, "to");
        p.h(str14, "key");
        AppMethodBeat.i(121705);
        this.fullPath = str;
        this.fileType = str2;
        this.title = str3;
        this.md5 = str4;
        this.size = j2;
        this.source = i2;
        this.svrId = str5;
        this.extId = str6;
        this.cdnURL = str7;
        this.aesKey = str8;
        this.authKey = str9;
        this.fileStatus = i3;
        this.appId = str10;
        this.sdkVersion = i4;
        this.mediaId = str11;
        this.uploadedSize = j3;
        AppMethodBeat.o(121705);
    }

    public HandOffFile() {
        this("", "", "", "", 0, 0, "", "", "", "", "", 0, "", 0, "", 0, 0, null, null, null, 1015808, null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HandOffFile(Parcel parcel) {
        super(parcel);
        p.h(parcel, "source");
        AppMethodBeat.i(121707);
        String readString = parcel.readString();
        if (readString == null) {
            p.hyc();
        }
        this.fullPath = readString;
        String readString2 = parcel.readString();
        if (readString2 == null) {
            p.hyc();
        }
        this.fileType = readString2;
        String readString3 = parcel.readString();
        if (readString3 == null) {
            p.hyc();
        }
        this.title = readString3;
        String readString4 = parcel.readString();
        if (readString4 == null) {
            p.hyc();
        }
        this.md5 = readString4;
        this.size = parcel.readLong();
        this.source = parcel.readInt();
        String readString5 = parcel.readString();
        if (readString5 == null) {
            p.hyc();
        }
        this.svrId = readString5;
        String readString6 = parcel.readString();
        if (readString6 == null) {
            p.hyc();
        }
        this.extId = readString6;
        String readString7 = parcel.readString();
        if (readString7 == null) {
            p.hyc();
        }
        this.cdnURL = readString7;
        String readString8 = parcel.readString();
        if (readString8 == null) {
            p.hyc();
        }
        this.aesKey = readString8;
        String readString9 = parcel.readString();
        if (readString9 == null) {
            p.hyc();
        }
        this.authKey = readString9;
        this.fileStatus = parcel.readInt();
        String readString10 = parcel.readString();
        if (readString10 == null) {
            p.hyc();
        }
        this.appId = readString10;
        this.sdkVersion = parcel.readInt();
        String readString11 = parcel.readString();
        if (readString11 == null) {
            p.hyc();
        }
        this.mediaId = readString11;
        this.uploadedSize = parcel.readLong();
        AppMethodBeat.o(121707);
    }

    @Override // com.tencent.mm.plugin.handoff.model.HandOff
    public final int getDataType() {
        return 1;
    }

    @Override // com.tencent.mm.plugin.handoff.model.HandOff
    public final void update(HandOff handOff) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        AppMethodBeat.i(121699);
        p.h(handOff, "newHandOff");
        super.update(handOff);
        if (handOff instanceof HandOffFile) {
            if (((HandOffFile) handOff).fullPath.length() > 0) {
                this.fullPath = ((HandOffFile) handOff).fullPath;
            }
            if (((HandOffFile) handOff).fileType.length() > 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                this.fileType = ((HandOffFile) handOff).fileType;
            }
            if (((HandOffFile) handOff).title.length() > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                this.title = ((HandOffFile) handOff).title;
            }
            if (((HandOffFile) handOff).md5.length() > 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3) {
                this.md5 = ((HandOffFile) handOff).md5;
            }
            if (((HandOffFile) handOff).size != 0) {
                this.size = ((HandOffFile) handOff).size;
            }
            if (((HandOffFile) handOff).source != 0) {
                this.source = ((HandOffFile) handOff).source;
            }
            if (((HandOffFile) handOff).svrId.length() > 0) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (z4) {
                this.svrId = ((HandOffFile) handOff).svrId;
            }
            if (((HandOffFile) handOff).extId.length() > 0) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (z5) {
                this.extId = ((HandOffFile) handOff).extId;
            }
            if (((HandOffFile) handOff).cdnURL.length() > 0) {
                z6 = true;
            } else {
                z6 = false;
            }
            if (z6) {
                this.cdnURL = ((HandOffFile) handOff).cdnURL;
            }
            if (((HandOffFile) handOff).aesKey.length() > 0) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (z7) {
                this.aesKey = ((HandOffFile) handOff).aesKey;
            }
            if (((HandOffFile) handOff).authKey.length() > 0) {
                z8 = true;
            } else {
                z8 = false;
            }
            if (z8) {
                this.authKey = ((HandOffFile) handOff).authKey;
            }
            if (((HandOffFile) handOff).fileStatus != 0) {
                this.fileStatus = ((HandOffFile) handOff).fileStatus;
            }
            if (((HandOffFile) handOff).appId.length() > 0) {
                z9 = true;
            } else {
                z9 = false;
            }
            if (z9) {
                this.appId = ((HandOffFile) handOff).appId;
            }
            if (((HandOffFile) handOff).sdkVersion != 0) {
                this.sdkVersion = ((HandOffFile) handOff).sdkVersion;
            }
            if (((HandOffFile) handOff).mediaId.length() > 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                this.mediaId = ((HandOffFile) handOff).mediaId;
            }
            if (((HandOffFile) handOff).uploadedSize != 0) {
                this.uploadedSize = ((HandOffFile) handOff).uploadedSize;
            }
        }
        AppMethodBeat.o(121699);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.handoff.model.HandOff
    public final String body() {
        AppMethodBeat.i(121700);
        String buv = n.buv("\n        <filetype>" + a.du(this.fileType) + "</filetype>\n        <title>" + a.du(this.title) + "</title>\n        <md5>" + a.du(this.md5) + "</md5>\n        <uploadedsize>" + a.du(Long.valueOf(this.uploadedSize)) + "</uploadedsize>\n        <size>" + a.du(Long.valueOf(this.size)) + "</size>\n        <source>" + a.du(Integer.valueOf(this.source)) + "</source>\n        <id>" + a.du(this.svrId) + "</id>\n        <extid>" + a.du(this.extId) + "</extid>\n        <cdnurl>" + a.du(this.cdnURL) + "</cdnurl>\n        <aeskey>" + a.du(this.aesKey) + "</aeskey>\n        <authkey>" + a.du(this.authKey) + "</authkey>\n        <filestatus>" + a.du(Integer.valueOf(this.fileStatus)) + "</filestatus>\n        <appid>" + a.du(this.appId) + "</appid>\n        <sdkversion>" + a.du(Integer.valueOf(this.sdkVersion)) + "</sdkversion>\n        <mediaid>" + a.du(this.mediaId) + "</mediaid>\n    ");
        AppMethodBeat.o(121700);
        return buv;
    }

    public final int describeContents() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.handoff.model.HandOff
    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(121701);
        p.h(parcel, "dest");
        super.writeToParcel(parcel, i2);
        parcel.writeString(this.fullPath);
        parcel.writeString(this.fileType);
        parcel.writeString(this.title);
        parcel.writeString(this.md5);
        parcel.writeLong(this.size);
        parcel.writeInt(this.source);
        parcel.writeString(this.svrId);
        parcel.writeString(this.extId);
        parcel.writeString(this.cdnURL);
        parcel.writeString(this.aesKey);
        parcel.writeString(this.authKey);
        parcel.writeInt(this.fileStatus);
        parcel.writeString(this.appId);
        parcel.writeInt(this.sdkVersion);
        parcel.writeString(this.mediaId);
        parcel.writeLong(this.uploadedSize);
        AppMethodBeat.o(121701);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001cH\u0007J2\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010\u0007H\u0007J\u0014\u0010$\u001a\u0004\u0018\u00010\u00052\b\u0010%\u001a\u0004\u0018\u00010&H\u0007J\u0012\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u0007H\u0007R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006*"}, hxF = {"Lcom/tencent/mm/plugin/handoff/model/HandOffFile$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/handoff/model/HandOffFile;", "KAesKey", "", "KAppId", "KAuthKey", "KCdnURL", "KExtId", "KFileStatus", "KFileType", "KFrom", "KFullPath", "KKey", "KMd5", "KMediaId", "KSdkVersion", "KSize", "KSource", "KSvrId", "KTitle", "KTo", "KUploadedSize", "fromBallInfo", "ballInfo", "Lcom/tencent/mm/plugin/ball/model/BallInfo;", "fromFavItem", "dataItem", "Lcom/tencent/mm/protocal/protobuf/FavDataItem;", "favId", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "fullpath", "fromMultiTask", "multiTaskInfo", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "isSupportOpenFile", "", "fileExt", "api-handoff_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static /* synthetic */ HandOffFile a(aml aml, String str, String str2, int i2) {
            AppMethodBeat.i(238030);
            if ((i2 & 2) != 0) {
                str = null;
            }
            HandOffFile fromFavItem = fromFavItem(aml, str, null, str2);
            AppMethodBeat.o(238030);
            return fromFavItem;
        }

        /* JADX WARNING: Removed duplicated region for block: B:19:0x0117  */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x0119  */
        /* JADX WARNING: Removed duplicated region for block: B:5:0x009a  */
        /* JADX WARNING: Removed duplicated region for block: B:7:0x009d  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static com.tencent.mm.plugin.handoff.model.HandOffFile fromFavItem(com.tencent.mm.protocal.protobuf.aml r28, java.lang.String r29, com.tencent.mm.storage.ca r30, java.lang.String r31) {
            /*
            // Method dump skipped, instructions count: 288
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.handoff.model.HandOffFile.a.fromFavItem(com.tencent.mm.protocal.protobuf.aml, java.lang.String, com.tencent.mm.storage.ca, java.lang.String):com.tencent.mm.plugin.handoff.model.HandOffFile");
        }

        public static HandOffFile fromBallInfo(BallInfo ballInfo) {
            AppMethodBeat.i(121695);
            p.h(ballInfo, "ballInfo");
            String eT = ballInfo.eT(HandOffFile.KFullPath, "");
            String eT2 = ballInfo.eT(HandOffFile.KFileType, "");
            String eT3 = ballInfo.eT(HandOffFile.KTitle, "");
            String eT4 = ballInfo.eT(HandOffFile.KMd5, "");
            long agQ = ballInfo.agQ(HandOffFile.KSize);
            int intExtra = ballInfo.getIntExtra(HandOffFile.KSource, 0);
            String eT5 = ballInfo.eT(HandOffFile.KSvrId, "");
            String eT6 = ballInfo.eT(HandOffFile.KExtId, "");
            String eT7 = ballInfo.eT(HandOffFile.KCdnURL, "");
            String eT8 = ballInfo.eT(HandOffFile.KAesKey, "");
            String eT9 = ballInfo.eT(HandOffFile.KAuthKey, "");
            int intExtra2 = ballInfo.getIntExtra(HandOffFile.KFileStatus, 0);
            String eT10 = ballInfo.eT(HandOffFile.KAppId, "");
            int intExtra3 = ballInfo.getIntExtra(HandOffFile.KSdkVersion, 0);
            String eT11 = ballInfo.eT(HandOffFile.KMediaId, "");
            long agQ2 = ballInfo.agQ(HandOffFile.KUploadedSize);
            String eT12 = ballInfo.eT(HandOffFile.KFrom, "");
            String eT13 = ballInfo.eT(HandOffFile.KTo, "");
            String eT14 = ballInfo.eT(HandOffFile.KKey, "");
            p.g(eT, "fullPath");
            p.g(eT2, "fileType");
            p.g(eT3, "title");
            p.g(eT4, "md5");
            p.g(eT5, "svrId");
            p.g(eT6, "extId");
            p.g(eT7, "cdnURL");
            p.g(eT8, "aesKey");
            p.g(eT9, "authKey");
            p.g(eT10, "appId");
            p.g(eT11, "mediaId");
            p.g(eT12, "from");
            p.g(eT13, "to");
            p.g(eT14, "key");
            HandOffFile handOffFile = new HandOffFile(eT, eT2, eT3, eT4, agQ, intExtra, eT5, eT6, eT7, eT8, eT9, intExtra2, eT10, intExtra3, eT11, agQ2, 2, eT12, eT13, eT14);
            AppMethodBeat.o(121695);
            return handOffFile;
        }

        public static HandOffFile fromMultiTask(MultiTaskInfo multiTaskInfo) {
            AppMethodBeat.i(238031);
            if (multiTaskInfo == null) {
                AppMethodBeat.o(238031);
                return null;
            }
            cru erh = multiTaskInfo.erh();
            aoe aoe = new aoe();
            aoe.parseFrom(multiTaskInfo.field_data);
            String nullAsNil = Util.nullAsNil(aoe.filePath);
            String nullAsNil2 = Util.nullAsNil(aoe.gCr);
            String nullAsNil3 = Util.nullAsNil(erh.title);
            String nullAsNil4 = Util.nullAsNil(aoe.LzT);
            long j2 = aoe.LAh;
            int i2 = aoe.LzU;
            String nullAsNil5 = Util.nullAsNil(aoe.LzV);
            String nullAsNil6 = Util.nullAsNil(aoe.LzW);
            String nullAsNil7 = Util.nullAsNil(aoe.LzX);
            String nullAsNil8 = Util.nullAsNil(aoe.LzY);
            String nullAsNil9 = Util.nullAsNil(aoe.LzZ);
            int i3 = aoe.LAa;
            String nullAsNil10 = Util.nullAsNil(aoe.LAb);
            int i4 = aoe.LAc;
            String nullAsNil11 = Util.nullAsNil(aoe.LAd);
            long j3 = aoe.LAe;
            String nullAsNil12 = Util.nullAsNil(aoe.LAf);
            String nullAsNil13 = Util.nullAsNil(aoe.LAg);
            String nullAsNil14 = Util.nullAsNil(multiTaskInfo.field_id);
            p.g(nullAsNil, "fullPath");
            p.g(nullAsNil2, "fileType");
            p.g(nullAsNil3, "title");
            p.g(nullAsNil4, "md5");
            p.g(nullAsNil5, "svrId");
            p.g(nullAsNil6, "extId");
            p.g(nullAsNil7, "cdnURL");
            p.g(nullAsNil8, "aesKey");
            p.g(nullAsNil9, "authKey");
            p.g(nullAsNil10, "appId");
            p.g(nullAsNil11, "mediaId");
            p.g(nullAsNil12, "from");
            p.g(nullAsNil13, "to");
            p.g(nullAsNil14, "key");
            HandOffFile handOffFile = new HandOffFile(nullAsNil, nullAsNil2, nullAsNil3, nullAsNil4, j2, i2, nullAsNil5, nullAsNil6, nullAsNil7, nullAsNil8, nullAsNil9, i3, nullAsNil10, i4, nullAsNil11, j3, 2, nullAsNil12, nullAsNil13, nullAsNil14);
            AppMethodBeat.o(238031);
            return handOffFile;
        }

        public static boolean isSupportOpenFile(String str) {
            boolean z;
            AppMethodBeat.i(238032);
            String str2 = str;
            if (str2 == null || str2.length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                AppMethodBeat.o(238032);
                return false;
            }
            if (!n.J(str, ".", false)) {
                str = ".".concat(String.valueOf(str));
            }
            if (FileExplorerUI.bfu(str) || FileExplorerUI.bft(str) || FileExplorerUI.bfv(str) || FileExplorerUI.bfw(str)) {
                AppMethodBeat.o(238032);
                return true;
            }
            AppMethodBeat.o(238032);
            return false;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001d\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b"}, hxF = {"com/tencent/mm/plugin/handoff/model/HandOffFile$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/handoff/model/HandOffFile;", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/handoff/model/HandOffFile;", "api-handoff_release"})
    public static final class b implements Parcelable.Creator<HandOffFile> {
        b() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ HandOffFile createFromParcel(Parcel parcel) {
            AppMethodBeat.i(121693);
            p.h(parcel, "source");
            HandOffFile handOffFile = new HandOffFile(parcel);
            AppMethodBeat.o(121693);
            return handOffFile;
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ HandOffFile[] newArray(int i2) {
            return new HandOffFile[i2];
        }
    }

    static {
        AppMethodBeat.i(121708);
        AppMethodBeat.o(121708);
    }

    public final void saveToBallInfo(BallInfo ballInfo) {
        AppMethodBeat.i(238041);
        p.h(ballInfo, "ballInfo");
        try {
            ballInfo.eS(KFullPath, this.fullPath);
            ballInfo.eS(KFileType, this.fileType);
            ballInfo.eS(KTitle, this.title);
            ballInfo.eS(KMd5, this.md5);
            ballInfo.X(KSize, this.size);
            ballInfo.cy(KSource, this.source);
            ballInfo.eS(KSvrId, this.svrId);
            ballInfo.eS(KExtId, this.extId);
            ballInfo.eS(KCdnURL, this.cdnURL);
            ballInfo.eS(KAesKey, this.aesKey);
            ballInfo.eS(KAuthKey, this.authKey);
            ballInfo.cy(KFileStatus, this.fileStatus);
            ballInfo.eS(KAppId, this.appId);
            ballInfo.cy(KSdkVersion, this.sdkVersion);
            ballInfo.eS(KMediaId, this.mediaId);
            ballInfo.X(KUploadedSize, this.uploadedSize);
            ballInfo.eS(KFrom, getFrom());
            ballInfo.eS(KTo, getTo());
            ballInfo.eS(KKey, getKey());
            AppMethodBeat.o(238041);
        } catch (Exception e2) {
            AppMethodBeat.o(238041);
        }
    }

    public final void saveToMultiTaskInfo(MultiTaskInfo multiTaskInfo) {
        AppMethodBeat.i(238042);
        if (multiTaskInfo == null) {
            AppMethodBeat.o(238042);
            return;
        }
        aoe aoe = new aoe();
        aoe.parseFrom(multiTaskInfo.field_data);
        aoe.LAh = this.size;
        aoe.LzT = this.md5;
        aoe.LzU = this.source;
        aoe.LzV = this.svrId;
        aoe.LzW = this.extId;
        aoe.LzX = this.cdnURL;
        aoe.LzY = this.aesKey;
        aoe.LzZ = this.authKey;
        aoe.LAa = this.fileStatus;
        aoe.LAb = this.appId;
        aoe.LAc = this.sdkVersion;
        aoe.LAd = this.mediaId;
        aoe.LAe = this.uploadedSize;
        aoe.LAf = getFrom();
        aoe.LAg = getTo();
        multiTaskInfo.field_data = aoe.toByteArray();
        AppMethodBeat.o(238042);
    }

    @Override // com.tencent.mm.plugin.handoff.model.HandOff
    public final HandOff copy() {
        AppMethodBeat.i(121703);
        HandOffFile handOffFile = new HandOffFile(this.fullPath, this.fileType, this.title, this.md5, this.size, this.source, this.svrId, this.extId, this.cdnURL, this.aesKey, this.authKey, this.fileStatus, this.appId, this.sdkVersion, this.mediaId, this.uploadedSize, getHandOffType(), getFrom(), getTo(), getKey());
        handOffFile.setId(getId());
        HandOffFile handOffFile2 = handOffFile;
        AppMethodBeat.o(121703);
        return handOffFile2;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.handoff.model.HandOff
    public final BallInfo doCreateBallInfo() {
        return null;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.handoff.model.HandOff
    public final o<cru, byte[]> doCreateMultiTaskInfo() {
        return null;
    }

    public final String toString() {
        AppMethodBeat.i(121704);
        String str = "HandOffFile(key='" + getKey() + "', id='" + getId() + "', createTime='" + getCreateTime() + ", fullPath='" + this.fullPath + "', fileType='" + this.fileType + "', title='" + this.title + "', md5='" + this.md5 + "', size=" + this.size + ", source=" + this.source + ", svrId='" + this.svrId + "', extId='" + this.extId + "', cdnURL='" + this.cdnURL + "', aesKey='" + this.aesKey + "', authKey='" + this.authKey + "', fileStatus=" + this.fileStatus + ", appId='" + this.appId + "', sdkVersion=" + this.sdkVersion + ", mediaId='" + this.mediaId + "', uploadedSize=" + this.uploadedSize + ')';
        AppMethodBeat.o(121704);
        return str;
    }
}
