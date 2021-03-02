package com.tencent.mm.plugin.sns.storage;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.g.c.gk;
import com.tencent.mm.modelsns.n;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.cnc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.storage.as;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Keep
public class SnsInfo extends gk {
    public static final String COL_ID = "rowid";
    public static final long SECONDS_OF_DAY = 86400;
    public static final long SECONDS_OF_HOUR = 3600;
    public static final long SECONDS_OF_MINUTE = 60;
    public static final String TABLEINDEXHEAD = "serverSnsTimeHeadIndex";
    public static final String TABLEINDEXLOCALFLAG = "snsLocalflagIndex";
    public static final String TABLEINDEXMULTI1 = "snsMultiIndex1";
    public static final String TABLEINDEXMULTI2 = "snsMultiIndex2";
    public static final String TABLEINDEXMULTI3 = "snsMultiIndex3";
    public static final String TABLEINDEXSOURCE = "serverSnsTimeSourceTypeIndex";
    public static final String TABLEINDEXTIME = "serverSnsTimeIndex";
    public static final String TABLEINDEXUSERNAME = "serverSnsNameIndex";
    private static final String TAG = "MicroMsg.SnsInfo";
    protected static Map<String, cnc> cacheMediaPost = new ConcurrentHashMap();
    protected static Map<String, TimeLineObject> cacheTimeLine = new ConcurrentHashMap();
    protected static IAutoDBItem.MAutoDBInfo info = gk.initAutoDBInfo(SnsInfo.class);
    @Keep
    private AdSnsInfo adsnsinfo;
    public String contentByteMd5 = null;
    private boolean isAd = false;
    public int localid;
    private cnc postInfo = null;
    public String postinfoMd5 = null;

