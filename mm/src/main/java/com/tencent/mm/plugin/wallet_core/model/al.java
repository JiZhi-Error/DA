package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.thumbplayer.core.common.TPMediaCodecProfileLevel;

public final class al {
    public int IbF = 0;
    private int IbG = 0;

    public al(int i2, int i3) {
        AppMethodBeat.i(70476);
        g.aAi();
        g.aAh().azQ().set(196660, Integer.valueOf(i2));
        g.aAi();
        g.aAh().azQ().set(ar.a.USERINFO_WALLET_BALANCE_SHOW_INT, Integer.valueOf(i3));
        this.IbF = i2;
        this.IbG = i3;
        Log.i("MicroMsg.WalletSwitchConfig", "WalletSwitchConfig1 " + i2 + "balanceShow:" + i3);
        AppMethodBeat.o(70476);
    }

    public al() {
        AppMethodBeat.i(70477);
        g.aAi();
        this.IbF = ((Integer) g.aAh().azQ().get(196660, (Object) 0)).intValue();
        g.aAi();
        this.IbG = ((Integer) g.aAh().azQ().get(ar.a.USERINFO_WALLET_BALANCE_SHOW_INT, (Object) 0)).intValue();
        Log.i("MicroMsg.WalletSwitchConfig", "WalletSwitchConfig2 " + this.IbF + "balanceShow:" + this.IbG);
        AppMethodBeat.o(70477);
    }

    public final boolean fQY() {
        boolean z;
        AppMethodBeat.i(70478);
        if ((this.IbF & 2) > 0) {
            z = true;
        } else {
            z = false;
        }
        Log.i("MicroMsg.WalletSwitchConfig", "isMicroPayOn, ret = %s switchBit %s", Boolean.valueOf(z), Integer.valueOf(this.IbF));
        AppMethodBeat.o(70478);
        return z;
    }

    public final boolean fNq() {
        boolean z;
        AppMethodBeat.i(70479);
        if ((this.IbF & 4) > 0) {
            z = true;
        } else {
            z = false;
        }
        Log.i("MicroMsg.WalletSwitchConfig", "isBalanceFetchOn, ret = %s switchBit %s", Boolean.valueOf(z), Integer.valueOf(this.IbF));
        AppMethodBeat.o(70479);
        return z;
    }

    public final boolean fQZ() {
        boolean z;
        AppMethodBeat.i(70480);
        if ((this.IbF & 128) > 0) {
            z = true;
        } else {
            z = false;
        }
        Log.i("MicroMsg.WalletSwitchConfig", "isSupportScanBankCard, ret = %s switchBit %s", Boolean.valueOf(z), Integer.valueOf(this.IbF));
        AppMethodBeat.o(70480);
        return z;
    }

    public final boolean fRa() {
        boolean z;
        AppMethodBeat.i(70481);
        if ((this.IbF & 256) > 0) {
            z = true;
        } else {
            z = false;
        }
        Log.i("MicroMsg.WalletSwitchConfig", "isSupportTouchPay, ret = %s switchBit %s", Boolean.valueOf(z), Integer.valueOf(this.IbF));
        AppMethodBeat.o(70481);
        return z;
    }

    public final boolean fRb() {
        boolean z;
        AppMethodBeat.i(70482);
        if ((this.IbF & 1024) > 0) {
            z = true;
        } else {
            z = false;
        }
        Log.i("MicroMsg.WalletSwitchConfig", "isSupportLCT, ret = %s switchBit %s", Boolean.valueOf(z), Integer.valueOf(this.IbF));
        AppMethodBeat.o(70482);
        return z;
    }

    public final boolean fRc() {
        boolean z;
        AppMethodBeat.i(70483);
        if ((this.IbF & 2048) > 0) {
            z = true;
        } else {
            z = false;
        }
        Log.i("MicroMsg.WalletSwitchConfig", "isSupporSwitchWalletCurrency, ret = %s switchBit %s", Boolean.valueOf(z), Integer.valueOf(this.IbF));
        AppMethodBeat.o(70483);
        return z;
    }

    public final boolean UB() {
        boolean z;
        AppMethodBeat.i(70484);
        if ((this.IbF & 8192) > 0) {
            z = true;
        } else {
            z = false;
        }
        Log.i("MicroMsg.WalletSwitchConfig", "isReportLocation, ret = %s switchBit %s", Boolean.valueOf(z), Integer.valueOf(this.IbF));
        AppMethodBeat.o(70484);
        return z;
    }

    public final boolean fRd() {
        boolean z;
        AppMethodBeat.i(70485);
        if ((this.IbF & TPMediaCodecProfileLevel.HEVCMainTierLevel52) > 0) {
            z = true;
        } else {
            z = false;
        }
        Log.i("MicroMsg.WalletSwitchConfig", "isReportWifiSSid, ret = %s switchBit %s", Boolean.valueOf(z), Integer.valueOf(this.IbF));
        AppMethodBeat.o(70485);
        return z;
    }

    public final boolean fRe() {
        boolean z;
        AppMethodBeat.i(70486);
        if ((this.IbF & TPMediaCodecProfileLevel.HEVCHighTierLevel61) > 0) {
            z = true;
        } else {
            z = false;
        }
        Log.i("MicroMsg.WalletSwitchConfig", "isReportCellInfo, ret = %s switchBit %s", Boolean.valueOf(z), Integer.valueOf(this.IbF));
        AppMethodBeat.o(70486);
        return z;
    }

    public final boolean fRf() {
        boolean z;
        AppMethodBeat.i(70487);
        if ((this.IbF & 16384) > 0) {
            z = true;
        } else {
            z = false;
        }
        Log.i("MicroMsg.WalletSwitchConfig", "isHideBalanceNum, ret = %s switchBit %s", Boolean.valueOf(z), Integer.valueOf(this.IbF));
        AppMethodBeat.o(70487);
        return z;
    }

    public final boolean fRg() {
        boolean z;
        AppMethodBeat.i(70488);
        if ((this.IbF & 32768) > 0) {
            z = true;
        } else {
            z = false;
        }
        Log.i("MicroMsg.WalletSwitchConfig", "isShowRealnameGuide, ret = %s switchBit %s", Boolean.valueOf(z), Integer.valueOf(this.IbF));
        AppMethodBeat.o(70488);
        return z;
    }

    public final boolean fRh() {
        boolean z;
        AppMethodBeat.i(70489);
        if ((this.IbF & 4194304) > 0) {
            z = true;
        } else {
            z = false;
        }
        Log.i("MicroMsg.WalletSwitchConfig", "isShowBalanceAmount, ret = %s switchBit %s", Boolean.valueOf(z), Integer.valueOf(this.IbF));
        AppMethodBeat.o(70489);
        return z;
    }

    public final boolean fRi() {
        boolean z;
        AppMethodBeat.i(70490);
        if ((this.IbF & TPMediaCodecProfileLevel.HEVCHighTierLevel6) > 0) {
            z = true;
        } else {
            z = false;
        }
        Log.i("MicroMsg.WalletSwitchConfig", "isShowProtocol, ret = %s switchBit %s", Boolean.valueOf(z), Integer.valueOf(this.IbF));
        AppMethodBeat.o(70490);
        return z;
    }

    public final boolean fRj() {
        AppMethodBeat.i(70491);
        boolean isEqual = Util.isEqual(this.IbG, 1);
        Log.i("MicroMsg.WalletSwitchConfig", "isShowBalance, ret = %s switchBit %s", Boolean.valueOf(isEqual), Integer.valueOf(this.IbF));
        AppMethodBeat.o(70491);
        return isEqual;
    }
}
