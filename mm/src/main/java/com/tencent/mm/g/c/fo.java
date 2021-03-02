package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class fo extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fVD = "originalArticleCount".hashCode();
    private static final int fVE = "friendSubscribeCount".hashCode();
    private static final int fVF = "allArticleWording".hashCode();
    private static final int fVG = "historyArticlesUrl".hashCode();
    private static final int fVH = "userRole".hashCode();
    private static final int fVI = "banReason".hashCode();
    private static final int fVJ = "showRecommendArticle".hashCode();
    private static final int fVK = "showService".hashCode();
    private static final int fVL = "messageListStr".hashCode();
    private static final int fVM = "serviceInfoListStr".hashCode();
    private static final int fVN = "bizAccountListStr".hashCode();
    private static final int fVO = "cacheTime".hashCode();
    private static final int fVP = "decryptUserName".hashCode();
    private static final int fVQ = "hiddenAvatar".hashCode();
    private static final int fVR = "hiddenButtonBeforeFocus".hashCode();
    private static final int fVS = "newBanReason".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    private static final int username_HASHCODE = ch.COL_USERNAME.hashCode();
    private boolean __hadSetusername = true;
    private boolean fVA = true;
    private boolean fVB = true;
    private boolean fVC = true;
    private boolean fVn = true;
    private boolean fVo = true;
    private boolean fVp = true;
    private boolean fVq = true;
    private boolean fVr = true;
    private boolean fVs = true;
    private boolean fVt = true;
    private boolean fVu = true;
    private boolean fVv = true;
    private boolean fVw = true;
    private boolean fVx = true;
    private boolean fVy = true;
    private boolean fVz = true;
    public String field_allArticleWording;
    public String field_banReason;
    public String field_bizAccountListStr;
    public long field_cacheTime;
    public String field_decryptUserName;
    public int field_friendSubscribeCount;
    public int field_hiddenAvatar;
    public int field_hiddenButtonBeforeFocus;
    public String field_historyArticlesUrl;
    public String field_messageListStr;
    public String field_newBanReason;
    public int field_originalArticleCount;
    public String field_serviceInfoListStr;
    public int field_showRecommendArticle;
    public int field_showService;
    public int field_userRole;
    public String field_username;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (username_HASHCODE == hashCode) {
                    this.field_username = cursor.getString(i2);
                    this.__hadSetusername = true;
                } else if (fVD == hashCode) {
                    this.field_originalArticleCount = cursor.getInt(i2);
                } else if (fVE == hashCode) {
                    this.field_friendSubscribeCount = cursor.getInt(i2);
                } else if (fVF == hashCode) {
                    this.field_allArticleWording = cursor.getString(i2);
                } else if (fVG == hashCode) {
                    this.field_historyArticlesUrl = cursor.getString(i2);
                } else if (fVH == hashCode) {
                    this.field_userRole = cursor.getInt(i2);
                } else if (fVI == hashCode) {
                    this.field_banReason = cursor.getString(i2);
                } else if (fVJ == hashCode) {
                    this.field_showRecommendArticle = cursor.getInt(i2);
                } else if (fVK == hashCode) {
                    this.field_showService = cursor.getInt(i2);
                } else if (fVL == hashCode) {
                    this.field_messageListStr = cursor.getString(i2);
                } else if (fVM == hashCode) {
                    this.field_serviceInfoListStr = cursor.getString(i2);
                } else if (fVN == hashCode) {
                    this.field_bizAccountListStr = cursor.getString(i2);
                } else if (fVO == hashCode) {
                    this.field_cacheTime = cursor.getLong(i2);
                } else if (fVP == hashCode) {
                    this.field_decryptUserName = cursor.getString(i2);
                } else if (fVQ == hashCode) {
                    this.field_hiddenAvatar = cursor.getInt(i2);
                } else if (fVR == hashCode) {
                    this.field_hiddenButtonBeforeFocus = cursor.getInt(i2);
                } else if (fVS == hashCode) {
                    this.field_newBanReason = cursor.getString(i2);
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.__hadSetusername) {
            contentValues.put(ch.COL_USERNAME, this.field_username);
        }
        if (this.fVn) {
            contentValues.put("originalArticleCount", Integer.valueOf(this.field_originalArticleCount));
        }
        if (this.fVo) {
            contentValues.put("friendSubscribeCount", Integer.valueOf(this.field_friendSubscribeCount));
        }
        if (this.fVp) {
            contentValues.put("allArticleWording", this.field_allArticleWording);
        }
        if (this.fVq) {
            contentValues.put("historyArticlesUrl", this.field_historyArticlesUrl);
        }
        if (this.fVr) {
            contentValues.put("userRole", Integer.valueOf(this.field_userRole));
        }
        if (this.fVs) {
            contentValues.put("banReason", this.field_banReason);
        }
        if (this.fVt) {
            contentValues.put("showRecommendArticle", Integer.valueOf(this.field_showRecommendArticle));
        }
        if (this.fVu) {
            contentValues.put("showService", Integer.valueOf(this.field_showService));
        }
        if (this.fVv) {
            contentValues.put("messageListStr", this.field_messageListStr);
        }
        if (this.fVw) {
            contentValues.put("serviceInfoListStr", this.field_serviceInfoListStr);
        }
        if (this.fVx) {
            contentValues.put("bizAccountListStr", this.field_bizAccountListStr);
        }
        if (this.fVy) {
            contentValues.put("cacheTime", Long.valueOf(this.field_cacheTime));
        }
        if (this.field_decryptUserName == null) {
            this.field_decryptUserName = "";
        }
        if (this.fVz) {
            contentValues.put("decryptUserName", this.field_decryptUserName);
        }
        if (this.fVA) {
            contentValues.put("hiddenAvatar", Integer.valueOf(this.field_hiddenAvatar));
        }
        if (this.fVB) {
            contentValues.put("hiddenButtonBeforeFocus", Integer.valueOf(this.field_hiddenButtonBeforeFocus));
        }
        if (this.fVC) {
            contentValues.put("newBanReason", this.field_newBanReason);
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