    static {
        AppMethodBeat.i(97532);
        AppMethodBeat.o(97532);
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    public SnsInfo() {
    }

    public cnc getPostInfo() {
        AppMethodBeat.i(97497);
        if (this.field_postBuf == null) {
            cnc cnc = new cnc();
            AppMethodBeat.o(97497);
            return cnc;
        }
        if (this.postinfoMd5 == null) {
            this.postinfoMd5 = g.getMessageDigest(this.field_postBuf);
        }
        if (cacheMediaPost.containsKey(this.postinfoMd5)) {
            this.postInfo = cacheMediaPost.get(this.postinfoMd5);
            if (this.postInfo != null) {
                cnc cnc2 = this.postInfo;
                AppMethodBeat.o(97497);
                return cnc2;
            }
        }
        try {
            this.postInfo = (cnc) new cnc().parseFrom(this.field_postBuf);
            cacheMediaPost.put(this.postinfoMd5, this.postInfo);
            cnc cnc3 = this.postInfo;
            AppMethodBeat.o(97497);
            return cnc3;
        } catch (Exception e2) {
            Log.e(TAG, "error get snsinfo timeline!");
            cnc cnc4 = new cnc();
            AppMethodBeat.o(97497);
            return cnc4;
        }
    }

    public void setPostInfo() {
        AppMethodBeat.i(203189);
        try {
            setPostBuf(this.postInfo.toByteArray());
            AppMethodBeat.o(203189);
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
            Log.e(TAG, "toByteArray error");
            AppMethodBeat.o(203189);
        }
    }

    public SnsInfo(long j2) {
        AppMethodBeat.i(203190);
        setSnsId(j2);
        AppMethodBeat.o(203190);
    }

    public static SnsInfo getNewSnsInfo(SnsInfo snsInfo) {
        AppMethodBeat.i(97499);
        SnsInfo snsInfo2 = new SnsInfo();
        snsInfo2.localid = snsInfo.localid;
        snsInfo2.field_snsId = snsInfo.field_snsId;
        snsInfo2.field_userName = snsInfo.field_userName;
        snsInfo2.field_localFlag = snsInfo.field_localFlag;
        snsInfo2.field_createTime = snsInfo.field_createTime;
        snsInfo2.field_head = snsInfo.field_head;
        snsInfo2.field_localPrivate = snsInfo.field_localPrivate;
        snsInfo2.field_type = snsInfo.field_type;
        snsInfo2.field_sourceType = snsInfo.field_sourceType;
        snsInfo2.field_likeFlag = snsInfo.field_likeFlag;
        snsInfo2.field_pravited = snsInfo.field_pravited;
        snsInfo2.field_stringSeq = snsInfo.field_stringSeq;
        snsInfo2.field_content = snsInfo.field_content;
        snsInfo2.field_attrBuf = snsInfo.field_attrBuf;
        AppMethodBeat.o(97499);
        return snsInfo2;
    }

    public void setSnsId(long j2) {
        AppMethodBeat.i(97500);
        this.field_snsId = j2;
        if (j2 != 0) {
            setStringSeq(j2);
        }
        AppMethodBeat.o(97500);
    }

    public String getSnsId() {
        AppMethodBeat.i(97501);
        if (isAd()) {
            String bp = y.bp("ad_table_", this.field_snsId);
            AppMethodBeat.o(97501);
            return bp;
        }
        String bp2 = y.bp("sns_table_", this.field_snsId);
        AppMethodBeat.o(97501);
        return bp2;
    }

    public void setUserName(String str) {
        this.field_userName = str;
    }

    public String getUserName() {
        return this.field_userName;
    }

    public static int formatUnixTime(long j2) {
        int i2;
        AppMethodBeat.i(97502);
        String format = new SimpleDateFormat("yyyyMMdd").format(new Date(1000 * j2));
        try {
            i2 = Integer.valueOf(format).intValue();
        } catch (Exception e2) {
            Log.e(TAG, "error valueOf  ".concat(String.valueOf(format)));
            i2 = (int) (j2 / 86400);
        }
        AppMethodBeat.o(97502);
        return i2;
    }

    public void setCreateTime(int i2) {
        AppMethodBeat.i(97503);
        if (i2 - this.field_createTime >= 180 || i2 - this.field_createTime < 0) {
            this.field_createTime = i2;
            setHead(formatUnixTime((long) i2));
            AppMethodBeat.o(97503);
            return;
        }
        if (this.field_head == 0) {
            setHead(formatUnixTime((long) this.field_createTime));
        }
        AppMethodBeat.o(97503);
    }

    public int getCreateTime() {
        return this.field_createTime;
    }

    public void setLocalPrivate() {
        this.field_localPrivate |= 1;
    }

    public void unLocalPrivate() {
        this.field_localPrivate = 0;
    }

    public int getLocalPrivate() {
        return this.field_localPrivate;
    }

    public void setTypeFlag(int i2) {
        this.field_type = i2;
    }

    public void setSubTypeFlag(int i2) {
        this.field_subType = i2;
    }

    public int getTypeFlag() {
        return this.field_type;
    }

    public int getLikeFlag() {
        return this.field_likeFlag;
    }

    public void setLikeFlag(int i2) {
        this.field_likeFlag = i2;
    }

    public void printInfo() {
    }

    public String getSnsInfo() {
        AppMethodBeat.i(203191);
        String str = "snsId: " + this.field_stringSeq + " \n  localFlag: " + this.field_localFlag + " #　 \n  type: " + this.field_type + " lp: " + this.field_localPrivate + " \n  isPr: " + this.field_pravited + " head: " + this.field_head + " \n  time: " + this.field_createTime + " \n ";
        AppMethodBeat.o(203191);
        return str;
    }

    public int getHead() {
        return this.field_head;
    }

    public void setHead(int i2) {
        this.field_head = i2;
    }

    public int getPravited() {
        return this.field_pravited;
    }

    public void setPravited(int i2) {
        this.field_pravited = i2;
    }

    public void setWithMe() {
        this.field_localFlag |= 1;
    }

    public void unSetWithMe() {
        this.field_localFlag &= -2;
    }

    public void setExposures() {
        this.field_localFlag |= 128;
    }

    public boolean isExposures() {
        return (this.field_localFlag & 128) > 0;
    }

    public void setExtFlag() {
        this.field_localFlag |= 2;
    }

    public boolean isWithMe() {
        return (this.field_localFlag & 1) > 0;
    }

    public void unSetExtFlag() {
        this.field_localFlag &= -3;
    }

    public void setWsFoldFlag() {
        this.field_localFlag |= 1024;
    }

    public void cleanWsFoldFlag() {
        this.field_localFlag &= -1025;
    }

    public boolean isWsFold() {
        return (this.field_localFlag & 1024) > 0;
    }

    public boolean isExtFlag() {
        return (this.field_localFlag & 2) > 0;
    }

    public boolean isLocalInvisible() {
        return (this.field_localFlag & 256) > 0;
    }

    public void setLocalInvisible() {
        this.field_localFlag |= 256;
    }

    public void setLocalVisible() {
        this.field_localFlag &= -257;
    }

    public String getLocalid() {
        AppMethodBeat.i(97504);
        if (isAd()) {
            String bp = y.bp("ad_table_", (long) this.localid);
            AppMethodBeat.o(97504);
            return bp;
        }
        String bp2 = y.bp("sns_table_", (long) this.localid);
        AppMethodBeat.o(97504);
        return bp2;
    }

    public void setLocalid(int i2) {
        this.localid = i2;
    }

    public void setAttrBuf(byte[] bArr) {
        AppMethodBeat.i(97505);
        this.field_attrBuf = bArr;
        this.contentByteMd5 = g.getMessageDigest(this.field_content) + g.getMessageDigest(this.field_attrBuf);
        AppMethodBeat.o(97505);
    }

    public String getStringSeq() {
        return this.field_stringSeq;
    }

    public void setStringSeq(String str) {
        this.field_stringSeq = str;
    }

    public void setStringSeq(long j2) {
        AppMethodBeat.i(97506);
        this.field_stringSeq = r.Jb(j2);
        this.field_stringSeq = r.aOr(this.field_stringSeq);
        Log.d(TAG, j2 + " stringSeq " + this.field_stringSeq);
        AppMethodBeat.o(97506);
    }

    public int getLocalFlag() {
        return this.field_localFlag;
    }

    public void setLocalFlag(int i2) {
        this.field_localFlag = i2;
    }

    @Override // com.tencent.mm.g.c.gk, com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        AppMethodBeat.i(97507);
        super.convertFrom(cursor);
        this.localid = (int) this.systemRowid;
        AppMethodBeat.o(97507);
    }

