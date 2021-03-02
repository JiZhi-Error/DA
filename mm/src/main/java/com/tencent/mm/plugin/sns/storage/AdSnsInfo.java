package com.tencent.mm.plugin.sns.storage;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.bw.b;
import com.tencent.mm.g.c.f;
import com.tencent.mm.modelsns.n;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.cj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Keep
public class AdSnsInfo extends f {
    public static final String COL_ID = "rowid";
    public static final String TABLEINDEXHEAD = "serverAdSnsTimeHeadIndex";
    public static final String TABLEINDEXLOCALFLAG = "AdsnsLocalflagIndex";
    public static final String TABLEINDEXMULTI1 = "adsnsMultiIndex1";
    public static final String TABLEINDEXMULTI2 = "adsnsMultiIndex2";
    public static final String TABLEINDEXSOURCE = "serverAdSnsTimeSourceTypeIndex";
    public static final String TABLEINDEXTIME = "serverAdSnsTimeIndex";
    public static final String TABLEINDEXUSERNAME = "serverAdSnsNameIndex";
    public static final String TAG = "MicroMsg.AdSnsInfo";
    protected static Map<String, ADInfo> cacheAdInfo = new ConcurrentHashMap();
    protected static Map<String, ADXml> cacheAdXml = new ConcurrentHashMap();
    protected static IAutoDBItem.MAutoDBInfo info = f.initAutoDBInfo(AdSnsInfo.class);
    public String contentByteMd5 = null;
    protected int localid;

