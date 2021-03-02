package com.tencent.mm.plugin.performance.elf;

public class ToolProcessChecker extends MainProcessChecker {
    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.performance.elf.AbstractProcessChecker, com.tencent.mm.plugin.performance.elf.MainProcessChecker
    public final String getTag() {
        return "MicroMsg.ToolProcessChecker";
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.performance.elf.AbstractProcessChecker
    public final boolean eCo() {
        return false;
    }
}