    public static synchronized void release() {
        synchronized (SnsInfo.class) {
            AppMethodBeat.i(97508);
            cacheTimeLine.clear();
            cacheMediaPost.clear();
            AppMethodBeat.o(97508);
        }
    }

    @Keep
    public TimeLineObject getTimeLine() {
        TimeLineObject timeLineObject;
        AppMethodBeat.i(97509);
        if (this.field_content == null) {
            TimeLineObject bfM = n.bfM();
            AppMethodBeat.o(97509);
            return bfM;
        }
        if (this.contentByteMd5 == null) {
            this.contentByteMd5 = g.getMessageDigest(this.field_content) + g.getMessageDigest(this.field_attrBuf);
        }
        if (!cacheTimeLine.containsKey(this.contentByteMd5) || (timeLineObject = cacheTimeLine.get(this.contentByteMd5)) == null) {
            try {
                TimeLineObject timeLineObject2 = (TimeLineObject) new TimeLineObject().parseFrom(this.field_content);
                cacheTimeLine.put(this.contentByteMd5, timeLineObject2);
                AppMethodBeat.o(97509);
                return timeLineObject2;
            } catch (Exception e2) {
                Log.e(TAG, "error get snsinfo timeline!");
                TimeLineObject bfM2 = n.bfM();
                AppMethodBeat.o(97509);
                return bfM2;
            }
        } else {
            AppMethodBeat.o(97509);
            return timeLineObject;
        }
    }

