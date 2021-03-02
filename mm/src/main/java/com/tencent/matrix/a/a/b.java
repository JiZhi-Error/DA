package com.tencent.matrix.a.a;

import com.tencent.c.a.a;

public final class b {
    public final a cQF;

    public final boolean RR() {
        return this.cQF.get(a.EnumC0131a.clicfg_matrix_battery_detect_wake_lock_enable.name(), true);
    }

    public final boolean RS() {
        return this.cQF.get(a.EnumC0131a.clicfg_matrix_battery_record_wake_lock_enable.name(), false);
    }

    public final boolean RT() {
        return this.cQF.get(a.EnumC0131a.clicfg_matrix_battery_record_alarm_enable.name(), false);
    }

    public final String toString() {
        return String.format("[BatteryCanary.BatteryConfig], isDetectWakeLock:%b, isDetectAlarm:%b, isRecordWakeLock:%b, isRecordAlarm:%b", Boolean.valueOf(RR()), Boolean.valueOf(RR()), Boolean.valueOf(RS()), Boolean.valueOf(RT()));
    }
}
