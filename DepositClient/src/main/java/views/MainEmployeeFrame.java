package views;

import depositclient.builder.implementation.ClientBuilder;
import depositclient.builder.implementation.ContractBuilder;
import depositclient.builder.implementation.DepositTypeBuilder;
import depositclient.model.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.TableModel;

import depositclient.entity.Client;
import depositclient.entity.Contract;
import depositclient.entity.DepositType;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import tableModels.ClientsTableModel;
import tableModels.ContractsTableModel;
import tableModels.DepositTypesTableModel;

public class MainEmployeeFrame extends JFrame {
    private final String userLogin;
    private TableModel model;
    private JFrame graph;

    public MainEmployeeFrame(String login) {
        userLogin = login;
        initComponents();
    }

    private void initComponents() {
        LookThroughContracts = new JDialog();
        jPanel2 = new ImagePanel(1);
        jLabel2 = new JLabel();
        jScrollPane1 = new JScrollPane();
        ContactsTable = new JTable();
        ReturnFromWatchingContractsButton = new JButton();
        lookThroughMyClientsDialog = new JDialog();
        jPanel3 = new ImagePanel(1);
        jLabel3 = new JLabel();
        jScrollPane2 = new JScrollPane();
        ClientDataTable = new JTable();
        ReturnFromWatchingMyClientsButton = new JButton();
        LookThroughDepositTypesDialog = new JDialog();
        jPanel4 = new ImagePanel(1);
        jLabel4 = new JLabel();
        jScrollPane3 = new JScrollPane();
        DepositTypes = new JTable();
        ReturnFromWatchingDepTypesButton = new JButton();
        economicPerformanceDialog = new JDialog();
        jPanel5 = new ImagePanel(1);
        jLabel5 = new JLabel();
        jLabel6 = new JLabel();
        jLabel7 = new JLabel();
        jLabel8 = new JLabel();
        jLabel9 = new JLabel();
        jLabel10 = new JLabel();
        jLabel11 = new JLabel();
        jLabel12 = new JLabel();
        InitialAmountField = new JTextField();
        NumberOfYearsField = new JTextField();
        CapitalizationField = new JTextField();
        PercentField = new JTextField();
        makePredictionButton = new JButton();
        jLabel13 = new JLabel();
        FinalAmountField = new JTextField();
        jLabel14 = new JLabel();
        FinalAmountField1 = new JTextField();
        jLabel15 = new JLabel();
        NumberOfYearsField1 = new JTextField();
        jLabel16 = new JLabel();
        CapitalizationField1 = new JTextField();
        jLabel17 = new JLabel();
        PercentField1 = new JTextField();
        jLabel18 = new JLabel();
        InitialAmountField1 = new JTextField();
        makePredictionButton1 = new JButton();
        jLabel19 = new JLabel();
        InitialAmountField2 = new JTextField();
        jLabel20 = new JLabel();
        NumberOfYearsField2 = new JTextField();
        jLabel21 = new JLabel();
        CapitalizationField2 = new JTextField();
        jLabel22 = new JLabel();
        FinalAmountField2 = new JTextField();
        jLabel23 = new JLabel();
        PercentField2 = new JTextField();
        makePredictionButton2 = new JButton();
        jSeparator1 = new JSeparator();
        jSeparator3 = new JSeparator();
        jSeparator2 = new JSeparator();
        ReturnFromPredictionButton = new JButton();
        SimpleComplexPercentDialog = new JDialog();
        jPanel6 = new ImagePanel(1);
        jLabel24 = new JLabel();
        jLabel25 = new JLabel();
        jLabel26 = new JLabel();
        jLabel27 = new JLabel();
        CompareInitialMonField = new JTextField();
        ComparePercentField = new JTextField();
        ComparePeriodField = new JTextField();
        jButton1 = new JButton();
        CompareButton = new JButton();
        jPanel1 = new ImagePanel(3);
        jLabel1 = new JLabel();
        lookThroughMyContractsButton = new JButton();
        lookThroughMyClientsButton = new JButton();
        depositsTypesButton = new JButton();
        economicPerformanceButton = new JButton();
        exitButton = new JButton();
        simpleComplexPercentButton = new JButton();
        searchInput1 = new JTextField();
        sortCheck1 = new JCheckBox("Cортировка по дате");
        searchProps1 = new JComboBox<>();
        searchInput2 = new JTextField();
        sortCheck2 = new JCheckBox("Cортировка по ФИО");
        searchProps2 = new JComboBox<>();
        searchInput3 = new JTextField();
        sortCheck3 = new JCheckBox("Cортировка по периоду");
        searchProps3 = new JComboBox<>();
        searchProps1.addItem("Поиск по --");
        searchProps1.addItem("ID клиента");
        searchProps1.addItem("ID сотрудника");

        jLabel2.setForeground(Color.white);
        jLabel3.setForeground(Color.white);
        jLabel4.setForeground(Color.white);
        jLabel5.setForeground(Color.white);
        jLabel6.setForeground(Color.white);
        jLabel7.setForeground(Color.white);
        jLabel8.setForeground(Color.white);
        jLabel9.setForeground(Color.white);
        jLabel10.setForeground(Color.white);
        jLabel11.setForeground(Color.white);
        jLabel12.setForeground(Color.white);
        jLabel13.setForeground(Color.white);
        jLabel14.setForeground(Color.white);
        jLabel15.setForeground(Color.white);
        jLabel16.setForeground(Color.white);
        jLabel17.setForeground(Color.white);
        jLabel18.setForeground(Color.white);
        jLabel19.setForeground(Color.white);
        jLabel20.setForeground(Color.white);
        jLabel21.setForeground(Color.white);
        jLabel22.setForeground(Color.white);
        jLabel23.setForeground(Color.white);
        jLabel24.setForeground(Color.white);
        jLabel25.setForeground(Color.white);
        jLabel26.setForeground(Color.white);
        jLabel27.setForeground(Color.white);

        searchProps2.addItem("Поиск по --");
        searchProps2.addItem("Логин");
        searchProps2.addItem("Паспорт");
        searchProps2.addItem("Телефон");

        searchProps3.addItem("Поиск по --");
        searchProps3.addItem("Название");
        searchProps3.addItem("Минимальная сумма");
        searchProps3.addItem("Максимальная сумма");
        searchProps3.addItem("Ставка процента");

        searchInput1.setFont(new Font("Raleway", Font.PLAIN, 17));
        searchInput1.setPreferredSize(new Dimension(150, 32));
        searchInput1.setMinimumSize(new Dimension(150, 32));
        searchInput1.setMaximumSize(new Dimension(150, 32));

        searchInput2.setFont(new Font("Raleway", Font.PLAIN, 17));
        searchInput2.setPreferredSize(new Dimension(150, 32));
        searchInput2.setMinimumSize(new Dimension(150, 32));
        searchInput2.setMaximumSize(new Dimension(150, 32));

        searchInput3.setFont(new Font("Raleway", Font.PLAIN, 17));
        searchInput3.setPreferredSize(new Dimension(150, 32));
        searchInput3.setMinimumSize(new Dimension(150, 32));
        searchInput3.setMaximumSize(new Dimension(150, 32));

        sortCheck1.setPreferredSize(new Dimension(30, 30));
        sortCheck1.setSelected(false);
        sortCheck2.setPreferredSize(new Dimension(30, 30));
        sortCheck2.setSelected(false);
        sortCheck3.setPreferredSize(new Dimension(30, 30));
        sortCheck3.setSelected(false);

        searchProps1.setPreferredSize(new Dimension(100, 32));
        searchProps1.setMaximumSize(new Dimension(100, 32));
        searchProps1.setMinimumSize(new Dimension(100, 32));
        searchProps2.setPreferredSize(new Dimension(100, 32));
        searchProps2.setMaximumSize(new Dimension(100, 32));
        searchProps2.setMinimumSize(new Dimension(100, 32));
        searchProps3.setPreferredSize(new Dimension(100, 32));
        searchProps3.setMaximumSize(new Dimension(100, 32));
        searchProps3.setMinimumSize(new Dimension(100, 32));

        LookThroughContracts.setMinimumSize(new Dimension(619, 640));
        LookThroughContracts.setResizable(false);

        jPanel2.setMinimumSize(new Dimension(619, 594));

        jLabel2.setFont(new Font("Raleway", Font.PLAIN, 24));
        jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel2.setText("Информация о договорах");

        ContactsTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                },
                new String[]{
                        "Title 1", "Title 2", "Title 3", "Title 4"
                }
        ));
        jScrollPane1.setViewportView(ContactsTable);

        ReturnFromWatchingContractsButton.setText("Назад");
        ReturnFromWatchingContractsButton.setBorderPainted(false);
        ReturnFromWatchingContractsButton.setPreferredSize(new Dimension(100, 50));
        ReturnFromWatchingContractsButton.setBackground(new Color(177, 220, 252));
        ReturnFromWatchingContractsButton.addActionListener(this::returnFromWatchingContracts);

        searchProps1.addActionListener(this::searchContracts);
        sortCheck1.addActionListener(this::sortByContractDate);

        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jLabel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(70, 70, 70)
                                                .addContainerGap()
                                                .addComponent(searchInput1)
                                                .addComponent(searchProps1)
                                                .addGap(80, 80, 80)
                                                .addComponent(sortCheck1))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addGap(73, 73, 73)
                                                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(ReturnFromWatchingContractsButton)))
                                                .addGap(0, 79, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup()
                                        .addComponent(searchInput1)
                                        .addComponent(searchProps1)
                                        .addComponent(sortCheck1))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(ReturnFromWatchingContractsButton)
                                .addContainerGap(46, Short.MAX_VALUE))
        );

        GroupLayout lookThroughContractsLayout = new GroupLayout(LookThroughContracts.getContentPane());
        LookThroughContracts.getContentPane().setLayout(lookThroughContractsLayout);
        lookThroughContractsLayout.setHorizontalGroup(
                lookThroughContractsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        lookThroughContractsLayout.setVerticalGroup(
                lookThroughContractsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        lookThroughMyClientsDialog.setMinimumSize(new Dimension(1162, 673));
        lookThroughMyClientsDialog.setResizable(false);

        jPanel3.setMinimumSize(new Dimension(1162, 653));

        jLabel3.setFont(new Font("Raleway", Font.PLAIN, 24));
        jLabel3.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel3.setText("Информация о клиентах");

        ClientDataTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                },
                new String[]{
                        "Title 1", "Title 2", "Title 3", "Title 4"
                }
        ));
        jScrollPane2.setViewportView(ClientDataTable);

        ReturnFromWatchingMyClientsButton.setFont(new Font("Raleway", Font.PLAIN, 16));
        ReturnFromWatchingMyClientsButton.setText("Назад");
        ReturnFromWatchingMyClientsButton.setBorderPainted(false);
        ReturnFromWatchingMyClientsButton.setPreferredSize(new Dimension(100, 50));
        ReturnFromWatchingMyClientsButton.setBackground(new Color(177, 220, 252));
        ReturnFromWatchingMyClientsButton.addActionListener(this::returnFromWatchingMyClients);

        searchProps2.addActionListener(this::searchClients);
        sortCheck2.addActionListener(this::sortByClientFullName);

        GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jLabel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(170, 170, 170)
                                                .addContainerGap()
                                                .addComponent(searchInput2)
                                                .addComponent(searchProps2)
                                                .addGap(80, 80, 80)
                                                .addComponent(sortCheck2))
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(ReturnFromWatchingMyClientsButton))
                                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                                .addGap(115, 115, 115)
                                                                .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 943, GroupLayout.PREFERRED_SIZE)))
                                                .addGap(0, 89, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup()
                                        .addComponent(searchInput2)
                                        .addComponent(searchProps2)
                                        .addComponent(sortCheck2))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(ReturnFromWatchingMyClientsButton)
                                .addContainerGap(57, Short.MAX_VALUE))
        );

        GroupLayout lookThroughMyClientsDialogLayout = new GroupLayout(lookThroughMyClientsDialog.getContentPane());
        lookThroughMyClientsDialog.getContentPane().setLayout(lookThroughMyClientsDialogLayout);
        lookThroughMyClientsDialogLayout.setHorizontalGroup(
                lookThroughMyClientsDialogLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        lookThroughMyClientsDialogLayout.setVerticalGroup(
                lookThroughMyClientsDialogLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );

        LookThroughDepositTypesDialog.setMinimumSize(new Dimension(880, 432));
        LookThroughDepositTypesDialog.setResizable(false);

        jPanel4.setMinimumSize(new Dimension(880, 435));

        jLabel4.setFont(new Font("Raleway", Font.PLAIN, 24));
        jLabel4.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel4.setText("Типы вкладов");

        DepositTypes.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                },
                new String[]{
                        "Title 1", "Title 2", "Title 3", "Title 4"
                }
        ));
        jScrollPane3.setViewportView(DepositTypes);

        ReturnFromWatchingDepTypesButton.setFont(new Font("Raleway", Font.PLAIN, 16));
        ReturnFromWatchingDepTypesButton.setText("Назад");
        ReturnFromWatchingDepTypesButton.setBorderPainted(false);
        ReturnFromWatchingDepTypesButton.setPreferredSize(new Dimension(100, 50));
        ReturnFromWatchingDepTypesButton.setBackground(new Color(177, 220, 252));
        ReturnFromWatchingDepTypesButton.addActionListener(this::returnFromWatchingDepTypes);

        searchProps3.addActionListener(this::searchDepTypes);
        sortCheck3.addActionListener(this::sortByTypePeriod);

        GroupLayout jPanel4Layout = new GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addContainerGap(44, Short.MAX_VALUE)
                                .addComponent(jScrollPane3, GroupLayout.PREFERRED_SIZE, 791, GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addContainerGap()
                                .addComponent(searchInput3)
                                .addComponent(searchProps3)
                                .addGap(80, 80, 80)
                                .addComponent(sortCheck3))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addComponent(ReturnFromWatchingDepTypesButton)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup()
                                        .addComponent(searchInput3)
                                        .addComponent(searchProps3)
                                        .addComponent(sortCheck3))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane3, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(ReturnFromWatchingDepTypesButton)
                                .addContainerGap(53, Short.MAX_VALUE))
        );

        GroupLayout lookThroughDepositTypesDialogLayout = new GroupLayout(LookThroughDepositTypesDialog.getContentPane());
        LookThroughDepositTypesDialog.getContentPane().setLayout(lookThroughDepositTypesDialogLayout);
        lookThroughDepositTypesDialogLayout.setHorizontalGroup(
                lookThroughDepositTypesDialogLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        lookThroughDepositTypesDialogLayout.setVerticalGroup(
                lookThroughDepositTypesDialogLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );

        economicPerformanceDialog.setMinimumSize(new Dimension(1152, 460));
        economicPerformanceDialog.setResizable(false);

        jPanel5.setMinimumSize(new Dimension(1152, 429));

        jLabel5.setFont(new Font("Raleway", Font.PLAIN, 24));
        jLabel5.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel5.setText("Расчет экономических показателей");

        jLabel6.setFont(new Font("Raleway", Font.PLAIN, 18));
        jLabel6.setText("Расчет конечной суммы");

        jLabel7.setFont(new Font("Raleway", Font.PLAIN, 18));
        jLabel7.setText("Расчет начальной суммы");

        jLabel8.setFont(new Font("Raleway", Font.PLAIN, 18));
        jLabel8.setText("Расчет процентной ставки");

        jLabel9.setFont(new Font("Raleway", Font.PLAIN, 16));
        jLabel9.setText("Начальная сумма");

        jLabel10.setFont(new Font("Raleway", Font.PLAIN, 16));
        jLabel10.setText("Срок (в годах)");

        jLabel11.setFont(new Font("Raleway", Font.PLAIN, 16));
        jLabel11.setText("Капитализация (р/г)");

        jLabel12.setFont(new Font("Raleway", Font.PLAIN, 16));
        jLabel12.setText("Процент (%)");

        InitialAmountField.setFont(new Font("Raleway", Font.PLAIN, 16));
        InitialAmountField.setText("10000");

        NumberOfYearsField.setFont(new Font("Raleway", Font.PLAIN, 16));
        NumberOfYearsField.setText("10");

        CapitalizationField.setFont(new Font("Raleway", Font.PLAIN, 16));
        CapitalizationField.setText("5");

        PercentField.setFont(new Font("Raleway", Font.PLAIN, 16));
        PercentField.setText("5");

        makePredictionButton.setFont(new Font("Raleway", Font.PLAIN, 16));
        makePredictionButton.setText("Произвести расчет");
        makePredictionButton.setBorderPainted(false);
        makePredictionButton.setPreferredSize(new Dimension(100, 50));
        makePredictionButton.setBackground(new Color(177, 220, 252));
        makePredictionButton.addActionListener(this::makePrediction);

        jLabel13.setFont(new Font("Raleway", Font.PLAIN, 16));
        jLabel13.setText("Конечная сумма");

        FinalAmountField.setText("16446.318");
        FinalAmountField.setEnabled(false);

        jLabel14.setFont(new Font("Raleway", Font.PLAIN, 16));
        jLabel14.setText("Конечная сумма");

        FinalAmountField1.setFont(new Font("Raleway", Font.PLAIN, 16));
        FinalAmountField1.setText("16446.318");

        jLabel15.setFont(new Font("Raleway", Font.PLAIN, 16));
        jLabel15.setText("Срок (в годах)");

        NumberOfYearsField1.setFont(new Font("Raleway", Font.PLAIN, 16));
        NumberOfYearsField1.setText("10");

        jLabel16.setFont(new Font("Raleway", Font.PLAIN, 16));
        jLabel16.setText("Капитализация (р/г)");

        CapitalizationField1.setFont(new Font("Raleway", Font.PLAIN, 16));
        CapitalizationField1.setText("5");

        jLabel17.setFont(new Font("Raleway", Font.PLAIN, 16));
        jLabel17.setText("Процент (%)");

        PercentField1.setFont(new Font("Raleway", Font.PLAIN, 16));
        PercentField1.setText("5");

        jLabel18.setFont(new Font("Raleway", Font.PLAIN, 16));
        jLabel18.setText("Начальная сумма");

        InitialAmountField1.setText("10000");
        InitialAmountField1.setEnabled(false);

        makePredictionButton1.setFont(new Font("Raleway", Font.PLAIN, 16));
        makePredictionButton1.setText("Произвести расчет");
        makePredictionButton1.setBackground(new Color(204, 204, 255));
        makePredictionButton1.setPreferredSize(new Dimension(50, 50));
        makePredictionButton1.setBorderPainted(false);
        makePredictionButton1.addActionListener(this::makeFirstPrediction);

        jLabel19.setFont(new Font("Raleway", Font.PLAIN, 16));
        jLabel19.setText("Начальная сумма");

        InitialAmountField2.setFont(new Font("Raleway", Font.PLAIN, 16));
        InitialAmountField2.setText("10000");

        jLabel20.setFont(new Font("Raleway", Font.PLAIN, 16));
        jLabel20.setText("Срок (в годах)");

        NumberOfYearsField2.setFont(new Font("Raleway", Font.PLAIN, 16));
        NumberOfYearsField2.setText("10");

        jLabel21.setFont(new Font("Raleway", Font.PLAIN, 16));
        jLabel21.setText("Капитализация (р/г)");

        CapitalizationField2.setFont(new Font("Raleway", Font.PLAIN, 16));
        CapitalizationField2.setText("5");

        jLabel22.setFont(new Font("Raleway", Font.PLAIN, 16));
        jLabel22.setText("Конечная сумма");

        FinalAmountField2.setFont(new Font("Raleway", Font.PLAIN, 16));
        FinalAmountField2.setText("16446.318");

        jLabel23.setFont(new Font("Raleway", Font.PLAIN, 16));
        jLabel23.setText("Процент (%)");

        PercentField2.setText("5");
        PercentField2.setEnabled(false);

        makePredictionButton2.setFont(new Font("Raleway", Font.PLAIN, 16));
        makePredictionButton2.setText("Произвести расчет");
        makePredictionButton2.setBackground(new Color(204, 204, 255));
        makePredictionButton2.setPreferredSize(new Dimension(50, 50));
        makePredictionButton2.setBorderPainted(false);
        makePredictionButton2.addActionListener(this::makeSecondPrediction);

        ReturnFromPredictionButton.setFont(new Font("Raleway", Font.PLAIN, 16));
        ReturnFromPredictionButton.setText("Назад");
        ReturnFromPredictionButton.setBorderPainted(false);
        ReturnFromPredictionButton.setPreferredSize(new Dimension(100, 50));
        ReturnFromPredictionButton.setBackground(new Color(177, 220, 252));
        ReturnFromPredictionButton.addActionListener(this::returnFromPrediction);

        GroupLayout jPanel5Layout = new GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
                jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addComponent(jLabel5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addContainerGap())
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addGap(52, 52, 52)
                                                .addComponent(jLabel6)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel7)
                                                .addGap(176, 176, 176)
                                                .addComponent(jLabel8)
                                                .addGap(78, 78, 78))
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                .addGroup(jPanel5Layout.createSequentialGroup()
                                                                        .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                                .addComponent(jLabel9)
                                                                                .addComponent(jLabel10))
                                                                        .addGap(39, 39, 39)
                                                                        .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                                .addComponent(InitialAmountField, GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                                                                                .addComponent(NumberOfYearsField)))
                                                                .addGroup(jPanel5Layout.createSequentialGroup()
                                                                        .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                                .addComponent(jLabel11)
                                                                                .addComponent(jLabel12))
                                                                        .addGap(18, 18, 18)
                                                                        .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                                .addComponent(FinalAmountField, GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                                                                                .addComponent(CapitalizationField)
                                                                                .addComponent(PercentField))))
                                                        .addComponent(jLabel13)
                                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                                                .addGap(70, 70, 70)
                                                                .addComponent(makePredictionButton)))
                                                .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                                                .addGap(65, 65, 65)
                                                                .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                                                                .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                                        .addComponent(jLabel14, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                        .addComponent(jLabel15, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                                .addGap(52, 52, 52)
                                                                                .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                                        .addComponent(FinalAmountField1, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                                                                        .addComponent(NumberOfYearsField1)))
                                                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                                                                .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(jLabel16, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(jLabel17)
                                                                                        .addComponent(jLabel18))
                                                                                .addGap(18, 18, 18)
                                                                                .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(CapitalizationField1)
                                                                                        .addComponent(PercentField1)
                                                                                        .addComponent(InitialAmountField1))))
                                                                .addGap(72, 72, 72)
                                                                .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel19)
                                                                        .addComponent(jLabel20)
                                                                        .addComponent(jLabel21)
                                                                        .addComponent(jLabel22)
                                                                        .addComponent(jLabel23))
                                                                .addGap(44, 44, 44)
                                                                .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(InitialAmountField2)
                                                                        .addComponent(NumberOfYearsField2)
                                                                        .addComponent(CapitalizationField2)
                                                                        .addComponent(FinalAmountField2, GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                                                                        .addComponent(PercentField2))
                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(makePredictionButton1)
                                                                .addGap(201, 201, 201)
                                                                .addComponent(makePredictionButton2)
                                                                .addGap(111, 111, 111))))))
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addGap(37, 37, 37)
                                                .addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 275, GroupLayout.PREFERRED_SIZE)
                                                .addGap(149, 149, 149)
                                                .addComponent(jSeparator3, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE)
                                                .addGap(169, 169, 169)
                                                .addComponent(jSeparator2, GroupLayout.PREFERRED_SIZE, 221, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(ReturnFromPredictionButton)))
                                .addGap(0, 90, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
                jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel8))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel9)
                                        .addComponent(InitialAmountField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel14)
                                        .addComponent(FinalAmountField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel19)
                                        .addComponent(InitialAmountField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel10)
                                        .addComponent(NumberOfYearsField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel15)
                                        .addComponent(NumberOfYearsField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel20)
                                        .addComponent(NumberOfYearsField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel11)
                                        .addComponent(CapitalizationField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel16)
                                        .addComponent(CapitalizationField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel21)
                                        .addComponent(CapitalizationField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel12)
                                        .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(PercentField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel17)
                                                .addComponent(PercentField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel22)
                                                .addComponent(FinalAmountField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(makePredictionButton)
                                        .addComponent(makePredictionButton1)
                                        .addComponent(makePredictionButton2))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                                .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jSeparator2, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel13)
                                                        .addComponent(FinalAmountField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel18)
                                                        .addComponent(InitialAmountField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel23)
                                                        .addComponent(PercentField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(jSeparator3, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ReturnFromPredictionButton)
                                .addGap(8, 8, 8))
        );

        GroupLayout economicPerformanceDialogLayout = new GroupLayout(economicPerformanceDialog.getContentPane());
        economicPerformanceDialog.getContentPane().setLayout(economicPerformanceDialogLayout);
        economicPerformanceDialogLayout.setHorizontalGroup(
                economicPerformanceDialogLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        economicPerformanceDialogLayout.setVerticalGroup(
                economicPerformanceDialogLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(economicPerformanceDialogLayout.createSequentialGroup()
                                .addComponent(jPanel5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 39, Short.MAX_VALUE))
        );

        SimpleComplexPercentDialog.setMinimumSize(new Dimension(570, 404));
        SimpleComplexPercentDialog.setResizable(false);

        jPanel6.setMinimumSize(new Dimension(540, 384));

        jLabel24.setFont(new Font("Raleway", Font.PLAIN, 18));
        jLabel24.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel24.setText("Сравнение простых и сложных процентов");

        jLabel25.setFont(new Font("Raleway", Font.PLAIN, 16));
        jLabel25.setText("Начальная сумма");

        jLabel26.setFont(new Font("Raleway", Font.PLAIN, 16));
        jLabel26.setText("Процентная ставка");

        jLabel27.setFont(new Font("Raleway", Font.PLAIN, 16));
        jLabel27.setText("Период");

        CompareInitialMonField.setFont(new Font("Raleway", Font.PLAIN, 16));

        ComparePercentField.setFont(new Font("Raleway", Font.PLAIN, 16));

        ComparePeriodField.setFont(new Font("Raleway", Font.PLAIN, 16));

        jButton1.setFont(new Font("Raleway", Font.PLAIN, 16));
        jButton1.setText("Назад");
        jButton1.setBackground(new Color(204, 204, 255));
        jButton1.setPreferredSize(new Dimension(50, 50));
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(this::jButton1ActionPerformed);

        CompareButton.setFont(new Font("Raleway", Font.PLAIN, 16));
        CompareButton.setText("Сравнить");
        CompareButton.setBorderPainted(false);
        CompareButton.setPreferredSize(new Dimension(100, 50));
        CompareButton.setBackground(new Color(177, 220, 252));
        CompareButton.addActionListener(this::compareButtonActionPerformed);

        GroupLayout jPanel6Layout = new GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
                jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel24, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                                .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel25)
                                                        .addComponent(jLabel26)
                                                        .addComponent(jLabel27))
                                                .addGap(41, 41, 41)
                                                .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(CompareInitialMonField)
                                                        .addComponent(ComparePercentField)
                                                        .addComponent(ComparePeriodField)
                                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                                                .addComponent(CompareButton, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, Short.MAX_VALUE))))
                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                                .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
                jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel24, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel25)
                                        .addComponent(CompareInitialMonField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel26)
                                        .addComponent(ComparePercentField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel27)
                                        .addComponent(ComparePeriodField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                                .addComponent(CompareButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32))
        );

        GroupLayout simpleComplexPercentDialogLayout = new GroupLayout(SimpleComplexPercentDialog.getContentPane());
        SimpleComplexPercentDialog.getContentPane().setLayout(simpleComplexPercentDialogLayout);
        simpleComplexPercentDialogLayout.setHorizontalGroup(
                simpleComplexPercentDialogLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        simpleComplexPercentDialogLayout.setVerticalGroup(
                simpleComplexPercentDialogLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(419, 500));
        setResizable(false);

        jPanel1.setMinimumSize(new java.awt.Dimension(800, 200));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 200));
        jPanel1.setMaximumSize(new java.awt.Dimension(800, 200));

        jPanel1.setBackground(new Color(220, 208, 255));
        jLabel1.setFont(new Font("Raleway", Font.PLAIN, 30));
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel1.setText("Меню консультанта");

        lookThroughMyContractsButton.setFont(new Font("Raleway", Font.PLAIN, 18));
        lookThroughMyContractsButton.setText("Просмотреть договоры");
        lookThroughMyContractsButton.setBackground(new Color(204, 204, 255));
        lookThroughMyContractsButton.setPreferredSize(new Dimension(50, 50));
        lookThroughMyContractsButton.setBorderPainted(false);
        lookThroughMyContractsButton.addActionListener(this::lookThroughMyContracts);

        lookThroughMyClientsButton.setFont(new Font("Raleway", Font.PLAIN, 18));
        lookThroughMyClientsButton.setText("Просмотреть клиентов");
        lookThroughMyClientsButton.setBorderPainted(false);
        lookThroughMyClientsButton.setBackground(new Color(204, 204, 255));
        lookThroughMyClientsButton.setPreferredSize(new Dimension(50, 50));
        lookThroughMyClientsButton.addActionListener(this::lookThroughMyClients);

        depositsTypesButton.setFont(new Font("Raleway", Font.PLAIN, 18));
        depositsTypesButton.setText("Типы вкладов");
        depositsTypesButton.setBorderPainted(false);
        depositsTypesButton.setBackground(new Color(177, 220, 252));
        depositsTypesButton.setPreferredSize(new Dimension(100, 50));
        depositsTypesButton.addActionListener(this::depositsTypes);

        economicPerformanceButton.setFont(new Font("Raleway", Font.PLAIN, 18));
        economicPerformanceButton.setText("Расчет показателей");
        economicPerformanceButton.setBorderPainted(false);
        economicPerformanceButton.setBackground(new Color(123, 161, 255));
        economicPerformanceButton.setPreferredSize(new Dimension(50, 50));
        economicPerformanceButton.addActionListener(this::economicPerformance);

        exitButton.setFont(new Font("Raleway", Font.PLAIN, 18));
        exitButton.setText("Выход");
        exitButton.setBorderPainted(false);
        exitButton.setPreferredSize(new Dimension(100, 50));
        exitButton.setBackground(new Color(177, 220, 252));
        exitButton.addActionListener(this::exitButtonActionPerformed);

        simpleComplexPercentButton.setFont(new Font("Raleway", Font.PLAIN, 18));
        simpleComplexPercentButton.setText("Простые и сложные проценты");
        simpleComplexPercentButton.setBorderPainted(false);
        simpleComplexPercentButton.setBackground(new Color(123, 161, 255));
        simpleComplexPercentButton.setPreferredSize(new Dimension(50, 50));
        simpleComplexPercentButton.addActionListener(this::simpleComplexPercent);

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lookThroughMyContractsButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, 300)
                                        .addComponent(lookThroughMyClientsButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, 300)
                                        .addComponent(depositsTypesButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, 300)
                                        .addComponent(economicPerformanceButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, 300)
                                        .addComponent(exitButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, 300)
                                        .addComponent(simpleComplexPercentButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, 300))
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lookThroughMyContractsButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lookThroughMyClientsButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(depositsTypesButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(economicPerformanceButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(simpleComplexPercentButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(exitButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(82, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    private void lookThroughMyContracts(ActionEvent evt) {
        String sqlString = "SELECT * FROM contacts INNER JOIN employees ON contacts.EmployeeID = employees.EmployeeID where employees.EmployeeLogin = '" + userLogin + "'";
        ArrayList<Contract> contracts = new ArrayList<>();
        SocketStream server = new SocketStream();
        server.sendInt(4);
        server.sendString(sqlString);
        try {
            int count = server.getInt();
            for (int i = 0; i < count; i++) {
                double contractNumber = Double.parseDouble(server.getString());
                String dateOfSigning = server.getString();
                double clientID = Double.parseDouble(server.getString());
                double employeeID = Double.parseDouble(server.getString());
                contracts.add(new Contract((int) contractNumber, dateOfSigning, (int) clientID, (int) employeeID));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        model = new ContractsTableModel(contracts);
        ContactsTable.setModel(model);
        this.setVisible(false);
        LookThroughContracts.setVisible(true);
    }

    private void returnFromWatchingContracts(ActionEvent evt) {
        this.setVisible(true);
        LookThroughContracts.setVisible(false);
    }

    private void lookThroughMyClients(ActionEvent evt) {
        String sqlString = "select * from clients INNER JOIN contacts ON contacts.ClientID = clients.ClientID INNER JOIN employees ON contacts.EmployeeID = employees.EmployeeID where employees.EmployeeLogin = '" + userLogin + "'";
        ArrayList<Client> client = new ArrayList<>();
        SocketStream server = new SocketStream();
        server.sendInt(2);
        server.sendString(sqlString);
        try {
            int count = server.getInt();
            for (int i = 0; i < count; i++) {
                client.add(new ClientBuilder()
                        .buildClientId((int) Double.parseDouble(server.getString()))
                        .buildLogin(server.getString())
                        .buildPassword(server.getString())
                        .buildFullName(server.getString())
                        .buildPassport(server.getString())
                        .buildPhoneNumber(server.getString())
                        .buildAddress(server.getString())
                        .build());
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        model = new ClientsTableModel(client);
        lookThroughMyClientsDialog.setVisible(true);
        ClientDataTable.setModel(model);
        this.setVisible(false);
    }

    private void returnFromWatchingMyClients(ActionEvent evt) {
        lookThroughMyClientsDialog.setVisible(false);
        this.setVisible(true);
    }

    private void depositsTypes(ActionEvent evt) {
        String sqlString = "select * from deposittypes";
        ArrayList<DepositType> deposit = new ArrayList<>();
        SocketStream server = new SocketStream();
        server.sendInt(6);
        server.sendString(sqlString);
        try {
            int count = server.getInt();
            for (int i = 0; i < count; i++) {
                deposit.add(new DepositTypeBuilder()
                        .buildId((int) Double.parseDouble(server.getString()))
                        .buildName(server.getString())
                        .buildMinMoney((int) Double.parseDouble(server.getString()))
                        .buildMaxMoney((int) Double.parseDouble(server.getString()))
                        .buildPeriod((int) Double.parseDouble(server.getString()))
                        .buildCapitalization((int) Double.parseDouble(server.getString()))
                        .buildPercent((int) Double.parseDouble(server.getString()))
                        .build());
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        model = new DepositTypesTableModel(deposit);
        LookThroughDepositTypesDialog.setVisible(true);
        DepositTypes.setModel(model);
        this.setVisible(false);
    }

    private void returnFromWatchingDepTypes(ActionEvent evt) {
        LookThroughDepositTypesDialog.setVisible(false);
        this.setVisible(true);
    }

    private void makePrediction(ActionEvent evt) {
        double initialAmountOfMoney = 10000.0;
        double numberOfYears = 10.0;
        double capitalization = 5.0;
        double percent = 5.0;
        int code = 0;
        try {
            initialAmountOfMoney = Double.parseDouble(InitialAmountField.getText());
            numberOfYears = Double.parseDouble(NumberOfYearsField.getText());
            capitalization = Double.parseDouble(CapitalizationField.getText());
            percent = Double.parseDouble(PercentField.getText());
            if (initialAmountOfMoney <= 0 || numberOfYears <= 0 || capitalization <= 0 || percent <= 0) {
                JOptionPane.showMessageDialog(null, "Введенные данные некорректны!",
                        "Нажмите ОК для повторного ввода", JOptionPane.ERROR_MESSAGE);
            } else {
                code = 1;
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Введенные данные некорректны!",
                    "Нажмите ОК для повторного ввода", JOptionPane.ERROR_MESSAGE);
        }
        if (code == 1) {
            double finalAmountOfMoney = 0;
            SocketStream server = new SocketStream();
            server.sendInt(12);
            server.sendString("" + initialAmountOfMoney);
            server.sendString("" + percent);
            server.sendString("" + capitalization);
            server.sendString("" + numberOfYears);
            try {
                finalAmountOfMoney = Double.parseDouble(server.getString());
            } catch (Exception e) {
                e.printStackTrace();
            }
            finalAmountOfMoney *= 100;
            finalAmountOfMoney = (int) finalAmountOfMoney;
            finalAmountOfMoney = (finalAmountOfMoney) / 100;

            FinalAmountField.setText("" + finalAmountOfMoney);
            this.drawChart(numberOfYears, initialAmountOfMoney, capitalization, percent);
        }
    }

    private void economicPerformance(ActionEvent evt) {
        economicPerformanceDialog.setVisible(true);
        this.setVisible(false);
    }

    private void returnFromPrediction(ActionEvent evt) {
        economicPerformanceDialog.setVisible(false);
        this.setVisible(true);
    }

    private void makeFirstPrediction(ActionEvent evt) {
        double finalAmountOfMoney = 16446.318;
        double numberOfYears = 10.0;
        double capitalization = 5.0;
        double percent = 5.0;
        int code = 0;
        try {
            finalAmountOfMoney = Double.parseDouble(FinalAmountField1.getText());
            numberOfYears = Double.parseDouble(NumberOfYearsField1.getText());
            capitalization = Double.parseDouble(CapitalizationField1.getText());
            percent = Double.parseDouble(PercentField1.getText());
            if (finalAmountOfMoney <= 0 || numberOfYears <= 0 || capitalization <= 0 || percent <= 0) {
                JOptionPane.showMessageDialog(null, "Введенные данные некорректны!",
                        "Нажмите ОК для повторного ввода", JOptionPane.ERROR_MESSAGE);
            } else {
                code = 1;
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Введенные данные некорректны!",
                    "Нажмите ОК для повторного ввода", JOptionPane.ERROR_MESSAGE);
        }
        if (code == 1) {
            double initialAmountOfMoney = 0;
            SocketStream server = new SocketStream();
            server.sendInt(13);
            server.sendString("" + finalAmountOfMoney);
            server.sendString("" + percent);
            server.sendString("" + capitalization);
            server.sendString("" + numberOfYears);
            try {
                initialAmountOfMoney = Double.parseDouble(server.getString());
            } catch (Exception e) {
                e.printStackTrace();
            }

            initialAmountOfMoney *= 100;
            initialAmountOfMoney = (int) initialAmountOfMoney;
            initialAmountOfMoney = (initialAmountOfMoney) / 100;

            InitialAmountField1.setText("" + initialAmountOfMoney);
            this.drawChart(numberOfYears, initialAmountOfMoney, capitalization, percent);
        }
    }

    private void makeSecondPrediction(ActionEvent evt) {
        double finalAmountOfMoney = 16446.318;
        double numberOfYears = 10.0;
        double capitalization = 5.0;
        double initialAmountOfMoney = 10000.0;
        int code = 0;
        try {
            finalAmountOfMoney = Double.parseDouble(FinalAmountField2.getText());
            numberOfYears = Double.parseDouble(NumberOfYearsField2.getText());
            capitalization = Double.parseDouble(CapitalizationField2.getText());
            initialAmountOfMoney = Double.parseDouble(InitialAmountField2.getText());
            if (numberOfYears <= 0 || capitalization <= 0 || initialAmountOfMoney <= 0 || finalAmountOfMoney <= initialAmountOfMoney) {
                JOptionPane.showMessageDialog(null, "Введенные данные некорректны!",
                        "Нажмите ОК для повторного ввода", JOptionPane.ERROR_MESSAGE);
            } else {
                code = 1;
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Введенные данные некорректны!",
                    "Нажмите ОК для повторного ввода", JOptionPane.ERROR_MESSAGE);
        }

        if (code == 1) {
            double percent = 0;
            SocketStream server = new SocketStream();
            server.sendInt(14);
            server.sendString("" + initialAmountOfMoney);
            server.sendString("" + finalAmountOfMoney);
            server.sendString("" + capitalization);
            server.sendString("" + numberOfYears);
            try {
                percent = Double.parseDouble(server.getString());
            } catch (Exception e) {
                e.printStackTrace();
            }
            percent *= 10000;
            percent = (int) percent;
            percent /= 100;

            PercentField2.setText("" + percent);
            this.drawChart(numberOfYears, initialAmountOfMoney, capitalization, percent);

        }
    }

    private void exitButtonActionPerformed(ActionEvent evt) {
        this.setVisible(false);
        Authorization auth = new Authorization();
        auth.setVisible(true);
        auth.setLocationRelativeTo(null);
    }

    private void simpleComplexPercent(ActionEvent evt) {
        SimpleComplexPercentDialog.setVisible(true);
        this.setVisible(false);
    }

    private void jButton1ActionPerformed(ActionEvent evt) {
        SimpleComplexPercentDialog.setVisible(false);
        this.setVisible(true);
    }

    private void compareButtonActionPerformed(ActionEvent evt) {
        double initialAmountOfMoney = 16446.318;
        double numberOfYears = 10.0;
        double capitalization = 10.0;
        double percent = 5.0;
        int code = 0;
        try {
            initialAmountOfMoney = Double.parseDouble(CompareInitialMonField.getText());
            numberOfYears = Double.parseDouble(ComparePeriodField.getText());
            percent = Double.parseDouble(ComparePercentField.getText());
            if (initialAmountOfMoney <= 0 || numberOfYears <= 0 || percent <= 0) {
                JOptionPane.showMessageDialog(null, "Введенные данные некорректны!",
                        "Нажмите ОК для повторного ввода", JOptionPane.ERROR_MESSAGE);
            } else {
                code = 1;
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Введенные данные некорректны!",
                    "Нажмите ОК для повторного ввода", JOptionPane.ERROR_MESSAGE);
        }
        if (code == 1) {
            XYSeries series = new XYSeries("Сложные проценты");
            XYSeries series2 = new XYSeries("Простые проценты");
            for (double i = 0; i < numberOfYears; i += 0.01) {
                series.add(i, this.amountOfMoney(i, initialAmountOfMoney, capitalization, percent));
                double amount = initialAmountOfMoney * (1 + (percent / 100) * i);
                series2.add(i, amount);

            }
            XYSeriesCollection xyDataset = new XYSeriesCollection();
            xyDataset.addSeries(series);
            xyDataset.addSeries(series2);
            JFreeChart chart = ChartFactory.createXYLineChart("Рост суммы вклада со"
                            + " временем", "Годы", "Сумма вклада",
                    xyDataset, PlotOrientation.VERTICAL, true, true, true);
            graph = new JFrame("Увеличение суммы вклада со временем");
            graph.getContentPane().add(new ChartPanel(chart));
            graph.setSize(400, 300);
            graph.setVisible(true);
        }
    }


    private void drawChart(double numberOfYears, double initialAmountOfMoney, double capitalization, double percent) {
        XYSeries series = new XYSeries("Рост суммы вклада");
        for (double i = 0; i < numberOfYears; i += 0.01) {
            double finish = 0;
            SocketStream server = new SocketStream();
            server.sendInt(12);
            server.sendString("" + initialAmountOfMoney);
            server.sendString("" + percent);
            server.sendString("" + capitalization);
            server.sendString("" + i);
            try {
                finish = Double.parseDouble(server.getString());
            } catch (Exception e) {
                e.printStackTrace();
            }
            series.add(i, finish);
        }

        XYDataset xyDataset = new XYSeriesCollection(series);
        JFreeChart chart = ChartFactory.createXYLineChart("Рост суммы вклада со"
                        + " временем", "Годы", "Сумма вклада",
                xyDataset, PlotOrientation.VERTICAL, true, true, true);
        graph = new JFrame("Увеличение суммы вклада со временем");
        graph.getContentPane().add(new ChartPanel(chart));
        graph.setSize(400, 300);
        graph.setVisible(true);
    }

    private double amountOfMoney(double numberOfYears, double initialAmountOfMoney, double capitalization, double percent) {
        double finalAmountOfMoney;
        finalAmountOfMoney = 1 + percent / (100 * capitalization);
        int power = (int) (capitalization * numberOfYears);
        finalAmountOfMoney = Math.pow(finalAmountOfMoney, power);
        finalAmountOfMoney *= initialAmountOfMoney;
        return finalAmountOfMoney;
    }

    private void searchContracts(ActionEvent event) {
        if (searchInput1.getText().isEmpty()) {
            return;
        }
        String sqlString;
        if (searchProps1.getSelectedItem().equals("Поиск по --")) {
            sqlString = "SELECT * FROM contacts INNER JOIN employees ON contacts.EmployeeID = employees.EmployeeID where employees.EmployeeLogin = '" + userLogin + "'";
            searchInput1.setText("");
        } else {
            Map<String, String> properties = new HashMap<>() {{
                put("ID клиента", "ClientID");
                put("ID сотрудника", "EmployeeID");
            }};
            sqlString = "SELECT * FROM contacts INNER JOIN employees ON contacts.EmployeeID = employees.EmployeeID where employees.EmployeeLogin = '"
                    + userLogin + "' AND contacts." + properties.get(searchProps1.getSelectedItem()) + " = '" + searchInput1.getText() + "'";
        }
        ArrayList<Contract> contracts = new ArrayList<>();
        SocketStream server = new SocketStream();
        server.sendInt(4);
        server.sendString(sqlString);
        try {
            int count = server.getInt();
            for (int i = 0; i < count; i++) {
                contracts.add(new ContractBuilder()
                        .buildContractNumber((int) Double.parseDouble(server.getString()))
                        .buildDateOfSigning(server.getString())
                        .buildClientID((int) Double.parseDouble(server.getString()))
                        .buildEmployeeID((int) Double.parseDouble(server.getString()))
                        .build());
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        model = new ContractsTableModel(contracts);
        ContactsTable.setModel(model);
        this.setVisible(false);
        LookThroughContracts.setVisible(true);
    }

    private void searchClients(ActionEvent event) {
        if (searchInput2.getText().isEmpty()) {
            return;
        }
        String sqlString;
        if (searchProps2.getSelectedItem().equals("Поиск по --")) {
            sqlString = "select * from clients INNER JOIN contacts ON contacts.ClientID = clients.ClientID INNER JOIN employees ON contacts.EmployeeID = employees.EmployeeID where employees.EmployeeLogin = '" + userLogin + "'";
            searchInput2.setText("");
        } else {
            Map<String, String> properties = new HashMap<>() {{
                put("Логин", "ClientLogin");
                put("Паспорт", "ClientPassport");
                put("Телефон", "ClientPhoneNumber");
            }};
            sqlString = "select * from clients INNER JOIN contacts ON contacts.ClientID = clients.ClientID INNER JOIN employees ON contacts.EmployeeID = employees.EmployeeID where employees.EmployeeLogin = '" + userLogin
                    + "' AND clients." + properties.get(searchProps2.getSelectedItem()) + " = '" + searchInput2.getText() + "'";
        }
        ArrayList<Client> client = new ArrayList<>();
        SocketStream server = new SocketStream();
        server.sendInt(2);
        server.sendString(sqlString);
        try {
            int count = server.getInt();
            for (int i = 0; i < count; i++) {
                double clientID = Double.parseDouble(server.getString());
                String login = server.getString();
                String password = server.getString();
                String fullName = server.getString();
                String passport = server.getString();
                String phoneNumber = server.getString();
                String address = server.getString();
                client.add(new Client((int) clientID, login, password, fullName, passport, phoneNumber, address));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        model = new ClientsTableModel(client);
        lookThroughMyClientsDialog.setVisible(true);
        ClientDataTable.setModel(model);
        this.setVisible(false);
    }

    private void searchDepTypes(ActionEvent event) {
        if (searchInput3.getText().isEmpty()) {
            return;
        }
        String sqlString;
        if (searchProps3.getSelectedItem().equals("Поиск по --")) {
            sqlString = "select * from deposittypes";
            searchInput3.setText("");
        } else {
            Map<String, String> properties = new HashMap<>() {{
                put("Название", "TypeName");
                put("Минимальная сумма", "TypeMinMoney");
                put("Максимальная сумма", "TypeMaxMoney");
                put("Ставка процента", "TypeInterestRate");
            }};
            sqlString = "select * from deposittypes where " + properties.get(searchProps3.getSelectedItem()) + " = '" + searchInput3.getText() + "'";
        }
        ArrayList<DepositType> deposit = new ArrayList<>();
        SocketStream server = new SocketStream();
        server.sendInt(6);
        server.sendString(sqlString);
        try {
            int count = server.getInt();
            for (int i = 0; i < count; i++) {
                double typeID = Double.parseDouble(server.getString());
                String typeName = server.getString();
                double minMon = Double.parseDouble(server.getString());
                double maxMon = Double.parseDouble(server.getString());
                double typePeriod = Double.parseDouble(server.getString());
                double typeCap = Double.parseDouble(server.getString());
                double typePercent = Double.parseDouble(server.getString());
                deposit.add(new DepositType((int) typeID, typeName, (int) minMon, (int) maxMon, (int) typePeriod, (int) typeCap, (int) typePercent));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        model = new DepositTypesTableModel(deposit);
        LookThroughDepositTypesDialog.setVisible(true);
        DepositTypes.setModel(model);
        this.setVisible(false);
    }

    private void sortByContractDate(ActionEvent event) {
        String sqlString;
        if (sortCheck1.isSelected()) {
            sqlString = "SELECT * FROM contacts INNER JOIN employees ON contacts.EmployeeID = employees.EmployeeID where employees.EmployeeLogin = '"
                    + userLogin + "' ORDER BY contacts.DateOfSigning";
        } else {
            sqlString = "SELECT * FROM contacts INNER JOIN employees ON contacts.EmployeeID = employees.EmployeeID where employees.EmployeeLogin = '" + userLogin + "'";
        }
        ArrayList<Contract> contracts = new ArrayList<>();
        SocketStream server = new SocketStream();
        server.sendInt(4);
        server.sendString(sqlString);
        try {
            int count = server.getInt();
            for (int i = 0; i < count; i++) {
                contracts.add(new ContractBuilder()
                        .buildContractNumber((int) Double.parseDouble(server.getString()))
                        .buildDateOfSigning(server.getString())
                        .buildClientID((int) Double.parseDouble(server.getString()))
                        .buildEmployeeID((int) Double.parseDouble(server.getString()))
                        .build());
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        model = new ContractsTableModel(contracts);
        ContactsTable.setModel(model);
        this.setVisible(false);
        LookThroughContracts.setVisible(true);
    }

    private void sortByClientFullName(ActionEvent event) {
        String sqlString;
        if (sortCheck2.isSelected()) {
            sqlString = "select * from clients INNER JOIN contacts ON contacts.ClientID = clients.ClientID INNER JOIN employees ON contacts.EmployeeID = employees.EmployeeID where employees.EmployeeLogin = '" + userLogin
                    + "' ORDER BY clients.ClientFullName";
        } else {
            sqlString = "select * from clients INNER JOIN contacts ON contacts.ClientID = clients.ClientID INNER JOIN employees ON contacts.EmployeeID = employees.EmployeeID where employees.EmployeeLogin = '" + userLogin + "'";
        }
        ArrayList<Client> client = new ArrayList<>();
        SocketStream server = new SocketStream();
        server.sendInt(2);
        server.sendString(sqlString);
        try {
            int count = server.getInt();
            for (int i = 0; i < count; i++) {
                client.add(new ClientBuilder()
                        .buildClientId((int) Double.parseDouble(server.getString()))
                        .buildLogin(server.getString())
                        .buildPassword(server.getString())
                        .buildFullName(server.getString())
                        .buildPassport(server.getString())
                        .buildPhoneNumber(server.getString())
                        .buildAddress(server.getString())
                        .build());
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        model = new ClientsTableModel(client);
        lookThroughMyClientsDialog.setVisible(true);
        ClientDataTable.setModel(model);
        this.setVisible(false);
    }

    private void sortByTypePeriod(ActionEvent event) {
        String sqlString;
        if (sortCheck3.isSelected()) {
            sqlString = "select * from deposittypes order by TypePeriod";
        } else {
            sqlString = "select * from deposittypes";
        }
        ArrayList<DepositType> deposit = new ArrayList<>();
        SocketStream server = new SocketStream();
        server.sendInt(6);
        server.sendString(sqlString);
        try {
            int count = server.getInt();
            for (int i = 0; i < count; i++) {
                deposit.add(new DepositTypeBuilder()
                        .buildId((int) Double.parseDouble(server.getString()))
                        .buildName(server.getString())
                        .buildMinMoney((int) Double.parseDouble(server.getString()))
                        .buildMaxMoney((int) Double.parseDouble(server.getString()))
                        .buildPeriod((int) Double.parseDouble(server.getString()))
                        .buildCapitalization((int) Double.parseDouble(server.getString()))
                        .buildPercent((int) Double.parseDouble(server.getString()))
                        .build());
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        model = new DepositTypesTableModel(deposit);
        LookThroughDepositTypesDialog.setVisible(true);
        DepositTypes.setModel(model);
        this.setVisible(false);
    }

    private JTextField CapitalizationField;
    private JTextField CapitalizationField1;
    private JTextField CapitalizationField2;
    private JTable ClientDataTable;
    private JButton CompareButton;
    private JTextField CompareInitialMonField;
    private JTextField ComparePercentField;
    private JTextField ComparePeriodField;
    private JTable ContactsTable;
    private JTable DepositTypes;
    private JButton depositsTypesButton;
    private JButton economicPerformanceButton;
    private JDialog economicPerformanceDialog;
    private JButton exitButton;
    private JTextField FinalAmountField;
    private JTextField FinalAmountField1;
    private JTextField FinalAmountField2;
    private JTextField InitialAmountField;
    private JTextField InitialAmountField1;
    private JTextField InitialAmountField2;
    private JDialog LookThroughContracts;
    private JDialog LookThroughDepositTypesDialog;
    private JTextField NumberOfYearsField;
    private JTextField NumberOfYearsField1;
    private JTextField NumberOfYearsField2;
    private JTextField PercentField;
    private JTextField PercentField1;
    private JTextField PercentField2;
    private JButton ReturnFromPredictionButton;
    private JButton ReturnFromWatchingContractsButton;
    private JButton ReturnFromWatchingDepTypesButton;
    private JButton ReturnFromWatchingMyClientsButton;
    private JButton simpleComplexPercentButton;
    private JDialog SimpleComplexPercentDialog;
    private JButton jButton1;
    private JLabel jLabel1;
    private JLabel jLabel10;
    private JLabel jLabel11;
    private JLabel jLabel12;
    private JLabel jLabel13;
    private JLabel jLabel14;
    private JLabel jLabel15;
    private JLabel jLabel16;
    private JLabel jLabel17;
    private JLabel jLabel18;
    private JLabel jLabel19;
    private JLabel jLabel2;
    private JLabel jLabel20;
    private JLabel jLabel21;
    private JLabel jLabel22;
    private JLabel jLabel23;
    private JLabel jLabel24;
    private JLabel jLabel25;
    private JLabel jLabel26;
    private JLabel jLabel27;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JPanel jPanel5;
    private JPanel jPanel6;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JScrollPane jScrollPane3;
    private JSeparator jSeparator1;
    private JSeparator jSeparator2;
    private JSeparator jSeparator3;
    private JButton lookThroughMyClientsButton;
    private JDialog lookThroughMyClientsDialog;
    private JButton lookThroughMyContractsButton;
    private JButton makePredictionButton;
    private JButton makePredictionButton1;
    private JButton makePredictionButton2;
    private JTextField searchInput1;
    private JComboBox<String> searchProps1;
    private JCheckBox sortCheck1;
    private JTextField searchInput2;
    private JComboBox<String> searchProps2;
    private JCheckBox sortCheck2;
    private JTextField searchInput3;
    private JComboBox<String> searchProps3;
    private JCheckBox sortCheck3;

    public class ImagePanel extends JPanel {

        private BufferedImage image;

        public ImagePanel(int i) {
            try {
                switch (i) {
                    case 1:
                        image = ImageIO.read(new File("src/main/resources/bigstock-banking-service-background-ba-365219083.jpg"));
                        break;
                    case 2:
                        image = ImageIO.read(new File("src/main/resources/1610809015_15-p-fon-bank-23.jpg"));
                        break;
                    case 3:
                        image = ImageIO.read(new File("src/main/resources/money.png"));
                        break;
                    case 4:
                        image = ImageIO.read(new File("src/main/resources/Demand-Forecast-3.jpg"));
                        break;
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(image, 0, 0, null); // see javadoc for more info on the parameters
        }

    }
}