    public void setTimeLine(TimeLineObject timeLineObject) {
        AppMethodBeat.i(97510);
        try {
            this.field_content = timeLineObject.toByteArray();
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
        }
        this.contentByteMd5 = g.getMessageDigest(this.field_content) + g.getMessageDigest(this.field_attrBuf);
        AppMethodBeat.o(97510);
    }

    public boolean setContent(String str) {
        AppMethodBeat.i(97511);
        try {
            this.field_content = n.PM(str).toByteArray();
            this.contentByteMd5 = g.getMessageDigest(this.field_content) + g.getMessageDigest(this.field_attrBuf);
            AppMethodBeat.o(97511);
            return true;
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
            AppMethodBeat.o(97511);
            return false;
        }
    }

    public boolean canDeal() {
        return this.field_snsId != 0;
    }

    public void setPostWaiting() {
        this.field_localFlag |= 16;
    }

    public void setPostHolding() {
        this.field_localFlag |= 512;
    }

    public void cleanPostHolding() {
        this.field_localFlag &= -513;
    }

    public void setPostFinish() {
        this.field_localFlag &= -17;
    }

    public boolean isWaitPost() {
        return (this.field_localFlag & 16) > 0;
    }

    public boolean isDieItem() {
        return (this.field_localFlag & 32) > 0 && this.field_snsId == 0;
    }

    public void clearItemDie() {
        this.field_localFlag &= -33;
    }

    public void setItemDie() {
        this.field_localFlag |= 32;
    }

    public void setOmittedFailResend() {
        this.field_localFlag |= 64;
    }

    public void unsetOmittedFailResend() {
        AppMethodBeat.i(203192);
        if (isOmittedFailResend()) {
            this.field_localFlag &= -65;
        }
        AppMethodBeat.o(203192);
    }

    public boolean isOmittedFailResend() {
        return (this.field_localFlag & 64) > 0;
    }

    public boolean isTimeLimit(int i2, long j2) {
        AppMethodBeat.i(203193);
        if (Util.secondsToNow(j2 / 1000) > 1200) {
            AppMethodBeat.o(203193);
            return true;
        }
        AppMethodBeat.o(203193);
        return false;
    }

    public byte[] getPostBuf() {
        return this.field_postBuf;
    }

    public void setPostBuf(byte[] bArr) {
        this.field_postBuf = bArr;
    }

    public int getSourceType() {
        return this.field_sourceType;
    }

    public boolean isDeadSource() {
        return (this.field_sourceType & 14) == 0;
    }

    public boolean isSourceExist(int i2) {
        return (this.field_sourceType & i2) > 0;
    }

    public void addSourceFlag(int i2) {
        this.field_sourceType |= i2;
    }

    public void removeSourceFlag(int i2) {
        this.field_sourceType &= i2 ^ -1;
    }

    @Keep
    public synchronized ADXml getAdXml() {
        ADXml adXml;
        AppMethodBeat.i(97513);
        if (this.adsnsinfo == null) {
            this.adsnsinfo = aj.faR().JE(this.field_snsId);
        }
        if (this.adsnsinfo == null) {
            adXml = new ADXml(null);
            AppMethodBeat.o(97513);
        } else {
            adXml = this.adsnsinfo.getAdXml();
            AppMethodBeat.o(97513);
        }
        return adXml;
    }

    @Keep
    public ADInfo getAdInfo() {
        AppMethodBeat.i(97514);
        if (this.adsnsinfo == null) {
            this.adsnsinfo = aj.faR().JE(this.field_snsId);
        }
        if (this.adsnsinfo == null) {
            ADInfo aDInfo = new ADInfo(null);
            AppMethodBeat.o(97514);
            return aDInfo;
        }
        ADInfo adInfo = this.adsnsinfo.getAdInfo();
        AppMethodBeat.o(97514);
        return adInfo;
    }

