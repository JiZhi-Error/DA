package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class aq extends IAutoDBItem {
    public static final String[] INDEX_CREATE = new String[0];
    private static final int fnB = "url".hashCode();
    private static final int fne = "title".hashCode();
    private static final int fnf = "description".hashCode();
    private static final int frA = "card_type".hashCode();
    private static final int frB = "logo_url".hashCode();
    private static final int frC = "time".hashCode();
    private static final int frD = "card_id".hashCode();
    private static final int frE = "card_tp_id".hashCode();
    private static final int frF = "msg_id".hashCode();
    private static final int frG = "msg_type".hashCode();
    private static final int frH = "jump_type".hashCode();
    private static final int frI = "buttonData".hashCode();
    private static final int frJ = "operData".hashCode();
    private static final int frK = "report_scene".hashCode();
    private static final int frL = "read_state".hashCode();
    private static final int frM = "accept_buttons".hashCode();
    private static final int frN = "consumed_box_id".hashCode();
    private static final int frO = "jump_buttons".hashCode();
    private static final int frP = "logo_color".hashCode();
    private static final int frQ = "unavailable_qr_code_list".hashCode();
    private static final int frR = "all_unavailable".hashCode();
    private static final int frS = "need_pull_card_entrance".hashCode();
    private static final int rowid_HASHCODE = "rowid".hashCode();
    public String field_accept_buttons;
    public boolean field_all_unavailable;
    public byte[] field_buttonData;
    public String field_card_id;
    public String field_card_tp_id;
    public int field_card_type;
    public String field_consumed_box_id;
    public String field_description;
    public String field_jump_buttons;
    public int field_jump_type;
    public String field_logo_color;
    public String field_logo_url;
    public String field_msg_id;
    public int field_msg_type;
    public boolean field_need_pull_card_entrance;
    public byte[] field_operData;
    public int field_read_state;
    public int field_report_scene;
    public int field_time;
    public String field_title;
    public String field_unavailable_qr_code_list;
    public String field_url;
    private boolean fnb = true;
    private boolean fnc = true;
    private boolean fnx = true;
    private boolean frh = true;
    private boolean fri = true;
    private boolean frj = true;
    private boolean frk = true;
    private boolean frl = true;
    private boolean frm = true;
    private boolean frn = true;
    private boolean fro = true;
    private boolean frp = true;
    private boolean frq = true;
    private boolean frr = true;
    private boolean frs = true;
    private boolean frt = true;
    private boolean fru = true;
    private boolean frv = true;
    private boolean frw = true;
    private boolean frx = true;
    private boolean fry = true;
    private boolean frz = true;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i2 = 0; i2 < length; i2++) {
                int hashCode = columnNames[i2].hashCode();
                if (frA == hashCode) {
                    this.field_card_type = cursor.getInt(i2);
                } else if (fne == hashCode) {
                    this.field_title = cursor.getString(i2);
                } else if (fnf == hashCode) {
                    this.field_description = cursor.getString(i2);
                } else if (frB == hashCode) {
                    this.field_logo_url = cursor.getString(i2);
                } else if (frC == hashCode) {
                    this.field_time = cursor.getInt(i2);
                } else if (frD == hashCode) {
                    this.field_card_id = cursor.getString(i2);
                } else if (frE == hashCode) {
                    this.field_card_tp_id = cursor.getString(i2);
                } else if (frF == hashCode) {
                    this.field_msg_id = cursor.getString(i2);
                    this.frm = true;
                } else if (frG == hashCode) {
                    this.field_msg_type = cursor.getInt(i2);
                } else if (frH == hashCode) {
                    this.field_jump_type = cursor.getInt(i2);
                } else if (fnB == hashCode) {
                    this.field_url = cursor.getString(i2);
                } else if (frI == hashCode) {
                    this.field_buttonData = cursor.getBlob(i2);
                } else if (frJ == hashCode) {
                    this.field_operData = cursor.getBlob(i2);
                } else if (frK == hashCode) {
                    this.field_report_scene = cursor.getInt(i2);
                } else if (frL == hashCode) {
                    this.field_read_state = cursor.getInt(i2);
                } else if (frM == hashCode) {
                    this.field_accept_buttons = cursor.getString(i2);
                } else if (frN == hashCode) {
                    this.field_consumed_box_id = cursor.getString(i2);
                } else if (frO == hashCode) {
                    this.field_jump_buttons = cursor.getString(i2);
                } else if (frP == hashCode) {
                    this.field_logo_color = cursor.getString(i2);
                } else if (frQ == hashCode) {
                    this.field_unavailable_qr_code_list = cursor.getString(i2);
                } else if (frR == hashCode) {
                    this.field_all_unavailable = cursor.getInt(i2) != 0;
                } else if (frS == hashCode) {
                    this.field_need_pull_card_entrance = cursor.getInt(i2) != 0;
                } else if (rowid_HASHCODE == hashCode) {
                    this.systemRowid = cursor.getLong(i2);
                }
            }
        }
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        if (this.frh) {
            contentValues.put("card_type", Integer.valueOf(this.field_card_type));
        }
        if (this.fnb) {
            contentValues.put("title", this.field_title);
        }
        if (this.fnc) {
            contentValues.put("description", this.field_description);
        }
        if (this.fri) {
            contentValues.put("logo_url", this.field_logo_url);
        }
        if (this.frj) {
            contentValues.put("time", Integer.valueOf(this.field_time));
        }
        if (this.frk) {
            contentValues.put("card_id", this.field_card_id);
        }
        if (this.frl) {
            contentValues.put("card_tp_id", this.field_card_tp_id);
        }
        if (this.frm) {
            contentValues.put("msg_id", this.field_msg_id);
        }
        if (this.frn) {
            contentValues.put("msg_type", Integer.valueOf(this.field_msg_type));
        }
        if (this.fro) {
            contentValues.put("jump_type", Integer.valueOf(this.field_jump_type));
        }
        if (this.fnx) {
            contentValues.put("url", this.field_url);
        }
        if (this.frp) {
            contentValues.put("buttonData", this.field_buttonData);
        }
        if (this.frq) {
            contentValues.put("operData", this.field_operData);
        }
        if (this.frr) {
            contentValues.put("report_scene", Integer.valueOf(this.field_report_scene));
        }
        if (this.frs) {
            contentValues.put("read_state", Integer.valueOf(this.field_read_state));
        }
        if (this.frt) {
            contentValues.put("accept_buttons", this.field_accept_buttons);
        }
        if (this.fru) {
            contentValues.put("consumed_box_id", this.field_consumed_box_id);
        }
        if (this.frv) {
            contentValues.put("jump_buttons", this.field_jump_buttons);
        }
        if (this.frw) {
            contentValues.put("logo_color", this.field_logo_color);
        }
        if (this.frx) {
            contentValues.put("unavailable_qr_code_list", this.field_unavailable_qr_code_list);
        }
        if (this.fry) {
            contentValues.put("all_unavailable", Boolean.valueOf(this.field_all_unavailable));
        }
        if (this.frz) {
            contentValues.put("need_pull_card_entrance", Boolean.valueOf(this.field_need_pull_card_entrance));
        }
        if (this.systemRowid > 0) {
            contentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return contentValues;
    }
}
