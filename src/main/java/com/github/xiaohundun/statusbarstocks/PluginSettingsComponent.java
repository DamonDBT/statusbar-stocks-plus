package com.github.xiaohundun.statusbarstocks;

import com.intellij.ui.JBIntSpinner;
import com.intellij.ui.JBSplitter;
import com.intellij.ui.components.JBCheckBox;
import com.intellij.ui.components.JBLabel;
import com.intellij.ui.components.JBTextField;
import com.intellij.util.ui.FormBuilder;

import javax.swing.*;

public class PluginSettingsComponent {
    private final JPanel myMainPanel;
    private final JBTextField stockCode = new JBTextField();
    private final JBCheckBox nameVisible = new JBCheckBox("show name");
    private final JBCheckBox codeVisible = new JBCheckBox("show code");
    private final JBCheckBox pinyinVisible = new JBCheckBox("show pinyin");
    private final JBCheckBox priceVisible = new JBCheckBox("show price");
    private final JBCheckBox changePercentageVisible = new JBCheckBox("show change");
    private final JBCheckBox lowProfileMode = new JBCheckBox("low mode");
    private final JBCheckBox percentVisible = new JBCheckBox("show %");
    //    private final JBTextField refreshInterval = new JBTextField();
    private final JBIntSpinner refreshInterval = new JBIntSpinner(5, 1, 3600);
    private final JBCheckBox marketCloseVisible = new JBCheckBox("market close visible");

    public PluginSettingsComponent() {
        stockCode.setText(AppSettingsState.getInstance().stockCode);
        refreshInterval.setNumber(AppSettingsState.getInstance().refreshInterval);
        priceVisible.setSelected(AppSettingsState.getInstance().priceVisible);
        changePercentageVisible.setSelected(AppSettingsState.getInstance().changePercentageVisible);
        lowProfileMode.setSelected(AppSettingsState.getInstance().lowProfileMode);
        nameVisible.setSelected(AppSettingsState.getInstance().nameVisible);
        codeVisible.setSelected(AppSettingsState.getInstance().codeVisible);
        pinyinVisible.setSelected(AppSettingsState.getInstance().pinyinVisible);
        percentVisible.setSelected(AppSettingsState.getInstance().percentVisible);
        marketCloseVisible.setSelected(AppSettingsState.getInstance().marketCloseVisible);
        myMainPanel = FormBuilder.createFormBuilder()
                .addLabeledComponent(new JBLabel("Stock code(comma-separated): "), stockCode, 1, false)
                .addLabeledComponent(new JBLabel("Refresh interval(seconds): "), refreshInterval, 1, false)
                .addComponent(nameVisible, 1)
                .addComponent(codeVisible, 1)
                .addComponent(pinyinVisible, 1)
                .addComponent(createSeparator(), 1)
                .addComponent(priceVisible, 1)
                .addComponent(changePercentageVisible, 1)
                .addComponent(lowProfileMode, 1)
                .addComponent(percentVisible, 1)
                .addComponent(marketCloseVisible, 1)
                .addComponentFillVertically(new JPanel(), 0)
                .getPanel();
    }

    /**
     * 创建标准分割线
     */
    private JBSplitter createSeparator() {
        JBSplitter splitter = new JBSplitter(false);
        splitter.setFirstComponent(new JPanel());
        splitter.setSecondComponent(new JPanel());
        splitter.setHonorComponentsMinimumSize(true);
        return splitter;
    }

    public JPanel getPanel() {
        return myMainPanel;
    }

    public JComponent getPreferredFocusedComponent() {
        return stockCode;
    }

    public String getStockCode() {
        return stockCode.getText();
    }

    public boolean getPriceVisible() {
        return priceVisible.isSelected();
    }

    public boolean getLowProfileMode() {
        return lowProfileMode.isSelected();
    }

    public boolean getChangePercentageVisible() {
        return changePercentageVisible.isSelected();
    }

    public boolean getNameVisible() {
        return nameVisible.isSelected();
    }

    public boolean getPinyinVisible() {
        return pinyinVisible.isSelected();
    }

    public boolean getCodeVisible() {
        return codeVisible.isSelected();
    }
    public boolean getPercentVisible() {
        return percentVisible.isSelected();
    }
    public boolean getMarketCloseVisible() {
        return marketCloseVisible.isSelected();
    }

    public int getRefreshInterval() {
        return refreshInterval.getNumber();
    }
}
