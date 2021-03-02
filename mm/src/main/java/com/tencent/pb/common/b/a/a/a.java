package com.tencent.pb.common.b.a.a;

import android.support.constraint.ConstraintLayout;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.thumbplayer.core.common.TPCodecParamers;
import java.util.Arrays;

public interface a {

    public static final class v extends com.google.a.a.e {
        public byte[] REA = com.google.a.a.g.cbu;
        public byte[] REB = com.google.a.a.g.cbu;
        public byte[] REC = com.google.a.a.g.cbu;
        public int REo = 0;
        public byte[] REp = com.google.a.a.g.cbu;
        public byte[] REq = com.google.a.a.g.cbu;
        public byte[] REr = com.google.a.a.g.cbu;
        public int REs = 0;
        public byte[] REt = com.google.a.a.g.cbu;
        public byte[] REu = com.google.a.a.g.cbu;
        public byte[] REv = com.google.a.a.g.cbu;
        public byte[] REw = com.google.a.a.g.cbu;
        public byte[] REx = com.google.a.a.g.cbu;
        public byte[] REy = com.google.a.a.g.cbu;
        public byte[] REz = com.google.a.a.g.cbu;
        public byte[] data = com.google.a.a.g.cbu;
        public String iconUrl = "";
        public String rCq = "";
        public int status = 0;
        public int zaR = 0;

        public v() {
            this.cbo = -1;
        }

        @Override // com.google.a.a.e
        public final void a(com.google.a.a.b bVar) {
            if (this.REo != 0) {
                bVar.bB(1, this.REo);
            }
            if (!Arrays.equals(this.REp, com.google.a.a.g.cbu)) {
                bVar.b(2, this.REp);
            }
            if (!this.iconUrl.equals("")) {
                bVar.e(3, this.iconUrl);
            }
            if (!Arrays.equals(this.REq, com.google.a.a.g.cbu)) {
                bVar.b(4, this.REq);
            }
            if (!Arrays.equals(this.REr, com.google.a.a.g.cbu)) {
                bVar.b(5, this.REr);
            }
            if (this.zaR != 0) {
                bVar.bB(6, this.zaR);
            }
            if (!Arrays.equals(this.data, com.google.a.a.g.cbu)) {
                bVar.b(7, this.data);
            }
            if (this.REs != 0) {
                bVar.bB(8, this.REs);
            }
            if (!Arrays.equals(this.REt, com.google.a.a.g.cbu)) {
                bVar.b(9, this.REt);
            }
            if (!this.rCq.equals("")) {
                bVar.e(10, this.rCq);
            }
            if (!Arrays.equals(this.REu, com.google.a.a.g.cbu)) {
                bVar.b(11, this.REu);
            }
            if (!Arrays.equals(this.REv, com.google.a.a.g.cbu)) {
                bVar.b(12, this.REv);
            }
            if (!Arrays.equals(this.REw, com.google.a.a.g.cbu)) {
                bVar.b(13, this.REw);
            }
            if (!Arrays.equals(this.REx, com.google.a.a.g.cbu)) {
                bVar.b(14, this.REx);
            }
            if (!Arrays.equals(this.REy, com.google.a.a.g.cbu)) {
                bVar.b(15, this.REy);
            }
            if (!Arrays.equals(this.REz, com.google.a.a.g.cbu)) {
                bVar.b(16, this.REz);
            }
            if (!Arrays.equals(this.REA, com.google.a.a.g.cbu)) {
                bVar.b(17, this.REA);
            }
            if (!Arrays.equals(this.REB, com.google.a.a.g.cbu)) {
                bVar.b(18, this.REB);
            }
            if (!Arrays.equals(this.REC, com.google.a.a.g.cbu)) {
                bVar.b(19, this.REC);
            }
            if (this.status != 0) {
                bVar.bB(20, this.status);
            }
            super.a(bVar);
        }

        @Override // com.google.a.a.e
        public final int Ig() {
            int Ig = super.Ig();
            if (this.REo != 0) {
                Ig += com.google.a.a.b.bC(1, this.REo);
            }
            if (!Arrays.equals(this.REp, com.google.a.a.g.cbu)) {
                Ig += com.google.a.a.b.c(2, this.REp);
            }
            if (!this.iconUrl.equals("")) {
                Ig += com.google.a.a.b.f(3, this.iconUrl);
            }
            if (!Arrays.equals(this.REq, com.google.a.a.g.cbu)) {
                Ig += com.google.a.a.b.c(4, this.REq);
            }
            if (!Arrays.equals(this.REr, com.google.a.a.g.cbu)) {
                Ig += com.google.a.a.b.c(5, this.REr);
            }
            if (this.zaR != 0) {
                Ig += com.google.a.a.b.bC(6, this.zaR);
            }
            if (!Arrays.equals(this.data, com.google.a.a.g.cbu)) {
                Ig += com.google.a.a.b.c(7, this.data);
            }
            if (this.REs != 0) {
                Ig += com.google.a.a.b.bC(8, this.REs);
            }
            if (!Arrays.equals(this.REt, com.google.a.a.g.cbu)) {
                Ig += com.google.a.a.b.c(9, this.REt);
            }
            if (!this.rCq.equals("")) {
                Ig += com.google.a.a.b.f(10, this.rCq);
            }
            if (!Arrays.equals(this.REu, com.google.a.a.g.cbu)) {
                Ig += com.google.a.a.b.c(11, this.REu);
            }
            if (!Arrays.equals(this.REv, com.google.a.a.g.cbu)) {
                Ig += com.google.a.a.b.c(12, this.REv);
            }
            if (!Arrays.equals(this.REw, com.google.a.a.g.cbu)) {
                Ig += com.google.a.a.b.c(13, this.REw);
            }
            if (!Arrays.equals(this.REx, com.google.a.a.g.cbu)) {
                Ig += com.google.a.a.b.c(14, this.REx);
            }
            if (!Arrays.equals(this.REy, com.google.a.a.g.cbu)) {
                Ig += com.google.a.a.b.c(15, this.REy);
            }
            if (!Arrays.equals(this.REz, com.google.a.a.g.cbu)) {
                Ig += com.google.a.a.b.c(16, this.REz);
            }
            if (!Arrays.equals(this.REA, com.google.a.a.g.cbu)) {
                Ig += com.google.a.a.b.c(17, this.REA);
            }
            if (!Arrays.equals(this.REB, com.google.a.a.g.cbu)) {
                Ig += com.google.a.a.b.c(18, this.REB);
            }
            if (!Arrays.equals(this.REC, com.google.a.a.g.cbu)) {
                Ig += com.google.a.a.b.c(19, this.REC);
            }
            if (this.status != 0) {
                return Ig + com.google.a.a.b.bC(20, this.status);
            }
            return Ig;
        }

        @Override // com.google.a.a.e
        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int yT = aVar.yT();
                switch (yT) {
                    case 0:
                        break;
                    case 8:
                        this.REo = aVar.zi();
                        break;
                    case 18:
                        this.REp = aVar.readBytes();
                        break;
                    case 26:
                        this.iconUrl = aVar.readString();
                        break;
                    case 34:
                        this.REq = aVar.readBytes();
                        break;
                    case 42:
                        this.REr = aVar.readBytes();
                        break;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
                        this.zaR = aVar.zi();
                        break;
                    case 58:
                        this.data = aVar.readBytes();
                        break;
                    case 64:
                        this.REs = aVar.zi();
                        break;
                    case 74:
                        this.REt = aVar.readBytes();
                        break;
                    case PlayerException.EXCEPTION_TYPE_ERROR_CREATE_JAVA_DATASOURCE /*{ENCODED_INT: 82}*/:
                        this.rCq = aVar.readString();
                        break;
                    case 90:
                        this.REu = aVar.readBytes();
                        break;
                    case 98:
                        this.REv = aVar.readBytes();
                        break;
                    case 106:
                        this.REw = aVar.readBytes();
                        break;
                    case 114:
                        this.REx = aVar.readBytes();
                        break;
                    case 122:
                        this.REy = aVar.readBytes();
                        break;
                    case 130:
                        this.REz = aVar.readBytes();
                        break;
                    case 138:
                        this.REA = aVar.readBytes();
                        break;
                    case 146:
                        this.REB = aVar.readBytes();
                        break;
                    case 154:
                        this.REC = aVar.readBytes();
                        break;
                    case 160:
                        this.status = aVar.zi();
                        break;
                    default:
                        if (com.google.a.a.g.a(aVar, yT)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }
    }

    public static final class w extends com.google.a.a.e {
        public int EX = 0;
        public int KBb = 0;
        public int RDt = 0;
        public int REE = 0;
        public int REG = 0;
        public int ret = 0;
        public String userName = "";

        public w() {
            this.cbo = -1;
        }

        @Override // com.google.a.a.e
        public final void a(com.google.a.a.b bVar) {
            if (!this.userName.equals("")) {
                bVar.e(2, this.userName);
            }
            if (this.EX != 0) {
                bVar.bs(3, this.EX);
            }
            if (this.REE != 0) {
                bVar.bB(4, this.REE);
            }
            if (this.ret != 0) {
                bVar.bs(5, this.ret);
            }
            if (this.REG != 0) {
                bVar.bs(6, this.REG);
            }
            if (this.RDt != 0) {
                bVar.bB(7, this.RDt);
            }
            if (this.KBb != 0) {
                bVar.bB(8, this.KBb);
            }
            super.a(bVar);
        }

        @Override // com.google.a.a.e
        public final int Ig() {
            int Ig = super.Ig();
            if (!this.userName.equals("")) {
                Ig += com.google.a.a.b.f(2, this.userName);
            }
            if (this.EX != 0) {
                Ig += com.google.a.a.b.bu(3, this.EX);
            }
            if (this.REE != 0) {
                Ig += com.google.a.a.b.bC(4, this.REE);
            }
            if (this.ret != 0) {
                Ig += com.google.a.a.b.bu(5, this.ret);
            }
            if (this.REG != 0) {
                Ig += com.google.a.a.b.bu(6, this.REG);
            }
            if (this.RDt != 0) {
                Ig += com.google.a.a.b.bC(7, this.RDt);
            }
            if (this.KBb != 0) {
                return Ig + com.google.a.a.b.bC(8, this.KBb);
            }
            return Ig;
        }

        @Override // com.google.a.a.e
        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int yT = aVar.yT();
                switch (yT) {
                    case 0:
                        break;
                    case 18:
                        this.userName = aVar.readString();
                        break;
                    case 24:
                        this.EX = aVar.zi();
                        break;
                    case 32:
                        this.REE = aVar.zi();
                        break;
                    case 40:
                        this.ret = aVar.zi();
                        break;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
                        this.REG = aVar.zi();
                        break;
                    case 56:
                        this.RDt = aVar.zi();
                        break;
                    case 64:
                        this.KBb = aVar.zi();
                        break;
                    default:
                        if (com.google.a.a.g.a(aVar, yT)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }
    }

    public static final class x extends com.google.a.a.e {
        public w REH = null;
        public byte[] body = com.google.a.a.g.cbu;

        public x() {
            this.cbo = -1;
        }

        @Override // com.google.a.a.e
        public final void a(com.google.a.a.b bVar) {
            if (this.REH != null) {
                bVar.a(1, this.REH);
            }
            if (!Arrays.equals(this.body, com.google.a.a.g.cbu)) {
                bVar.b(2, this.body);
            }
            super.a(bVar);
        }

        @Override // com.google.a.a.e
        public final int Ig() {
            int Ig = super.Ig();
            if (this.REH != null) {
                Ig += com.google.a.a.b.b(1, this.REH);
            }
            if (!Arrays.equals(this.body, com.google.a.a.g.cbu)) {
                return Ig + com.google.a.a.b.c(2, this.body);
            }
            return Ig;
        }

        @Override // com.google.a.a.e
        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int yT = aVar.yT();
                switch (yT) {
                    case 0:
                        break;
                    case 10:
                        if (this.REH == null) {
                            this.REH = new w();
                        }
                        aVar.a(this.REH);
                        break;
                    case 18:
                        this.body = aVar.readBytes();
                        break;
                    default:
                        if (com.google.a.a.g.a(aVar, yT)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }
    }

    public static final class bg extends com.google.a.a.e {
        public ap RGJ = null;
        public int type = 0;

        public bg() {
            this.cbo = -1;
        }

        @Override // com.google.a.a.e
        public final void a(com.google.a.a.b bVar) {
            if (this.type != 0) {
                bVar.bs(1, this.type);
            }
            if (this.RGJ != null) {
                bVar.a(2, this.RGJ);
            }
            super.a(bVar);
        }

        @Override // com.google.a.a.e
        public final int Ig() {
            int Ig = super.Ig();
            if (this.type != 0) {
                Ig += com.google.a.a.b.bu(1, this.type);
            }
            if (this.RGJ != null) {
                return Ig + com.google.a.a.b.b(2, this.RGJ);
            }
            return Ig;
        }

        @Override // com.google.a.a.e
        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int yT = aVar.yT();
                switch (yT) {
                    case 0:
                        break;
                    case 8:
                        this.type = aVar.zi();
                        break;
                    case 18:
                        if (this.RGJ == null) {
                            this.RGJ = new ap();
                        }
                        aVar.a(this.RGJ);
                        break;
                    default:
                        if (com.google.a.a.g.a(aVar, yT)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }
    }

    public static final class be extends com.google.a.a.e {
        public int GXO = 0;
        public long GXP = 0;
        public int RGE = 0;

        public be() {
            this.cbo = -1;
        }

        @Override // com.google.a.a.e
        public final void a(com.google.a.a.b bVar) {
            if (this.GXO != 0) {
                bVar.bs(1, this.GXO);
            }
            if (this.GXP != 0) {
                bVar.q(2, this.GXP);
            }
            if (this.RGE != 0) {
                bVar.bB(3, this.RGE);
            }
            super.a(bVar);
        }

        @Override // com.google.a.a.e
        public final int Ig() {
            int Ig = super.Ig();
            if (this.GXO != 0) {
                Ig += com.google.a.a.b.bu(1, this.GXO);
            }
            if (this.GXP != 0) {
                Ig += com.google.a.a.b.r(2, this.GXP);
            }
            if (this.RGE != 0) {
                return Ig + com.google.a.a.b.bC(3, this.RGE);
            }
            return Ig;
        }

        @Override // com.google.a.a.e
        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int yT = aVar.yT();
                switch (yT) {
                    case 0:
                        break;
                    case 8:
                        this.GXO = aVar.zi();
                        break;
                    case 16:
                        this.GXP = aVar.zl();
                        break;
                    case 24:
                        this.RGE = aVar.zi();
                        break;
                    default:
                        if (com.google.a.a.g.a(aVar, yT)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }
    }

    public static final class ay extends com.google.a.a.e {
        public int RFA = 0;
        public int RFB = 0;
        public int RFC = 0;
        public int RFD = 0;
        public int RFE = 0;
        public int RFF = 0;
        public int RFG = 0;
        public int RFx = 0;
        public int RFy = 0;
        public int RFz = 0;
        public int iTa = 0;
        public int iTb = 0;

        public ay() {
            this.cbo = -1;
        }

        @Override // com.google.a.a.e
        public final void a(com.google.a.a.b bVar) {
            if (this.RFx != 0) {
                bVar.bs(1, this.RFx);
            }
            if (this.iTa != 0) {
                bVar.bs(2, this.iTa);
            }
            if (this.iTb != 0) {
                bVar.bs(3, this.iTb);
            }
            if (this.RFy != 0) {
                bVar.bs(4, this.RFy);
            }
            if (this.RFz != 0) {
                bVar.bs(5, this.RFz);
            }
            if (this.RFA != 0) {
                bVar.bs(6, this.RFA);
            }
            if (this.RFB != 0) {
                bVar.bs(7, this.RFB);
            }
            if (this.RFC != 0) {
                bVar.bs(8, this.RFC);
            }
            if (this.RFD != 0) {
                bVar.bs(9, this.RFD);
            }
            if (this.RFE != 0) {
                bVar.bs(10, this.RFE);
            }
            if (this.RFF != 0) {
                bVar.bs(11, this.RFF);
            }
            if (this.RFG != 0) {
                bVar.bs(12, this.RFG);
            }
            super.a(bVar);
        }

        @Override // com.google.a.a.e
        public final int Ig() {
            int Ig = super.Ig();
            if (this.RFx != 0) {
                Ig += com.google.a.a.b.bu(1, this.RFx);
            }
            if (this.iTa != 0) {
                Ig += com.google.a.a.b.bu(2, this.iTa);
            }
            if (this.iTb != 0) {
                Ig += com.google.a.a.b.bu(3, this.iTb);
            }
            if (this.RFy != 0) {
                Ig += com.google.a.a.b.bu(4, this.RFy);
            }
            if (this.RFz != 0) {
                Ig += com.google.a.a.b.bu(5, this.RFz);
            }
            if (this.RFA != 0) {
                Ig += com.google.a.a.b.bu(6, this.RFA);
            }
            if (this.RFB != 0) {
                Ig += com.google.a.a.b.bu(7, this.RFB);
            }
            if (this.RFC != 0) {
                Ig += com.google.a.a.b.bu(8, this.RFC);
            }
            if (this.RFD != 0) {
                Ig += com.google.a.a.b.bu(9, this.RFD);
            }
            if (this.RFE != 0) {
                Ig += com.google.a.a.b.bu(10, this.RFE);
            }
            if (this.RFF != 0) {
                Ig += com.google.a.a.b.bu(11, this.RFF);
            }
            if (this.RFG != 0) {
                return Ig + com.google.a.a.b.bu(12, this.RFG);
            }
            return Ig;
        }

        @Override // com.google.a.a.e
        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int yT = aVar.yT();
                switch (yT) {
                    case 0:
                        break;
                    case 8:
                        this.RFx = aVar.zi();
                        break;
                    case 16:
                        this.iTa = aVar.zi();
                        break;
                    case 24:
                        this.iTb = aVar.zi();
                        break;
                    case 32:
                        this.RFy = aVar.zi();
                        break;
                    case 40:
                        this.RFz = aVar.zi();
                        break;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
                        this.RFA = aVar.zi();
                        break;
                    case 56:
                        this.RFB = aVar.zi();
                        break;
                    case 64:
                        this.RFC = aVar.zi();
                        break;
                    case 72:
                        this.RFD = aVar.zi();
                        break;
                    case PlayerException.EXCEPTION_TYPE_CONNECT_FAIL /*{ENCODED_INT: 80}*/:
                        this.RFE = aVar.zi();
                        break;
                    case TPCodecParamers.TP_PROFILE_H264_EXTENDED /*{ENCODED_INT: 88}*/:
                        this.RFF = aVar.zi();
                        break;
                    case PlayerException.EXCEPTION_IN_SETAUDIOEFFECT /*{ENCODED_INT: 96}*/:
                        this.RFG = aVar.zi();
                        break;
                    default:
                        if (com.google.a.a.g.a(aVar, yT)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }
    }

    public static final class u extends com.google.a.a.e {
        public long KTS = 0;
        public long KTT = 0;
        public String RDO = "";
        public String REh = "";
        public String REi = "";
        public int REj = 1;
        public long REk = 0;
        public int REl = 0;
        public long REm = 0;
        public int REn = 0;
        public String countrycode = "";
        public String ivR = "";
        public String username = "";

        public u() {
            this.cbo = -1;
        }

        @Override // com.google.a.a.e
        public final void a(com.google.a.a.b bVar) {
            if (this.KTS != 0) {
                bVar.n(1, this.KTS);
            }
            if (!this.REh.equals("")) {
                bVar.e(2, this.REh);
            }
            if (!this.REi.equals("")) {
                bVar.e(3, this.REi);
            }
            if (this.REj != 1) {
                bVar.bs(4, this.REj);
            }
            if (!this.username.equals("")) {
                bVar.e(5, this.username);
            }
            if (!this.ivR.equals("")) {
                bVar.e(6, this.ivR);
            }
            if (!this.RDO.equals("")) {
                bVar.e(7, this.RDO);
            }
            if (this.REk != 0) {
                bVar.n(8, this.REk);
            }
            if (this.REl != 0) {
                bVar.bB(9, this.REl);
            }
            if (!this.countrycode.equals("")) {
                bVar.e(10, this.countrycode);
            }
            if (this.REm != 0) {
                bVar.n(11, this.REm);
            }
            if (this.REn != 0) {
                bVar.bB(12, this.REn);
            }
            if (this.KTT != 0) {
                bVar.n(13, this.KTT);
            }
            super.a(bVar);
        }

        @Override // com.google.a.a.e
        public final int Ig() {
            int Ig = super.Ig();
            if (this.KTS != 0) {
                Ig += com.google.a.a.b.p(1, this.KTS);
            }
            if (!this.REh.equals("")) {
                Ig += com.google.a.a.b.f(2, this.REh);
            }
            if (!this.REi.equals("")) {
                Ig += com.google.a.a.b.f(3, this.REi);
            }
            if (this.REj != 1) {
                Ig += com.google.a.a.b.bu(4, this.REj);
            }
            if (!this.username.equals("")) {
                Ig += com.google.a.a.b.f(5, this.username);
            }
            if (!this.ivR.equals("")) {
                Ig += com.google.a.a.b.f(6, this.ivR);
            }
            if (!this.RDO.equals("")) {
                Ig += com.google.a.a.b.f(7, this.RDO);
            }
            if (this.REk != 0) {
                Ig += com.google.a.a.b.p(8, this.REk);
            }
            if (this.REl != 0) {
                Ig += com.google.a.a.b.bC(9, this.REl);
            }
            if (!this.countrycode.equals("")) {
                Ig += com.google.a.a.b.f(10, this.countrycode);
            }
            if (this.REm != 0) {
                Ig += com.google.a.a.b.p(11, this.REm);
            }
            if (this.REn != 0) {
                Ig += com.google.a.a.b.bC(12, this.REn);
            }
            if (this.KTT != 0) {
                return Ig + com.google.a.a.b.p(13, this.KTT);
            }
            return Ig;
        }

        @Override // com.google.a.a.e
        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int yT = aVar.yT();
                switch (yT) {
                    case 0:
                        break;
                    case 8:
                        this.KTS = aVar.zl();
                        break;
                    case 18:
                        this.REh = aVar.readString();
                        break;
                    case 26:
                        this.REi = aVar.readString();
                        break;
                    case 32:
                        this.REj = aVar.zi();
                        break;
                    case 42:
                        this.username = aVar.readString();
                        break;
                    case 50:
                        this.ivR = aVar.readString();
                        break;
                    case 58:
                        this.RDO = aVar.readString();
                        break;
                    case 64:
                        this.REk = aVar.zl();
                        break;
                    case 72:
                        this.REl = aVar.zi();
                        break;
                    case PlayerException.EXCEPTION_TYPE_ERROR_CREATE_JAVA_DATASOURCE /*{ENCODED_INT: 82}*/:
                        this.countrycode = aVar.readString();
                        break;
                    case TPCodecParamers.TP_PROFILE_H264_EXTENDED /*{ENCODED_INT: 88}*/:
                        this.REm = aVar.zl();
                        break;
                    case PlayerException.EXCEPTION_IN_SETAUDIOEFFECT /*{ENCODED_INT: 96}*/:
                        this.REn = aVar.zi();
                        break;
                    case 104:
                        this.KTT = aVar.zl();
                        break;
                    default:
                        if (com.google.a.a.g.a(aVar, yT)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }
    }

    public static final class at extends com.google.a.a.e {
        public int RFo = 0;
        public long jii = 0;
        public int jlm = 0;

        public at() {
            this.cbo = -1;
        }

        @Override // com.google.a.a.e
        public final void a(com.google.a.a.b bVar) {
            if (this.jii != 0) {
                bVar.n(1, this.jii);
            }
            if (this.jlm != 0) {
                bVar.bB(2, this.jlm);
            }
            if (this.RFo != 0) {
                bVar.bB(3, this.RFo);
            }
            super.a(bVar);
        }

        @Override // com.google.a.a.e
        public final int Ig() {
            int Ig = super.Ig();
            if (this.jii != 0) {
                Ig += com.google.a.a.b.p(1, this.jii);
            }
            if (this.jlm != 0) {
                Ig += com.google.a.a.b.bC(2, this.jlm);
            }
            if (this.RFo != 0) {
                return Ig + com.google.a.a.b.bC(3, this.RFo);
            }
            return Ig;
        }

        @Override // com.google.a.a.e
        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int yT = aVar.yT();
                switch (yT) {
                    case 0:
                        break;
                    case 8:
                        this.jii = aVar.zl();
                        break;
                    case 16:
                        this.jlm = aVar.zi();
                        break;
                    case 24:
                        this.RFo = aVar.zi();
                        break;
                    default:
                        if (com.google.a.a.g.a(aVar, yT)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }
    }

    public static final class bb extends com.google.a.a.e {
        private static volatile bb[] RGd;
        public int Hrs = 0;
        public int KBb = 0;
        public byte[] RDF = com.google.a.a.g.cbu;
        public int RDz = 0;
        public int RGe = 0;
        public int RGf = 0;
        public aw RGg = null;
        public int RGh = 0;
        public String RGi = "";
        public ax[] RGj = ax.hjj();
        public int RGk = 0;
        public int[] RGl = com.google.a.a.g.bYn;
        public int RGm = 0;
        public int RGn = 0;
        public int RGo = 0;
        public int RGp = 0;
        public at RGq = null;
        public String RGr = "";
        public int RGs = 0;
        public u RGt = null;
        public int RGu = -1;
        public String RGv = "";
        public int RGw = 0;
        public int RGx = 0;
        public int RGy = 0;
        public int bDZ = 0;
        public String dLN = "";
        public int platform = 0;
        public int qrD = -1;
        public int status = 0;