    static {
        AppMethodBeat.i(97433);
        AppMethodBeat.o(97433);
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    @Keep
    public ADXml getAdXml() {
        ADXml aDXml;
        AppMethodBeat.i(97410);
        if (this.field_adxml == null) {
            aDXml = null;
        } else if (cacheAdXml.containsKey(this.field_adxml)) {
            ADXml aDXml2 = cacheAdXml.get(this.field_adxml);
            AppMethodBeat.o(97410);
            return aDXml2;
        } else {
            aDXml = new ADXml(this.field_adxml);
            cacheAdXml.put(this.field_adxml, aDXml);
        }
        if (aDXml == null) {
            ADXml aDXml3 = new ADXml(null);
            AppMethodBeat.o(97410);
            return aDXml3;
        }
        AppMethodBeat.o(97410);
        return aDXml;
    }

    public ADXml getRecXml() {
        ADXml aDXml;
        AppMethodBeat.i(97411);
        if (this.field_recxml == null) {
            aDXml = null;
        } else if (cacheAdXml.containsKey(this.field_recxml)) {
            ADXml aDXml2 = cacheAdXml.get(this.field_recxml);
            AppMethodBeat.o(97411);
            return aDXml2;
        } else {
            aDXml = new ADXml(this.field_recxml);
            cacheAdXml.put(this.field_recxml, aDXml);
        }
        if (aDXml == null) {
            ADXml aDXml3 = new ADXml(null);
            AppMethodBeat.o(97411);
            return aDXml3;
        }
        AppMethodBeat.o(97411);
        return aDXml;
    }

    public ADInfo getAdInfo() {
        ADInfo aDInfo;
        AppMethodBeat.i(97412);
        if (this.field_adinfo == null) {
            aDInfo = null;
        } else if (cacheAdInfo.containsKey(this.field_adinfo)) {
            ADInfo aDInfo2 = cacheAdInfo.get(this.field_adinfo);
            AppMethodBeat.o(97412);
            return aDInfo2;
        } else {
            aDInfo = new ADInfo(this.field_adinfo);
            cacheAdInfo.put(this.field_adinfo, aDInfo);
        }
        if (aDInfo == null) {
            ADInfo aDInfo3 = new ADInfo(null);
            AppMethodBeat.o(97412);
            return aDInfo3;
        }
        AppMethodBeat.o(97412);
        return aDInfo;
    }

    public ADInfo getAtAdInfo() {
        ADInfo aDInfo;
        AppMethodBeat.i(97413);
        if (this.field_atAdinfo == null) {
            aDInfo = null;
        } else if (cacheAdInfo.containsKey(this.field_atAdinfo)) {
            ADInfo aDInfo2 = cacheAdInfo.get(this.field_atAdinfo);
            AppMethodBeat.o(97413);
            return aDInfo2;
        } else {
            aDInfo = new ADInfo(this.field_atAdinfo);
            cacheAdInfo.put(this.field_atAdinfo, aDInfo);
        }
        if (aDInfo == null) {
            ADInfo aDInfo3 = new ADInfo(null);
            AppMethodBeat.o(97413);
            return aDInfo3;
        }
        AppMethodBeat.o(97413);
        return aDInfo;
    }

    public boolean isRecExpAd() {
        AppMethodBeat.i(97414);
        ADXml adXml = getAdXml();
        if (adXml != null) {
            boolean isRecExpAd = adXml.isRecExpAd();
            AppMethodBeat.o(97414);
            return isRecExpAd;
        }
        AppMethodBeat.o(97414);
        return false;
    }

    public int getRecSrc() {
        AppMethodBeat.i(97415);
        ADXml recXml = getRecXml();
        if (recXml == null) {
            AppMethodBeat.o(97415);
            return 0;
        }
        int i2 = recXml.recSrc;
        AppMethodBeat.o(97415);
        return i2;
    }

    public int getSource() {
        AppMethodBeat.i(97416);
        ADXml recXml = getRecXml();
        if (recXml == null) {
            AppMethodBeat.o(97416);
            return 0;
        }
        int i2 = recXml.recSrc;
        AppMethodBeat.o(97416);
        return i2;
    }

    public int getExpId() {
        AppMethodBeat.i(97417);
        ADXml recXml = getRecXml();
        if (recXml == null) {
            AppMethodBeat.o(97417);
            return 0;
        }
        int i2 = recXml.recExpId;
        AppMethodBeat.o(97417);
        return i2;
    }

    public void setExposures() {
        this.field_localFlag |= 128;
    }

    public boolean isExposured() {
        return (this.field_localFlag & 128) > 0;
    }

    public void setNotExposured() {
        this.field_localFlag &= -129;
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

    public void setTimeLine(TimeLineObject timeLineObject) {
        AppMethodBeat.i(97418);
        try {
            this.field_content = timeLineObject.toByteArray();
            AppMethodBeat.o(97418);
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
            AppMethodBeat.o(97418);
        }
    }

    public boolean setContent(String str) {
        AppMethodBeat.i(97419);
        try {
            this.field_content = n.PM(str).toByteArray();
            this.contentByteMd5 = g.getMessageDigest(this.field_content) + g.getMessageDigest(this.field_attrBuf);
            AppMethodBeat.o(97419);
            return true;
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
            AppMethodBeat.o(97419);
            return false;
        }
    }

    public TimeLineObject getTimeLine() {
        TimeLineObject timeLineObject;
        AppMethodBeat.i(97420);
        if (this.field_content == null) {
            TimeLineObject bfM = n.bfM();
            AppMethodBeat.o(97420);
            return bfM;
        }
        if (this.contentByteMd5 == null) {
            this.contentByteMd5 = g.getMessageDigest(this.field_content) + g.getMessageDigest(this.field_attrBuf);
        }
        if (!SnsInfo.cacheTimeLine.containsKey(this.contentByteMd5) || (timeLineObject = SnsInfo.cacheTimeLine.get(this.contentByteMd5)) == null) {
            try {
                TimeLineObject timeLineObject2 = (TimeLineObject) new TimeLineObject().parseFrom(this.field_content);
                SnsInfo.cacheTimeLine.put(this.contentByteMd5, timeLineObject2);
                AppMethodBeat.o(97420);
                return timeLineObject2;
            } catch (Exception e2) {
                Log.e(TAG, "error get snsinfo timeline!");
                TimeLineObject bfM2 = n.bfM();
                AppMethodBeat.o(97420);
                return bfM2;
            }
        } else {
            AppMethodBeat.o(97420);
            return timeLineObject;
        }
    }

    public void setSnsId(long j2) {
        AppMethodBeat.i(203183);
        this.field_snsId = j2;
        if (j2 != 0) {
            setStringSeq(j2);
        }
        AppMethodBeat.o(203183);
    }

    public void setRemindInfoGroup(cj cjVar) {
        AppMethodBeat.i(97421);
        try {
            this.field_remindInfoGroup = cjVar.toByteArray();
            AppMethodBeat.o(97421);
        } catch (Exception e2) {
            Log.e(TAG, "remindInfo toBytes error! " + e2.getMessage());
            AppMethodBeat.o(97421);
        }
    }

    public cj getRemindInfoGroup() {
        Exception e2;
        cj cjVar;
        AppMethodBeat.i(97422);
        try {
            if (this.field_remindInfoGroup != null) {
                cjVar = new cj();
                try {
                    cjVar.parseFrom(this.field_remindInfoGroup);
                } catch (Exception e3) {
                    e2 = e3;
                    Log.e(TAG, "parse remindInfo error! " + e2.getMessage());
                    AppMethodBeat.o(97422);
                    return cjVar;
                }
            } else {
                cjVar = null;
            }
        } catch (Exception e4) {
            e2 = e4;
            cjVar = null;
            Log.e(TAG, "parse remindInfo error! " + e2.getMessage());
            AppMethodBeat.o(97422);
            return cjVar;
        }
        AppMethodBeat.o(97422);
        return cjVar;
    }

    public b getTimelineRemindInfoSourceInfo() {
        AppMethodBeat.i(97423);
        if (getRemindInfoGroup() == null || getRemindInfoGroup().KGD == null || getRemindInfoGroup().KGD.MQd == null) {
            AppMethodBeat.o(97423);
            return null;
        }
        b buffer = getRemindInfoGroup().KGD.MQd.getBuffer();
        AppMethodBeat.o(97423);
        return buffer;
    }

    public b getTimelineRemindInfoSelfInfo() {
        AppMethodBeat.i(97424);
        if (getRemindInfoGroup() == null || getRemindInfoGroup().KGD == null || getRemindInfoGroup().KGD.MQe == null) {
            AppMethodBeat.o(97424);
            return null;
        }
        b buffer = getRemindInfoGroup().KGD.MQe.getBuffer();
        AppMethodBeat.o(97424);
        return buffer;
    }

    public b getAtFriendRemindInfoSourceInfo() {
        AppMethodBeat.i(97425);
        if (getRemindInfoGroup() == null || getRemindInfoGroup().KGE == null || getRemindInfoGroup().KGE.MQd == null) {
            AppMethodBeat.o(97425);
            return null;
        }
        b buffer = getRemindInfoGroup().KGE.MQd.getBuffer();
        AppMethodBeat.o(97425);
        return buffer;
    }

    public b getAtFriendRemindInfoSelfInfo() {
        AppMethodBeat.i(97426);
        if (getRemindInfoGroup() == null || getRemindInfoGroup().KGE == null || getRemindInfoGroup().KGE.MQe == null) {
            AppMethodBeat.o(97426);
            return null;
        }
        b buffer = getRemindInfoGroup().KGE.MQe.getBuffer();
        AppMethodBeat.o(97426);
        return buffer;
    }

    public void setStringSeq(long j2) {
        AppMethodBeat.i(203184);
        this.field_stringSeq = r.Jb(j2);
        this.field_stringSeq = r.aOr(this.field_stringSeq);
        Log.d(TAG, j2 + " stringSeq " + this.field_stringSeq);
        AppMethodBeat.o(203184);
    }

    public void setAttrBuf(byte[] bArr) {
        AppMethodBeat.i(97427);
        this.field_attrBuf = bArr;
        this.contentByteMd5 = g.getMessageDigest(this.field_content) + g.getMessageDigest(this.field_attrBuf);
        AppMethodBeat.o(97427);
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

    public String getSnsId() {
        AppMethodBeat.i(97428);
        String bp = y.bp("ad_table_", this.field_snsId);
        AppMethodBeat.o(97428);
        return bp;
    }

    public String getLocalid() {
        AppMethodBeat.i(203185);
        String bq = y.bq("ad_table_", (long) this.localid);
        AppMethodBeat.o(203185);
        return bq;
    }

    public SnsInfo convertToSnsInfo() {
        AppMethodBeat.i(97429);
        SnsInfo snsInfo = new SnsInfo();
        snsInfo.setTimeLine(getTimeLine());
        Log.d(TAG, "from server xml ok %d", Long.valueOf(this.field_snsId));
        snsInfo.setLocalid(this.localid);
        snsInfo.setUserName(this.field_userName);
        snsInfo.setCreateTime(this.field_createTime);
        snsInfo.setLikeFlag(this.field_likeFlag);
        snsInfo.setSnsId(this.field_snsId);
        snsInfo.field_sourceType = this.field_sourceType;
        snsInfo.field_content = this.field_content;
        snsInfo.addSourceFlag(2);
        snsInfo.addSourceFlag(32);
        snsInfo.field_attrBuf = this.field_attrBuf;
        TimeLineObject timeLine = snsInfo.getTimeLine();
        timeLine.UserName = this.field_userName;
        snsInfo.setPravited(timeLine.Privated);
        snsInfo.setExtFlag();
        snsInfo.setTimeLine(timeLine);
        if (timeLine.ContentObj != null) {
            snsInfo.setTypeFlag(timeLine.ContentObj.LoU);
            snsInfo.setSubTypeFlag(timeLine.ContentObj.LoW);
        }
        snsInfo.setAdSnsInfo(this);
        AppMethodBeat.o(97429);
        return snsInfo;
    }

    @Override // com.tencent.mm.g.c.f, com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        AppMethodBeat.i(97430);
        super.convertFrom(cursor);
        this.localid = (int) this.systemRowid;
        AppMethodBeat.o(97430);
    }

    public ContentValues convertFrom(ContentValues contentValues) {
        AppMethodBeat.i(203186);
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
        this.field_adinfo = contentValues.getAsString(f.COL_ADINFO);
        this.field_adxml = contentValues.getAsString(f.COL_ADXML);
        this.field_createAdTime = contentValues.getAsInteger(f.COL_CREATEADTIME).intValue();
        this.field_exposureTime = contentValues.getAsInteger(f.COL_EXPOSURETIME).intValue();
        this.field_firstControlTime = contentValues.getAsInteger(f.COL_FIRSTCONTROLTIME).intValue();
        this.field_recxml = contentValues.getAsString(f.COL_RECXML);
        this.field_subType = contentValues.getAsInteger("subType").intValue();
        this.systemRowid = contentValues.getAsLong("rowid").longValue();
        this.field_atAdinfo = contentValues.getAsString(f.COL_ATADINFO);
        this.field_remindInfoGroup = contentValues.getAsByteArray(f.COL_REMINDINFOGROUP);
        AppMethodBeat.o(203186);
        return contentValues;
    }

    public Bundle writeToBundle() {
        AppMethodBeat.i(97431);
        Bundle bundle = new Bundle();
        bundle.putParcelable("values", super.convertTo());
        bundle.putInt("localid", this.localid);
        AppMethodBeat.o(97431);
        return bundle;
    }

    public void readFromBundle(Bundle bundle) {
        AppMethodBeat.i(97432);
        if (bundle == null) {
            AppMethodBeat.o(97432);
            return;
        }
        convertFrom((ContentValues) bundle.getParcelable("values"));
        this.localid = bundle.getInt("localid");
        AppMethodBeat.o(97432);
    }
}