    @Keep
    public ADInfo getAtAdInfo() {
        AppMethodBeat.i(97515);
        if (this.adsnsinfo == null) {
            this.adsnsinfo = aj.faR().JE(this.field_snsId);
        }
        if (this.adsnsinfo == null) {
            ADInfo aDInfo = new ADInfo(null);
            AppMethodBeat.o(97515);
            return aDInfo;
        }
        ADInfo atAdInfo = this.adsnsinfo.getAtAdInfo();
        AppMethodBeat.o(97515);
        return atAdInfo;
    }

    @Keep
    public ADInfo getAdInfo(int i2) {
        AppMethodBeat.i(97516);
        if (i2 == 2) {
            ADInfo atAdInfo = getAtAdInfo();
            AppMethodBeat.o(97516);
            return atAdInfo;
        }
        ADInfo adInfo = getAdInfo();
        AppMethodBeat.o(97516);
        return adInfo;
    }

    public String getAid() {
        AppMethodBeat.i(97517);
        ADInfo adInfo = getAdInfo();
        if (adInfo == null) {
            AppMethodBeat.o(97517);
            return "";
        }
        String str = adInfo.aid;
        AppMethodBeat.o(97517);
        return str;
    }

    public String getTraceid() {
        AppMethodBeat.i(97518);
        ADInfo adInfo = getAdInfo();
        if (adInfo == null) {
            AppMethodBeat.o(97518);
            return "";
        }
        String str = adInfo.traceid;
        AppMethodBeat.o(97518);
        return str;
    }

    public String getAdLink() {
        AppMethodBeat.i(97519);
        ADXml adXml = getAdXml();
        if (adXml != null) {
            String str = adXml.adActionLink;
            AppMethodBeat.o(97519);
            return str;
        }
        AppMethodBeat.o(97519);
        return "";
    }

    public String getAdInfoLink() {
        AppMethodBeat.i(97520);
        ADInfo adInfo = getAdInfo();
        if (adInfo != null) {
            String str = adInfo.adActionLink;
            AppMethodBeat.o(97520);
            return str;
        }
        AppMethodBeat.o(97520);
        return "";
    }

    public String getUxinfo() {
        AppMethodBeat.i(97521);
        ADInfo adInfo = getAdInfo();
        if (adInfo != null) {
            String str = adInfo.uxInfo;
            AppMethodBeat.o(97521);
            return str;
        }
        AppMethodBeat.o(97521);
        return "";
    }

    public void setAdSnsInfo(AdSnsInfo adSnsInfo) {
        this.adsnsinfo = adSnsInfo;
    }

    public AdSnsInfo getAdSnsInfo() {
        AppMethodBeat.i(97522);
        if (this.adsnsinfo == null) {
            this.adsnsinfo = aj.faR().JE(this.field_snsId);
        }
        if (this.adsnsinfo != null) {
            this.adsnsinfo.field_createTime = this.field_createTime;
            this.adsnsinfo.field_userName = this.field_userName;
            this.adsnsinfo.field_likeFlag = this.field_likeFlag;
            this.adsnsinfo.field_attrBuf = this.field_attrBuf;
        }
        AdSnsInfo adSnsInfo = this.adsnsinfo;
        AppMethodBeat.o(97522);
        return adSnsInfo;
    }

    public String getAdTitle() {
        AppMethodBeat.i(203194);
        ADXml adXml = getAdXml();
        if (adXml != null) {
            String str = adXml.adActionTitle;
            AppMethodBeat.o(203194);
            return str;
        }
        AppMethodBeat.o(203194);
        return "";
    }

    public boolean isAd() {
        AppMethodBeat.i(185991);
        boolean isSourceExist = isSourceExist(32);
        AppMethodBeat.o(185991);
        return isSourceExist;
    }