        @Override // com.google.a.a.e
        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            int length;
            int length2;
            while (true) {
                int yT = aVar.yT();
                switch (yT) {
                    case 0:
                        break;
                    case 8:
                        this.KBb = aVar.zi();
                        break;
                    case 16:
                        this.RGe = aVar.zi();
                        break;
                    case 24:
                        this.status = aVar.zi();
                        break;
                    case 32:
                        this.bDZ = aVar.zi();
                        break;
                    case 40:
                        this.qrD = aVar.zi();
                        break;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
                        this.RGf = aVar.zi();
                        break;
                    case 58:
                        if (this.RGg == null) {
                            this.RGg = new aw();
                        }
                        aVar.a(this.RGg);
                        break;
                    case 64:
                        this.RGh = aVar.zi();
                        break;
                    case 74:
                        this.RGi = aVar.readString();
                        break;
                    case PlayerException.EXCEPTION_TYPE_ERROR_CREATE_JAVA_DATASOURCE /*{ENCODED_INT: 82}*/:
                        int b2 = com.google.a.a.g.b(aVar, 82);
                        if (this.RGj == null) {
                            length2 = 0;
                        } else {
                            length2 = this.RGj.length;
                        }
                        ax[] axVarArr = new ax[(b2 + length2)];
                        if (length2 != 0) {
                            System.arraycopy(this.RGj, 0, axVarArr, 0, length2);
                        }
                        while (length2 < axVarArr.length - 1) {
                            axVarArr[length2] = new ax();
                            aVar.a(axVarArr[length2]);
                            aVar.yT();
                            length2++;
                        }
                        axVarArr[length2] = new ax();
                        aVar.a(axVarArr[length2]);
                        this.RGj = axVarArr;
                        break;
                    case TPCodecParamers.TP_PROFILE_H264_EXTENDED /*{ENCODED_INT: 88}*/:
                        this.RGk = aVar.zi();
                        break;
                    case PlayerException.EXCEPTION_IN_SETAUDIOEFFECT /*{ENCODED_INT: 96}*/:
                        int b3 = com.google.a.a.g.b(aVar, 96);
                        if (this.RGl == null) {
                            length = 0;
                        } else {
                            length = this.RGl.length;
                        }
                        int[] iArr = new int[(b3 + length)];
                        if (length != 0) {
                            System.arraycopy(this.RGl, 0, iArr, 0, length);
                        }
                        while (length < iArr.length - 1) {
                            iArr[length] = aVar.zi();
                            aVar.yT();
                            length++;
                        }
                        iArr[length] = aVar.zi();
                        this.RGl = iArr;
                        break;
                    case 98:
                        int fH = aVar.fH(aVar.zi());
                        int position = aVar.getPosition();
                        int i2 = 0;
                        while (aVar.zk() > 0) {
                            aVar.zi();
                            i2++;
                        }
                        aVar.gZ(position);
                        int length3 = this.RGl == null ? 0 : this.RGl.length;
                        int[] iArr2 = new int[(i2 + length3)];
                        if (length3 != 0) {
                            System.arraycopy(this.RGl, 0, iArr2, 0, length3);
                        }
                        while (length3 < iArr2.length) {
                            iArr2[length3] = aVar.zi();
                            length3++;
                        }
                        this.RGl = iArr2;
                        aVar.fI(fH);
                        break;
                    case 104:
                        this.RGm = aVar.zi();
                        break;
                    case 112:
                        this.RGn = aVar.zi();
                        break;
                    case 120:
                        this.RGo = aVar.zi();
                        break;
                    case 128:
                        this.RGp = aVar.zi();
                        break;
                    case 138:
                        if (this.RGq == null) {
                            this.RGq = new at();
                        }
                        aVar.a(this.RGq);
                        break;
                    case 802:
                        this.dLN = aVar.readString();
                        break;
                    case 810:
                        this.RGr = aVar.readString();
                        break;
                    case 816:
                        this.RGs = aVar.zi();
                        break;
                    case 1602:
                        this.RDF = aVar.readBytes();
                        break;
                    case 1610:
                        if (this.RGt == null) {
                            this.RGt = new u();
                        }
                        aVar.a(this.RGt);
                        break;
                    case 1616:
                        this.RGu = aVar.zi();
                        break;
                    case 1626:
                        this.RGv = aVar.readString();
                        break;
                    case 1632:
                        this.platform = aVar.zi();
                        break;
                    case 1640:
                        this.RGw = aVar.zi();
                        break;
                    case 1648:
                        this.Hrs = aVar.zi();
                        break;
                    case 1656:
                        this.RGx = aVar.zi();
                        break;
                    case 1664:
                        this.RGy = aVar.zi();
                        break;
                    case 1920:
                        this.RDz = aVar.zi();
                        break;
                    default:
                        if (com.google.a.a.g.a(aVar, yT)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        public static bb[] hjl() {
            if (RGd == null) {
                synchronized (com.google.a.a.c.cbn) {
                    if (RGd == null) {
                        RGd = new bb[0];
                    }
                }
            }
            return RGd;
        }

        public bb() {
            this.cbo = -1;
        }

        @Override // com.google.a.a.e
        public final void a(com.google.a.a.b bVar) {
            if (this.KBb != 0) {
                bVar.bB(1, this.KBb);
            }
            if (this.RGe != 0) {
                bVar.bB(2, this.RGe);
            }
            if (this.status != 0) {
                bVar.bB(3, this.status);
            }
            if (this.bDZ != 0) {
                bVar.bB(4, this.bDZ);
            }
            if (this.qrD != -1) {
                bVar.bs(5, this.qrD);
            }
            if (this.RGf != 0) {
                bVar.bB(6, this.RGf);
            }
            if (this.RGg != null) {
                bVar.a(7, this.RGg);
            }
            if (this.RGh != 0) {
                bVar.bB(8, this.RGh);
            }
            if (!this.RGi.equals("")) {
                bVar.e(9, this.RGi);
            }
            if (this.RGj != null && this.RGj.length > 0) {
                for (int i2 = 0; i2 < this.RGj.length; i2++) {
                    ax axVar = this.RGj[i2];
                    if (axVar != null) {
                        bVar.a(10, axVar);
                    }
                }
            }
            if (this.RGk != 0) {
                bVar.bB(11, this.RGk);
            }
            if (this.RGl != null && this.RGl.length > 0) {
                for (int i3 = 0; i3 < this.RGl.length; i3++) {
                    bVar.bB(12, this.RGl[i3]);
                }
            }
            if (this.RGm != 0) {
                bVar.bB(13, this.RGm);
            }
            if (this.RGn != 0) {
                bVar.bB(14, this.RGn);
            }
            if (this.RGo != 0) {
                bVar.bB(15, this.RGo);
            }
            if (this.RGp != 0) {
                bVar.bB(16, this.RGp);
            }
            if (this.RGq != null) {
                bVar.a(17, this.RGq);
            }
            if (!this.dLN.equals("")) {
                bVar.e(100, this.dLN);
            }
            if (!this.RGr.equals("")) {
                bVar.e(101, this.RGr);
            }
            if (this.RGs != 0) {
                bVar.bB(102, this.RGs);
            }
            if (!Arrays.equals(this.RDF, com.google.a.a.g.cbu)) {
                bVar.b(200, this.RDF);
            }
            if (this.RGt != null) {
                bVar.a(201, this.RGt);
            }
            if (this.RGu != -1) {
                bVar.bs(202, this.RGu);
            }
            if (!this.RGv.equals("")) {
                bVar.e(203, this.RGv);
            }
            if (this.platform != 0) {
                bVar.bs(204, this.platform);
            }
            if (this.RGw != 0) {
                bVar.bB(205, this.RGw);
            }
            if (this.Hrs != 0) {
                bVar.bB(206, this.Hrs);
            }
            if (this.RGx != 0) {
                bVar.bB(207, this.RGx);
            }
            if (this.RGy != 0) {
                bVar.bB(208, this.RGy);
            }
            if (this.RDz != 0) {
                bVar.bB(240, this.RDz);
            }
            super.a(bVar);
        }

        @Override // com.google.a.a.e
        public final int Ig() {
            int Ig = super.Ig();
            if (this.KBb != 0) {
                Ig += com.google.a.a.b.bC(1, this.KBb);
            }
            if (this.RGe != 0) {
                Ig += com.google.a.a.b.bC(2, this.RGe);
            }
            if (this.status != 0) {
                Ig += com.google.a.a.b.bC(3, this.status);
            }
            if (this.bDZ != 0) {
                Ig += com.google.a.a.b.bC(4, this.bDZ);
            }
            if (this.qrD != -1) {
                Ig += com.google.a.a.b.bu(5, this.qrD);
            }
            if (this.RGf != 0) {
                Ig += com.google.a.a.b.bC(6, this.RGf);
            }
            if (this.RGg != null) {
                Ig += com.google.a.a.b.b(7, this.RGg);
            }
            if (this.RGh != 0) {
                Ig += com.google.a.a.b.bC(8, this.RGh);
            }
            if (!this.RGi.equals("")) {
                Ig += com.google.a.a.b.f(9, this.RGi);
            }
            if (this.RGj != null && this.RGj.length > 0) {
                int i2 = Ig;
                for (int i3 = 0; i3 < this.RGj.length; i3++) {
                    ax axVar = this.RGj[i3];
                    if (axVar != null) {
                        i2 += com.google.a.a.b.b(10, axVar);
                    }
                }
                Ig = i2;
            }
            if (this.RGk != 0) {
                Ig += com.google.a.a.b.bC(11, this.RGk);
            }
            if (this.RGl != null && this.RGl.length > 0) {
                int i4 = 0;
                for (int i5 = 0; i5 < this.RGl.length; i5++) {
                    i4 += com.google.a.a.b.fY(this.RGl[i5]);
                }
                Ig = Ig + i4 + (this.RGl.length * 1);
            }
            if (this.RGm != 0) {
                Ig += com.google.a.a.b.bC(13, this.RGm);
            }
            if (this.RGn != 0) {
                Ig += com.google.a.a.b.bC(14, this.RGn);
            }
            if (this.RGo != 0) {
                Ig += com.google.a.a.b.bC(15, this.RGo);
            }
            if (this.RGp != 0) {
                Ig += com.google.a.a.b.bC(16, this.RGp);
            }
            if (this.RGq != null) {
                Ig += com.google.a.a.b.b(17, this.RGq);
            }
            if (!this.dLN.equals("")) {
                Ig += com.google.a.a.b.f(100, this.dLN);
            }
            if (!this.RGr.equals("")) {
                Ig += com.google.a.a.b.f(101, this.RGr);
            }
            if (this.RGs != 0) {
                Ig += com.google.a.a.b.bC(102, this.RGs);
            }
            if (!Arrays.equals(this.RDF, com.google.a.a.g.cbu)) {
                Ig += com.google.a.a.b.c(200, this.RDF);
            }
            if (this.RGt != null) {
                Ig += com.google.a.a.b.b(201, this.RGt);
            }
            if (this.RGu != -1) {
                Ig += com.google.a.a.b.bu(202, this.RGu);
            }
            if (!this.RGv.equals("")) {
                Ig += com.google.a.a.b.f(203, this.RGv);
            }
            if (this.platform != 0) {
                Ig += com.google.a.a.b.bu(204, this.platform);
            }
            if (this.RGw != 0) {
                Ig += com.google.a.a.b.bC(205, this.RGw);
            }
            if (this.Hrs != 0) {
                Ig += com.google.a.a.b.bC(206, this.Hrs);
            }
            if (this.RGx != 0) {
                Ig += com.google.a.a.b.bC(207, this.RGx);
            }
            if (this.RGy != 0) {
                Ig += com.google.a.a.b.bC(208, this.RGy);
            }
            if (this.RDz != 0) {
                return Ig + com.google.a.a.b.bC(240, this.RDz);
            }
            return Ig;
        }
    }

    public static final class bc extends com.google.a.a.e {
        private static volatile bc[] RGz;
        public int KBb = 0;
        public long RGA = 0;
        public String RGB = "";
        public String RGC = "";
        public String headUrl = "";
        public String username = "";

        public static bc[] hjm() {
            if (RGz == null) {
                synchronized (com.google.a.a.c.cbn) {
                    if (RGz == null) {
                        RGz = new bc[0];
                    }
                }
            }
            return RGz;
        }

        public bc() {
            this.cbo = -1;
        }

        @Override // com.google.a.a.e
        public final void a(com.google.a.a.b bVar) {
            if (this.KBb != 0) {
                bVar.bB(1, this.KBb);
            }
            if (!this.username.equals("")) {
                bVar.e(2, this.username);
            }
            if (!this.headUrl.equals("")) {
                bVar.e(3, this.headUrl);
            }
            if (this.RGA != 0) {
                bVar.n(4, this.RGA);
            }
            if (!this.RGB.equals("")) {
                bVar.e(5, this.RGB);
            }
            if (!this.RGC.equals("")) {
                bVar.e(6, this.RGC);
            }
            super.a(bVar);
        }

        @Override // com.google.a.a.e
        public final int Ig() {
            int Ig = super.Ig();
            if (this.KBb != 0) {
                Ig += com.google.a.a.b.bC(1, this.KBb);
            }
            if (!this.username.equals("")) {
                Ig += com.google.a.a.b.f(2, this.username);
            }
            if (!this.headUrl.equals("")) {
                Ig += com.google.a.a.b.f(3, this.headUrl);
            }
            if (this.RGA != 0) {
                Ig += com.google.a.a.b.p(4, this.RGA);
            }
            if (!this.RGB.equals("")) {
                Ig += com.google.a.a.b.f(5, this.RGB);
            }
            if (!this.RGC.equals("")) {
                return Ig + com.google.a.a.b.f(6, this.RGC);
            }
            return Ig;
        }

        @Override // com.google.a.a.e
        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int yT = aVar.yT();
                switch (yT) {
                    case 0:
                        break;
                    case 8:
                        this.KBb = aVar.zi();
                        break;
                    case 18:
                        this.username = aVar.readString();
                        break;
                    case 26:
                        this.headUrl = aVar.readString();
                        break;
                    case 32:
                        this.RGA = aVar.zl();
                        break;
                    case 42:
                        this.RGB = aVar.readString();
                        break;
                    case 50:
                        this.RGC = aVar.readString();
                        break;
                    default:
                        if (com.google.a.a.g.a(aVar, yT)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }
    }

    public static final class p extends com.google.a.a.e {
        private static volatile p[] RDP;
        public int RDQ = 0;
        public int RDR = 0;
        public byte[] dQa = com.google.a.a.g.cbu;

        public static p[] hjc() {
            if (RDP == null) {
                synchronized (com.google.a.a.c.cbn) {
                    if (RDP == null) {
                        RDP = new p[0];
                    }
                }
            }
            return RDP;
        }

        public p() {
            this.cbo = -1;
        }

        @Override // com.google.a.a.e
        public final void a(com.google.a.a.b bVar) {
            if (this.RDQ != 0) {
                bVar.bs(1, this.RDQ);
            }
            if (!Arrays.equals(this.dQa, com.google.a.a.g.cbu)) {
                bVar.b(2, this.dQa);
            }
            if (this.RDR != 0) {
                bVar.bB(3, this.RDR);
            }
            super.a(bVar);
        }

        @Override // com.google.a.a.e
        public final int Ig() {
            int Ig = super.Ig();
            if (this.RDQ != 0) {
                Ig += com.google.a.a.b.bu(1, this.RDQ);
            }
            if (!Arrays.equals(this.dQa, com.google.a.a.g.cbu)) {
                Ig += com.google.a.a.b.c(2, this.dQa);
            }
            if (this.RDR != 0) {
                return Ig + com.google.a.a.b.bC(3, this.RDR);
            }
            return Ig;
        }

        @Override // com.google.a.a.e
        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int yT = aVar.yT();
                switch (yT) {
                    case 0:
                        break;
                    case 8:
                        this.RDQ = aVar.zi();
                        break;
                    case 18:
                        this.dQa = aVar.readBytes();
                        break;
                    case 24:
                        this.RDR = aVar.zi();
                        break;
                    default:
                        if (com.google.a.a.g.a(aVar, yT)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }
    }

    public static final class av extends com.google.a.a.e {
        public int RFr = 0;
        public int RFs = 0;

        public av() {
            this.cbo = -1;
        }

        @Override // com.google.a.a.e
        public final void a(com.google.a.a.b bVar) {
            if (this.RFr != 0) {
                bVar.bs(1, this.RFr);
            }
            if (this.RFs != 0) {
                bVar.bs(2, this.RFs);
            }
            super.a(bVar);
        }

        @Override // com.google.a.a.e
        public final int Ig() {
            int Ig = super.Ig();
            if (this.RFr != 0) {
                Ig += com.google.a.a.b.bu(1, this.RFr);
            }
            if (this.RFs != 0) {
                return Ig + com.google.a.a.b.bu(2, this.RFs);
            }
            return Ig;
        }

        @Override // com.google.a.a.e
        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int yT = aVar.yT();
                switch (yT) {
                    case 0:
                        break;
                    case 8:
                        this.RFr = aVar.zi();
                        break;
                    case 16:
                        this.RFs = aVar.zi();
                        break;
                    default:
                        if (com.google.a.a.g.a(aVar, yT)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }
    }

    public static final class bd extends com.google.a.a.e {
        public int RGD = 0;

        public bd() {
            this.cbo = -1;
        }

        @Override // com.google.a.a.e
        public final void a(com.google.a.a.b bVar) {
            if (this.RGD != 0) {
                bVar.bB(1, this.RGD);
            }
            super.a(bVar);
        }

        @Override // com.google.a.a.e
        public final int Ig() {
            int Ig = super.Ig();
            if (this.RGD != 0) {
                return Ig + com.google.a.a.b.bC(1, this.RGD);
            }
            return Ig;
        }

        @Override // com.google.a.a.e
        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int yT = aVar.yT();
                switch (yT) {
                    case 0:
                        break;
                    case 8:
                        this.RGD = aVar.zi();
                        break;
                    default:
                        if (com.google.a.a.g.a(aVar, yT)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }
    }

    public static final class az extends com.google.a.a.e {
        public byte[] RFH = com.google.a.a.g.cbu;
        public long RFI = 0;
        public byte[] RFJ = com.google.a.a.g.cbu;
        public byte[] RFK = com.google.a.a.g.cbu;
        public byte[] RFL = com.google.a.a.g.cbu;
        public bd RFM = null;
        public byte[] RFN = com.google.a.a.g.cbu;
        public av RFO = null;
        public String RFP = "";
        public String RFQ = "";
        public long RFR = 0;
        public byte[] RFS = com.google.a.a.g.cbu;
        public byte[] RFT = com.google.a.a.g.cbu;
        public byte[] RFU = com.google.a.a.g.cbu;
        public byte[] RFV = com.google.a.a.g.cbu;
        public int RFW = 0;
        public byte[] RFX = com.google.a.a.g.cbu;
        public byte[] RFY = com.google.a.a.g.cbu;
        public int RFZ = 0;
        public p[] RGa = p.hjc();
        public byte[] ckv = com.google.a.a.g.cbu;
        public int dLt = 0;
        public String name = "";

        @Override // com.google.a.a.e
        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            int length;
            while (true) {
                int yT = aVar.yT();
                switch (yT) {
                    case 0:
                        break;
                    case 10:
                        this.name = aVar.readString();
                        break;
                    case 18:
                        this.RFH = aVar.readBytes();
                        break;
                    case 24:
                        this.dLt = aVar.zi();
                        break;
                    case 32:
                        this.RFI = aVar.zl();
                        break;
                    case 42:
                        this.RFJ = aVar.readBytes();
                        break;
                    case 50:
                        this.RFK = aVar.readBytes();
                        break;
                    case 58:
                        this.RFL = aVar.readBytes();
                        break;
                    case 66:
                        if (this.RFM == null) {
                            this.RFM = new bd();
                        }
                        aVar.a(this.RFM);
                        break;
                    case 74:
                        this.RFN = aVar.readBytes();
                        break;
                    case PlayerException.EXCEPTION_TYPE_ERROR_CREATE_JAVA_DATASOURCE /*{ENCODED_INT: 82}*/:
                        if (this.RFO == null) {
                            this.RFO = new av();
                        }
                        aVar.a(this.RFO);
                        break;
                    case 802:
                        this.RFP = aVar.readString();
                        break;
                    case 810:
                        this.RFQ = aVar.readString();
                        break;
                    case 1600:
                        this.RFR = aVar.zl();
                        break;
                    case 1610:
                        this.RFS = aVar.readBytes();
                        break;
                    case 1618:
                        this.RFT = aVar.readBytes();
                        break;
                    case 1626:
                        this.RFU = aVar.readBytes();
                        break;
                    case 1634:
                        this.RFV = aVar.readBytes();
                        break;
                    case 1760:
                        this.RFW = aVar.zi();
                        break;
                    case 1770:
                        this.RFX = aVar.readBytes();
                        break;
                    case 1778:
                        this.RFY = aVar.readBytes();
                        break;
                    case 1786:
                        this.ckv = aVar.readBytes();
                        break;
                    case 1792:
                        this.RFZ = aVar.zi();
                        break;
                    case 1802:
                        int b2 = com.google.a.a.g.b(aVar, 1802);
                        if (this.RGa == null) {
                            length = 0;
                        } else {
                            length = this.RGa.length;
                        }
                        p[] pVarArr = new p[(b2 + length)];
                        if (length != 0) {
                            System.arraycopy(this.RGa, 0, pVarArr, 0, length);
                        }
                        while (length < pVarArr.length - 1) {
                            pVarArr[length] = new p();
                            aVar.a(pVarArr[length]);
                            aVar.yT();
                            length++;
                        }
                        pVarArr[length] = new p();
                        aVar.a(pVarArr[length]);
                        this.RGa = pVarArr;
                        break;
                    default:
                        if (com.google.a.a.g.a(aVar, yT)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        public az() {
            this.cbo = -1;
        }

        @Override // com.google.a.a.e
        public final void a(com.google.a.a.b bVar) {
            if (!this.name.equals("")) {
                bVar.e(1, this.name);
            }
            if (!Arrays.equals(this.RFH, com.google.a.a.g.cbu)) {
                bVar.b(2, this.RFH);
            }
            if (this.dLt != 0) {
                bVar.bs(3, this.dLt);
            }
            if (this.RFI != 0) {
                bVar.n(4, this.RFI);
            }
            if (!Arrays.equals(this.RFJ, com.google.a.a.g.cbu)) {
                bVar.b(5, this.RFJ);
            }
            if (!Arrays.equals(this.RFK, com.google.a.a.g.cbu)) {
                bVar.b(6, this.RFK);
            }
            if (!Arrays.equals(this.RFL, com.google.a.a.g.cbu)) {
                bVar.b(7, this.RFL);
            }
            if (this.RFM != null) {
                bVar.a(8, this.RFM);
            }
            if (!Arrays.equals(this.RFN, com.google.a.a.g.cbu)) {
                bVar.b(9, this.RFN);
            }
            if (this.RFO != null) {
                bVar.a(10, this.RFO);
            }
            if (!this.RFP.equals("")) {
                bVar.e(100, this.RFP);
            }
            if (!this.RFQ.equals("")) {
                bVar.e(101, this.RFQ);
            }
            if (this.RFR != 0) {
                bVar.n(200, this.RFR);
            }
            if (!Arrays.equals(this.RFS, com.google.a.a.g.cbu)) {
                bVar.b(201, this.RFS);
            }
            if (!Arrays.equals(this.RFT, com.google.a.a.g.cbu)) {
                bVar.b(202, this.RFT);
            }
            if (!Arrays.equals(this.RFU, com.google.a.a.g.cbu)) {
                bVar.b(203, this.RFU);
            }
            if (!Arrays.equals(this.RFV, com.google.a.a.g.cbu)) {
                bVar.b(204, this.RFV);
            }
            if (this.RFW != 0) {
                bVar.bs(TbsListener.ErrorCode.COPY_INSTALL_SUCCESS, this.RFW);
            }
            if (!Arrays.equals(this.RFX, com.google.a.a.g.cbu)) {
                bVar.b(TbsListener.ErrorCode.INCRUPDATE_INSTALL_SUCCESS, this.RFX);
            }
            if (!Arrays.equals(this.RFY, com.google.a.a.g.cbu)) {
                bVar.b(TbsListener.ErrorCode.UNLZMA_FAIURE, this.RFY);
            }
            if (!Arrays.equals(this.ckv, com.google.a.a.g.cbu)) {
                bVar.b(TbsListener.ErrorCode.EXCEED_LZMA_RETRY_NUM, this.ckv);
            }
            if (this.RFZ != 0) {
                bVar.bB(TbsListener.ErrorCode.EXCEED_INCR_UPDATE, this.RFZ);
            }
            if (this.RGa != null && this.RGa.length > 0) {
                for (int i2 = 0; i2 < this.RGa.length; i2++) {
                    p pVar = this.RGa[i2];
                    if (pVar != null) {
                        bVar.a(TbsListener.ErrorCode.CREATE_TEMP_CONF_ERROR, pVar);
                    }
                }
            }
            super.a(bVar);
        }

        @Override // com.google.a.a.e
        public final int Ig() {
            int Ig = super.Ig();
            if (!this.name.equals("")) {
                Ig += com.google.a.a.b.f(1, this.name);
            }
            if (!Arrays.equals(this.RFH, com.google.a.a.g.cbu)) {
                Ig += com.google.a.a.b.c(2, this.RFH);
            }
            if (this.dLt != 0) {
                Ig += com.google.a.a.b.bu(3, this.dLt);
            }
            if (this.RFI != 0) {
                Ig += com.google.a.a.b.p(4, this.RFI);
            }
            if (!Arrays.equals(this.RFJ, com.google.a.a.g.cbu)) {
                Ig += com.google.a.a.b.c(5, this.RFJ);
            }
            if (!Arrays.equals(this.RFK, com.google.a.a.g.cbu)) {
                Ig += com.google.a.a.b.c(6, this.RFK);
            }
            if (!Arrays.equals(this.RFL, com.google.a.a.g.cbu)) {
                Ig += com.google.a.a.b.c(7, this.RFL);
            }
            if (this.RFM != null) {
                Ig += com.google.a.a.b.b(8, this.RFM);
            }
            if (!Arrays.equals(this.RFN, com.google.a.a.g.cbu)) {
                Ig += com.google.a.a.b.c(9, this.RFN);
            }
            if (this.RFO != null) {
                Ig += com.google.a.a.b.b(10, this.RFO);
            }
            if (!this.RFP.equals("")) {
                Ig += com.google.a.a.b.f(100, this.RFP);
            }
            if (!this.RFQ.equals("")) {
                Ig += com.google.a.a.b.f(101, this.RFQ);
            }
            if (this.RFR != 0) {
                Ig += com.google.a.a.b.p(200, this.RFR);
            }
            if (!Arrays.equals(this.RFS, com.google.a.a.g.cbu)) {
                Ig += com.google.a.a.b.c(201, this.RFS);
            }
            if (!Arrays.equals(this.RFT, com.google.a.a.g.cbu)) {
                Ig += com.google.a.a.b.c(202, this.RFT);
            }
            if (!Arrays.equals(this.RFU, com.google.a.a.g.cbu)) {
                Ig += com.google.a.a.b.c(203, this.RFU);
            }
            if (!Arrays.equals(this.RFV, com.google.a.a.g.cbu)) {
                Ig += com.google.a.a.b.c(204, this.RFV);
            }
            if (this.RFW != 0) {
                Ig += com.google.a.a.b.bu(TbsListener.ErrorCode.COPY_INSTALL_SUCCESS, this.RFW);
            }
            if (!Arrays.equals(this.RFX, com.google.a.a.g.cbu)) {
                Ig += com.google.a.a.b.c(TbsListener.ErrorCode.INCRUPDATE_INSTALL_SUCCESS, this.RFX);
            }
            if (!Arrays.equals(this.RFY, com.google.a.a.g.cbu)) {
                Ig += com.google.a.a.b.c(TbsListener.ErrorCode.UNLZMA_FAIURE, this.RFY);
            }
            if (!Arrays.equals(this.ckv, com.google.a.a.g.cbu)) {
                Ig += com.google.a.a.b.c(TbsListener.ErrorCode.EXCEED_LZMA_RETRY_NUM, this.ckv);
            }
            if (this.RFZ != 0) {
                Ig += com.google.a.a.b.bC(TbsListener.ErrorCode.EXCEED_INCR_UPDATE, this.RFZ);
            }
            if (this.RGa == null || this.RGa.length <= 0) {
                return Ig;
            }
            int i2 = Ig;
            for (int i3 = 0; i3 < this.RGa.length; i3++) {
                p pVar = this.RGa[i3];
                if (pVar != null) {
                    i2 += com.google.a.a.b.b((int) TbsListener.ErrorCode.CREATE_TEMP_CONF_ERROR, pVar);
                }
            }
            return i2;
        }
    }

    public static final class ax extends com.google.a.a.e {
        private static volatile ax[] RFt;
        public int RFu = 0;
        public int RFv = 0;
        public byte[] RFw = com.google.a.a.g.cbu;

        public static ax[] hjj() {
            if (RFt == null) {
                synchronized (com.google.a.a.c.cbn) {
                    if (RFt == null) {
                        RFt = new ax[0];
                    }
                }
            }
            return RFt;
        }

        public ax() {
            this.cbo = -1;
        }

        @Override // com.google.a.a.e
        public final void a(com.google.a.a.b bVar) {
            if (this.RFu != 0) {
                bVar.bs(1, this.RFu);
            }
            if (this.RFv != 0) {
                bVar.bs(2, this.RFv);
            }
            if (!Arrays.equals(this.RFw, com.google.a.a.g.cbu)) {
                bVar.b(3, this.RFw);
            }
            super.a(bVar);
        }

        @Override // com.google.a.a.e
        public final int Ig() {
            int Ig = super.Ig();
            if (this.RFu != 0) {
                Ig += com.google.a.a.b.bu(1, this.RFu);
            }
            if (this.RFv != 0) {
                Ig += com.google.a.a.b.bu(2, this.RFv);
            }
            if (!Arrays.equals(this.RFw, com.google.a.a.g.cbu)) {
                return Ig + com.google.a.a.b.c(3, this.RFw);
            }
            return Ig;
        }

        @Override // com.google.a.a.e
        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int yT = aVar.yT();
                switch (yT) {
                    case 0:
                        break;
                    case 8:
                        this.RFu = aVar.zi();
                        break;
                    case 16:
                        this.RFv = aVar.zi();
                        break;
                    case 26:
                        this.RFw = aVar.readBytes();
                        break;
                    default:
                        if (com.google.a.a.g.a(aVar, yT)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }
    }

    public static final class q extends com.google.a.a.e {
        private static volatile q[] RDS;
        public int RDT = 0;
        public String RDU = "";
        public int port = 0;

        public static q[] hjd() {
            if (RDS == null) {
                synchronized (com.google.a.a.c.cbn) {
                    if (RDS == null) {
                        RDS = new q[0];
                    }
                }
            }
            return RDS;
        }

        public q() {
            this.cbo = -1;
        }

        @Override // com.google.a.a.e
        public final void a(com.google.a.a.b bVar) {
            if (this.RDT != 0) {
                bVar.bB(1, this.RDT);
            }
            if (this.port != 0) {
                bVar.bs(2, this.port);
            }
            if (!this.RDU.equals("")) {
                bVar.e(3, this.RDU);
            }
            super.a(bVar);
        }

        @Override // com.google.a.a.e
        public final int Ig() {
            int Ig = super.Ig();
            if (this.RDT != 0) {
                Ig += com.google.a.a.b.bC(1, this.RDT);
            }
            if (this.port != 0) {
                Ig += com.google.a.a.b.bu(2, this.port);
            }
            if (!this.RDU.equals("")) {
                return Ig + com.google.a.a.b.f(3, this.RDU);
            }
            return Ig;
        }

        @Override // com.google.a.a.e
        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int yT = aVar.yT();
                switch (yT) {
                    case 0:
                        break;
                    case 8:
                        this.RDT = aVar.zi();
                        break;
                    case 16:
                        this.port = aVar.zi();
                        break;
                    case 26:
                        this.RDU = aVar.readString();
                        break;
                    default:
                        if (com.google.a.a.g.a(aVar, yT)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }
    }

    public static final class aw extends com.google.a.a.e {
        public int sceneType = 0;

        public aw() {
            this.cbo = -1;
        }

        @Override // com.google.a.a.e
        public final void a(com.google.a.a.b bVar) {
            if (this.sceneType != 0) {
                bVar.bs(1, this.sceneType);
            }
            super.a(bVar);
        }

        @Override // com.google.a.a.e
        public final int Ig() {
            int Ig = super.Ig();
            if (this.sceneType != 0) {
                return Ig + com.google.a.a.b.bu(1, this.sceneType);
            }
            return Ig;
        }

        @Override // com.google.a.a.e
        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int yT = aVar.yT();
                switch (yT) {
                    case 0:
                        break;
                    case 8:
                        this.sceneType = aVar.zi();
                        break;
                    default:
                        if (com.google.a.a.g.a(aVar, yT)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }
    }

    public static final class bh extends com.google.a.a.e {
        public int GXO = 0;
        public long GXP = 0;
        public int RDt = 0;
        public bb[] REK = bb.hjl();
        public int RGK = 0;
        public String RGL = "";
        public String[] RGM = com.google.a.a.g.EMPTY_STRING_ARRAY;
        public long RGN = 0;
        public String RGc = "";
        public String groupId = "";

        @Override // com.google.a.a.e
        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            int length;
            while (true) {
                int yT = aVar.yT();
                switch (yT) {
                    case 0:
                        break;
                    case 10:
                        this.groupId = aVar.readString();
                        break;
                    case 16:
                        this.GXO = aVar.zi();
                        break;
                    case 24:
                        this.GXP = aVar.zl();
                        break;
                    case 32:
                        this.RDt = aVar.zi();
                        break;
                    case 40:
                        this.RGK = aVar.zi();
                        break;
                    case 50:
                        this.RGc = aVar.readString();
                        break;
                    case 58:
                        int b2 = com.google.a.a.g.b(aVar, 58);
                        if (this.REK == null) {
                            length = 0;
                        } else {
                            length = this.REK.length;
                        }
                        bb[] bbVarArr = new bb[(b2 + length)];
                        if (length != 0) {
                            System.arraycopy(this.REK, 0, bbVarArr, 0, length);
                        }
                        while (length < bbVarArr.length - 1) {
                            bbVarArr[length] = new bb();
                            aVar.a(bbVarArr[length]);
                            aVar.yT();
                            length++;
                        }
                        bbVarArr[length] = new bb();
                        aVar.a(bbVarArr[length]);
                        this.REK = bbVarArr;
                        break;
                    case 66:
                        this.RGL = aVar.readString();
                        break;
                    case 74:
                        int b3 = com.google.a.a.g.b(aVar, 74);
                        int length2 = this.RGM == null ? 0 : this.RGM.length;
                        String[] strArr = new String[(b3 + length2)];
                        if (length2 != 0) {
                            System.arraycopy(this.RGM, 0, strArr, 0, length2);
                        }
                        while (length2 < strArr.length - 1) {
                            strArr[length2] = aVar.readString();
                            aVar.yT();
                            length2++;
                        }
                        strArr[length2] = aVar.readString();
                        this.RGM = strArr;
                        break;
                    case PlayerException.EXCEPTION_TYPE_CONNECT_FAIL /*{ENCODED_INT: 80}*/:
                        this.RGN = aVar.zl();
                        break;
                    default:
                        if (com.google.a.a.g.a(aVar, yT)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        public bh() {
            this.cbo = -1;
        }

        @Override // com.google.a.a.e
        public final void a(com.google.a.a.b bVar) {
            if (!this.groupId.equals("")) {
                bVar.e(1, this.groupId);
            }
            if (this.GXO != 0) {
                bVar.bs(2, this.GXO);
            }
            if (this.GXP != 0) {
                bVar.q(3, this.GXP);
            }
            if (this.RDt != 0) {
                bVar.bB(4, this.RDt);
            }
            if (this.RGK != 0) {
                bVar.bs(5, this.RGK);
            }
            if (!this.RGc.equals("")) {
                bVar.e(6, this.RGc);
            }
            if (this.REK != null && this.REK.length > 0) {
                for (int i2 = 0; i2 < this.REK.length; i2++) {
                    bb bbVar = this.REK[i2];
                    if (bbVar != null) {
                        bVar.a(7, bbVar);
                    }
                }
            }
            if (!this.RGL.equals("")) {
                bVar.e(8, this.RGL);
            }
            if (this.RGM != null && this.RGM.length > 0) {
                for (int i3 = 0; i3 < this.RGM.length; i3++) {
                    String str = this.RGM[i3];
                    if (str != null) {
                        bVar.e(9, str);
                    }
                }
            }
            if (this.RGN != 0) {
                bVar.n(10, this.RGN);
            }
            super.a(bVar);
        }

        @Override // com.google.a.a.e
        public final int Ig() {
            int Ig = super.Ig();
            if (!this.groupId.equals("")) {
                Ig += com.google.a.a.b.f(1, this.groupId);
            }
            if (this.GXO != 0) {
                Ig += com.google.a.a.b.bu(2, this.GXO);
            }
            if (this.GXP != 0) {
                Ig += com.google.a.a.b.r(3, this.GXP);
            }
            if (this.RDt != 0) {
                Ig += com.google.a.a.b.bC(4, this.RDt);
            }
            if (this.RGK != 0) {
                Ig += com.google.a.a.b.bu(5, this.RGK);
            }
            if (!this.RGc.equals("")) {
                Ig += com.google.a.a.b.f(6, this.RGc);
            }
            if (this.REK != null && this.REK.length > 0) {
                int i2 = Ig;
                for (int i3 = 0; i3 < this.REK.length; i3++) {
                    bb bbVar = this.REK[i3];
                    if (bbVar != null) {
                        i2 += com.google.a.a.b.b(7, bbVar);
                    }
                }
                Ig = i2;
            }
            if (!this.RGL.equals("")) {
                Ig += com.google.a.a.b.f(8, this.RGL);
            }
            if (this.RGM != null && this.RGM.length > 0) {
                int i4 = 0;
                int i5 = 0;
                for (int i6 = 0; i6 < this.RGM.length; i6++) {
                    String str = this.RGM[i6];
                    if (str != null) {
                        i5++;
                        i4 += com.google.a.a.b.cb(str);
                    }
                }
                Ig = Ig + i4 + (i5 * 1);
            }
            if (this.RGN != 0) {
                return Ig + com.google.a.a.b.p(10, this.RGN);
            }
            return Ig;
        }
    }

    public static final class r extends com.google.a.a.e {
        public int GXO = 0;
        public long GXP = 0;
        public int RDV = 0;
        public bc[] RDW = bc.hjm();
        public bb[] RDX = bb.hjl();
        public ay RDY = null;
        public int RDZ = 0;
        public az RDq = null;
        public int RDt = 0;
        public be RDv = null;
        public int REa = 0;
        public int REb = 0;
        public byte[] REc = com.google.a.a.g.cbu;
        public byte[] REd = com.google.a.a.g.cbu;
        public bb[] REe = bb.hjl();
        public int audioStreamType = 0;
        public String groupId = "";
        public int jlm = 0;
        public long msgId = 0;

        @Override // com.google.a.a.e
        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            int length;
            int length2;
            int length3;
            while (true) {
                int yT = aVar.yT();
                switch (yT) {
                    case 0:
                        break;
                    case 8:
                        this.RDV = aVar.zi();
                        break;
                    case 18:
                        this.groupId = aVar.readString();
                        break;
                    case 24:
                        this.GXO = aVar.zi();
                        break;
                    case 32:
                        this.GXP = aVar.zl();
                        break;
                    case 40:
                        this.RDt = aVar.zi();
                        break;
                    case 50:
                        if (this.RDq == null) {
                            this.RDq = new az();
                        }
                        aVar.a(this.RDq);
                        break;
                    case 58:
                        int b2 = com.google.a.a.g.b(aVar, 58);
                        if (this.RDW == null) {
                            length3 = 0;
                        } else {
                            length3 = this.RDW.length;
                        }
                        bc[] bcVarArr = new bc[(b2 + length3)];
                        if (length3 != 0) {
                            System.arraycopy(this.RDW, 0, bcVarArr, 0, length3);
                        }
                        while (length3 < bcVarArr.length - 1) {
                            bcVarArr[length3] = new bc();
                            aVar.a(bcVarArr[length3]);
                            aVar.yT();
                            length3++;
                        }
                        bcVarArr[length3] = new bc();
                        aVar.a(bcVarArr[length3]);
                        this.RDW = bcVarArr;
                        break;
                    case 66:
                        int b3 = com.google.a.a.g.b(aVar, 66);
                        if (this.RDX == null) {
                            length2 = 0;
                        } else {
                            length2 = this.RDX.length;
                        }
                        bb[] bbVarArr = new bb[(b3 + length2)];
                        if (length2 != 0) {
                            System.arraycopy(this.RDX, 0, bbVarArr, 0, length2);
                        }
                        while (length2 < bbVarArr.length - 1) {
                            bbVarArr[length2] = new bb();
                            aVar.a(bbVarArr[length2]);
                            aVar.yT();
                            length2++;
                        }
                        bbVarArr[length2] = new bb();
                        aVar.a(bbVarArr[length2]);
                        this.RDX = bbVarArr;
                        break;
                    case 74:
                        if (this.RDY == null) {
                            this.RDY = new ay();
                        }
                        aVar.a(this.RDY);
                        break;
                    case PlayerException.EXCEPTION_TYPE_ERROR_CREATE_JAVA_DATASOURCE /*{ENCODED_INT: 82}*/:
                        if (this.RDv == null) {
                            this.RDv = new be();
                        }
                        aVar.a(this.RDv);
                        break;
                    case TPCodecParamers.TP_PROFILE_H264_EXTENDED /*{ENCODED_INT: 88}*/:
                        this.RDZ = aVar.zi();
                        break;
                    case PlayerException.EXCEPTION_IN_SETAUDIOEFFECT /*{ENCODED_INT: 96}*/:
                        this.REa = aVar.zi();
                        break;
                    case 104:
                        this.jlm = aVar.zi();
                        break;
                    case 808:
                        this.msgId = aVar.zl();
                        break;
                    case 816:
                        this.REb = aVar.zi();
                        break;
                    case 826:
                        this.REc = aVar.readBytes();
                        break;
                    case 1602:
                        this.REd = aVar.readBytes();
                        break;
                    case 1610:
                        int b4 = com.google.a.a.g.b(aVar, 1610);
                        if (this.REe == null) {
                            length = 0;
                        } else {
                            length = this.REe.length;
                        }
                        bb[] bbVarArr2 = new bb[(b4 + length)];
                        if (length != 0) {
                            System.arraycopy(this.REe, 0, bbVarArr2, 0, length);
                        }
                        while (length < bbVarArr2.length - 1) {
                            bbVarArr2[length] = new bb();
                            aVar.a(bbVarArr2[length]);
                            aVar.yT();
                            length++;
                        }
                        bbVarArr2[length] = new bb();
                        aVar.a(bbVarArr2[length]);
                        this.REe = bbVarArr2;
                        break;
                    case 1616:
                        this.audioStreamType = aVar.zi();
                        break;
                    default:
                        if (com.google.a.a.g.a(aVar, yT)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        public r() {
            this.cbo = -1;
        }

        @Override // com.google.a.a.e
        public final void a(com.google.a.a.b bVar) {
            if (this.RDV != 0) {
                bVar.bs(1, this.RDV);
            }
            if (!this.groupId.equals("")) {
                bVar.e(2, this.groupId);
            }
            if (this.GXO != 0) {
                bVar.bs(3, this.GXO);
            }
            if (this.GXP != 0) {
                bVar.q(4, this.GXP);
            }
            if (this.RDt != 0) {
                bVar.bB(5, this.RDt);
            }
            if (this.RDq != null) {
                bVar.a(6, this.RDq);
            }
            if (this.RDW != null && this.RDW.length > 0) {
                for (int i2 = 0; i2 < this.RDW.length; i2++) {
                    bc bcVar = this.RDW[i2];
                    if (bcVar != null) {
                        bVar.a(7, bcVar);
                    }
                }
            }
            if (this.RDX != null && this.RDX.length > 0) {
                for (int i3 = 0; i3 < this.RDX.length; i3++) {
                    bb bbVar = this.RDX[i3];
                    if (bbVar != null) {
                        bVar.a(8, bbVar);
                    }
                }
            }
            if (this.RDY != null) {
                bVar.a(9, this.RDY);
            }
            if (this.RDv != null) {
                bVar.a(10, this.RDv);
            }
            if (this.RDZ != 0) {
                bVar.bB(11, this.RDZ);
            }
            if (this.REa != 0) {
                bVar.bB(12, this.REa);
            }
            if (this.jlm != 0) {
                bVar.bB(13, this.jlm);
            }
            if (this.msgId != 0) {
                bVar.n(101, this.msgId);
            }
            if (this.REb != 0) {
                bVar.bB(102, this.REb);
            }
            if (!Arrays.equals(this.REc, com.google.a.a.g.cbu)) {
                bVar.b(103, this.REc);
            }
            if (!Arrays.equals(this.REd, com.google.a.a.g.cbu)) {
                bVar.b(200, this.REd);
            }
            if (this.REe != null && this.REe.length > 0) {
                for (int i4 = 0; i4 < this.REe.length; i4++) {
                    bb bbVar2 = this.REe[i4];
                    if (bbVar2 != null) {
                        bVar.a(201, bbVar2);
                    }
                }
            }
            if (this.audioStreamType != 0) {
                bVar.bs(202, this.audioStreamType);
            }
            super.a(bVar);
        }

        @Override // com.google.a.a.e
        public final int Ig() {
            int Ig = super.Ig();
            if (this.RDV != 0) {
                Ig += com.google.a.a.b.bu(1, this.RDV);
            }
            if (!this.groupId.equals("")) {
                Ig += com.google.a.a.b.f(2, this.groupId);
            }
            if (this.GXO != 0) {
                Ig += com.google.a.a.b.bu(3, this.GXO);
            }
            if (this.GXP != 0) {
                Ig += com.google.a.a.b.r(4, this.GXP);
            }
            if (this.RDt != 0) {
                Ig += com.google.a.a.b.bC(5, this.RDt);
            }
            if (this.RDq != null) {
                Ig += com.google.a.a.b.b(6, this.RDq);
            }
            if (this.RDW != null && this.RDW.length > 0) {
                int i2 = Ig;
                for (int i3 = 0; i3 < this.RDW.length; i3++) {
                    bc bcVar = this.RDW[i3];
                    if (bcVar != null) {
                        i2 += com.google.a.a.b.b(7, bcVar);
                    }
                }
                Ig = i2;
            }
            if (this.RDX != null && this.RDX.length > 0) {
                int i4 = Ig;
                for (int i5 = 0; i5 < this.RDX.length; i5++) {
                    bb bbVar = this.RDX[i5];
                    if (bbVar != null) {
                        i4 += com.google.a.a.b.b(8, bbVar);
                    }
                }
                Ig = i4;
            }
            if (this.RDY != null) {
                Ig += com.google.a.a.b.b(9, this.RDY);
            }
            if (this.RDv != null) {
                Ig += com.google.a.a.b.b(10, this.RDv);
            }
            if (this.RDZ != 0) {
                Ig += com.google.a.a.b.bC(11, this.RDZ);
            }
            if (this.REa != 0) {
                Ig += com.google.a.a.b.bC(12, this.REa);
            }
            if (this.jlm != 0) {
                Ig += com.google.a.a.b.bC(13, this.jlm);
            }
            if (this.msgId != 0) {
                Ig += com.google.a.a.b.p(101, this.msgId);
            }
            if (this.REb != 0) {
                Ig += com.google.a.a.b.bC(102, this.REb);
            }
            if (!Arrays.equals(this.REc, com.google.a.a.g.cbu)) {
                Ig += com.google.a.a.b.c(103, this.REc);
            }
            if (!Arrays.equals(this.REd, com.google.a.a.g.cbu)) {
                Ig += com.google.a.a.b.c(200, this.REd);
            }
            if (this.REe != null && this.REe.length > 0) {
                for (int i6 = 0; i6 < this.REe.length; i6++) {
                    bb bbVar2 = this.REe[i6];
                    if (bbVar2 != null) {
                        Ig += com.google.a.a.b.b(201, bbVar2);
                    }
                }
            }
            if (this.audioStreamType != 0) {
                return Ig + com.google.a.a.b.bu(202, this.audioStreamType);
            }
            return Ig;
        }
    }

    public static final class y extends com.google.a.a.e {
        private static volatile y[] REI;
        public String REJ = "";
        public String sXO = "";

        public static y[] hje() {
            if (REI == null) {
                synchronized (com.google.a.a.c.cbn) {
                    if (REI == null) {
                        REI = new y[0];
                    }
                }
            }
            return REI;
        }

        public y() {
            this.cbo = -1;
        }

        @Override // com.google.a.a.e
        public final void a(com.google.a.a.b bVar) {
            if (!this.sXO.equals("")) {
                bVar.e(1, this.sXO);
            }
            if (!this.REJ.equals("")) {
                bVar.e(2, this.REJ);
            }
            super.a(bVar);
        }

        @Override // com.google.a.a.e
        public final int Ig() {
            int Ig = super.Ig();
            if (!this.sXO.equals("")) {
                Ig += com.google.a.a.b.f(1, this.sXO);
            }
            if (!this.REJ.equals("")) {
                return Ig + com.google.a.a.b.f(2, this.REJ);
            }
            return Ig;
        }

        @Override // com.google.a.a.e
        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int yT = aVar.yT();
                switch (yT) {
                    case 0:
                        break;
                    case 10:
                        this.sXO = aVar.readString();
                        break;
                    case 18:
                        this.REJ = aVar.readString();
                        break;
                    default:
                        if (com.google.a.a.g.a(aVar, yT)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }
    }

    public static final class c extends com.google.a.a.e {
        public y[] RDp = y.hje();

        @Override // com.google.a.a.e
        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            int length;
            while (true) {
                int yT = aVar.yT();
                switch (yT) {
                    case 0:
                        break;
                    case 10:
                        int b2 = com.google.a.a.g.b(aVar, 10);
                        if (this.RDp == null) {
                            length = 0;
                        } else {
                            length = this.RDp.length;
                        }
                        y[] yVarArr = new y[(b2 + length)];
                        if (length != 0) {
                            System.arraycopy(this.RDp, 0, yVarArr, 0, length);
                        }
                        while (length < yVarArr.length - 1) {
                            yVarArr[length] = new y();
                            aVar.a(yVarArr[length]);
                            aVar.yT();
                            length++;
                        }
                        yVarArr[length] = new y();
                        aVar.a(yVarArr[length]);
                        this.RDp = yVarArr;
                        break;
                    default:
                        if (com.google.a.a.g.a(aVar, yT)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        public c() {
            this.cbo = -1;
        }

        @Override // com.google.a.a.e
        public final void a(com.google.a.a.b bVar) {
            if (this.RDp != null && this.RDp.length > 0) {
                for (int i2 = 0; i2 < this.RDp.length; i2++) {
                    y yVar = this.RDp[i2];
                    if (yVar != null) {
                        bVar.a(1, yVar);
                    }
                }
            }
            super.a(bVar);
        }

        @Override // com.google.a.a.e
        public final int Ig() {
            int Ig = super.Ig();
            if (this.RDp != null && this.RDp.length > 0) {
                for (int i2 = 0; i2 < this.RDp.length; i2++) {
                    y yVar = this.RDp[i2];
                    if (yVar != null) {
                        Ig += com.google.a.a.b.b(1, yVar);
                    }
                }
            }
            return Ig;
        }
    }

    public static final class k extends com.google.a.a.e {
        public int action = 0;
        public String groupId = "";
        public int roomId = 0;
        public long timestamp = 0;
        public long ypH = 0;

        public k() {
            this.cbo = -1;
        }

        @Override // com.google.a.a.e
        public final void a(com.google.a.a.b bVar) {
            bVar.bB(1, this.action);
            bVar.bs(2, this.roomId);
            bVar.q(3, this.ypH);
            if (!this.groupId.equals("")) {
                bVar.e(4, this.groupId);
            }
            if (this.timestamp != 0) {
                bVar.n(5, this.timestamp);
            }
            super.a(bVar);
        }

        @Override // com.google.a.a.e
        public final int Ig() {
            int Ig = super.Ig() + com.google.a.a.b.bC(1, this.action) + com.google.a.a.b.bu(2, this.roomId) + com.google.a.a.b.r(3, this.ypH);
            if (!this.groupId.equals("")) {
                Ig += com.google.a.a.b.f(4, this.groupId);
            }
            if (this.timestamp != 0) {
                return Ig + com.google.a.a.b.p(5, this.timestamp);
            }
            return Ig;
        }

        @Override // com.google.a.a.e
        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int yT = aVar.yT();
                switch (yT) {
                    case 0:
                        break;
                    case 8:
                        this.action = aVar.zi();
                        break;
                    case 16:
                        this.roomId = aVar.zi();
                        break;
                    case 24:
                        this.ypH = aVar.zl();
                        break;
                    case 34:
                        this.groupId = aVar.readString();
                        break;
                    case 40:
                        this.timestamp = aVar.zl();
                        break;
                    default:
                        if (com.google.a.a.g.a(aVar, yT)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }
    }

    public static final class aj extends com.google.a.a.e {
        public int LGa = 0;
        public int RFa = 0;
        public int RFb = 0;
        public int RFc = 0;
        public int RFd = 0;
        public int RFe = 0;
        public int RFf = -1;
        public int RFg = 0;
        public int RFh = 0;
        public int roomId = 0;
        public long ypH = 0;

        public aj() {
            this.cbo = -1;
        }

        @Override // com.google.a.a.e
        public final void a(com.google.a.a.b bVar) {
            if (this.LGa != 0) {
                bVar.bB(1, this.LGa);
            }
            if (this.roomId != 0) {
                bVar.bs(2, this.roomId);
            }
            if (this.ypH != 0) {
                bVar.q(3, this.ypH);
            }
            if (this.RFa != 0) {
                bVar.bB(4, this.RFa);
            }
            if (this.RFb != 0) {
                bVar.bB(5, this.RFb);
            }
            if (this.RFc != 0) {
                bVar.bB(6, this.RFc);
            }
            if (this.RFd != 0) {
                bVar.bB(7, this.RFd);
            }
            if (this.RFe != 0) {
                bVar.bB(8, this.RFe);
            }
            if (this.RFf != -1) {
                bVar.bs(9, this.RFf);
            }
            if (this.RFg != 0) {
                bVar.bs(10, this.RFg);
            }
            if (this.RFh != 0) {
                bVar.bs(11, this.RFh);
            }
            super.a(bVar);
        }

        @Override // com.google.a.a.e
        public final int Ig() {
            int Ig = super.Ig();
            if (this.LGa != 0) {
                Ig += com.google.a.a.b.bC(1, this.LGa);
            }
            if (this.roomId != 0) {
                Ig += com.google.a.a.b.bu(2, this.roomId);
            }
            if (this.ypH != 0) {
                Ig += com.google.a.a.b.r(3, this.ypH);
            }
            if (this.RFa != 0) {
                Ig += com.google.a.a.b.bC(4, this.RFa);
            }
            if (this.RFb != 0) {
                Ig += com.google.a.a.b.bC(5, this.RFb);
            }
            if (this.RFc != 0) {
                Ig += com.google.a.a.b.bC(6, this.RFc);
            }
            if (this.RFd != 0) {
                Ig += com.google.a.a.b.bC(7, this.RFd);
            }
            if (this.RFe != 0) {
                Ig += com.google.a.a.b.bC(8, this.RFe);
            }
            if (this.RFf != -1) {
                Ig += com.google.a.a.b.bu(9, this.RFf);
            }
            if (this.RFg != 0) {
                Ig += com.google.a.a.b.bu(10, this.RFg);
            }
            if (this.RFh != 0) {
                return Ig + com.google.a.a.b.bu(11, this.RFh);
            }
            return Ig;
        }

        @Override // com.google.a.a.e
        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int yT = aVar.yT();
                switch (yT) {
                    case 0:
                        break;
                    case 8:
                        this.LGa = aVar.zi();
                        break;
                    case 16:
                        this.roomId = aVar.zi();
                        break;
                    case 24:
                        this.ypH = aVar.zl();
                        break;
                    case 32:
                        this.RFa = aVar.zi();
                        break;
                    case 40:
                        this.RFb = aVar.zi();
                        break;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
                        this.RFc = aVar.zi();
                        break;
                    case 56:
                        this.RFd = aVar.zi();
                        break;
                    case 64:
                        this.RFe = aVar.zi();
                        break;
                    case 72:
                        this.RFf = aVar.zi();
                        break;
                    case PlayerException.EXCEPTION_TYPE_CONNECT_FAIL /*{ENCODED_INT: 80}*/:
                        this.RFg = aVar.zi();
                        break;
                    case TPCodecParamers.TP_PROFILE_H264_EXTENDED /*{ENCODED_INT: 88}*/:
                        this.RFh = aVar.zi();
                        break;
                    default:
                        if (com.google.a.a.g.a(aVar, yT)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }
    }

    public static final class t extends com.google.a.a.e {
        public as[] REg = as.hjh();

        @Override // com.google.a.a.e
        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            int length;
            while (true) {
                int yT = aVar.yT();
                switch (yT) {
                    case 0:
                        break;
                    case 10:
                        int b2 = com.google.a.a.g.b(aVar, 10);
                        if (this.REg == null) {
                            length = 0;
                        } else {
                            length = this.REg.length;
                        }
                        as[] asVarArr = new as[(b2 + length)];
                        if (length != 0) {
                            System.arraycopy(this.REg, 0, asVarArr, 0, length);
                        }
                        while (length < asVarArr.length - 1) {
                            asVarArr[length] = new as();
                            aVar.a(asVarArr[length]);
                            aVar.yT();
                            length++;
                        }
                        asVarArr[length] = new as();
                        aVar.a(asVarArr[length]);
                        this.REg = asVarArr;
                        break;
                    default:
                        if (com.google.a.a.g.a(aVar, yT)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        public t() {
            this.cbo = -1;
        }

        @Override // com.google.a.a.e
        public final void a(com.google.a.a.b bVar) {
            if (this.REg != null && this.REg.length > 0) {
                for (int i2 = 0; i2 < this.REg.length; i2++) {
                    as asVar = this.REg[i2];
                    if (asVar != null) {
                        bVar.a(1, asVar);
                    }
                }
            }
            super.a(bVar);
        }

        @Override // com.google.a.a.e
        public final int Ig() {
            int Ig = super.Ig();
            if (this.REg != null && this.REg.length > 0) {
                for (int i2 = 0; i2 < this.REg.length; i2++) {
                    as asVar = this.REg[i2];
                    if (asVar != null) {
                        Ig += com.google.a.a.b.b(1, asVar);
                    }
                }
            }
            return Ig;
        }
    }

    public static final class s extends com.google.a.a.e {
        public int REf = 0;

        public s() {
            this.cbo = -1;
        }

        @Override // com.google.a.a.e
        public final void a(com.google.a.a.b bVar) {
            bVar.bB(1, this.REf);
            super.a(bVar);
        }

        @Override // com.google.a.a.e
        public final int Ig() {
            return super.Ig() + com.google.a.a.b.bC(1, this.REf);
        }

        @Override // com.google.a.a.e
        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int yT = aVar.yT();
                switch (yT) {
                    case 0:
                        break;
                    case 8:
                        this.REf = aVar.zi();
                        break;
                    default:
                        if (com.google.a.a.g.a(aVar, yT)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }
    }

    public static final class h extends com.google.a.a.e {
        public String gAb = "";
        public String groupId = "";
        public int roomId = 0;
        public long timestamp = 0;
        public long ypH = 0;

        public h() {
            this.cbo = -1;
        }

        @Override // com.google.a.a.e
        public final void a(com.google.a.a.b bVar) {
            bVar.bs(1, this.roomId);
            bVar.q(2, this.ypH);
            bVar.e(3, this.gAb);
            if (!this.groupId.equals("")) {
                bVar.e(4, this.groupId);
            }
            if (this.timestamp != 0) {
                bVar.n(5, this.timestamp);
            }
            super.a(bVar);
        }

        @Override // com.google.a.a.e
        public final int Ig() {
            int Ig = super.Ig() + com.google.a.a.b.bu(1, this.roomId) + com.google.a.a.b.r(2, this.ypH) + com.google.a.a.b.f(3, this.gAb);
            if (!this.groupId.equals("")) {
                Ig += com.google.a.a.b.f(4, this.groupId);
            }
            if (this.timestamp != 0) {
                return Ig + com.google.a.a.b.p(5, this.timestamp);
            }
            return Ig;
        }

        @Override // com.google.a.a.e
        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int yT = aVar.yT();
                switch (yT) {
                    case 0:
                        break;
                    case 8:
                        this.roomId = aVar.zi();
                        break;
                    case 16:
                        this.ypH = aVar.zl();
                        break;
                    case 26:
                        this.gAb = aVar.readString();
                        break;
                    case 34:
                        this.groupId = aVar.readString();
                        break;
                    case 40:
                        this.timestamp = aVar.zl();
                        break;
                    default:
                        if (com.google.a.a.g.a(aVar, yT)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }
    }

    public static final class ag extends com.google.a.a.e {
        public int roomId = 0;
        public long ypH = 0;

        public ag() {
            this.cbo = -1;
        }

        @Override // com.google.a.a.e
        public final void a(com.google.a.a.b bVar) {
            if (this.roomId != 0) {
                bVar.bs(1, this.roomId);
            }
            if (this.ypH != 0) {
                bVar.q(2, this.ypH);
            }
            super.a(bVar);
        }

        @Override // com.google.a.a.e
        public final int Ig() {
            int Ig = super.Ig();
            if (this.roomId != 0) {
                Ig += com.google.a.a.b.bu(1, this.roomId);
            }
            if (this.ypH != 0) {
                return Ig + com.google.a.a.b.r(2, this.ypH);
            }
            return Ig;
        }

        @Override // com.google.a.a.e
        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int yT = aVar.yT();
                switch (yT) {
                    case 0:
                        break;
                    case 8:
                        this.roomId = aVar.zi();
                        break;
                    case 16:
                        this.ypH = aVar.zl();
                        break;
                    default:
                        if (com.google.a.a.g.a(aVar, yT)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }
    }

    public static final class as extends com.google.a.a.e {
        private static volatile as[] RFl;
        public int KBb = 0;
        public int RFm = 0;
        public int RFn = 0;
        public String dLN = "";
        public int qrD = 0;
        public int videoStatus = 0;

        public static as[] hjh() {
            if (RFl == null) {
                synchronized (com.google.a.a.c.cbn) {
                    if (RFl == null) {
                        RFl = new as[0];
                    }
                }
            }
            return RFl;
        }

        public as() {
            this.cbo = -1;
        }

        @Override // com.google.a.a.e
        public final void a(com.google.a.a.b bVar) {
            if (this.qrD != 0) {
                bVar.bB(1, this.qrD);
            }
            if (!this.dLN.equals("")) {
                bVar.e(2, this.dLN);
            }
            if (this.KBb != 0) {
                bVar.bB(3, this.KBb);
            }
            if (this.videoStatus != 0) {
                bVar.bB(4, this.videoStatus);
            }
            if (this.RFm != 0) {
                bVar.bB(5, this.RFm);
            }
            if (this.RFn != 0) {
                bVar.bB(6, this.RFn);
            }
            super.a(bVar);
        }

        @Override // com.google.a.a.e
        public final int Ig() {
            int Ig = super.Ig();
            if (this.qrD != 0) {
                Ig += com.google.a.a.b.bC(1, this.qrD);
            }
            if (!this.dLN.equals("")) {
                Ig += com.google.a.a.b.f(2, this.dLN);
            }
            if (this.KBb != 0) {
                Ig += com.google.a.a.b.bC(3, this.KBb);
            }
            if (this.videoStatus != 0) {
                Ig += com.google.a.a.b.bC(4, this.videoStatus);
            }
            if (this.RFm != 0) {
                Ig += com.google.a.a.b.bC(5, this.RFm);
            }
            if (this.RFn != 0) {
                return Ig + com.google.a.a.b.bC(6, this.RFn);
            }
            return Ig;
        }

        @Override // com.google.a.a.e
        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int yT = aVar.yT();
                switch (yT) {
                    case 0:
                        break;
                    case 8:
                        this.qrD = aVar.zi();
                        break;
                    case 18:
                        this.dLN = aVar.readString();
                        break;
                    case 24:
                        this.KBb = aVar.zi();
                        break;
                    case 32:
                        this.videoStatus = aVar.zi();
                        break;
                    case 40:
                        this.RFm = aVar.zi();
                        break;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
                        this.RFn = aVar.zi();
                        break;
                    default:
                        if (com.google.a.a.g.a(aVar, yT)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }
    }

    public static final class ar extends com.google.a.a.e {
        private static volatile ar[] RFk;
        public int qrD = 0;

        public static ar[] hjg() {
            if (RFk == null) {
                synchronized (com.google.a.a.c.cbn) {
                    if (RFk == null) {
                        RFk = new ar[0];
                    }
                }
            }
            return RFk;
        }

        public ar() {
            this.cbo = -1;
        }

        @Override // com.google.a.a.e
        public final void a(com.google.a.a.b bVar) {
            if (this.qrD != 0) {
                bVar.bB(1, this.qrD);
            }
            super.a(bVar);
        }

        @Override // com.google.a.a.e
        public final int Ig() {
            int Ig = super.Ig();
            if (this.qrD != 0) {
                return Ig + com.google.a.a.b.bC(1, this.qrD);
            }
            return Ig;
        }

        @Override // com.google.a.a.e
        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int yT = aVar.yT();
                switch (yT) {
                    case 0:
                        break;
                    case 8:
                        this.qrD = aVar.zi();
                        break;
                    default:
                        if (com.google.a.a.g.a(aVar, yT)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }
    }

    public static final class j extends com.google.a.a.e {
        public ar[] RDE = ar.hjg();
        public String groupId = "";
        public int roomId = 0;
        public long timestamp = 0;
        public long ypH = 0;

        @Override // com.google.a.a.e
        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            int length;
            while (true) {
                int yT = aVar.yT();
                switch (yT) {
                    case 0:
                        break;
                    case 8:
                        this.roomId = aVar.zi();
                        break;
                    case 16:
                        this.ypH = aVar.zl();
                        break;
                    case 26:
                        this.groupId = aVar.readString();
                        break;
                    case 34:
                        int b2 = com.google.a.a.g.b(aVar, 34);
                        if (this.RDE == null) {
                            length = 0;
                        } else {
                            length = this.RDE.length;
                        }
                        ar[] arVarArr = new ar[(b2 + length)];
                        if (length != 0) {
                            System.arraycopy(this.RDE, 0, arVarArr, 0, length);
                        }
                        while (length < arVarArr.length - 1) {
                            arVarArr[length] = new ar();
                            aVar.a(arVarArr[length]);
                            aVar.yT();
                            length++;
                        }
                        arVarArr[length] = new ar();
                        aVar.a(arVarArr[length]);
                        this.RDE = arVarArr;
                        break;
                    case 40:
                        this.timestamp = aVar.zl();
                        break;
                    default:
                        if (com.google.a.a.g.a(aVar, yT)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        public j() {
            this.cbo = -1;
        }

        @Override // com.google.a.a.e
        public final void a(com.google.a.a.b bVar) {
            bVar.bs(1, this.roomId);
            bVar.q(2, this.ypH);
            if (!this.groupId.equals("")) {
                bVar.e(3, this.groupId);
            }
            if (this.RDE != null && this.RDE.length > 0) {
                for (int i2 = 0; i2 < this.RDE.length; i2++) {
                    ar arVar = this.RDE[i2];
                    if (arVar != null) {
                        bVar.a(4, arVar);
                    }
                }
            }
            if (this.timestamp != 0) {
                bVar.n(5, this.timestamp);
            }
            super.a(bVar);
        }

        @Override // com.google.a.a.e
        public final int Ig() {
            int Ig = super.Ig() + com.google.a.a.b.bu(1, this.roomId) + com.google.a.a.b.r(2, this.ypH);
            if (!this.groupId.equals("")) {
                Ig += com.google.a.a.b.f(3, this.groupId);
            }
            if (this.RDE != null && this.RDE.length > 0) {
                int i2 = Ig;
                for (int i3 = 0; i3 < this.RDE.length; i3++) {
                    ar arVar = this.RDE[i3];
                    if (arVar != null) {
                        i2 += com.google.a.a.b.b(4, arVar);
                    }
                }
                Ig = i2;
            }
            if (this.timestamp != 0) {
                return Ig + com.google.a.a.b.p(5, this.timestamp);
            }
            return Ig;
        }
    }

    public static final class ai extends com.google.a.a.e {
        public int roomId = 0;
        public long ypH = 0;

        public ai() {
            this.cbo = -1;
        }

        @Override // com.google.a.a.e
        public final void a(com.google.a.a.b bVar) {
            if (this.roomId != 0) {
                bVar.bs(1, this.roomId);
            }
            if (this.ypH != 0) {
                bVar.q(2, this.ypH);
            }
            super.a(bVar);
        }

        @Override // com.google.a.a.e
        public final int Ig() {
            int Ig = super.Ig();
            if (this.roomId != 0) {
                Ig += com.google.a.a.b.bu(1, this.roomId);
            }
            if (this.ypH != 0) {
                return Ig + com.google.a.a.b.r(2, this.ypH);
            }
            return Ig;
        }

        @Override // com.google.a.a.e
        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int yT = aVar.yT();
                switch (yT) {
                    case 0:
                        break;
                    case 8:
                        this.roomId = aVar.zi();
                        break;
                    case 16:
                        this.ypH = aVar.zl();
                        break;
                    default:
                        if (com.google.a.a.g.a(aVar, yT)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }
    }

    public static final class aq extends com.google.a.a.e {
        private static volatile aq[] RFj;
        public int qrD = 0;

        public static aq[] hjf() {
            if (RFj == null) {
                synchronized (com.google.a.a.c.cbn) {
                    if (RFj == null) {
                        RFj = new aq[0];
                    }
                }
            }
            return RFj;
        }

        public aq() {
            this.cbo = -1;
        }

        @Override // com.google.a.a.e
        public final void a(com.google.a.a.b bVar) {
            if (this.qrD != 0) {
                bVar.bB(1, this.qrD);
            }
            super.a(bVar);
        }

        @Override // com.google.a.a.e
        public final int Ig() {
            int Ig = super.Ig();
            if (this.qrD != 0) {
                return Ig + com.google.a.a.b.bC(1, this.qrD);
            }
            return Ig;
        }

        @Override // com.google.a.a.e
        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int yT = aVar.yT();
                switch (yT) {
                    case 0:
                        break;
                    case 8:
                        this.qrD = aVar.zi();
                        break;
                    default:
                        if (com.google.a.a.g.a(aVar, yT)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }
    }

    public static final class i extends com.google.a.a.e {
        public aq[] RDD = aq.hjf();
        public String groupId = "";
        public int roomId = 0;
        public long timestamp = 0;
        public long ypH = 0;

        @Override // com.google.a.a.e
        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            int length;
            while (true) {
                int yT = aVar.yT();
                switch (yT) {
                    case 0:
                        break;
                    case 8:
                        this.roomId = aVar.zi();
                        break;
                    case 16:
                        this.ypH = aVar.zl();
                        break;
                    case 26:
                        this.groupId = aVar.readString();
                        break;
                    case 34:
                        int b2 = com.google.a.a.g.b(aVar, 34);
                        if (this.RDD == null) {
                            length = 0;
                        } else {
                            length = this.RDD.length;
                        }
                        aq[] aqVarArr = new aq[(b2 + length)];
                        if (length != 0) {
                            System.arraycopy(this.RDD, 0, aqVarArr, 0, length);
                        }
                        while (length < aqVarArr.length - 1) {
                            aqVarArr[length] = new aq();
                            aVar.a(aqVarArr[length]);
                            aVar.yT();
                            length++;
                        }
                        aqVarArr[length] = new aq();
                        aVar.a(aqVarArr[length]);
                        this.RDD = aqVarArr;
                        break;
                    case 40:
                        this.timestamp = aVar.zl();
                        break;
                    default:
                        if (com.google.a.a.g.a(aVar, yT)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        public i() {
            this.cbo = -1;
        }

        @Override // com.google.a.a.e
        public final void a(com.google.a.a.b bVar) {
            bVar.bs(1, this.roomId);
            bVar.q(2, this.ypH);
            if (!this.groupId.equals("")) {
                bVar.e(3, this.groupId);
            }
            if (this.RDD != null && this.RDD.length > 0) {
                for (int i2 = 0; i2 < this.RDD.length; i2++) {
                    aq aqVar = this.RDD[i2];
                    if (aqVar != null) {
                        bVar.a(4, aqVar);
                    }
                }
            }
            if (this.timestamp != 0) {
                bVar.n(5, this.timestamp);
            }
            super.a(bVar);
        }

        @Override // com.google.a.a.e
        public final int Ig() {
            int Ig = super.Ig() + com.google.a.a.b.bu(1, this.roomId) + com.google.a.a.b.r(2, this.ypH);
            if (!this.groupId.equals("")) {
                Ig += com.google.a.a.b.f(3, this.groupId);
            }
            if (this.RDD != null && this.RDD.length > 0) {
                int i2 = Ig;
                for (int i3 = 0; i3 < this.RDD.length; i3++) {
                    aq aqVar = this.RDD[i3];
                    if (aqVar != null) {
                        i2 += com.google.a.a.b.b(4, aqVar);
                    }
                }
                Ig = i2;
            }
            if (this.timestamp != 0) {
                return Ig + com.google.a.a.b.p(5, this.timestamp);
            }
            return Ig;
        }
    }

    public static final class ah extends com.google.a.a.e {
        public int roomId = 0;
        public long ypH = 0;

        public ah() {
            this.cbo = -1;
        }

        @Override // com.google.a.a.e
        public final void a(com.google.a.a.b bVar) {
            if (this.roomId != 0) {
                bVar.bs(1, this.roomId);
            }
            if (this.ypH != 0) {
                bVar.q(2, this.ypH);
            }
            super.a(bVar);
        }

        @Override // com.google.a.a.e
        public final int Ig() {
            int Ig = super.Ig();
            if (this.roomId != 0) {
                Ig += com.google.a.a.b.bu(1, this.roomId);
            }
            if (this.ypH != 0) {
                return Ig + com.google.a.a.b.r(2, this.ypH);
            }
            return Ig;
        }

        @Override // com.google.a.a.e
        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int yT = aVar.yT();
                switch (yT) {
                    case 0:
                        break;
                    case 8:
                        this.roomId = aVar.zi();
                        break;
                    case 16:
                        this.ypH = aVar.zl();
                        break;
                    default:
                        if (com.google.a.a.g.a(aVar, yT)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }
    }

    public static final class m extends com.google.a.a.e {
        public int GXO = 0;
        public long GXP = 0;
        public int RDG = 0;
        public int RDu = 0;
        public String groupId = "";
        public int netType = 0;
        public int qrD = -1;

        public m() {
            this.cbo = -1;
        }

        @Override // com.google.a.a.e
        public final void a(com.google.a.a.b bVar) {
            if (!this.groupId.equals("")) {
                bVar.e(1, this.groupId);
            }
            if (this.GXO != 0) {
                bVar.bs(2, this.GXO);
            }
            if (this.GXP != 0) {
                bVar.q(3, this.GXP);
            }
            if (this.qrD != -1) {
                bVar.bs(4, this.qrD);
            }
            if (this.RDu != 0) {
                bVar.bB(5, this.RDu);
            }
            if (this.netType != 0) {
                bVar.bB(6, this.netType);
            }
            if (this.RDG != 0) {
                bVar.bs(7, this.RDG);
            }
            super.a(bVar);
        }

        @Override // com.google.a.a.e
        public final int Ig() {
            int Ig = super.Ig();
            if (!this.groupId.equals("")) {
                Ig += com.google.a.a.b.f(1, this.groupId);
            }
            if (this.GXO != 0) {
                Ig += com.google.a.a.b.bu(2, this.GXO);
            }
            if (this.GXP != 0) {
                Ig += com.google.a.a.b.r(3, this.GXP);
            }
            if (this.qrD != -1) {
                Ig += com.google.a.a.b.bu(4, this.qrD);
            }
            if (this.RDu != 0) {
                Ig += com.google.a.a.b.bC(5, this.RDu);
            }
            if (this.netType != 0) {
                Ig += com.google.a.a.b.bC(6, this.netType);
            }
            if (this.RDG != 0) {
                return Ig + com.google.a.a.b.bu(7, this.RDG);
            }
            return Ig;
        }

        @Override // com.google.a.a.e
        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int yT = aVar.yT();
                switch (yT) {
                    case 0:
                        break;
                    case 10:
                        this.groupId = aVar.readString();
                        break;
                    case 16:
                        this.GXO = aVar.zi();
                        break;
                    case 24:
                        this.GXP = aVar.zl();
                        break;
                    case 32:
                        this.qrD = aVar.zi();
                        break;
                    case 40:
                        this.RDu = aVar.zi();
                        break;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
                        this.netType = aVar.zi();
                        break;
                    case 56:
                        int zi = aVar.zi();
                        switch (zi) {
                            case 0:
                            case 1:
                                this.RDG = zi;
                                continue;
                        }
                    default:
                        if (com.google.a.a.g.a(aVar, yT)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }
    }

    public static final class an extends com.google.a.a.e {
        public int GXO = 0;
        public long GXP = 0;
        public int Lnt = -1;
        public ay RDY = null;
        public az RDq = null;
        public bb[] REK = bb.hjl();
        public q[] REL = q.hjd();
        public bc[] REM = bc.hjm();
        public int REN = 0;
        public int[] REO = com.google.a.a.g.bYn;
        public q[] REP = q.hjd();
        public q[] RES = q.hjd();
        public int RET = 0;
        public int REU = 0;
        public int REW = 0;
        public byte[] REX = com.google.a.a.g.cbu;
        public int[] REY = com.google.a.a.g.bYn;
        public int REa = 0;
        public bb[] REe = bb.hjl();
        public String groupId = "";

        @Override // com.google.a.a.e
        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            int length;
            int length2;
            int length3;
            int length4;
            int length5;
            int length6;
            int length7;
            int length8;
            while (true) {
                int yT = aVar.yT();
                switch (yT) {
                    case 0:
                        break;
                    case 10:
                        this.groupId = aVar.readString();
                        break;
                    case 16:
                        this.GXO = aVar.zi();
                        break;
                    case 24:
                        this.GXP = aVar.zl();
                        break;
                    case 34:
                        int b2 = com.google.a.a.g.b(aVar, 34);
                        if (this.REL == null) {
                            length8 = 0;
                        } else {
                            length8 = this.REL.length;
                        }
                        q[] qVarArr = new q[(b2 + length8)];
                        if (length8 != 0) {
                            System.arraycopy(this.REL, 0, qVarArr, 0, length8);
                        }
                        while (length8 < qVarArr.length - 1) {
                            qVarArr[length8] = new q();
                            aVar.a(qVarArr[length8]);
                            aVar.yT();
                            length8++;
                        }
                        qVarArr[length8] = new q();
                        aVar.a(qVarArr[length8]);
                        this.REL = qVarArr;
                        break;
                    case 42:
                        int b3 = com.google.a.a.g.b(aVar, 42);
                        if (this.REK == null) {
                            length7 = 0;
                        } else {
                            length7 = this.REK.length;
                        }
                        bb[] bbVarArr = new bb[(b3 + length7)];
                        if (length7 != 0) {
                            System.arraycopy(this.REK, 0, bbVarArr, 0, length7);
                        }
                        while (length7 < bbVarArr.length - 1) {
                            bbVarArr[length7] = new bb();
                            aVar.a(bbVarArr[length7]);
                            aVar.yT();
                            length7++;
                        }
                        bbVarArr[length7] = new bb();
                        aVar.a(bbVarArr[length7]);
                        this.REK = bbVarArr;
                        break;
                    case 50:
                        if (this.RDY == null) {
                            this.RDY = new ay();
                        }
                        aVar.a(this.RDY);
                        break;
                    case 56:
                        this.REN = aVar.zi();
                        break;
                    case 64:
                        int b4 = com.google.a.a.g.b(aVar, 64);
                        if (this.REO == null) {
                            length6 = 0;
                        } else {
                            length6 = this.REO.length;
                        }
                        int[] iArr = new int[(b4 + length6)];
                        if (length6 != 0) {
                            System.arraycopy(this.REO, 0, iArr, 0, length6);
                        }
                        while (length6 < iArr.length - 1) {
                            iArr[length6] = aVar.zi();
                            aVar.yT();
                            length6++;
                        }
                        iArr[length6] = aVar.zi();
                        this.REO = iArr;
                        break;
                    case 66:
                        int fH = aVar.fH(aVar.zi());
                        int position = aVar.getPosition();
                        int i2 = 0;
                        while (aVar.zk() > 0) {
                            aVar.zi();
                            i2++;
                        }
                        aVar.gZ(position);
                        int length9 = this.REO == null ? 0 : this.REO.length;
                        int[] iArr2 = new int[(i2 + length9)];
                        if (length9 != 0) {
                            System.arraycopy(this.REO, 0, iArr2, 0, length9);
                        }
                        while (length9 < iArr2.length) {
                            iArr2[length9] = aVar.zi();
                            length9++;
                        }
                        this.REO = iArr2;
                        aVar.fI(fH);
                        break;
                    case 74:
                        int b5 = com.google.a.a.g.b(aVar, 74);
                        if (this.REM == null) {
                            length5 = 0;
                        } else {
                            length5 = this.REM.length;
                        }
                        bc[] bcVarArr = new bc[(b5 + length5)];
                        if (length5 != 0) {
                            System.arraycopy(this.REM, 0, bcVarArr, 0, length5);
                        }
                        while (length5 < bcVarArr.length - 1) {
                            bcVarArr[length5] = new bc();
                            aVar.a(bcVarArr[length5]);
                            aVar.yT();
                            length5++;
                        }
                        bcVarArr[length5] = new bc();
                        aVar.a(bcVarArr[length5]);
                        this.REM = bcVarArr;
                        break;
                    case PlayerException.EXCEPTION_TYPE_ERROR_CREATE_JAVA_DATASOURCE /*{ENCODED_INT: 82}*/:
                        if (this.RDq == null) {
                            this.RDq = new az();
                        }
                        aVar.a(this.RDq);
                        break;
                    case 90:
                        int b6 = com.google.a.a.g.b(aVar, 90);
                        if (this.REP == null) {
                            length4 = 0;
                        } else {
                            length4 = this.REP.length;
                        }
                        q[] qVarArr2 = new q[(b6 + length4)];
                        if (length4 != 0) {
                            System.arraycopy(this.REP, 0, qVarArr2, 0, length4);
                        }
                        while (length4 < qVarArr2.length - 1) {
                            qVarArr2[length4] = new q();
                            aVar.a(qVarArr2[length4]);
                            aVar.yT();
                            length4++;
                        }
                        qVarArr2[length4] = new q();
                        aVar.a(qVarArr2[length4]);
                        this.REP = qVarArr2;
                        break;
                    case 98:
                        int b7 = com.google.a.a.g.b(aVar, 98);
                        if (this.REe == null) {
                            length3 = 0;
                        } else {
                            length3 = this.REe.length;
                        }
                        bb[] bbVarArr2 = new bb[(b7 + length3)];
                        if (length3 != 0) {
                            System.arraycopy(this.REe, 0, bbVarArr2, 0, length3);
                        }
                        while (length3 < bbVarArr2.length - 1) {
                            bbVarArr2[length3] = new bb();
                            aVar.a(bbVarArr2[length3]);
                            aVar.yT();
                            length3++;
                        }
                        bbVarArr2[length3] = new bb();
                        aVar.a(bbVarArr2[length3]);
                        this.REe = bbVarArr2;
                        break;
                    case 106:
                        int b8 = com.google.a.a.g.b(aVar, 106);
                        if (this.RES == null) {
                            length2 = 0;
                        } else {
                            length2 = this.RES.length;
                        }
                        q[] qVarArr3 = new q[(b8 + length2)];
                        if (length2 != 0) {
                            System.arraycopy(this.RES, 0, qVarArr3, 0, length2);
                        }
                        while (length2 < qVarArr3.length - 1) {
                            qVarArr3[length2] = new q();
                            aVar.a(qVarArr3[length2]);
                            aVar.yT();
                            length2++;
                        }
                        qVarArr3[length2] = new q();
                        aVar.a(qVarArr3[length2]);
                        this.RES = qVarArr3;
                        break;
                    case 112:
                        this.RET = aVar.zi();
                        break;
                    case 120:
                        this.REU = aVar.zi();
                        break;
                    case 128:
                        this.REW = aVar.zi();
                        break;
                    case 138:
                        this.REX = aVar.readBytes();
                        break;
                    case 144:
                        this.Lnt = aVar.zi();
                        break;
                    case 152:
                        int b9 = com.google.a.a.g.b(aVar, 152);
                        if (this.REY == null) {
                            length = 0;
                        } else {
                            length = this.REY.length;
                        }
                        int[] iArr3 = new int[(b9 + length)];
                        if (length != 0) {
                            System.arraycopy(this.REY, 0, iArr3, 0, length);
                        }
                        while (length < iArr3.length - 1) {
                            iArr3[length] = aVar.zi();
                            aVar.yT();
                            length++;
                        }
                        iArr3[length] = aVar.zi();
                        this.REY = iArr3;
                        break;
                    case 154:
                        int fH2 = aVar.fH(aVar.zi());
                        int position2 = aVar.getPosition();
                        int i3 = 0;
                        while (aVar.zk() > 0) {
                            aVar.zi();
                            i3++;
                        }
                        aVar.gZ(position2);
                        int length10 = this.REY == null ? 0 : this.REY.length;
                        int[] iArr4 = new int[(i3 + length10)];
                        if (length10 != 0) {
                            System.arraycopy(this.REY, 0, iArr4, 0, length10);
                        }
                        while (length10 < iArr4.length) {
                            iArr4[length10] = aVar.zi();
                            length10++;
                        }
                        this.REY = iArr4;
                        aVar.fI(fH2);
                        break;
                    case 160:
                        this.REa = aVar.zi();
                        break;
                    default:
                        if (com.google.a.a.g.a(aVar, yT)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        public an() {
            this.cbo = -1;
        }

        @Override // com.google.a.a.e
        public final void a(com.google.a.a.b bVar) {
            if (!this.groupId.equals("")) {
                bVar.e(1, this.groupId);
            }
            if (this.GXO != 0) {
                bVar.bs(2, this.GXO);
            }
            if (this.GXP != 0) {
                bVar.q(3, this.GXP);
            }
            if (this.REL != null && this.REL.length > 0) {
                for (int i2 = 0; i2 < this.REL.length; i2++) {
                    q qVar = this.REL[i2];
                    if (qVar != null) {
                        bVar.a(4, qVar);
                    }
                }
            }
            if (this.REK != null && this.REK.length > 0) {
                for (int i3 = 0; i3 < this.REK.length; i3++) {
                    bb bbVar = this.REK[i3];
                    if (bbVar != null) {
                        bVar.a(5, bbVar);
                    }
                }
            }
            if (this.RDY != null) {
                bVar.a(6, this.RDY);
            }
            if (this.REN != 0) {
                bVar.bs(7, this.REN);
            }
            if (this.REO != null && this.REO.length > 0) {
                for (int i4 = 0; i4 < this.REO.length; i4++) {
                    bVar.bs(8, this.REO[i4]);
                }
            }
            if (this.REM != null && this.REM.length > 0) {
                for (int i5 = 0; i5 < this.REM.length; i5++) {
                    bc bcVar = this.REM[i5];
                    if (bcVar != null) {
                        bVar.a(9, bcVar);
                    }
                }
            }
            if (this.RDq != null) {
                bVar.a(10, this.RDq);
            }
            if (this.REP != null && this.REP.length > 0) {
                for (int i6 = 0; i6 < this.REP.length; i6++) {
                    q qVar2 = this.REP[i6];
                    if (qVar2 != null) {
                        bVar.a(11, qVar2);
                    }
                }
            }
            if (this.REe != null && this.REe.length > 0) {
                for (int i7 = 0; i7 < this.REe.length; i7++) {
                    bb bbVar2 = this.REe[i7];
                    if (bbVar2 != null) {
                        bVar.a(12, bbVar2);
                    }
                }
            }
            if (this.RES != null && this.RES.length > 0) {
                for (int i8 = 0; i8 < this.RES.length; i8++) {
                    q qVar3 = this.RES[i8];
                    if (qVar3 != null) {
                        bVar.a(13, qVar3);
                    }
                }
            }
            if (this.RET != 0) {
                bVar.bs(14, this.RET);
            }
            if (this.REU != 0) {
                bVar.bs(15, this.REU);
            }
            if (this.REW != 0) {
                bVar.bs(16, this.REW);
            }
            if (!Arrays.equals(this.REX, com.google.a.a.g.cbu)) {
                bVar.b(17, this.REX);
            }
            if (this.Lnt != -1) {
                bVar.bs(18, this.Lnt);
            }
            if (this.REY != null && this.REY.length > 0) {
                for (int i9 = 0; i9 < this.REY.length; i9++) {
                    bVar.bB(19, this.REY[i9]);
                }
            }
            if (this.REa != 0) {
                bVar.bB(20, this.REa);
            }
            super.a(bVar);
        }

        @Override // com.google.a.a.e
        public final int Ig() {
            int Ig = super.Ig();
            if (!this.groupId.equals("")) {
                Ig += com.google.a.a.b.f(1, this.groupId);
            }
            if (this.GXO != 0) {
                Ig += com.google.a.a.b.bu(2, this.GXO);
            }
            if (this.GXP != 0) {
                Ig += com.google.a.a.b.r(3, this.GXP);
            }
            if (this.REL != null && this.REL.length > 0) {
                int i2 = Ig;
                for (int i3 = 0; i3 < this.REL.length; i3++) {
                    q qVar = this.REL[i3];
                    if (qVar != null) {
                        i2 += com.google.a.a.b.b(4, qVar);
                    }
                }
                Ig = i2;
            }
            if (this.REK != null && this.REK.length > 0) {
                int i4 = Ig;
                for (int i5 = 0; i5 < this.REK.length; i5++) {
                    bb bbVar = this.REK[i5];
                    if (bbVar != null) {
                        i4 += com.google.a.a.b.b(5, bbVar);
                    }
                }
                Ig = i4;
            }
            if (this.RDY != null) {
                Ig += com.google.a.a.b.b(6, this.RDY);
            }
            if (this.REN != 0) {
                Ig += com.google.a.a.b.bu(7, this.REN);
            }
            if (this.REO != null && this.REO.length > 0) {
                int i6 = 0;
                for (int i7 = 0; i7 < this.REO.length; i7++) {
                    i6 += com.google.a.a.b.fT(this.REO[i7]);
                }
                Ig = Ig + i6 + (this.REO.length * 1);
            }
            if (this.REM != null && this.REM.length > 0) {
                int i8 = Ig;
                for (int i9 = 0; i9 < this.REM.length; i9++) {
                    bc bcVar = this.REM[i9];
                    if (bcVar != null) {
                        i8 += com.google.a.a.b.b(9, bcVar);
                    }
                }
                Ig = i8;
            }
            if (this.RDq != null) {
                Ig += com.google.a.a.b.b(10, this.RDq);
            }
            if (this.REP != null && this.REP.length > 0) {
                int i10 = Ig;
                for (int i11 = 0; i11 < this.REP.length; i11++) {
                    q qVar2 = this.REP[i11];
                    if (qVar2 != null) {
                        i10 += com.google.a.a.b.b(11, qVar2);
                    }
                }
                Ig = i10;
            }
            if (this.REe != null && this.REe.length > 0) {
                int i12 = Ig;
                for (int i13 = 0; i13 < this.REe.length; i13++) {
                    bb bbVar2 = this.REe[i13];
                    if (bbVar2 != null) {
                        i12 += com.google.a.a.b.b(12, bbVar2);
                    }
                }
                Ig = i12;
            }
            if (this.RES != null && this.RES.length > 0) {
                int i14 = Ig;
                for (int i15 = 0; i15 < this.RES.length; i15++) {
                    q qVar3 = this.RES[i15];
                    if (qVar3 != null) {
                        i14 += com.google.a.a.b.b(13, qVar3);
                    }
                }
                Ig = i14;
            }
            if (this.RET != 0) {
                Ig += com.google.a.a.b.bu(14, this.RET);
            }
            if (this.REU != 0) {
                Ig += com.google.a.a.b.bu(15, this.REU);
            }
            if (this.REW != 0) {
                Ig += com.google.a.a.b.bu(16, this.REW);
            }
            if (!Arrays.equals(this.REX, com.google.a.a.g.cbu)) {
                Ig += com.google.a.a.b.c(17, this.REX);
            }
            if (this.Lnt != -1) {
                Ig += com.google.a.a.b.bu(18, this.Lnt);
            }
            if (this.REY != null && this.REY.length > 0) {
                int i16 = 0;
                for (int i17 = 0; i17 < this.REY.length; i17++) {
                    i16 += com.google.a.a.b.fY(this.REY[i17]);
                }
                Ig = Ig + i16 + (this.REY.length * 2);
            }
            if (this.REa != 0) {
                return Ig + com.google.a.a.b.bC(20, this.REa);
            }
            return Ig;
        }
    }

    public static final class g extends com.google.a.a.e {
        public int GXO = 0;
        public long GXP = 0;
        public String RDo = "";
        public int bDZ = 0;
        public String groupId = "";

        public g() {
            this.cbo = -1;
        }

        @Override // com.google.a.a.e
        public final void a(com.google.a.a.b bVar) {
            if (!this.groupId.equals("")) {
                bVar.e(1, this.groupId);
            }
            if (this.GXO != 0) {
                bVar.bs(2, this.GXO);
            }
            if (this.GXP != 0) {
                bVar.q(3, this.GXP);
            }
            if (this.bDZ != 0) {
                bVar.bs(4, this.bDZ);
            }
            if (!this.RDo.equals("")) {
                bVar.e(5, this.RDo);
            }
            super.a(bVar);
        }

        @Override // com.google.a.a.e
        public final int Ig() {
            int Ig = super.Ig();
            if (!this.groupId.equals("")) {
                Ig += com.google.a.a.b.f(1, this.groupId);
            }
            if (this.GXO != 0) {
                Ig += com.google.a.a.b.bu(2, this.GXO);
            }
            if (this.GXP != 0) {
                Ig += com.google.a.a.b.r(3, this.GXP);
            }
            if (this.bDZ != 0) {
                Ig += com.google.a.a.b.bu(4, this.bDZ);
            }
            if (!this.RDo.equals("")) {
                return Ig + com.google.a.a.b.f(5, this.RDo);
            }
            return Ig;
        }

        @Override // com.google.a.a.e
        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int yT = aVar.yT();
                switch (yT) {
                    case 0:
                        break;
                    case 10:
                        this.groupId = aVar.readString();
                        break;
                    case 16:
                        this.GXO = aVar.zi();
                        break;
                    case 24:
                        this.GXP = aVar.zl();
                        break;
                    case 32:
                        this.bDZ = aVar.zi();
                        break;
                    case 42:
                        this.RDo = aVar.readString();
                        break;
                    default:
                        if (com.google.a.a.g.a(aVar, yT)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }
    }

    public static final class af extends com.google.a.a.e {
        public int GXO = 0;
        public long GXP = 0;
        public String RDo = "";
        public String groupId = "";

        public af() {
            this.cbo = -1;
        }

        @Override // com.google.a.a.e
        public final void a(com.google.a.a.b bVar) {
            if (!this.groupId.equals("")) {
                bVar.e(1, this.groupId);
            }
            if (this.GXO != 0) {
                bVar.bs(2, this.GXO);
            }
            if (this.GXP != 0) {
                bVar.q(3, this.GXP);
            }
            if (!this.RDo.equals("")) {
                bVar.e(4, this.RDo);
            }
            super.a(bVar);
        }

        @Override // com.google.a.a.e
        public final int Ig() {
            int Ig = super.Ig();
            if (!this.groupId.equals("")) {
                Ig += com.google.a.a.b.f(1, this.groupId);
            }
            if (this.GXO != 0) {
                Ig += com.google.a.a.b.bu(2, this.GXO);
            }
            if (this.GXP != 0) {
                Ig += com.google.a.a.b.r(3, this.GXP);
            }
            if (!this.RDo.equals("")) {
                return Ig + com.google.a.a.b.f(4, this.RDo);
            }
            return Ig;
        }

        @Override // com.google.a.a.e
        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int yT = aVar.yT();
                switch (yT) {
                    case 0:
                        break;
                    case 10:
                        this.groupId = aVar.readString();
                        break;
                    case 16:
                        this.GXO = aVar.zi();
                        break;
                    case 24:
                        this.GXP = aVar.zl();
                        break;
                    case 34:
                        this.RDo = aVar.readString();
                        break;
                    default:
                        if (com.google.a.a.g.a(aVar, yT)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }
    }

    public static final class b extends com.google.a.a.e {
        public String RDo = "";
        public int bDZ = 0;

        public b() {
            this.cbo = -1;
        }

        @Override // com.google.a.a.e
        public final void a(com.google.a.a.b bVar) {
            if (!this.RDo.equals("")) {
                bVar.e(1, this.RDo);
            }
            if (this.bDZ != 0) {
                bVar.bs(2, this.bDZ);
            }
            super.a(bVar);
        }

        @Override // com.google.a.a.e
        public final int Ig() {
            int Ig = super.Ig();
            if (!this.RDo.equals("")) {
                Ig += com.google.a.a.b.f(1, this.RDo);
            }
            if (this.bDZ != 0) {
                return Ig + com.google.a.a.b.bu(2, this.bDZ);
            }
            return Ig;
        }

        @Override // com.google.a.a.e
        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int yT = aVar.yT();
                switch (yT) {
                    case 0:
                        break;
                    case 10:
                        this.RDo = aVar.readString();
                        break;
                    case 16:
                        this.bDZ = aVar.zi();
                        break;
                    default:
                        if (com.google.a.a.g.a(aVar, yT)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }
    }

    public static final class aa extends com.google.a.a.e {
        public String RDo = "";

        public aa() {
            this.cbo = -1;
        }

        @Override // com.google.a.a.e
        public final void a(com.google.a.a.b bVar) {
            if (!this.RDo.equals("")) {
                bVar.e(1, this.RDo);
            }
            super.a(bVar);
        }

        @Override // com.google.a.a.e
        public final int Ig() {
            int Ig = super.Ig();
            if (!this.RDo.equals("")) {
                return Ig + com.google.a.a.b.f(1, this.RDo);
            }
            return Ig;
        }

        @Override // com.google.a.a.e
        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int yT = aVar.yT();
                switch (yT) {
                    case 0:
                        break;
                    case 10:
                        this.RDo = aVar.readString();
                        break;
                    default:
                        if (com.google.a.a.g.a(aVar, yT)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }
    }

    public static final class l extends com.google.a.a.e {
        public int GXO = 0;
        public long GXP = 0;
        public byte[] RDF = com.google.a.a.g.cbu;
        public bg RDs = null;
        public int RDu = 0;
        public String groupId = "";

        public l() {
            this.cbo = -1;
        }

        @Override // com.google.a.a.e
        public final void a(com.google.a.a.b bVar) {
            if (!this.groupId.equals("")) {
                bVar.e(1, this.groupId);
            }
            if (this.GXO != 0) {
                bVar.bs(2, this.GXO);
            }
            if (this.GXP != 0) {
                bVar.q(3, this.GXP);
            }
            if (this.RDs != null) {
                bVar.a(4, this.RDs);
            }
            if (this.RDu != 0) {
                bVar.bB(5, this.RDu);
            }
            if (!Arrays.equals(this.RDF, com.google.a.a.g.cbu)) {
                bVar.b(200, this.RDF);
            }
            super.a(bVar);
        }

        @Override // com.google.a.a.e
        public final int Ig() {
            int Ig = super.Ig();
            if (!this.groupId.equals("")) {
                Ig += com.google.a.a.b.f(1, this.groupId);
            }
            if (this.GXO != 0) {
                Ig += com.google.a.a.b.bu(2, this.GXO);
            }
            if (this.GXP != 0) {
                Ig += com.google.a.a.b.r(3, this.GXP);
            }
            if (this.RDs != null) {
                Ig += com.google.a.a.b.b(4, this.RDs);
            }
            if (this.RDu != 0) {
                Ig += com.google.a.a.b.bC(5, this.RDu);
            }
            if (!Arrays.equals(this.RDF, com.google.a.a.g.cbu)) {
                return Ig + com.google.a.a.b.c(200, this.RDF);
            }
            return Ig;
        }

        @Override // com.google.a.a.e
        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int yT = aVar.yT();
                switch (yT) {
                    case 0:
                        break;
                    case 10:
                        this.groupId = aVar.readString();
                        break;
                    case 16:
                        this.GXO = aVar.zi();
                        break;
                    case 24:
                        this.GXP = aVar.zl();
                        break;
                    case 34:
                        if (this.RDs == null) {
                            this.RDs = new bg();
                        }
                        aVar.a(this.RDs);
                        break;
                    case 40:
                        this.RDu = aVar.zi();
                        break;
                    case 1602:
                        this.RDF = aVar.readBytes();
                        break;
                    default:
                        if (com.google.a.a.g.a(aVar, yT)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }
    }

    public static final class ak extends com.google.a.a.e {
        public int GXO = 0;
        public long GXP = 0;
        public ay RDY = null;
        public az RDq = null;
        public bb[] REK = bb.hjl();
        public q[] REL = q.hjd();
        public bc[] REM = bc.hjm();
        public int REN = 0;
        public int[] REO = com.google.a.a.g.bYn;
        public bb[] REe = bb.hjl();
        public String groupId = "";

        @Override // com.google.a.a.e
        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            int length;
            int length2;
            int length3;
            int length4;
            int length5;
            while (true) {
                int yT = aVar.yT();
                switch (yT) {
                    case 0:
                        break;
                    case 10:
                        this.groupId = aVar.readString();
                        break;
                    case 16:
                        this.GXO = aVar.zi();
                        break;
                    case 24:
                        this.GXP = aVar.zl();
                        break;
                    case 34:
                        int b2 = com.google.a.a.g.b(aVar, 34);
                        if (this.REL == null) {
                            length5 = 0;
                        } else {
                            length5 = this.REL.length;
                        }
                        q[] qVarArr = new q[(b2 + length5)];
                        if (length5 != 0) {
                            System.arraycopy(this.REL, 0, qVarArr, 0, length5);
                        }
                        while (length5 < qVarArr.length - 1) {
                            qVarArr[length5] = new q();
                            aVar.a(qVarArr[length5]);
                            aVar.yT();
                            length5++;
                        }
                        qVarArr[length5] = new q();
                        aVar.a(qVarArr[length5]);
                        this.REL = qVarArr;
                        break;
                    case 42:
                        if (this.RDY == null) {
                            this.RDY = new ay();
                        }
                        aVar.a(this.RDY);
                        break;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
                        this.REN = aVar.zi();
                        break;
                    case 56:
                        int b3 = com.google.a.a.g.b(aVar, 56);
                        if (this.REO == null) {
                            length4 = 0;
                        } else {
                            length4 = this.REO.length;
                        }
                        int[] iArr = new int[(b3 + length4)];
                        if (length4 != 0) {
                            System.arraycopy(this.REO, 0, iArr, 0, length4);
                        }
                        while (length4 < iArr.length - 1) {
                            iArr[length4] = aVar.zi();
                            aVar.yT();
                            length4++;
                        }
                        iArr[length4] = aVar.zi();
                        this.REO = iArr;
                        break;
                    case 58:
                        int fH = aVar.fH(aVar.zi());
                        int position = aVar.getPosition();
                        int i2 = 0;
                        while (aVar.zk() > 0) {
                            aVar.zi();
                            i2++;
                        }
                        aVar.gZ(position);
                        int length6 = this.REO == null ? 0 : this.REO.length;
                        int[] iArr2 = new int[(i2 + length6)];
                        if (length6 != 0) {
                            System.arraycopy(this.REO, 0, iArr2, 0, length6);
                        }
                        while (length6 < iArr2.length) {
                            iArr2[length6] = aVar.zi();
                            length6++;
                        }
                        this.REO = iArr2;
                        aVar.fI(fH);
                        break;
                    case 1602:
                        int b4 = com.google.a.a.g.b(aVar, 1602);
                        if (this.REK == null) {
                            length3 = 0;
                        } else {
                            length3 = this.REK.length;
                        }
                        bb[] bbVarArr = new bb[(b4 + length3)];
                        if (length3 != 0) {
                            System.arraycopy(this.REK, 0, bbVarArr, 0, length3);
                        }
                        while (length3 < bbVarArr.length - 1) {
                            bbVarArr[length3] = new bb();
                            aVar.a(bbVarArr[length3]);
                            aVar.yT();
                            length3++;
                        }
                        bbVarArr[length3] = new bb();
                        aVar.a(bbVarArr[length3]);
                        this.REK = bbVarArr;
                        break;
                    case 1610:
                        int b5 = com.google.a.a.g.b(aVar, 1610);
                        if (this.REM == null) {
                            length2 = 0;
                        } else {
                            length2 = this.REM.length;
                        }
                        bc[] bcVarArr = new bc[(b5 + length2)];
                        if (length2 != 0) {
                            System.arraycopy(this.REM, 0, bcVarArr, 0, length2);
                        }
                        while (length2 < bcVarArr.length - 1) {
                            bcVarArr[length2] = new bc();
                            aVar.a(bcVarArr[length2]);
                            aVar.yT();
                            length2++;
                        }
                        bcVarArr[length2] = new bc();
                        aVar.a(bcVarArr[length2]);
                        this.REM = bcVarArr;
                        break;
                    case 1618:
                        if (this.RDq == null) {
                            this.RDq = new az();
                        }
                        aVar.a(this.RDq);
                        break;
                    case 1626:
                        int b6 = com.google.a.a.g.b(aVar, 1626);
                        if (this.REe == null) {
                            length = 0;
                        } else {
                            length = this.REe.length;
                        }
                        bb[] bbVarArr2 = new bb[(b6 + length)];
                        if (length != 0) {
                            System.arraycopy(this.REe, 0, bbVarArr2, 0, length);
                        }
                        while (length < bbVarArr2.length - 1) {
                            bbVarArr2[length] = new bb();
                            aVar.a(bbVarArr2[length]);
                            aVar.yT();
                            length++;
                        }
                        bbVarArr2[length] = new bb();
                        aVar.a(bbVarArr2[length]);
                        this.REe = bbVarArr2;
                        break;
                    default:
                        if (com.google.a.a.g.a(aVar, yT)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        public ak() {
            this.cbo = -1;
        }

        @Override // com.google.a.a.e
        public final void a(com.google.a.a.b bVar) {
            if (!this.groupId.equals("")) {
                bVar.e(1, this.groupId);
            }
            if (this.GXO != 0) {
                bVar.bs(2, this.GXO);
            }
            if (this.GXP != 0) {
                bVar.q(3, this.GXP);
            }
            if (this.REL != null && this.REL.length > 0) {
                for (int i2 = 0; i2 < this.REL.length; i2++) {
                    q qVar = this.REL[i2];
                    if (qVar != null) {
                        bVar.a(4, qVar);
                    }
                }
            }
            if (this.RDY != null) {
                bVar.a(5, this.RDY);
            }
            if (this.REN != 0) {
                bVar.bs(6, this.REN);
            }
            if (this.REO != null && this.REO.length > 0) {
                for (int i3 = 0; i3 < this.REO.length; i3++) {
                    bVar.bs(7, this.REO[i3]);
                }
            }
            if (this.REK != null && this.REK.length > 0) {
                for (int i4 = 0; i4 < this.REK.length; i4++) {
                    bb bbVar = this.REK[i4];
                    if (bbVar != null) {
                        bVar.a(200, bbVar);
                    }
                }
            }
            if (this.REM != null && this.REM.length > 0) {
                for (int i5 = 0; i5 < this.REM.length; i5++) {
                    bc bcVar = this.REM[i5];
                    if (bcVar != null) {
                        bVar.a(201, bcVar);
                    }
                }
            }
            if (this.RDq != null) {
                bVar.a(202, this.RDq);
            }
            if (this.REe != null && this.REe.length > 0) {
                for (int i6 = 0; i6 < this.REe.length; i6++) {
                    bb bbVar2 = this.REe[i6];
                    if (bbVar2 != null) {
                        bVar.a(203, bbVar2);
                    }
                }
            }
            super.a(bVar);
        }

        @Override // com.google.a.a.e
        public final int Ig() {
            int Ig = super.Ig();
            if (!this.groupId.equals("")) {
                Ig += com.google.a.a.b.f(1, this.groupId);
            }
            if (this.GXO != 0) {
                Ig += com.google.a.a.b.bu(2, this.GXO);
            }
            if (this.GXP != 0) {
                Ig += com.google.a.a.b.r(3, this.GXP);
            }
            if (this.REL != null && this.REL.length > 0) {
                int i2 = Ig;
                for (int i3 = 0; i3 < this.REL.length; i3++) {
                    q qVar = this.REL[i3];
                    if (qVar != null) {
                        i2 += com.google.a.a.b.b(4, qVar);
                    }
                }
                Ig = i2;
            }
            if (this.RDY != null) {
                Ig += com.google.a.a.b.b(5, this.RDY);
            }
            if (this.REN != 0) {
                Ig += com.google.a.a.b.bu(6, this.REN);
            }
            if (this.REO != null && this.REO.length > 0) {
                int i4 = 0;
                for (int i5 = 0; i5 < this.REO.length; i5++) {
                    i4 += com.google.a.a.b.fT(this.REO[i5]);
                }
                Ig = Ig + i4 + (this.REO.length * 1);
            }
            if (this.REK != null && this.REK.length > 0) {
                int i6 = Ig;
                for (int i7 = 0; i7 < this.REK.length; i7++) {
                    bb bbVar = this.REK[i7];
                    if (bbVar != null) {
                        i6 += com.google.a.a.b.b(200, bbVar);
                    }
                }
                Ig = i6;
            }
            if (this.REM != null && this.REM.length > 0) {
                int i8 = Ig;
                for (int i9 = 0; i9 < this.REM.length; i9++) {
                    bc bcVar = this.REM[i9];
                    if (bcVar != null) {
                        i8 += com.google.a.a.b.b(201, bcVar);
                    }
                }
                Ig = i8;
            }
            if (this.RDq != null) {
                Ig += com.google.a.a.b.b(202, this.RDq);
            }
            if (this.REe != null && this.REe.length > 0) {
                for (int i10 = 0; i10 < this.REe.length; i10++) {
                    bb bbVar2 = this.REe[i10];
                    if (bbVar2 != null) {
                        Ig += com.google.a.a.b.b(203, bbVar2);
                    }
                }
            }
            return Ig;
        }
    }

    public static final class ae extends com.google.a.a.e {
        public az RDq = null;
        public int REZ = 0;
        public String groupId = "";

        public ae() {
            this.cbo = -1;
        }

        @Override // com.google.a.a.e
        public final void a(com.google.a.a.b bVar) {
            if (!this.groupId.equals("")) {
                bVar.e(1, this.groupId);
            }
            if (this.RDq != null) {
                bVar.a(2, this.RDq);
            }
            if (this.REZ != 0) {
                bVar.bs(3, this.REZ);
            }
            super.a(bVar);
        }

        @Override // com.google.a.a.e
        public final int Ig() {
            int Ig = super.Ig();
            if (!this.groupId.equals("")) {
                Ig += com.google.a.a.b.f(1, this.groupId);
            }
            if (this.RDq != null) {
                Ig += com.google.a.a.b.b(2, this.RDq);
            }
            if (this.REZ != 0) {
                return Ig + com.google.a.a.b.bu(3, this.REZ);
            }
            return Ig;
        }

        @Override // com.google.a.a.e
        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int yT = aVar.yT();
                switch (yT) {
                    case 0:
                        break;
                    case 10:
                        this.groupId = aVar.readString();
                        break;
                    case 18:
                        if (this.RDq == null) {
                            this.RDq = new az();
                        }
                        aVar.a(this.RDq);
                        break;
                    case 24:
                        this.REZ = aVar.zi();
                        break;
                    default:
                        if (com.google.a.a.g.a(aVar, yT)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }
    }

    public static final class bf extends com.google.a.a.e {
        private static volatile bf[] RGF;
        public int RGG = 0;
        public int RGH = 0;
        public int RGI = 0;
        public int qwL = 0;
        public int rtt = 0;

        public static bf[] hjn() {
            if (RGF == null) {
                synchronized (com.google.a.a.c.cbn) {
                    if (RGF == null) {
                        RGF = new bf[0];
                    }
                }
            }
            return RGF;
        }

        public bf() {
            this.cbo = -1;
        }

        @Override // com.google.a.a.e
        public final void a(com.google.a.a.b bVar) {
            if (this.qwL != 0) {
                bVar.bs(1, this.qwL);
            }
            if (this.rtt != 0) {
                bVar.bs(2, this.rtt);
            }
            if (this.RGG != 0) {
                bVar.bs(3, this.RGG);
            }
            if (this.RGH != 0) {
                bVar.bs(4, this.RGH);
            }
            if (this.RGI != 0) {
                bVar.bs(5, this.RGI);
            }
            super.a(bVar);
        }

        @Override // com.google.a.a.e
        public final int Ig() {
            int Ig = super.Ig();
            if (this.qwL != 0) {
                Ig += com.google.a.a.b.bu(1, this.qwL);
            }
            if (this.rtt != 0) {
                Ig += com.google.a.a.b.bu(2, this.rtt);
            }
            if (this.RGG != 0) {
                Ig += com.google.a.a.b.bu(3, this.RGG);
            }
            if (this.RGH != 0) {
                Ig += com.google.a.a.b.bu(4, this.RGH);
            }
            if (this.RGI != 0) {
                return Ig + com.google.a.a.b.bu(5, this.RGI);
            }
            return Ig;
        }

        @Override // com.google.a.a.e
        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int yT = aVar.yT();
                switch (yT) {
                    case 0:
                        break;
                    case 8:
                        this.qwL = aVar.zi();
                        break;
                    case 16:
                        this.rtt = aVar.zi();
                        break;
                    case 24:
                        this.RGG = aVar.zi();
                        break;
                    case 32:
                        this.RGH = aVar.zi();
                        break;
                    case 40:
                        this.RGI = aVar.zi();
                        break;
                    default:
                        if (com.google.a.a.g.a(aVar, yT)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }
    }

    public static final class ap extends com.google.a.a.e {
        public byte[] buffer = com.google.a.a.g.cbu;
        public int iLen = 0;

        public ap() {
            this.cbo = -1;
        }

        @Override // com.google.a.a.e
        public final void a(com.google.a.a.b bVar) {
            bVar.bB(1, this.iLen);
            if (!Arrays.equals(this.buffer, com.google.a.a.g.cbu)) {
                bVar.b(2, this.buffer);
            }
            super.a(bVar);
        }

        @Override // com.google.a.a.e
        public final int Ig() {
            int Ig = super.Ig() + com.google.a.a.b.bC(1, this.iLen);
            if (!Arrays.equals(this.buffer, com.google.a.a.g.cbu)) {
                return Ig + com.google.a.a.b.c(2, this.buffer);
            }
            return Ig;
        }

        @Override // com.google.a.a.e
        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int yT = aVar.yT();
                switch (yT) {
                    case 0:
                        break;
                    case 8:
                        this.iLen = aVar.zi();
                        break;
                    case 18:
                        this.buffer = aVar.readBytes();
                        break;
                    default:
                        if (com.google.a.a.g.a(aVar, yT)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }
    }

    public static final class au extends com.google.a.a.e {
        private static volatile au[] RFp;
        public int LGa = 0;
        public int RFq = 0;
        public int fps = 0;
        public int qrD = 0;

        public static au[] hji() {
            if (RFp == null) {
                synchronized (com.google.a.a.c.cbn) {
                    if (RFp == null) {
                        RFp = new au[0];
                    }
                }
            }
            return RFp;
        }

        public au() {
            this.cbo = -1;
        }

        @Override // com.google.a.a.e
        public final void a(com.google.a.a.b bVar) {
            if (this.qrD != 0) {
                bVar.bs(1, this.qrD);
            }
            if (this.RFq != 0) {
                bVar.bs(2, this.RFq);
            }
            if (this.fps != 0) {
                bVar.bs(3, this.fps);
            }
            if (this.LGa != 0) {
                bVar.bs(4, this.LGa);
            }
            super.a(bVar);
        }

        @Override // com.google.a.a.e
        public final int Ig() {
            int Ig = super.Ig();
            if (this.qrD != 0) {
                Ig += com.google.a.a.b.bu(1, this.qrD);
            }
            if (this.RFq != 0) {
                Ig += com.google.a.a.b.bu(2, this.RFq);
            }
            if (this.fps != 0) {
                Ig += com.google.a.a.b.bu(3, this.fps);
            }
            if (this.LGa != 0) {
                return Ig + com.google.a.a.b.bu(4, this.LGa);
            }
            return Ig;
        }

        @Override // com.google.a.a.e
        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int yT = aVar.yT();
                switch (yT) {
                    case 0:
                        break;
                    case 8:
                        this.qrD = aVar.zi();
                        break;
                    case 16:
                        this.RFq = aVar.zi();
                        break;
                    case 24:
                        this.fps = aVar.zi();
                        break;
                    case 32:
                        this.LGa = aVar.zi();
                        break;
                    default:
                        if (com.google.a.a.g.a(aVar, yT)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }
    }

    public static final class n extends com.google.a.a.e {
        public int GXO = 0;
        public long GXP = 0;
        public int RDH = 0;
        public byte[] RDI = com.google.a.a.g.cbu;
        public bf[] RDJ = bf.hjn();
        public au[] RDK = au.hji();
        public int RDL = 0;
        public int RDM = 0;
        public String groupId = "";
        public int jqs = 0;
        public int qrD = -1;

        @Override // com.google.a.a.e
        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            int length;
            int length2;
            while (true) {
                int yT = aVar.yT();
                switch (yT) {
                    case 0:
                        break;
                    case 10:
                        this.groupId = aVar.readString();
                        break;
                    case 16:
                        this.GXO = aVar.zi();
                        break;
                    case 24:
                        this.GXP = aVar.zl();
                        break;
                    case 32:
                        this.qrD = aVar.zi();
                        break;
                    case 40:
                        this.RDH = aVar.zi();
                        break;
                    case 50:
                        this.RDI = aVar.readBytes();
                        break;
                    case 58:
                        int b2 = com.google.a.a.g.b(aVar, 58);
                        if (this.RDJ == null) {
                            length2 = 0;
                        } else {
                            length2 = this.RDJ.length;
                        }
                        bf[] bfVarArr = new bf[(b2 + length2)];
                        if (length2 != 0) {
                            System.arraycopy(this.RDJ, 0, bfVarArr, 0, length2);
                        }
                        while (length2 < bfVarArr.length - 1) {
                            bfVarArr[length2] = new bf();
                            aVar.a(bfVarArr[length2]);
                            aVar.yT();
                            length2++;
                        }
                        bfVarArr[length2] = new bf();
                        aVar.a(bfVarArr[length2]);
                        this.RDJ = bfVarArr;
                        break;
                    case 66:
                        int b3 = com.google.a.a.g.b(aVar, 66);
                        if (this.RDK == null) {
                            length = 0;
                        } else {
                            length = this.RDK.length;
                        }
                        au[] auVarArr = new au[(b3 + length)];
                        if (length != 0) {
                            System.arraycopy(this.RDK, 0, auVarArr, 0, length);
                        }
                        while (length < auVarArr.length - 1) {
                            auVarArr[length] = new au();
                            aVar.a(auVarArr[length]);
                            aVar.yT();
                            length++;
                        }
                        auVarArr[length] = new au();
                        aVar.a(auVarArr[length]);
                        this.RDK = auVarArr;
                        break;
                    case 72:
                        this.RDL = aVar.zi();
                        break;
                    case PlayerException.EXCEPTION_TYPE_CONNECT_FAIL /*{ENCODED_INT: 80}*/:
                        this.RDM = aVar.zi();
                        break;
                    case TPCodecParamers.TP_PROFILE_H264_EXTENDED /*{ENCODED_INT: 88}*/:
                        this.jqs = aVar.zi();
                        break;
                    default:
                        if (com.google.a.a.g.a(aVar, yT)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        public n() {
            this.cbo = -1;
        }

        @Override // com.google.a.a.e
        public final void a(com.google.a.a.b bVar) {
            if (!this.groupId.equals("")) {
                bVar.e(1, this.groupId);
            }
            if (this.GXO != 0) {
                bVar.bs(2, this.GXO);
            }
            if (this.GXP != 0) {
                bVar.q(3, this.GXP);
            }
            if (this.qrD != -1) {
                bVar.bs(4, this.qrD);
            }
            if (this.RDH != 0) {
                bVar.bs(5, this.RDH);
            }
            if (!Arrays.equals(this.RDI, com.google.a.a.g.cbu)) {
                bVar.b(6, this.RDI);
            }
            if (this.RDJ != null && this.RDJ.length > 0) {
                for (int i2 = 0; i2 < this.RDJ.length; i2++) {
                    bf bfVar = this.RDJ[i2];
                    if (bfVar != null) {
                        bVar.a(7, bfVar);
                    }
                }
            }
            if (this.RDK != null && this.RDK.length > 0) {
                for (int i3 = 0; i3 < this.RDK.length; i3++) {
                    au auVar = this.RDK[i3];
                    if (auVar != null) {
                        bVar.a(8, auVar);
                    }
                }
            }
            if (this.RDL != 0) {
                bVar.bs(9, this.RDL);
            }
            if (this.RDM != 0) {
                bVar.bs(10, this.RDM);
            }
            if (this.jqs != 0) {
                bVar.bs(11, this.jqs);
            }
            super.a(bVar);
        }

        @Override // com.google.a.a.e
        public final int Ig() {
            int Ig = super.Ig();
            if (!this.groupId.equals("")) {
                Ig += com.google.a.a.b.f(1, this.groupId);
            }
            if (this.GXO != 0) {
                Ig += com.google.a.a.b.bu(2, this.GXO);
            }
            if (this.GXP != 0) {
                Ig += com.google.a.a.b.r(3, this.GXP);
            }
            if (this.qrD != -1) {
                Ig += com.google.a.a.b.bu(4, this.qrD);
            }
            if (this.RDH != 0) {
                Ig += com.google.a.a.b.bu(5, this.RDH);
            }
            if (!Arrays.equals(this.RDI, com.google.a.a.g.cbu)) {
                Ig += com.google.a.a.b.c(6, this.RDI);
            }
            if (this.RDJ != null && this.RDJ.length > 0) {
                int i2 = Ig;
                for (int i3 = 0; i3 < this.RDJ.length; i3++) {
                    bf bfVar = this.RDJ[i3];
                    if (bfVar != null) {
                        i2 += com.google.a.a.b.b(7, bfVar);
                    }
                }
                Ig = i2;
            }
            if (this.RDK != null && this.RDK.length > 0) {
                for (int i4 = 0; i4 < this.RDK.length; i4++) {
                    au auVar = this.RDK[i4];
                    if (auVar != null) {
                        Ig += com.google.a.a.b.b(8, auVar);
                    }
                }
            }
            if (this.RDL != 0) {
                Ig += com.google.a.a.b.bu(9, this.RDL);
            }
            if (this.RDM != 0) {
                Ig += com.google.a.a.b.bu(10, this.RDM);
            }
            if (this.jqs != 0) {
                return Ig + com.google.a.a.b.bu(11, this.jqs);
            }
            return Ig;
        }
    }

    public static final class ao extends com.google.a.a.e {
        public int GXO = 0;
        public long GXP = 0;
        public String groupId = "";

        public ao() {
            this.cbo = -1;
        }

        @Override // com.google.a.a.e
        public final void a(com.google.a.a.b bVar) {
            if (!this.groupId.equals("")) {
                bVar.e(1, this.groupId);
            }
            if (this.GXO != 0) {
                bVar.bs(2, this.GXO);
            }
            if (this.GXP != 0) {
                bVar.q(3, this.GXP);
            }
            super.a(bVar);
        }

        @Override // com.google.a.a.e
        public final int Ig() {
            int Ig = super.Ig();
            if (!this.groupId.equals("")) {
                Ig += com.google.a.a.b.f(1, this.groupId);
            }
            if (this.GXO != 0) {
                Ig += com.google.a.a.b.bu(2, this.GXO);
            }
            if (this.GXP != 0) {
                return Ig + com.google.a.a.b.r(3, this.GXP);
            }
            return Ig;
        }

        @Override // com.google.a.a.e
        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int yT = aVar.yT();
                switch (yT) {
                    case 0:
                        break;
                    case 10:
                        this.groupId = aVar.readString();
                        break;
                    case 16:
                        this.GXO = aVar.zi();
                        break;
                    case 24:
                        this.GXP = aVar.zl();
                        break;
                    default:
                        if (com.google.a.a.g.a(aVar, yT)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }
    }

    public static final class o extends com.google.a.a.e {
        private static volatile o[] RDN;
        public int KBb = 0;
        public String RDO = "";
        public String nickname = "";

        public static o[] hjb() {
            if (RDN == null) {
                synchronized (com.google.a.a.c.cbn) {
                    if (RDN == null) {
                        RDN = new o[0];
                    }
                }
            }
            return RDN;
        }

        public o() {
            this.cbo = -1;
        }

        @Override // com.google.a.a.e
        public final void a(com.google.a.a.b bVar) {
            if (this.KBb != 0) {
                bVar.bB(1, this.KBb);
            }
            if (!this.nickname.equals("")) {
                bVar.e(2, this.nickname);
            }
            if (!this.RDO.equals("")) {
                bVar.e(3, this.RDO);
            }
            super.a(bVar);
        }

        @Override // com.google.a.a.e
        public final int Ig() {
            int Ig = super.Ig();
            if (this.KBb != 0) {
                Ig += com.google.a.a.b.bC(1, this.KBb);
            }
            if (!this.nickname.equals("")) {
                Ig += com.google.a.a.b.f(2, this.nickname);
            }
            if (!this.RDO.equals("")) {
                return Ig + com.google.a.a.b.f(3, this.RDO);
            }
            return Ig;
        }

        @Override // com.google.a.a.e
        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int yT = aVar.yT();
                switch (yT) {
                    case 0:
                        break;
                    case 8:
                        this.KBb = aVar.zi();
                        break;
                    case 18:
                        this.nickname = aVar.readString();
                        break;
                    case 26:
                        this.RDO = aVar.readString();
                        break;
                    default:
                        if (com.google.a.a.g.a(aVar, yT)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }
    }

    public static final class e extends com.google.a.a.e {
        public int GXO = 0;
        public long GXP = 0;
        public u RDA = null;
        public int RDB = 0;
        public int RDm = 0;
        public az RDq = null;
        public bg RDs = null;
        public int RDu = 0;
        public String[] RDx = com.google.a.a.g.EMPTY_STRING_ARRAY;
        public o[] RDy = o.hjb();
        public int RDz = 0;
        public String groupId = "";
        public int netType = 0;
        public int vkj = 0;

        @Override // com.google.a.a.e
        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            int length;
            while (true) {
                int yT = aVar.yT();
                switch (yT) {
                    case 0:
                        break;
                    case 10:
                        this.groupId = aVar.readString();
                        break;
                    case 16:
                        this.GXO = aVar.zi();
                        break;
                    case 24:
                        this.GXP = aVar.zl();
                        break;
                    case 34:
                        if (this.RDs == null) {
                            this.RDs = new bg();
                        }
                        aVar.a(this.RDs);
                        break;
                    case 40:
                        this.vkj = aVar.zi();
                        break;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
                        this.RDu = aVar.zi();
                        break;
                    case 56:
                        this.RDm = aVar.zi();
                        break;
                    case 64:
                        this.netType = aVar.zi();
                        break;
                    case 1602:
                        if (this.RDq == null) {
                            this.RDq = new az();
                        }
                        aVar.a(this.RDq);
                        break;
                    case 1610:
                        int b2 = com.google.a.a.g.b(aVar, 1610);
                        int length2 = this.RDx == null ? 0 : this.RDx.length;
                        String[] strArr = new String[(b2 + length2)];
                        if (length2 != 0) {
                            System.arraycopy(this.RDx, 0, strArr, 0, length2);
                        }
                        while (length2 < strArr.length - 1) {
                            strArr[length2] = aVar.readString();
                            aVar.yT();
                            length2++;
                        }
                        strArr[length2] = aVar.readString();
                        this.RDx = strArr;
                        break;
                    case 1618:
                        int b3 = com.google.a.a.g.b(aVar, 1618);
                        if (this.RDy == null) {
                            length = 0;
                        } else {
                            length = this.RDy.length;
                        }
                        o[] oVarArr = new o[(b3 + length)];
                        if (length != 0) {
                            System.arraycopy(this.RDy, 0, oVarArr, 0, length);
                        }
                        while (length < oVarArr.length - 1) {
                            oVarArr[length] = new o();
                            aVar.a(oVarArr[length]);
                            aVar.yT();
                            length++;
                        }
                        oVarArr[length] = new o();
                        aVar.a(oVarArr[length]);
                        this.RDy = oVarArr;
                        break;
                    case 1626:
                        if (this.RDA == null) {
                            this.RDA = new u();
                        }
                        aVar.a(this.RDA);
                        break;
                    case 1632:
                        this.RDB = aVar.zi();
                        break;
                    case 1920:
                        this.RDz = aVar.zi();
                        break;
                    default:
                        if (com.google.a.a.g.a(aVar, yT)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        public e() {
            this.cbo = -1;
        }

        @Override // com.google.a.a.e
        public final void a(com.google.a.a.b bVar) {
            if (!this.groupId.equals("")) {
                bVar.e(1, this.groupId);
            }
            if (this.GXO != 0) {
                bVar.bs(2, this.GXO);
            }
            if (this.GXP != 0) {
                bVar.q(3, this.GXP);
            }
            if (this.RDs != null) {
                bVar.a(4, this.RDs);
            }
            if (this.vkj != 0) {
                bVar.bs(5, this.vkj);
            }
            if (this.RDu != 0) {
                bVar.bB(6, this.RDu);
            }
            if (this.RDm != 0) {
                bVar.bs(7, this.RDm);
            }
            if (this.netType != 0) {
                bVar.bB(8, this.netType);
            }
            if (this.RDq != null) {
                bVar.a(200, this.RDq);
            }
            if (this.RDx != null && this.RDx.length > 0) {
                for (int i2 = 0; i2 < this.RDx.length; i2++) {
                    String str = this.RDx[i2];
                    if (str != null) {
                        bVar.e(201, str);
                    }
                }
            }
            if (this.RDy != null && this.RDy.length > 0) {
                for (int i3 = 0; i3 < this.RDy.length; i3++) {
                    o oVar = this.RDy[i3];
                    if (oVar != null) {
                        bVar.a(202, oVar);
                    }
                }
            }
            if (this.RDA != null) {
                bVar.a(203, this.RDA);
            }
            if (this.RDB != 0) {
                bVar.bB(204, this.RDB);
            }
            if (this.RDz != 0) {
                bVar.bB(240, this.RDz);
            }
            super.a(bVar);
        }

        @Override // com.google.a.a.e
        public final int Ig() {
            int Ig = super.Ig();
            if (!this.groupId.equals("")) {
                Ig += com.google.a.a.b.f(1, this.groupId);
            }
            if (this.GXO != 0) {
                Ig += com.google.a.a.b.bu(2, this.GXO);
            }
            if (this.GXP != 0) {
                Ig += com.google.a.a.b.r(3, this.GXP);
            }
            if (this.RDs != null) {
                Ig += com.google.a.a.b.b(4, this.RDs);
            }
            if (this.vkj != 0) {
                Ig += com.google.a.a.b.bu(5, this.vkj);
            }
            if (this.RDu != 0) {
                Ig += com.google.a.a.b.bC(6, this.RDu);
            }
            if (this.RDm != 0) {
                Ig += com.google.a.a.b.bu(7, this.RDm);
            }
            if (this.netType != 0) {
                Ig += com.google.a.a.b.bC(8, this.netType);
            }
            if (this.RDq != null) {
                Ig += com.google.a.a.b.b(200, this.RDq);
            }
            if (this.RDx != null && this.RDx.length > 0) {
                int i2 = 0;
                int i3 = 0;
                for (int i4 = 0; i4 < this.RDx.length; i4++) {
                    String str = this.RDx[i4];
                    if (str != null) {
                        i3++;
                        i2 += com.google.a.a.b.cb(str);
                    }
                }
                Ig = Ig + i2 + (i3 * 2);
            }
            if (this.RDy != null && this.RDy.length > 0) {
                for (int i5 = 0; i5 < this.RDy.length; i5++) {
                    o oVar = this.RDy[i5];
                    if (oVar != null) {
                        Ig += com.google.a.a.b.b(202, oVar);
                    }
                }
            }
            if (this.RDA != null) {
                Ig += com.google.a.a.b.b(203, this.RDA);
            }
            if (this.RDB != 0) {
                Ig += com.google.a.a.b.bC(204, this.RDB);
            }
            if (this.RDz != 0) {
                return Ig + com.google.a.a.b.bC(240, this.RDz);
            }
            return Ig;
        }
    }

    public static final class ac extends com.google.a.a.e {
        public int GXO = 0;
        public long GXP = 0;
        public int Lnt = -1;
        public int RDQ = 0;
        public ay RDY = null;
        public az RDq = null;
        public bb[] REK = bb.hjl();
        public q[] REL = q.hjd();
        public bc[] REM = bc.hjm();
        public int REN = 0;
        public int[] REO = com.google.a.a.g.bYn;
        public q[] REP = q.hjd();
        public int REQ = 0;
        public int RER = 0;
        public q[] RES = q.hjd();
        public int RET = 0;
        public int REU = 0;
        public int REW = 0;
        public byte[] REX = com.google.a.a.g.cbu;
        public int[] REY = com.google.a.a.g.bYn;
        public int REa = 0;
        public bb[] REe = bb.hjl();
        public String groupId = "";
        public int vkj = 0;

        @Override // com.google.a.a.e
        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            int length;
            int length2;
            int length3;
            int length4;
            int length5;
            int length6;
            int length7;
            int length8;
            while (true) {
                int yT = aVar.yT();
                switch (yT) {
                    case 0:
                        break;
                    case 10:
                        this.groupId = aVar.readString();
                        break;
                    case 16:
                        this.GXO = aVar.zi();
                        break;
                    case 24:
                        this.GXP = aVar.zl();
                        break;
                    case 34:
                        int b2 = com.google.a.a.g.b(aVar, 34);
                        if (this.REL == null) {
                            length8 = 0;
                        } else {
                            length8 = this.REL.length;
                        }
                        q[] qVarArr = new q[(b2 + length8)];
                        if (length8 != 0) {
                            System.arraycopy(this.REL, 0, qVarArr, 0, length8);
                        }
                        while (length8 < qVarArr.length - 1) {
                            qVarArr[length8] = new q();
                            aVar.a(qVarArr[length8]);
                            aVar.yT();
                            length8++;
                        }
                        qVarArr[length8] = new q();
                        aVar.a(qVarArr[length8]);
                        this.REL = qVarArr;
                        break;
                    case 42:
                        int b3 = com.google.a.a.g.b(aVar, 42);
                        if (this.REK == null) {
                            length7 = 0;
                        } else {
                            length7 = this.REK.length;
                        }
                        bb[] bbVarArr = new bb[(b3 + length7)];
                        if (length7 != 0) {
                            System.arraycopy(this.REK, 0, bbVarArr, 0, length7);
                        }
                        while (length7 < bbVarArr.length - 1) {
                            bbVarArr[length7] = new bb();
                            aVar.a(bbVarArr[length7]);
                            aVar.yT();
                            length7++;
                        }
                        bbVarArr[length7] = new bb();
                        aVar.a(bbVarArr[length7]);
                        this.REK = bbVarArr;
                        break;
                    case 50:
                        if (this.RDY == null) {
                            this.RDY = new ay();
                        }
                        aVar.a(this.RDY);
                        break;
                    case 56:
                        this.REN = aVar.zi();
                        break;
                    case 64:
                        int b4 = com.google.a.a.g.b(aVar, 64);
                        if (this.REO == null) {
                            length6 = 0;
                        } else {
                            length6 = this.REO.length;
                        }
                        int[] iArr = new int[(b4 + length6)];
                        if (length6 != 0) {
                            System.arraycopy(this.REO, 0, iArr, 0, length6);
                        }
                        while (length6 < iArr.length - 1) {
                            iArr[length6] = aVar.zi();
                            aVar.yT();
                            length6++;
                        }
                        iArr[length6] = aVar.zi();
                        this.REO = iArr;
                        break;
                    case 66:
                        int fH = aVar.fH(aVar.zi());
                        int position = aVar.getPosition();
                        int i2 = 0;
                        while (aVar.zk() > 0) {
                            aVar.zi();
                            i2++;
                        }
                        aVar.gZ(position);
                        int length9 = this.REO == null ? 0 : this.REO.length;
                        int[] iArr2 = new int[(i2 + length9)];
                        if (length9 != 0) {
                            System.arraycopy(this.REO, 0, iArr2, 0, length9);
                        }
                        while (length9 < iArr2.length) {
                            iArr2[length9] = aVar.zi();
                            length9++;
                        }
                        this.REO = iArr2;
                        aVar.fI(fH);
                        break;
                    case 72:
                        this.vkj = aVar.zi();
                        break;
                    case PlayerException.EXCEPTION_TYPE_ERROR_CREATE_JAVA_DATASOURCE /*{ENCODED_INT: 82}*/:
                        int b5 = com.google.a.a.g.b(aVar, 82);
                        if (this.REM == null) {
                            length5 = 0;
                        } else {
                            length5 = this.REM.length;
                        }
                        bc[] bcVarArr = new bc[(b5 + length5)];
                        if (length5 != 0) {
                            System.arraycopy(this.REM, 0, bcVarArr, 0, length5);
                        }
                        while (length5 < bcVarArr.length - 1) {
                            bcVarArr[length5] = new bc();
                            aVar.a(bcVarArr[length5]);
                            aVar.yT();
                            length5++;
                        }
                        bcVarArr[length5] = new bc();
                        aVar.a(bcVarArr[length5]);
                        this.REM = bcVarArr;
                        break;
                    case 90:
                        if (this.RDq == null) {
                            this.RDq = new az();
                        }
                        aVar.a(this.RDq);
                        break;
                    case PlayerException.EXCEPTION_IN_SETAUDIOEFFECT /*{ENCODED_INT: 96}*/:
                        this.RDQ = aVar.zi();
                        break;
                    case 106:
                        int b6 = com.google.a.a.g.b(aVar, 106);
                        if (this.REP == null) {
                            length4 = 0;
                        } else {
                            length4 = this.REP.length;
                        }
                        q[] qVarArr2 = new q[(b6 + length4)];
                        if (length4 != 0) {
                            System.arraycopy(this.REP, 0, qVarArr2, 0, length4);
                        }
                        while (length4 < qVarArr2.length - 1) {
                            qVarArr2[length4] = new q();
                            aVar.a(qVarArr2[length4]);
                            aVar.yT();
                            length4++;
                        }
                        qVarArr2[length4] = new q();
                        aVar.a(qVarArr2[length4]);
                        this.REP = qVarArr2;
                        break;
                    case 114:
                        int b7 = com.google.a.a.g.b(aVar, 114);
                        if (this.RES == null) {
                            length3 = 0;
                        } else {
                            length3 = this.RES.length;
                        }
                        q[] qVarArr3 = new q[(b7 + length3)];
                        if (length3 != 0) {
                            System.arraycopy(this.RES, 0, qVarArr3, 0, length3);
                        }
                        while (length3 < qVarArr3.length - 1) {
                            qVarArr3[length3] = new q();
                            aVar.a(qVarArr3[length3]);
                            aVar.yT();
                            length3++;
                        }
                        qVarArr3[length3] = new q();
                        aVar.a(qVarArr3[length3]);
                        this.RES = qVarArr3;
                        break;
                    case 120:
                        this.RET = aVar.zi();
                        break;
                    case 128:
                        this.REU = aVar.zi();
                        break;
                    case com.tencent.mm.plugin.appbrand.jsapi.k.r.CTRL_INDEX:
                        this.REW = aVar.zi();
                        break;
                    case 146:
                        this.REX = aVar.readBytes();
                        break;
                    case 152:
                        this.Lnt = aVar.zi();
                        break;
                    case 160:
                        int b8 = com.google.a.a.g.b(aVar, 160);
                        if (this.REY == null) {
                            length2 = 0;
                        } else {
                            length2 = this.REY.length;
                        }
                        int[] iArr3 = new int[(b8 + length2)];
                        if (length2 != 0) {
                            System.arraycopy(this.REY, 0, iArr3, 0, length2);
                        }
                        while (length2 < iArr3.length - 1) {
                            iArr3[length2] = aVar.zi();
                            aVar.yT();
                            length2++;
                        }
                        iArr3[length2] = aVar.zi();
                        this.REY = iArr3;
                        break;
                    case TbsListener.ErrorCode.STARTDOWNLOAD_3 /*{ENCODED_INT: 162}*/:
                        int fH2 = aVar.fH(aVar.zi());
                        int position2 = aVar.getPosition();
                        int i3 = 0;
                        while (aVar.zk() > 0) {
                            aVar.zi();
                            i3++;
                        }
                        aVar.gZ(position2);
                        int length10 = this.REY == null ? 0 : this.REY.length;
                        int[] iArr4 = new int[(i3 + length10)];
                        if (length10 != 0) {
                            System.arraycopy(this.REY, 0, iArr4, 0, length10);
                        }
                        while (length10 < iArr4.length) {
                            iArr4[length10] = aVar.zi();
                            length10++;
                        }
                        this.REY = iArr4;
                        aVar.fI(fH2);
                        break;
                    case 168:
                        this.REa = aVar.zi();
                        break;
                    case 800:
                        this.REQ = aVar.zi();
                        break;
                    case 808:
                        this.RER = aVar.zi();
                        break;
                    case 818:
                        int b9 = com.google.a.a.g.b(aVar, 818);
                        if (this.REe == null) {
                            length = 0;
                        } else {
                            length = this.REe.length;
                        }
                        bb[] bbVarArr2 = new bb[(b9 + length)];
                        if (length != 0) {
                            System.arraycopy(this.REe, 0, bbVarArr2, 0, length);
                        }
                        while (length < bbVarArr2.length - 1) {
                            bbVarArr2[length] = new bb();
                            aVar.a(bbVarArr2[length]);
                            aVar.yT();
                            length++;
                        }
                        bbVarArr2[length] = new bb();
                        aVar.a(bbVarArr2[length]);
                        this.REe = bbVarArr2;
                        break;
                    default:
                        if (com.google.a.a.g.a(aVar, yT)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        public ac() {
            this.cbo = -1;
        }

        @Override // com.google.a.a.e
        public final void a(com.google.a.a.b bVar) {
            if (!this.groupId.equals("")) {
                bVar.e(1, this.groupId);
            }
            if (this.GXO != 0) {
                bVar.bs(2, this.GXO);
            }
            if (this.GXP != 0) {
                bVar.q(3, this.GXP);
            }
            if (this.REL != null && this.REL.length > 0) {
                for (int i2 = 0; i2 < this.REL.length; i2++) {
                    q qVar = this.REL[i2];
                    if (qVar != null) {
                        bVar.a(4, qVar);
                    }
                }
            }
            if (this.REK != null && this.REK.length > 0) {
                for (int i3 = 0; i3 < this.REK.length; i3++) {
                    bb bbVar = this.REK[i3];
                    if (bbVar != null) {
                        bVar.a(5, bbVar);
                    }
                }
            }
            if (this.RDY != null) {
                bVar.a(6, this.RDY);
            }
            if (this.REN != 0) {
                bVar.bs(7, this.REN);
            }
            if (this.REO != null && this.REO.length > 0) {
                for (int i4 = 0; i4 < this.REO.length; i4++) {
                    bVar.bs(8, this.REO[i4]);
                }
            }
            if (this.vkj != 0) {
                bVar.bs(9, this.vkj);
            }
            if (this.REM != null && this.REM.length > 0) {
                for (int i5 = 0; i5 < this.REM.length; i5++) {
                    bc bcVar = this.REM[i5];
                    if (bcVar != null) {
                        bVar.a(10, bcVar);
                    }
                }
            }
            if (this.RDq != null) {
                bVar.a(11, this.RDq);
            }
            if (this.RDQ != 0) {
                bVar.bB(12, this.RDQ);
            }
            if (this.REP != null && this.REP.length > 0) {
                for (int i6 = 0; i6 < this.REP.length; i6++) {
                    q qVar2 = this.REP[i6];
                    if (qVar2 != null) {
                        bVar.a(13, qVar2);
                    }
                }
            }
            if (this.RES != null && this.RES.length > 0) {
                for (int i7 = 0; i7 < this.RES.length; i7++) {
                    q qVar3 = this.RES[i7];
                    if (qVar3 != null) {
                        bVar.a(14, qVar3);
                    }
                }
            }
            if (this.RET != 0) {
                bVar.bs(15, this.RET);
            }
            if (this.REU != 0) {
                bVar.bs(16, this.REU);
            }
            if (this.REW != 0) {
                bVar.bs(17, this.REW);
            }
            if (!Arrays.equals(this.REX, com.google.a.a.g.cbu)) {
                bVar.b(18, this.REX);
            }
            if (this.Lnt != -1) {
                bVar.bs(19, this.Lnt);
            }
            if (this.REY != null && this.REY.length > 0) {
                for (int i8 = 0; i8 < this.REY.length; i8++) {
                    bVar.bB(20, this.REY[i8]);
                }
            }
            if (this.REa != 0) {
                bVar.bB(21, this.REa);
            }
            if (this.REQ != 0) {
                bVar.bB(100, this.REQ);
            }
            if (this.RER != 0) {
                bVar.bB(101, this.RER);
            }
            if (this.REe != null && this.REe.length > 0) {
                for (int i9 = 0; i9 < this.REe.length; i9++) {
                    bb bbVar2 = this.REe[i9];
                    if (bbVar2 != null) {
                        bVar.a(102, bbVar2);
                    }
                }
            }
            super.a(bVar);
        }

        @Override // com.google.a.a.e
        public final int Ig() {
            int Ig = super.Ig();
            if (!this.groupId.equals("")) {
                Ig += com.google.a.a.b.f(1, this.groupId);
            }
            if (this.GXO != 0) {
                Ig += com.google.a.a.b.bu(2, this.GXO);
            }
            if (this.GXP != 0) {
                Ig += com.google.a.a.b.r(3, this.GXP);
            }
            if (this.REL != null && this.REL.length > 0) {
                int i2 = Ig;
                for (int i3 = 0; i3 < this.REL.length; i3++) {
                    q qVar = this.REL[i3];
                    if (qVar != null) {
                        i2 += com.google.a.a.b.b(4, qVar);
                    }
                }
                Ig = i2;
            }
            if (this.REK != null && this.REK.length > 0) {
                int i4 = Ig;
                for (int i5 = 0; i5 < this.REK.length; i5++) {
                    bb bbVar = this.REK[i5];
                    if (bbVar != null) {
                        i4 += com.google.a.a.b.b(5, bbVar);
                    }
                }
                Ig = i4;
            }
            if (this.RDY != null) {
                Ig += com.google.a.a.b.b(6, this.RDY);
            }
            if (this.REN != 0) {
                Ig += com.google.a.a.b.bu(7, this.REN);
            }
            if (this.REO != null && this.REO.length > 0) {
                int i6 = 0;
                for (int i7 = 0; i7 < this.REO.length; i7++) {
                    i6 += com.google.a.a.b.fT(this.REO[i7]);
                }
                Ig = Ig + i6 + (this.REO.length * 1);
            }
            if (this.vkj != 0) {
                Ig += com.google.a.a.b.bu(9, this.vkj);
            }
            if (this.REM != null && this.REM.length > 0) {
                int i8 = Ig;
                for (int i9 = 0; i9 < this.REM.length; i9++) {
                    bc bcVar = this.REM[i9];
                    if (bcVar != null) {
                        i8 += com.google.a.a.b.b(10, bcVar);
                    }
                }
                Ig = i8;
            }
            if (this.RDq != null) {
                Ig += com.google.a.a.b.b(11, this.RDq);
            }
            if (this.RDQ != 0) {
                Ig += com.google.a.a.b.bC(12, this.RDQ);
            }
            if (this.REP != null && this.REP.length > 0) {
                int i10 = Ig;
                for (int i11 = 0; i11 < this.REP.length; i11++) {
                    q qVar2 = this.REP[i11];
                    if (qVar2 != null) {
                        i10 += com.google.a.a.b.b(13, qVar2);
                    }
                }
                Ig = i10;
            }
            if (this.RES != null && this.RES.length > 0) {
                int i12 = Ig;
                for (int i13 = 0; i13 < this.RES.length; i13++) {
                    q qVar3 = this.RES[i13];
                    if (qVar3 != null) {
                        i12 += com.google.a.a.b.b(14, qVar3);
                    }
                }
                Ig = i12;
            }
            if (this.RET != 0) {
                Ig += com.google.a.a.b.bu(15, this.RET);
            }
            if (this.REU != 0) {
                Ig += com.google.a.a.b.bu(16, this.REU);
            }
            if (this.REW != 0) {
                Ig += com.google.a.a.b.bu(17, this.REW);
            }
            if (!Arrays.equals(this.REX, com.google.a.a.g.cbu)) {
                Ig += com.google.a.a.b.c(18, this.REX);
            }
            if (this.Lnt != -1) {
                Ig += com.google.a.a.b.bu(19, this.Lnt);
            }
            if (this.REY != null && this.REY.length > 0) {
                int i14 = 0;
                for (int i15 = 0; i15 < this.REY.length; i15++) {
                    i14 += com.google.a.a.b.fY(this.REY[i15]);
                }
                Ig = Ig + i14 + (this.REY.length * 2);
            }
            if (this.REa != 0) {
                Ig += com.google.a.a.b.bC(21, this.REa);
            }
            if (this.REQ != 0) {
                Ig += com.google.a.a.b.bC(100, this.REQ);
            }
            if (this.RER != 0) {
                Ig += com.google.a.a.b.bC(101, this.RER);
            }
            if (this.REe != null && this.REe.length > 0) {
                for (int i16 = 0; i16 < this.REe.length; i16++) {
                    bb bbVar2 = this.REe[i16];
                    if (bbVar2 != null) {
                        Ig += com.google.a.a.b.b(102, bbVar2);
                    }
                }
            }
            return Ig;
        }
    }

    public static final class f extends com.google.a.a.e {
        public int GXO = 0;
        public long GXP = 0;
        public int RDC = 0;
        public int bDZ = 0;
        public String groupId = "";

        public f() {
            this.cbo = -1;
        }

        @Override // com.google.a.a.e
        public final void a(com.google.a.a.b bVar) {
            if (!this.groupId.equals("")) {
                bVar.e(1, this.groupId);
            }
            if (this.GXO != 0) {
                bVar.bs(2, this.GXO);
            }
            if (this.GXP != 0) {
                bVar.q(3, this.GXP);
            }
            if (this.bDZ != 0) {
                bVar.bs(4, this.bDZ);
            }
            if (this.RDC != 0) {
                bVar.bs(5, this.RDC);
            }
            super.a(bVar);
        }

        @Override // com.google.a.a.e
        public final int Ig() {
            int Ig = super.Ig();
            if (!this.groupId.equals("")) {
                Ig += com.google.a.a.b.f(1, this.groupId);
            }
            if (this.GXO != 0) {
                Ig += com.google.a.a.b.bu(2, this.GXO);
            }
            if (this.GXP != 0) {
                Ig += com.google.a.a.b.r(3, this.GXP);
            }
            if (this.bDZ != 0) {
                Ig += com.google.a.a.b.bu(4, this.bDZ);
            }
            if (this.RDC != 0) {
                return Ig + com.google.a.a.b.bu(5, this.RDC);
            }
            return Ig;
        }

        @Override // com.google.a.a.e
        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int yT = aVar.yT();
                switch (yT) {
                    case 0:
                        break;
                    case 10:
                        this.groupId = aVar.readString();
                        break;
                    case 16:
                        this.GXO = aVar.zi();
                        break;
                    case 24:
                        this.GXP = aVar.zl();
                        break;
                    case 32:
                        this.bDZ = aVar.zi();
                        break;
                    case 40:
                        this.RDC = aVar.zi();
                        break;
                    default:
                        if (com.google.a.a.g.a(aVar, yT)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }
    }

    public static final class ad extends com.google.a.a.e {
        public int GXO = 0;
        public long GXP = 0;
        public String groupId = "";

        public ad() {
            this.cbo = -1;
        }

        @Override // com.google.a.a.e
        public final void a(com.google.a.a.b bVar) {
            if (!this.groupId.equals("")) {
                bVar.e(1, this.groupId);
            }
            if (this.GXO != 0) {
                bVar.bs(2, this.GXO);
            }
            if (this.GXP != 0) {
                bVar.q(3, this.GXP);
            }
            super.a(bVar);
        }

        @Override // com.google.a.a.e
        public final int Ig() {
            int Ig = super.Ig();
            if (!this.groupId.equals("")) {
                Ig += com.google.a.a.b.f(1, this.groupId);
            }
            if (this.GXO != 0) {
                Ig += com.google.a.a.b.bu(2, this.GXO);
            }
            if (this.GXP != 0) {
                return Ig + com.google.a.a.b.r(3, this.GXP);
            }
            return Ig;
        }

        @Override // com.google.a.a.e
        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int yT = aVar.yT();
                switch (yT) {
                    case 0:
                        break;
                    case 10:
                        this.groupId = aVar.readString();
                        break;
                    case 16:
                        this.GXO = aVar.zi();
                        break;
                    case 24:
                        this.GXP = aVar.zl();
                        break;
                    default:
                        if (com.google.a.a.g.a(aVar, yT)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }
    }

    /* renamed from: com.tencent.pb.common.b.a.a.a$a  reason: collision with other inner class name */
    public static final class C2179a extends com.google.a.a.e {
        public int GXO = 0;
        public long GXP = 0;
        public int[] RDl = com.google.a.a.g.bYn;
        public int RDm = 0;
        public String[] RDn = com.google.a.a.g.EMPTY_STRING_ARRAY;
        public String groupId = "";

        @Override // com.google.a.a.e
        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            int length;
            while (true) {
                int yT = aVar.yT();
                switch (yT) {
                    case 0:
                        break;
                    case 10:
                        this.groupId = aVar.readString();
                        break;
                    case 16:
                        this.GXO = aVar.zi();
                        break;
                    case 24:
                        this.GXP = aVar.zl();
                        break;
                    case 32:
                        int b2 = com.google.a.a.g.b(aVar, 32);
                        if (this.RDl == null) {
                            length = 0;
                        } else {
                            length = this.RDl.length;
                        }
                        int[] iArr = new int[(b2 + length)];
                        if (length != 0) {
                            System.arraycopy(this.RDl, 0, iArr, 0, length);
                        }
                        while (length < iArr.length - 1) {
                            iArr[length] = aVar.zi();
                            aVar.yT();
                            length++;
                        }
                        iArr[length] = aVar.zi();
                        this.RDl = iArr;
                        break;
                    case 34:
                        int fH = aVar.fH(aVar.zi());
                        int position = aVar.getPosition();
                        int i2 = 0;
                        while (aVar.zk() > 0) {
                            aVar.zi();
                            i2++;
                        }
                        aVar.gZ(position);
                        int length2 = this.RDl == null ? 0 : this.RDl.length;
                        int[] iArr2 = new int[(i2 + length2)];
                        if (length2 != 0) {
                            System.arraycopy(this.RDl, 0, iArr2, 0, length2);
                        }
                        while (length2 < iArr2.length) {
                            iArr2[length2] = aVar.zi();
                            length2++;
                        }
                        this.RDl = iArr2;
                        aVar.fI(fH);
                        break;
                    case 40:
                        this.RDm = aVar.zi();
                        break;
                    case 802:
                        int b3 = com.google.a.a.g.b(aVar, 802);
                        int length3 = this.RDn == null ? 0 : this.RDn.length;
                        String[] strArr = new String[(b3 + length3)];
                        if (length3 != 0) {
                            System.arraycopy(this.RDn, 0, strArr, 0, length3);
                        }
                        while (length3 < strArr.length - 1) {
                            strArr[length3] = aVar.readString();
                            aVar.yT();
                            length3++;
                        }
                        strArr[length3] = aVar.readString();
                        this.RDn = strArr;
                        break;
                    default:
                        if (com.google.a.a.g.a(aVar, yT)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        public C2179a() {
            this.cbo = -1;
        }

        @Override // com.google.a.a.e
        public final void a(com.google.a.a.b bVar) {
            if (!this.groupId.equals("")) {
                bVar.e(1, this.groupId);
            }
            if (this.GXO != 0) {
                bVar.bs(2, this.GXO);
            }
            if (this.GXP != 0) {
                bVar.q(3, this.GXP);
            }
            if (this.RDl != null && this.RDl.length > 0) {
                for (int i2 = 0; i2 < this.RDl.length; i2++) {
                    bVar.bB(4, this.RDl[i2]);
                }
            }
            if (this.RDm != 0) {
                bVar.bs(5, this.RDm);
            }
            if (this.RDn != null && this.RDn.length > 0) {
                for (int i3 = 0; i3 < this.RDn.length; i3++) {
                    String str = this.RDn[i3];
                    if (str != null) {
                        bVar.e(100, str);
                    }
                }
            }
            super.a(bVar);
        }

        @Override // com.google.a.a.e
        public final int Ig() {
            int Ig = super.Ig();
            if (!this.groupId.equals("")) {
                Ig += com.google.a.a.b.f(1, this.groupId);
            }
            if (this.GXO != 0) {
                Ig += com.google.a.a.b.bu(2, this.GXO);
            }
            if (this.GXP != 0) {
                Ig += com.google.a.a.b.r(3, this.GXP);
            }
            if (this.RDl != null && this.RDl.length > 0) {
                int i2 = 0;
                for (int i3 = 0; i3 < this.RDl.length; i3++) {
                    i2 += com.google.a.a.b.fY(this.RDl[i3]);
                }
                Ig = Ig + i2 + (this.RDl.length * 1);
            }
            if (this.RDm != 0) {
                Ig += com.google.a.a.b.bu(5, this.RDm);
            }
            if (this.RDn == null || this.RDn.length <= 0) {
                return Ig;
            }
            int i4 = 0;
            int i5 = 0;
            for (int i6 = 0; i6 < this.RDn.length; i6++) {
                String str = this.RDn[i6];
                if (str != null) {
                    i5++;
                    i4 += com.google.a.a.b.cb(str);
                }
            }
            return Ig + i4 + (i5 * 2);
        }
    }

    public static final class z extends com.google.a.a.e {
        public int GXO = 0;
        public long GXP = 0;
        public az RDq = null;
        public bb[] REK = bb.hjl();
        public String groupId = "";

        @Override // com.google.a.a.e
        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            int length;
            while (true) {
                int yT = aVar.yT();
                switch (yT) {
                    case 0:
                        break;
                    case 10:
                        this.groupId = aVar.readString();
                        break;
                    case 16:
                        this.GXO = aVar.zi();
                        break;
                    case 24:
                        this.GXP = aVar.zl();
                        break;
                    case 34:
                        int b2 = com.google.a.a.g.b(aVar, 34);
                        if (this.REK == null) {
                            length = 0;
                        } else {
                            length = this.REK.length;
                        }
                        bb[] bbVarArr = new bb[(b2 + length)];
                        if (length != 0) {
                            System.arraycopy(this.REK, 0, bbVarArr, 0, length);
                        }
                        while (length < bbVarArr.length - 1) {
                            bbVarArr[length] = new bb();
                            aVar.a(bbVarArr[length]);
                            aVar.yT();
                            length++;
                        }
                        bbVarArr[length] = new bb();
                        aVar.a(bbVarArr[length]);
                        this.REK = bbVarArr;
                        break;
                    case 42:
                        if (this.RDq == null) {
                            this.RDq = new az();
                        }
                        aVar.a(this.RDq);
                        break;
                    default:
                        if (com.google.a.a.g.a(aVar, yT)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        public z() {
            this.cbo = -1;
        }

        @Override // com.google.a.a.e
        public final void a(com.google.a.a.b bVar) {
            if (!this.groupId.equals("")) {
                bVar.e(1, this.groupId);
            }
            if (this.GXO != 0) {
                bVar.bs(2, this.GXO);
            }
            if (this.GXP != 0) {
                bVar.q(3, this.GXP);
            }
            if (this.REK != null && this.REK.length > 0) {
                for (int i2 = 0; i2 < this.REK.length; i2++) {
                    bb bbVar = this.REK[i2];
                    if (bbVar != null) {
                        bVar.a(4, bbVar);
                    }
                }
            }
            if (this.RDq != null) {
                bVar.a(5, this.RDq);
            }
            super.a(bVar);
        }

        @Override // com.google.a.a.e
        public final int Ig() {
            int Ig = super.Ig();
            if (!this.groupId.equals("")) {
                Ig += com.google.a.a.b.f(1, this.groupId);
            }
            if (this.GXO != 0) {
                Ig += com.google.a.a.b.bu(2, this.GXO);
            }
            if (this.GXP != 0) {
                Ig += com.google.a.a.b.r(3, this.GXP);
            }
            if (this.REK != null && this.REK.length > 0) {
                int i2 = Ig;
                for (int i3 = 0; i3 < this.REK.length; i3++) {
                    bb bbVar = this.REK[i3];
                    if (bbVar != null) {
                        i2 += com.google.a.a.b.b(4, bbVar);
                    }
                }
                Ig = i2;
            }
            if (this.RDq != null) {
                return Ig + com.google.a.a.b.b(5, this.RDq);
            }
            return Ig;
        }
    }

    public static final class ba extends com.google.a.a.e {
        private static volatile ba[] RGb;
        public int GXO = 0;
        public long GXP = 0;
        public int RDt = 0;
        public bb[] REK = bb.hjl();
        public String RGc = "";
        public String groupId = "";

        @Override // com.google.a.a.e
        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            int length;
            while (true) {
                int yT = aVar.yT();
                switch (yT) {
                    case 0:
                        break;
                    case 10:
                        this.groupId = aVar.readString();
                        break;
                    case 16:
                        this.GXO = aVar.zi();
                        break;
                    case 24:
                        this.GXP = aVar.zl();
                        break;
                    case 34:
                        int b2 = com.google.a.a.g.b(aVar, 34);
                        if (this.REK == null) {
                            length = 0;
                        } else {
                            length = this.REK.length;
                        }
                        bb[] bbVarArr = new bb[(b2 + length)];
                        if (length != 0) {
                            System.arraycopy(this.REK, 0, bbVarArr, 0, length);
                        }
                        while (length < bbVarArr.length - 1) {
                            bbVarArr[length] = new bb();
                            aVar.a(bbVarArr[length]);
                            aVar.yT();
                            length++;
                        }
                        bbVarArr[length] = new bb();
                        aVar.a(bbVarArr[length]);
                        this.REK = bbVarArr;
                        break;
                    case 40:
                        this.RDt = aVar.zi();
                        break;
                    case 50:
                        this.RGc = aVar.readString();
                        break;
                    default:
                        if (com.google.a.a.g.a(aVar, yT)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        public static ba[] hjk() {
            if (RGb == null) {
                synchronized (com.google.a.a.c.cbn) {
                    if (RGb == null) {
                        RGb = new ba[0];
                    }
                }
            }
            return RGb;
        }

        public ba() {
            this.cbo = -1;
        }

        @Override // com.google.a.a.e
        public final void a(com.google.a.a.b bVar) {
            if (!this.groupId.equals("")) {
                bVar.e(1, this.groupId);
            }
            if (this.GXO != 0) {
                bVar.bs(2, this.GXO);
            }
            if (this.GXP != 0) {
                bVar.q(3, this.GXP);
            }
            if (this.REK != null && this.REK.length > 0) {
                for (int i2 = 0; i2 < this.REK.length; i2++) {
                    bb bbVar = this.REK[i2];
                    if (bbVar != null) {
                        bVar.a(4, bbVar);
                    }
                }
            }
            if (this.RDt != 0) {
                bVar.bB(5, this.RDt);
            }
            if (!this.RGc.equals("")) {
                bVar.e(6, this.RGc);
            }
            super.a(bVar);
        }

        @Override // com.google.a.a.e
        public final int Ig() {
            int Ig = super.Ig();
            if (!this.groupId.equals("")) {
                Ig += com.google.a.a.b.f(1, this.groupId);
            }
            if (this.GXO != 0) {
                Ig += com.google.a.a.b.bu(2, this.GXO);
            }
            if (this.GXP != 0) {
                Ig += com.google.a.a.b.r(3, this.GXP);
            }
            if (this.REK != null && this.REK.length > 0) {
                int i2 = Ig;
                for (int i3 = 0; i3 < this.REK.length; i3++) {
                    bb bbVar = this.REK[i3];
                    if (bbVar != null) {
                        i2 += com.google.a.a.b.b(4, bbVar);
                    }
                }
                Ig = i2;
            }
            if (this.RDt != 0) {
                Ig += com.google.a.a.b.bC(5, this.RDt);
            }
            if (!this.RGc.equals("")) {
                return Ig + com.google.a.a.b.f(6, this.RGc);
            }
            return Ig;
        }
    }

    public static final class al extends com.google.a.a.e {
        public ba[] RFi = ba.hjk();

        @Override // com.google.a.a.e
        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            int length;
            while (true) {
                int yT = aVar.yT();
                switch (yT) {
                    case 0:
                        break;
                    case 10:
                        int b2 = com.google.a.a.g.b(aVar, 10);
                        if (this.RFi == null) {
                            length = 0;
                        } else {
                            length = this.RFi.length;
                        }
                        ba[] baVarArr = new ba[(b2 + length)];
                        if (length != 0) {
                            System.arraycopy(this.RFi, 0, baVarArr, 0, length);
                        }
                        while (length < baVarArr.length - 1) {
                            baVarArr[length] = new ba();
                            aVar.a(baVarArr[length]);
                            aVar.yT();
                            length++;
                        }
                        baVarArr[length] = new ba();
                        aVar.a(baVarArr[length]);
                        this.RFi = baVarArr;
                        break;
                    default:
                        if (com.google.a.a.g.a(aVar, yT)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        public al() {
            this.cbo = -1;
        }

        @Override // com.google.a.a.e
        public final void a(com.google.a.a.b bVar) {
            if (this.RFi != null && this.RFi.length > 0) {
                for (int i2 = 0; i2 < this.RFi.length; i2++) {
                    ba baVar = this.RFi[i2];
                    if (baVar != null) {
                        bVar.a(1, baVar);
                    }
                }
            }
            super.a(bVar);
        }

        @Override // com.google.a.a.e
        public final int Ig() {
            int Ig = super.Ig();
            if (this.RFi != null && this.RFi.length > 0) {
                for (int i2 = 0; i2 < this.RFi.length; i2++) {
                    ba baVar = this.RFi[i2];
                    if (baVar != null) {
                        Ig += com.google.a.a.b.b(1, baVar);
                    }
                }
            }
            return Ig;
        }
    }

    public static final class d extends com.google.a.a.e {
        public String RDo = "";
        public az RDq = null;
        public int[] RDr = com.google.a.a.g.bYn;
        public bg RDs = null;
        public int RDt = 0;
        public int RDu = 0;
        public be RDv = null;
        public String RDw = "";
        public String[] RDx = com.google.a.a.g.EMPTY_STRING_ARRAY;
        public o[] RDy = o.hjb();
        public int RDz = 0;
        public int netType = 0;

        @Override // com.google.a.a.e
        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            int length;
            int length2;
            while (true) {
                int yT = aVar.yT();
                switch (yT) {
                    case 0:
                        break;
                    case 10:
                        if (this.RDq == null) {
                            this.RDq = new az();
                        }
                        aVar.a(this.RDq);
                        break;
                    case 16:
                        int b2 = com.google.a.a.g.b(aVar, 16);
                        if (this.RDr == null) {
                            length2 = 0;
                        } else {
                            length2 = this.RDr.length;
                        }
                        int[] iArr = new int[(b2 + length2)];
                        if (length2 != 0) {
                            System.arraycopy(this.RDr, 0, iArr, 0, length2);
                        }
                        while (length2 < iArr.length - 1) {
                            iArr[length2] = aVar.zi();
                            aVar.yT();
                            length2++;
                        }
                        iArr[length2] = aVar.zi();
                        this.RDr = iArr;
                        break;
                    case 18:
                        int fH = aVar.fH(aVar.zi());
                        int position = aVar.getPosition();
                        int i2 = 0;
                        while (aVar.zk() > 0) {
                            aVar.zi();
                            i2++;
                        }
                        aVar.gZ(position);
                        int length3 = this.RDr == null ? 0 : this.RDr.length;
                        int[] iArr2 = new int[(i2 + length3)];
                        if (length3 != 0) {
                            System.arraycopy(this.RDr, 0, iArr2, 0, length3);
                        }
                        while (length3 < iArr2.length) {
                            iArr2[length3] = aVar.zi();
                            length3++;
                        }
                        this.RDr = iArr2;
                        aVar.fI(fH);
                        break;
                    case 26:
                        if (this.RDs == null) {
                            this.RDs = new bg();
                        }
                        aVar.a(this.RDs);
                        break;
                    case 32:
                        this.RDt = aVar.zi();
                        break;
                    case 40:
                        this.RDu = aVar.zi();
                        break;
                    case 50:
                        if (this.RDv == null) {
                            this.RDv = new be();
                        }
                        aVar.a(this.RDv);
                        break;
                    case 58:
                        this.RDo = aVar.readString();
                        break;
                    case 66:
                        this.RDw = aVar.readString();
                        break;
                    case 72:
                        this.netType = aVar.zi();
                        break;
                    case 802:
                        int b3 = com.google.a.a.g.b(aVar, 802);
                        int length4 = this.RDx == null ? 0 : this.RDx.length;
                        String[] strArr = new String[(b3 + length4)];
                        if (length4 != 0) {
                            System.arraycopy(this.RDx, 0, strArr, 0, length4);
                        }
                        while (length4 < strArr.length - 1) {
                            strArr[length4] = aVar.readString();
                            aVar.yT();
                            length4++;
                        }
                        strArr[length4] = aVar.readString();
                        this.RDx = strArr;
                        break;
                    case 1618:
                        int b4 = com.google.a.a.g.b(aVar, 1618);
                        if (this.RDy == null) {
                            length = 0;
                        } else {
                            length = this.RDy.length;
                        }
                        o[] oVarArr = new o[(b4 + length)];
                        if (length != 0) {
                            System.arraycopy(this.RDy, 0, oVarArr, 0, length);
                        }
                        while (length < oVarArr.length - 1) {
                            oVarArr[length] = new o();
                            aVar.a(oVarArr[length]);
                            aVar.yT();
                            length++;
                        }
                        oVarArr[length] = new o();
                        aVar.a(oVarArr[length]);
                        this.RDy = oVarArr;
                        break;
                    case 1920:
                        this.RDz = aVar.zi();
                        break;
                    default:
                        if (com.google.a.a.g.a(aVar, yT)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        public d() {
            this.cbo = -1;
        }

        @Override // com.google.a.a.e
        public final void a(com.google.a.a.b bVar) {
            if (this.RDq != null) {
                bVar.a(1, this.RDq);
            }
            if (this.RDr != null && this.RDr.length > 0) {
                for (int i2 = 0; i2 < this.RDr.length; i2++) {
                    bVar.bB(2, this.RDr[i2]);
                }
            }
            if (this.RDs != null) {
                bVar.a(3, this.RDs);
            }
            if (this.RDt != 0) {
                bVar.bB(4, this.RDt);
            }
            if (this.RDu != 0) {
                bVar.bB(5, this.RDu);
            }
            if (this.RDv != null) {
                bVar.a(6, this.RDv);
            }
            if (!this.RDo.equals("")) {
                bVar.e(7, this.RDo);
            }
            if (!this.RDw.equals("")) {
                bVar.e(8, this.RDw);
            }
            if (this.netType != 0) {
                bVar.bB(9, this.netType);
            }
            if (this.RDx != null && this.RDx.length > 0) {
                for (int i3 = 0; i3 < this.RDx.length; i3++) {
                    String str = this.RDx[i3];
                    if (str != null) {
                        bVar.e(100, str);
                    }
                }
            }
            if (this.RDy != null && this.RDy.length > 0) {
                for (int i4 = 0; i4 < this.RDy.length; i4++) {
                    o oVar = this.RDy[i4];
                    if (oVar != null) {
                        bVar.a(202, oVar);
                    }
                }
            }
            if (this.RDz != 0) {
                bVar.bB(240, this.RDz);
            }
            super.a(bVar);
        }

        @Override // com.google.a.a.e
        public final int Ig() {
            int Ig = super.Ig();
            if (this.RDq != null) {
                Ig += com.google.a.a.b.b(1, this.RDq);
            }
            if (this.RDr != null && this.RDr.length > 0) {
                int i2 = 0;
                for (int i3 = 0; i3 < this.RDr.length; i3++) {
                    i2 += com.google.a.a.b.fY(this.RDr[i3]);
                }
                Ig = Ig + i2 + (this.RDr.length * 1);
            }
            if (this.RDs != null) {
                Ig += com.google.a.a.b.b(3, this.RDs);
            }
            if (this.RDt != 0) {
                Ig += com.google.a.a.b.bC(4, this.RDt);
            }
            if (this.RDu != 0) {
                Ig += com.google.a.a.b.bC(5, this.RDu);
            }
            if (this.RDv != null) {
                Ig += com.google.a.a.b.b(6, this.RDv);
            }
            if (!this.RDo.equals("")) {
                Ig += com.google.a.a.b.f(7, this.RDo);
            }
            if (!this.RDw.equals("")) {
                Ig += com.google.a.a.b.f(8, this.RDw);
            }
            if (this.netType != 0) {
                Ig += com.google.a.a.b.bC(9, this.netType);
            }
            if (this.RDx != null && this.RDx.length > 0) {
                int i4 = 0;
                int i5 = 0;
                for (int i6 = 0; i6 < this.RDx.length; i6++) {
                    String str = this.RDx[i6];
                    if (str != null) {
                        i5++;
                        i4 += com.google.a.a.b.cb(str);
                    }
                }
                Ig = Ig + i4 + (i5 * 2);
            }
            if (this.RDy != null && this.RDy.length > 0) {
                for (int i7 = 0; i7 < this.RDy.length; i7++) {
                    o oVar = this.RDy[i7];
                    if (oVar != null) {
                        Ig += com.google.a.a.b.b(202, oVar);
                    }
                }
            }
            if (this.RDz != 0) {
                return Ig + com.google.a.a.b.bC(240, this.RDz);
            }
            return Ig;
        }
    }

    public static final class ab extends com.google.a.a.e {
        public int GXO = 0;
        public long GXP = 0;
        public int Lnt = -1;
        public int RDQ = 0;
        public bb[] RDX = bb.hjl();
        public ay RDY = null;
        public String RDo = "";
        public az RDq = null;
        public int RDt = 0;
        public q[] REL = q.hjd();
        public bc[] REM = bc.hjm();
        public int REN = 0;
        public int[] REO = com.google.a.a.g.bYn;
        public q[] REP = q.hjd();
        public int REQ = 0;
        public int RER = 0;
        public q[] RES = q.hjd();
        public int RET = 0;
        public int REU = 0;
        public int REW = 0;
        public byte[] REX = com.google.a.a.g.cbu;
        public int[] REY = com.google.a.a.g.bYn;
        public int REa = 0;
        public bb[] REe = bb.hjl();
        public String groupId = "";

        @Override // com.google.a.a.e
        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            int length;
            int length2;
            int length3;
            int length4;
            int length5;
            int length6;
            int length7;
            int length8;
            while (true) {
                int yT = aVar.yT();
                switch (yT) {
                    case 0:
                        break;
                    case 10:
                        this.groupId = aVar.readString();
                        break;
                    case 16:
                        this.GXO = aVar.zi();
                        break;
                    case 24:
                        this.GXP = aVar.zl();
                        break;
                    case 32:
                        this.RDt = aVar.zi();
                        break;
                    case 42:
                        int b2 = com.google.a.a.g.b(aVar, 42);
                        if (this.REL == null) {
                            length8 = 0;
                        } else {
                            length8 = this.REL.length;
                        }
                        q[] qVarArr = new q[(b2 + length8)];
                        if (length8 != 0) {
                            System.arraycopy(this.REL, 0, qVarArr, 0, length8);
                        }
                        while (length8 < qVarArr.length - 1) {
                            qVarArr[length8] = new q();
                            aVar.a(qVarArr[length8]);
                            aVar.yT();
                            length8++;
                        }
                        qVarArr[length8] = new q();
                        aVar.a(qVarArr[length8]);
                        this.REL = qVarArr;
                        break;
                    case 50:
                        int b3 = com.google.a.a.g.b(aVar, 50);
                        if (this.REM == null) {
                            length7 = 0;
                        } else {
                            length7 = this.REM.length;
                        }
                        bc[] bcVarArr = new bc[(b3 + length7)];
                        if (length7 != 0) {
                            System.arraycopy(this.REM, 0, bcVarArr, 0, length7);
                        }
                        while (length7 < bcVarArr.length - 1) {
                            bcVarArr[length7] = new bc();
                            aVar.a(bcVarArr[length7]);
                            aVar.yT();
                            length7++;
                        }
                        bcVarArr[length7] = new bc();
                        aVar.a(bcVarArr[length7]);
                        this.REM = bcVarArr;
                        break;
                    case 58:
                        if (this.RDY == null) {
                            this.RDY = new ay();
                        }
                        aVar.a(this.RDY);
                        break;
                    case 66:
                        this.RDo = aVar.readString();
                        break;
                    case 74:
                        int b4 = com.google.a.a.g.b(aVar, 74);
                        if (this.RDX == null) {
                            length6 = 0;
                        } else {
                            length6 = this.RDX.length;
                        }
                        bb[] bbVarArr = new bb[(b4 + length6)];
                        if (length6 != 0) {
                            System.arraycopy(this.RDX, 0, bbVarArr, 0, length6);
                        }
                        while (length6 < bbVarArr.length - 1) {
                            bbVarArr[length6] = new bb();
                            aVar.a(bbVarArr[length6]);
                            aVar.yT();
                            length6++;
                        }
                        bbVarArr[length6] = new bb();
                        aVar.a(bbVarArr[length6]);
                        this.RDX = bbVarArr;
                        break;
                    case PlayerException.EXCEPTION_TYPE_CONNECT_FAIL /*{ENCODED_INT: 80}*/:
                        this.REN = aVar.zi();
                        break;
                    case TPCodecParamers.TP_PROFILE_H264_EXTENDED /*{ENCODED_INT: 88}*/:
                        int b5 = com.google.a.a.g.b(aVar, 88);
                        if (this.REO == null) {
                            length5 = 0;
                        } else {
                            length5 = this.REO.length;
                        }
                        int[] iArr = new int[(b5 + length5)];
                        if (length5 != 0) {
                            System.arraycopy(this.REO, 0, iArr, 0, length5);
                        }
                        while (length5 < iArr.length - 1) {
                            iArr[length5] = aVar.zi();
                            aVar.yT();
                            length5++;
                        }
                        iArr[length5] = aVar.zi();
                        this.REO = iArr;
                        break;
                    case 90:
                        int fH = aVar.fH(aVar.zi());
                        int position = aVar.getPosition();
                        int i2 = 0;
                        while (aVar.zk() > 0) {
                            aVar.zi();
                            i2++;
                        }
                        aVar.gZ(position);
                        int length9 = this.REO == null ? 0 : this.REO.length;
                        int[] iArr2 = new int[(i2 + length9)];
                        if (length9 != 0) {
                            System.arraycopy(this.REO, 0, iArr2, 0, length9);
                        }
                        while (length9 < iArr2.length) {
                            iArr2[length9] = aVar.zi();
                            length9++;
                        }
                        this.REO = iArr2;
                        aVar.fI(fH);
                        break;
                    case 98:
                        if (this.RDq == null) {
                            this.RDq = new az();
                        }
                        aVar.a(this.RDq);
                        break;
                    case 104:
                        this.RDQ = aVar.zi();
                        break;
                    case 114:
                        int b6 = com.google.a.a.g.b(aVar, 114);
                        if (this.REP == null) {
                            length4 = 0;
                        } else {
                            length4 = this.REP.length;
                        }
                        q[] qVarArr2 = new q[(b6 + length4)];
                        if (length4 != 0) {
                            System.arraycopy(this.REP, 0, qVarArr2, 0, length4);
                        }
                        while (length4 < qVarArr2.length - 1) {
                            qVarArr2[length4] = new q();
                            aVar.a(qVarArr2[length4]);
                            aVar.yT();
                            length4++;
                        }
                        qVarArr2[length4] = new q();
                        aVar.a(qVarArr2[length4]);
                        this.REP = qVarArr2;
                        break;
                    case 120:
                        this.REQ = aVar.zi();
                        break;
                    case 128:
                        this.RER = aVar.zi();
                        break;
                    case 138:
                        int b7 = com.google.a.a.g.b(aVar, 138);
                        if (this.REe == null) {
                            length3 = 0;
                        } else {
                            length3 = this.REe.length;
                        }
                        bb[] bbVarArr2 = new bb[(b7 + length3)];
                        if (length3 != 0) {
                            System.arraycopy(this.REe, 0, bbVarArr2, 0, length3);
                        }
                        while (length3 < bbVarArr2.length - 1) {
                            bbVarArr2[length3] = new bb();
                            aVar.a(bbVarArr2[length3]);
                            aVar.yT();
                            length3++;
                        }
                        bbVarArr2[length3] = new bb();
                        aVar.a(bbVarArr2[length3]);
                        this.REe = bbVarArr2;
                        break;
                    case 146:
                        int b8 = com.google.a.a.g.b(aVar, 146);
                        if (this.RES == null) {
                            length2 = 0;
                        } else {
                            length2 = this.RES.length;
                        }
                        q[] qVarArr3 = new q[(b8 + length2)];
                        if (length2 != 0) {
                            System.arraycopy(this.RES, 0, qVarArr3, 0, length2);
                        }
                        while (length2 < qVarArr3.length - 1) {
                            qVarArr3[length2] = new q();
                            aVar.a(qVarArr3[length2]);
                            aVar.yT();
                            length2++;
                        }
                        qVarArr3[length2] = new q();
                        aVar.a(qVarArr3[length2]);
                        this.RES = qVarArr3;
                        break;
                    case 152:
                        this.RET = aVar.zi();
                        break;
                    case 160:
                        this.REU = aVar.zi();
                        break;
                    case 168:
                        this.REW = aVar.zi();
                        break;
                    case 178:
                        this.REX = aVar.readBytes();
                        break;
                    case 184:
                        this.Lnt = aVar.zi();
                        break;
                    case 192:
                        int b9 = com.google.a.a.g.b(aVar, 192);
                        if (this.REY == null) {
                            length = 0;
                        } else {
                            length = this.REY.length;
                        }
                        int[] iArr3 = new int[(b9 + length)];
                        if (length != 0) {
                            System.arraycopy(this.REY, 0, iArr3, 0, length);
                        }
                        while (length < iArr3.length - 1) {
                            iArr3[length] = aVar.zi();
                            aVar.yT();
                            length++;
                        }
                        iArr3[length] = aVar.zi();
                        this.REY = iArr3;
                        break;
                    case 194:
                        int fH2 = aVar.fH(aVar.zi());
                        int position2 = aVar.getPosition();
                        int i3 = 0;
                        while (aVar.zk() > 0) {
                            aVar.zi();
                            i3++;
                        }
                        aVar.gZ(position2);
                        int length10 = this.REY == null ? 0 : this.REY.length;
                        int[] iArr4 = new int[(i3 + length10)];
                        if (length10 != 0) {
                            System.arraycopy(this.REY, 0, iArr4, 0, length10);
                        }
                        while (length10 < iArr4.length) {
                            iArr4[length10] = aVar.zi();
                            length10++;
                        }
                        this.REY = iArr4;
                        aVar.fI(fH2);
                        break;
                    case 200:
                        this.REa = aVar.zi();
                        break;
                    default:
                        if (com.google.a.a.g.a(aVar, yT)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        public ab() {
            this.cbo = -1;
        }

        @Override // com.google.a.a.e
        public final void a(com.google.a.a.b bVar) {
            if (!this.groupId.equals("")) {
                bVar.e(1, this.groupId);
            }
            if (this.GXO != 0) {
                bVar.bs(2, this.GXO);
            }
            if (this.GXP != 0) {
                bVar.q(3, this.GXP);
            }
            if (this.RDt != 0) {
                bVar.bB(4, this.RDt);
            }
            if (this.REL != null && this.REL.length > 0) {
                for (int i2 = 0; i2 < this.REL.length; i2++) {
                    q qVar = this.REL[i2];
                    if (qVar != null) {
                        bVar.a(5, qVar);
                    }
                }
            }
            if (this.REM != null && this.REM.length > 0) {
                for (int i3 = 0; i3 < this.REM.length; i3++) {
                    bc bcVar = this.REM[i3];
                    if (bcVar != null) {
                        bVar.a(6, bcVar);
                    }
                }
            }
            if (this.RDY != null) {
                bVar.a(7, this.RDY);
            }
            if (!this.RDo.equals("")) {
                bVar.e(8, this.RDo);
            }
            if (this.RDX != null && this.RDX.length > 0) {
                for (int i4 = 0; i4 < this.RDX.length; i4++) {
                    bb bbVar = this.RDX[i4];
                    if (bbVar != null) {
                        bVar.a(9, bbVar);
                    }
                }
            }
            if (this.REN != 0) {
                bVar.bs(10, this.REN);
            }
            if (this.REO != null && this.REO.length > 0) {
                for (int i5 = 0; i5 < this.REO.length; i5++) {
                    bVar.bs(11, this.REO[i5]);
                }
            }
            if (this.RDq != null) {
                bVar.a(12, this.RDq);
            }
            if (this.RDQ != 0) {
                bVar.bB(13, this.RDQ);
            }
            if (this.REP != null && this.REP.length > 0) {
                for (int i6 = 0; i6 < this.REP.length; i6++) {
                    q qVar2 = this.REP[i6];
                    if (qVar2 != null) {
                        bVar.a(14, qVar2);
                    }
                }
            }
            if (this.REQ != 0) {
                bVar.bB(15, this.REQ);
            }
            if (this.RER != 0) {
                bVar.bB(16, this.RER);
            }
            if (this.REe != null && this.REe.length > 0) {
                for (int i7 = 0; i7 < this.REe.length; i7++) {
                    bb bbVar2 = this.REe[i7];
                    if (bbVar2 != null) {
                        bVar.a(17, bbVar2);
                    }
                }
            }
            if (this.RES != null && this.RES.length > 0) {
                for (int i8 = 0; i8 < this.RES.length; i8++) {
                    q qVar3 = this.RES[i8];
                    if (qVar3 != null) {
                        bVar.a(18, qVar3);
                    }
                }
            }
            if (this.RET != 0) {
                bVar.bs(19, this.RET);
            }
            if (this.REU != 0) {
                bVar.bs(20, this.REU);
            }
            if (this.REW != 0) {
                bVar.bs(21, this.REW);
            }
            if (!Arrays.equals(this.REX, com.google.a.a.g.cbu)) {
                bVar.b(22, this.REX);
            }
            if (this.Lnt != -1) {
                bVar.bs(23, this.Lnt);
            }
            if (this.REY != null && this.REY.length > 0) {
                for (int i9 = 0; i9 < this.REY.length; i9++) {
                    bVar.bB(24, this.REY[i9]);
                }
            }
            if (this.REa != 0) {
                bVar.bB(25, this.REa);
            }
            super.a(bVar);
        }

        @Override // com.google.a.a.e
        public final int Ig() {
            int Ig = super.Ig();
            if (!this.groupId.equals("")) {
                Ig += com.google.a.a.b.f(1, this.groupId);
            }
            if (this.GXO != 0) {
                Ig += com.google.a.a.b.bu(2, this.GXO);
            }
            if (this.GXP != 0) {
                Ig += com.google.a.a.b.r(3, this.GXP);
            }
            if (this.RDt != 0) {
                Ig += com.google.a.a.b.bC(4, this.RDt);
            }
            if (this.REL != null && this.REL.length > 0) {
                int i2 = Ig;
                for (int i3 = 0; i3 < this.REL.length; i3++) {
                    q qVar = this.REL[i3];
                    if (qVar != null) {
                        i2 += com.google.a.a.b.b(5, qVar);
                    }
                }
                Ig = i2;
            }
            if (this.REM != null && this.REM.length > 0) {
                int i4 = Ig;
                for (int i5 = 0; i5 < this.REM.length; i5++) {
                    bc bcVar = this.REM[i5];
                    if (bcVar != null) {
                        i4 += com.google.a.a.b.b(6, bcVar);
                    }
                }
                Ig = i4;
            }
            if (this.RDY != null) {
                Ig += com.google.a.a.b.b(7, this.RDY);
            }
            if (!this.RDo.equals("")) {
                Ig += com.google.a.a.b.f(8, this.RDo);
            }
            if (this.RDX != null && this.RDX.length > 0) {
                int i6 = Ig;
                for (int i7 = 0; i7 < this.RDX.length; i7++) {
                    bb bbVar = this.RDX[i7];
                    if (bbVar != null) {
                        i6 += com.google.a.a.b.b(9, bbVar);
                    }
                }
                Ig = i6;
            }
            if (this.REN != 0) {
                Ig += com.google.a.a.b.bu(10, this.REN);
            }
            if (this.REO != null && this.REO.length > 0) {
                int i8 = 0;
                for (int i9 = 0; i9 < this.REO.length; i9++) {
                    i8 += com.google.a.a.b.fT(this.REO[i9]);
                }
                Ig = Ig + i8 + (this.REO.length * 1);
            }
            if (this.RDq != null) {
                Ig += com.google.a.a.b.b(12, this.RDq);
            }
            if (this.RDQ != 0) {
                Ig += com.google.a.a.b.bC(13, this.RDQ);
            }
            if (this.REP != null && this.REP.length > 0) {
                int i10 = Ig;
                for (int i11 = 0; i11 < this.REP.length; i11++) {
                    q qVar2 = this.REP[i11];
                    if (qVar2 != null) {
                        i10 += com.google.a.a.b.b(14, qVar2);
                    }
                }
                Ig = i10;
            }
            if (this.REQ != 0) {
                Ig += com.google.a.a.b.bC(15, this.REQ);
            }
            if (this.RER != 0) {
                Ig += com.google.a.a.b.bC(16, this.RER);
            }
            if (this.REe != null && this.REe.length > 0) {
                int i12 = Ig;
                for (int i13 = 0; i13 < this.REe.length; i13++) {
                    bb bbVar2 = this.REe[i13];
                    if (bbVar2 != null) {
                        i12 += com.google.a.a.b.b(17, bbVar2);
                    }
                }
                Ig = i12;
            }
            if (this.RES != null && this.RES.length > 0) {
                int i14 = Ig;
                for (int i15 = 0; i15 < this.RES.length; i15++) {
                    q qVar3 = this.RES[i15];
                    if (qVar3 != null) {
                        i14 += com.google.a.a.b.b(18, qVar3);
                    }
                }
                Ig = i14;
            }
            if (this.RET != 0) {
                Ig += com.google.a.a.b.bu(19, this.RET);
            }
            if (this.REU != 0) {
                Ig += com.google.a.a.b.bu(20, this.REU);
            }
            if (this.REW != 0) {
                Ig += com.google.a.a.b.bu(21, this.REW);
            }
            if (!Arrays.equals(this.REX, com.google.a.a.g.cbu)) {
                Ig += com.google.a.a.b.c(22, this.REX);
            }
            if (this.Lnt != -1) {
                Ig += com.google.a.a.b.bu(23, this.Lnt);
            }
            if (this.REY != null && this.REY.length > 0) {
                int i16 = 0;
                for (int i17 = 0; i17 < this.REY.length; i17++) {
                    i16 += com.google.a.a.b.fY(this.REY[i17]);
                }
                Ig = Ig + i16 + (this.REY.length * 2);
            }
            if (this.REa != 0) {
                return Ig + com.google.a.a.b.bC(25, this.REa);
            }
            return Ig;
        }
    }

    public static final class am extends com.google.a.a.e {
        public int ret = 0;

        public am() {
            this.cbo = -1;
        }

        @Override // com.google.a.a.e
        public final void a(com.google.a.a.b bVar) {
            if (this.ret != 0) {
                bVar.bs(1, this.ret);
            }
            super.a(bVar);
        }

        @Override // com.google.a.a.e
        public final int Ig() {
            int Ig = super.Ig();
            if (this.ret != 0) {
                return Ig + com.google.a.a.b.bu(1, this.ret);
            }
            return Ig;
        }

        @Override // com.google.a.a.e
        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int yT = aVar.yT();
                switch (yT) {
                    case 0:
                        break;
                    case 8:
                        this.ret = aVar.zi();
                        break;
                    default:
                        if (com.google.a.a.g.a(aVar, yT)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }
    }
}
