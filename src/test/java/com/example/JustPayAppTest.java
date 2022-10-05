package com.example;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class JustPayAppTest {
    /**　正常系シナリオ */
    @Test
    public void testSuccess() {
        JustPayApp app = new JustPayApp();
        assertEquals("HomePane", app.getPaneName());
        app.doAction("READ_BUTTON");
        assertEquals("BarcodeReaderPane", app.getPaneName());
        app.doAction("READ_BARCODE");
        assertEquals("ConfirmPane", app.getPaneName());
        app.doAction("SETTLEMENT_BUTTON_OK");
        assertEquals("ResultPane", app.getPaneName());
        app.doAction("OK_BUTTON");
        assertEquals("HomePane", app.getPaneName());
    }

    /**　決済失敗→再読取→キャンセルボタン */
    @Test
    public void testSettlementFail_Reread_CancelButton() {
        JustPayApp app = new JustPayApp();
        assertEquals("HomePane", app.getPaneName());
        app.doAction("READ_BUTTON");
        assertEquals("BarcodeReaderPane", app.getPaneName());
        app.doAction("READ_BARCODE");
        assertEquals("ConfirmPane", app.getPaneName());
        app.doAction("SETTLEMENT_BUTTON_FAIL");
        assertEquals("FailurePane", app.getPaneName());
        app.doAction("REREAD_BUTTON");
        assertEquals("BarcodeReaderPane", app.getPaneName());
        app.doAction("CANCEL_BUTTON");
        assertEquals("HomePane", app.getPaneName());
    }
    /**　決済失敗→OKボタン */
    @Test
    public void testSettlementFail_OKButton() {
        JustPayApp app = new JustPayApp();
        assertEquals("HomePane", app.getPaneName());
        app.doAction("READ_BUTTON");
        assertEquals("BarcodeReaderPane", app.getPaneName());
        app.doAction("READ_BARCODE");
        assertEquals("ConfirmPane", app.getPaneName());
        app.doAction("SETTLEMENT_BUTTON_FAIL");
        assertEquals("FailurePane", app.getPaneName());
        app.doAction("OK_BUTTON");
        assertEquals("HomePane", app.getPaneName());
    }
    /**　金額確→キャンセルボタン */
    @Test
    public void testConfirm_CancelButton() {
        JustPayApp app = new JustPayApp();
        assertEquals("HomePane", app.getPaneName());
        app.doAction("READ_BUTTON");
        assertEquals("BarcodeReaderPane", app.getPaneName());
        app.doAction("READ_BARCODE");
        assertEquals("ConfirmPane", app.getPaneName());
        app.doAction("CANCEL_BUTTON");
        assertEquals("HomePane", app.getPaneName());
    }
}