    public boolean isWxWork() {
        String str;
        AppMethodBeat.i(203195);
        com.tencent.mm.kernel.g.aAi();
        as bjK = ((l) com.tencent.mm.kernel.g.af(l.class)).aSN().bjK(this.field_userName);
        if (bjK == null) {
            str = null;
        } else {
            str = bjK.field_openImAppid;
        }
        if (!as.bjp(this.field_userName) || !"3552365301".equals(str)) {
            AppMethodBeat.o(203195);
            return false;
        }
        AppMethodBeat.o(203195);
        return true;
    }

    public int getAdRecSrc() {
        AppMethodBeat.i(97524);
        ADXml adXml = getAdXml();
        if (adXml != null) {
            int i2 = adXml.recSrc;
            AppMethodBeat.o(97524);
            return i2;
        }
        AppMethodBeat.o(97524);
        return 0;
    }

    public boolean isRecExpAd() {
        AppMethodBeat.i(97525);
        ADXml adXml = getAdXml();
        if (adXml != null) {
            boolean isRecExpAd = adXml.isRecExpAd();
            AppMethodBeat.o(97525);
            return isRecExpAd;
        }
        AppMethodBeat.o(97525);
        return false;
    }

    public boolean isValid() {
        return this.field_snsId != 0;
    }

    public boolean isInValid() {
        return this.field_snsId == 0;
    }

    public String dumpAd() {
        AppMethodBeat.i(203196);
        AdSnsInfo adSnsInfo = getAdSnsInfo();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.field_stringSeq);
        stringBuffer.append(adSnsInfo.field_adxml);
        stringBuffer.append(" <createtime " + this.field_createTime + ">");
        stringBuffer.append(" <exposuretime " + adSnsInfo.field_exposureTime + ">");
        stringBuffer.append(" <adcreatetime " + adSnsInfo.field_createAdTime + "> ");
        stringBuffer.append(adSnsInfo.getTimeLine().ContentDesc);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(203196);
        return stringBuffer2;
    }

    @Keep
    public int getAdType() {
        AppMethodBeat.i(97526);
        if (isAd()) {
            ADXml adXml = getAdXml();
            TimeLineObject timeLine = getTimeLine();
            if (adXml.isLinkAd()) {
                AppMethodBeat.o(97526);
                return 3;
            } else if (timeLine != null && timeLine.ContentObj.LoU == 27) {
                AppMethodBeat.o(97526);
                return 6;
            } else if (adXml.isCardAd() || adXml.isFullCardAd()) {
                if (timeLine == null || timeLine.ContentObj.LoU != 15 || timeLine.sightFolded == 1) {
                    AppMethodBeat.o(97526);
                    return 4;
                }
                AppMethodBeat.o(97526);
                return 5;
            } else if (adXml.isFinderTopicCard()) {
                AppMethodBeat.o(97526);
                return 9;
            } else if (this.field_type == 1) {
                AppMethodBeat.o(97526);
                return 1;
            } else {
                AppMethodBeat.o(97526);
                return 2;
            }
        } else {
            AppMethodBeat.o(97526);
            return -1;
        }
    }

    public boolean isTurnCardAd() {
        AppMethodBeat.i(97527);
        if (getTimeLine() == null || getTimeLine().ContentObj.LoU != 27) {
            AppMethodBeat.o(97527);
            return false;
        }
        AppMethodBeat.o(97527);
        return true;
    }

    public boolean isCardAd() {
        AppMethodBeat.i(97528);
        if (getAdXml() == null || !getAdXml().isCardAd()) {
            AppMethodBeat.o(97528);
            return false;
        }
        AppMethodBeat.o(97528);
        return true;
    }

    public boolean isFullCardAd() {
        AppMethodBeat.i(97529);
        if (getAdXml() == null || !getAdXml().isFullCardAd()) {
            AppMethodBeat.o(97529);
            return false;
        }
        AppMethodBeat.o(97529);
        return true;
    }

    public boolean isSphereCardAd() {
        AppMethodBeat.i(97530);
        if (getAdXml() == null || !getAdXml().isSphereCardAd()) {
            AppMethodBeat.o(97530);
            return false;
        }
        AppMethodBeat.o(97530);
        return true;
    }

    public boolean isFinderTopicCardAd() {
        AppMethodBeat.i(203197);
        if (getAdXml() == null || !getAdXml().isFinderTopicCard()) {
            AppMethodBeat.o(203197);
            return false;
        }
        AppMethodBeat.o(203197);
        return true;
    }

    public boolean isFinderAd() {
        AppMethodBeat.i(203198);
        ADXml adXml = getAdXml();
        ADInfo adInfo = getAdInfo();
        if (!isAd() || adXml == null || adXml.adFinderInfo == null || adInfo == null || adInfo.adActionType != 9) {
            AppMethodBeat.o(203198);
            return false;
        }
        AppMethodBeat.o(203198);
        return true;
    }

    public boolean isTwistAd() {
        AppMethodBeat.i(203199);
        ADXml adXml = getAdXml();
        if (!isAd() || adXml == null || adXml.adTwistInfo == null) {
            AppMethodBeat.o(203199);
            return false;
        }
        AppMethodBeat.o(203199);
        return true;
    }

    public boolean isLongPressGestureAd() {
        AppMethodBeat.i(203200);
        if (getAdXml() == null || !getAdXml().isLongPressGestureAd()) {
            AppMethodBeat.o(203200);
            return false;
        }
        AppMethodBeat.o(203200);
        return true;
    }

    public ContentValues convertFrom(ContentValues contentValues) {
        AppMethodBeat.i(203201);
        this.field_snsId = contentValues.getAsLong("snsId").longValue();
        this.field_userName = contentValues.getAsString("userName");
        this.field_localFlag = contentValues.getAsInteger("localFlag").intValue();
        this.field_createTime = contentValues.getAsInteger("createTime").intValue();
        this.field_head = contentValues.getAsInteger("head").intValue();
        this.field_localPrivate = contentValues.getAsInteger("localPrivate").intValue();
        this.field_type = contentValues.getAsInteger("type").intValue();
        this.field_sourceType = contentValues.getAsInteger("sourceType").intValue();
        this.field_likeFlag = contentValues.getAsInteger("likeFlag").intValue();
        this.field_pravited = contentValues.getAsInteger("pravited").intValue();
        this.field_stringSeq = contentValues.getAsString("stringSeq");
        this.field_content = contentValues.getAsByteArray("content");
        this.field_attrBuf = contentValues.getAsByteArray("attrBuf");
        this.field_postBuf = contentValues.getAsByteArray("postBuf");
        this.field_subType = contentValues.getAsInteger("subType").intValue();
        if (contentValues.containsKey("rowid")) {
            this.systemRowid = contentValues.getAsLong("rowid").longValue();
        }
        AppMethodBeat.o(203201);
        return contentValues;
    }

    public Bundle writeToBundle() {
        AppMethodBeat.i(97531);
        Bundle bundle = new Bundle();
        bundle.putParcelable("values", super.convertTo());
        bundle.putInt("localid", this.localid);
        if (getAdSnsInfo() != null) {
            bundle.putBundle("adValues", getAdSnsInfo().writeToBundle());
        }
        AppMethodBeat.o(97531);
        return bundle;
    }

    public void readFromBundle(Bundle bundle) {
        AppMethodBeat.i(203202);
        if (bundle == null) {
            AppMethodBeat.o(203202);
            return;
        }
        convertFrom((ContentValues) bundle.getParcelable("values"));
        this.localid = bundle.getInt("localid");
        Bundle bundle2 = bundle.getBundle("adValues");
        if (bundle2 != null) {
            AdSnsInfo adSnsInfo = new AdSnsInfo();
            adSnsInfo.readFromBundle(bundle2);
            this.adsnsinfo = adSnsInfo;
        }
        AppMethodBeat.o(203202);
    }
}
