package views;

import depositclient.builder.implementation.*;
import depositclient.entity.Client;
import depositclient.entity.Contract;
import depositclient.entity.Deposit;
import depositclient.entity.DepositType;
import depositclient.entity.Employee;
import depositclient.model.SocketStream;
import depositclient.model.Validator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.TableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import tableModels.ClientsTableModel;
import tableModels.ContractsTableModel;
import tableModels.DepositTypesTableModel;
import tableModels.DepositsTableModel;
import tableModels.EmployeesTableModel;

public class MainAdminFrame extends JFrame {
    private final String userLogin;
    private TableModel model;
    private int count;
    private int rows;
    private int lastID;
    private double absInitialMoney = 0;
    private double absPlannedMoney = 0;
    private final Validator valid;
    private boolean validator;
    private String previous;


    public MainAdminFrame(String login) {
        valid = new Validator();
        userLogin = login;
        initComponents();
    }

    private void initComponents() {
        clientsDialog = new JDialog();
        jPanel2 = new ImagePanel(1);
        jLabel2 = new JLabel();
        jSeparator1 = new JSeparator();
        jScrollPane1 = new JScrollPane();
        clientDataTable = new JTable();
        addClientButton = new JButton();
        editClientButton = new JButton();
        deleteClientButton = new JButton();
        returnFromClientsButton = new JButton();
        putClientsIntoFileButton = new JButton();
        addClientDialog = new JDialog();
        jPanel3 = new ImagePanel(1);
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();
        jLabel6 = new JLabel();
        jLabel7 = new JLabel();
        jLabel8 = new JLabel();
        jLabel9 = new JLabel();
        jLabel10 = new JLabel();
        confirmAddingClientButton = new JButton();
        addClientIDField = new JTextField();
        addClientLoginField = new JTextField();
        addClientPasswordField = new JPasswordField();
        addClientFullNameField = new JTextField();
        addClientPassportField = new JTextField();
        addClientPhoneNumberField = new JTextField();
        addClientAddressField = new JTextField();
        editClientDialog = new JDialog();
        jPanel4 = new ImagePanel(1);
        jLabel11 = new JLabel();
        jLabel12 = new JLabel();
        jLabel13 = new JLabel();
        jLabel14 = new JLabel();
        jLabel15 = new JLabel();
        jLabel16 = new JLabel();
        jLabel17 = new JLabel();
        jLabel18 = new JLabel();
        editClientIDField = new JTextField();
        editClientLoginField = new JTextField();
        editClientPasswordField = new JPasswordField();
        editClientFullName = new JTextField();
        editClientPassport = new JTextField();
        editClientPhoneNumberField = new JTextField();
        editClientAddressField = new JTextField();
        confirmEditingClientButton = new JButton();
        employeesDialog = new JDialog();
        jPanel5 = new ImagePanel(1);
        jLabel19 = new JLabel();
        jSeparator2 = new JSeparator();
        jScrollPane2 = new JScrollPane();
        employeeDataTable = new JTable();
        addEmployeeButton = new JButton();
        editEmployeeButton = new JButton();
        deleteEmployeeButton = new JButton();
        returnFromEmployeesButton = new JButton();
        to = new JButton();
        putEmployeesIntoFileButton = new JButton();
        addEmployeeDialog = new JDialog();
        jPanel6 = new ImagePanel(1);
        jLabel20 = new JLabel();
        jLabel21 = new JLabel();
        jLabel22 = new JLabel();
        jLabel23 = new JLabel();
        jLabel24 = new JLabel();
        jLabel25 = new JLabel();
        jLabel26 = new JLabel();
        jLabel27 = new JLabel();
        addEmployeeIDField = new JTextField();
        addEmployeeLoginField = new JTextField();
        addEmployeePassword = new JPasswordField();
        addEmployeeFullNameField = new JTextField();
        addEmployeeContractNumber = new JTextField();
        addEmployeeYearField = new JTextField();
        jLabel28 = new JLabel();
        addEmployeeMonthField = new JTextField();
        jLabel29 = new JLabel();
        addEmployeeDayField = new JTextField();
        addEmployeePositionField = new JComboBox<>();
        confirmAddingEmployeeButton = new JButton();
        editEmployeeDialog = new JDialog();
        jPanel7 = new ImagePanel(1);
        jLabel30 = new JLabel();
        jLabel31 = new JLabel();
        jLabel32 = new JLabel();
        jLabel33 = new JLabel();
        jLabel34 = new JLabel();
        jLabel35 = new JLabel();
        jLabel36 = new JLabel();
        jLabel37 = new JLabel();
        editEmployeeIDField = new JTextField();
        editEmployeeLoginField = new JTextField();
        editEmployeePassword = new JPasswordField();
        editEmployeeFullName = new JTextField();
        editEmployeeContractNumber = new JTextField();
        editEmployeeDate = new JTextField();
        editEmployeePosition = new JComboBox<>();
        confirmEditingEmployeeButton = new JButton();
        contractsDialog = new JDialog();
        jPanel8 = new ImagePanel(1);
        jLabel38 = new JLabel();
        jSeparator3 = new JSeparator();
        jScrollPane3 = new JScrollPane();
        contractsTable = new JTable();
        addContractButton = new JButton();
        editContractButton = new JButton();
        deleteContractButton = new JButton();
        returnFromContractsButton = new JButton();
        putContractsIntoFileButton = new JButton();
        addContractDialog = new JDialog();
        jPanel9 = new ImagePanel(1);
        jLabel39 = new JLabel();
        jLabel40 = new JLabel();
        addContractNumberField = new JTextField();
        addDateOfSigningLabel = new JLabel();
        addYearOfSigningField = new JTextField();
        jLabel41 = new JLabel();
        addMonthOfSigningField = new JTextField();
        jLabel42 = new JLabel();
        addDayOfSigningField = new JTextField();
        jLabel43 = new JLabel();
        addContractClientID = new JTextField();
        jLabel44 = new JLabel();
        addContractsEmployeeIDField = new JTextField();
        confirmAdditionContractButton = new JButton();
        editContractDialog = new JDialog();
        jPanel10 = new ImagePanel(1);
        jLabel45 = new JLabel();
        jLabel46 = new JLabel();
        jLabel47 = new JLabel();
        jLabel48 = new JLabel();
        jLabel49 = new JLabel();
        editContractNumberField = new JTextField();
        editDateOfSigning = new JTextField();
        editContractClientIDField = new JTextField();
        editContractEmployeeID = new JTextField();
        confirmEditingContractButton = new JButton();
        depositTypesDialog = new JDialog();
        jPanel11 = new ImagePanel(1);
        jLabel50 = new JLabel();
        jSeparator4 = new JSeparator();
        jScrollPane4 = new JScrollPane();
        depositTypesTable = new JTable();
        addDepTypeButton = new JButton();
        editDepTypeButton = new JButton();
        deleteDepTypeButton = new JButton();
        returnFromDepTypesButton = new JButton();
        putDepTypesIntoFileButton = new JButton();
        addDepositTypeDialog = new JDialog();
        jPanel12 = new ImagePanel(1);
        jLabel51 = new JLabel();
        jLabel52 = new JLabel();
        jLabel53 = new JLabel();
        jLabel54 = new JLabel();
        jLabel55 = new JLabel();
        jLabel56 = new JLabel();
        jLabel57 = new JLabel();
        jLabel58 = new JLabel();
        addTypeIDField = new JTextField();
        addTypeNameField = new JTextField();
        addTypeMinMoneyField = new JTextField();
        addTypeMaxMoneyField = new JTextField();
        addTypePeriodField = new JTextField();
        addTypeCapitalizationField = new JTextField();
        addTypePercentField = new JTextField();
        confirmAddingTypeButton = new JButton();
        editDepTypeDialog = new JDialog();
        jPanel13 = new ImagePanel(1);
        jLabel59 = new JLabel();
        jLabel60 = new JLabel();
        jLabel61 = new JLabel();
        jLabel62 = new JLabel();
        jLabel63 = new JLabel();
        jLabel64 = new JLabel();
        jLabel65 = new JLabel();
        jLabel66 = new JLabel();
        editTypeIDField = new JTextField();
        editTypeNameField = new JTextField();
        editTypeMinMonField = new JTextField();
        editTypeMaxMonField = new JTextField();
        editTypePeriodField = new JTextField();
        editTypeCapitalizationField = new JTextField();
        editTypePercentField = new JTextField();
        confirmEditingTypeButton = new JButton();
        depositsDialog = new JDialog();
        jPanel14 = new ImagePanel(1);
        jLabel67 = new JLabel();
        jSeparator5 = new JSeparator();
        jScrollPane5 = new JScrollPane();
        depositsDataTable = new JTable();
        addDepositButton = new JButton();
        editDepositButton = new JButton();
        deleteDepositButton = new JButton();
        returnFromDepositsButton = new JButton();
        putDepositsIntoFile = new JButton();
        drawACircleChartButton = new JButton();
        addDepositDialog = new JDialog();
        jPanel15 = new ImagePanel(1);
        jLabel68 = new JLabel();
        jLabel69 = new JLabel();
        jLabel70 = new JLabel();
        jLabel71 = new JLabel();
        jLabel72 = new JLabel();
        jLabel73 = new JLabel();
        jLabel74 = new JLabel();
        jLabel75 = new JLabel();
        addDepositIDField = new JTextField();
        addDepositInitialMoneyField = new JTextField();
        addDepositYearField = new JTextField();
        jLabel76 = new JLabel();
        addDepositMonthField = new JTextField();
        jLabel77 = new JLabel();
        addDepositDayField = new JTextField();
        addDepositPlannedMoneyField = new JTextField();
        addDepositIDTypeField = new JTextField();
        addDepositContractNumberField = new JTextField();
        addDepositClientIDField = new JTextField();
        confirmAddingDeposit = new JButton();
        editDepositDialog = new JDialog();
        jPanel16 = new ImagePanel(1);
        jLabel78 = new JLabel();
        jLabel79 = new JLabel();
        jLabel80 = new JLabel();
        jLabel81 = new JLabel();
        jLabel82 = new JLabel();
        jLabel83 = new JLabel();
        jLabel84 = new JLabel();
        jLabel85 = new JLabel();
        editDepositIDField = new JTextField();
        editInitialMoneyField = new JTextField();
        editDateOfOpeningField = new JTextField();
        editFinalMoneyField = new JTextField();
        editDepositIDTypeField = new JTextField();
        editDepositIDContractField = new JTextField();
        editDepositIDClientField = new JTextField();
        confirmToEditDepositsButton = new JButton();
        jPanel1 = new ImagePanel(3);

        jLabel1 = new JLabel();
        jLabel1.setForeground(Color.BLACK);
        lookThroughClientsButton = new JButton();
        lookThroughEmployeesButton = new JButton();
        lookThroughContractsButton = new JButton();
        lookThroughDepositTypesButton = new JButton();
        lookThroughDepositsButton = new JButton();
        exitButton = new JButton();
        searchInput1 = new JTextField();
        sortCheck1 = new JCheckBox("Cортировка по ФИО");
        searchProps1 = new JComboBox<>();
        searchInput2 = new JTextField();
        sortCheck2 = new JCheckBox("Cортировка по ФИО");
        sortCheck3 = new JCheckBox("Cортировка по дате найма");
        searchProps2 = new JComboBox<>();
        searchInput4 = new JTextField();
        sortCheck4 = new JCheckBox("Cортировка по дате");
        searchProps4 = new JComboBox<>();
        searchInput5 = new JTextField();
        sortCheck5 = new JCheckBox("Cортировка по периоду");
        searchProps5 = new JComboBox<>();
        searchInput6 = new JTextField();
        sortCheck6 = new JCheckBox("Cортировка по дате открытия");
        searchProps6 = new JComboBox<>();

        searchProps1.addItem("Поиск по --");
        searchProps1.addItem("Логин");
        searchProps1.addItem("Номер контракта");

        searchProps2.addItem("Поиск по --");
        searchProps2.addItem("Логин");
        searchProps2.addItem("Паспорт");
        searchProps2.addItem("Телефон");

        searchProps4.addItem("Поиск по --");
        searchProps4.addItem("ID клиента");
        searchProps4.addItem("ID сотрудника");

        searchProps5.addItem("Поиск по --");
        searchProps5.addItem("Название");
        searchProps5.addItem("Минимальная сумма");
        searchProps5.addItem("Максимальная сумма");
        searchProps5.addItem("Ставка процента");

        searchProps6.addItem("Поиск по --");
        searchProps6.addItem("Начальная сумма");
        searchProps6.addItem("Конечная сумма");
        searchProps6.addItem("Номер типа");
        searchProps6.addItem("Номер контракта");
        searchProps6.addItem("ID клиента");

        searchInput1.setFont(new Font("Raleway", Font.PLAIN, 17));
        searchInput1.setPreferredSize(new Dimension(150, 32));
        searchInput1.setMinimumSize(new Dimension(150, 32));
        searchInput1.setMaximumSize(new Dimension(150, 32));

        searchInput2.setFont(new Font("Raleway", Font.PLAIN, 17));
        searchInput2.setPreferredSize(new Dimension(150, 32));
        searchInput2.setMinimumSize(new Dimension(150, 32));
        searchInput2.setMaximumSize(new Dimension(150, 32));

        searchInput4.setFont(new Font("Raleway", Font.PLAIN, 17));
        searchInput4.setPreferredSize(new Dimension(150, 32));
        searchInput4.setMinimumSize(new Dimension(150, 32));
        searchInput4.setMaximumSize(new Dimension(150, 32));

        searchInput5.setFont(new Font("Raleway", Font.PLAIN, 17));
        searchInput5.setPreferredSize(new Dimension(150, 32));
        searchInput5.setMinimumSize(new Dimension(150, 32));
        searchInput5.setMaximumSize(new Dimension(150, 32));

        searchInput6.setFont(new Font("Raleway", Font.PLAIN, 17));
        searchInput6.setPreferredSize(new Dimension(150, 32));
        searchInput6.setMinimumSize(new Dimension(150, 32));
        searchInput6.setMaximumSize(new Dimension(150, 32));

        sortCheck1.setPreferredSize(new Dimension(30, 30));
        sortCheck1.setSelected(false);
        sortCheck2.setPreferredSize(new Dimension(30, 30));
        sortCheck2.setSelected(false);
        sortCheck3.setPreferredSize(new Dimension(30, 30));
        sortCheck3.setSelected(false);
        sortCheck4.setPreferredSize(new Dimension(30, 30));
        sortCheck4.setSelected(false);
        sortCheck5.setPreferredSize(new Dimension(30, 30));
        sortCheck5.setSelected(false);
        sortCheck6.setPreferredSize(new Dimension(30, 30));
        sortCheck6.setSelected(false);

        searchProps1.setPreferredSize(new Dimension(100, 32));
        searchProps1.setMaximumSize(new Dimension(100, 32));
        searchProps1.setMinimumSize(new Dimension(100, 32));
        searchProps2.setPreferredSize(new Dimension(100, 32));
        searchProps2.setMaximumSize(new Dimension(100, 32));
        searchProps2.setMinimumSize(new Dimension(100, 32));
        searchProps4.setPreferredSize(new Dimension(100, 32));
        searchProps4.setMaximumSize(new Dimension(100, 32));
        searchProps4.setMinimumSize(new Dimension(100, 32));
        searchProps5.setPreferredSize(new Dimension(100, 32));
        searchProps5.setMaximumSize(new Dimension(100, 32));
        searchProps5.setMinimumSize(new Dimension(100, 32));
        searchProps6.setPreferredSize(new Dimension(100, 32));
        searchProps6.setMaximumSize(new Dimension(100, 32));
        searchProps6.setMinimumSize(new Dimension(100, 32));

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
        jLabel28.setForeground(Color.white);
        jLabel29.setForeground(Color.white);
        jLabel30.setForeground(Color.white);
        jLabel31.setForeground(Color.white);
        jLabel32.setForeground(Color.white);
        jLabel33.setForeground(Color.white);
        jLabel34.setForeground(Color.white);
        jLabel35.setForeground(Color.white);
        jLabel36.setForeground(Color.white);
        jLabel37.setForeground(Color.white);
        jLabel38.setForeground(Color.white);
        jLabel39.setForeground(Color.white);
        jLabel40.setForeground(Color.white);
        jLabel41.setForeground(Color.white);
        jLabel42.setForeground(Color.white);
        jLabel43.setForeground(Color.white);
        jLabel44.setForeground(Color.white);
        jLabel45.setForeground(Color.white);
        jLabel46.setForeground(Color.white);
        jLabel47.setForeground(Color.white);
        jLabel48.setForeground(Color.white);
        jLabel49.setForeground(Color.white);
        jLabel50.setForeground(Color.white);
        jLabel51.setForeground(Color.white);
        jLabel52.setForeground(Color.white);
        jLabel53.setForeground(Color.white);
        jLabel54.setForeground(Color.white);
        jLabel55.setForeground(Color.white);
        jLabel56.setForeground(Color.white);
        jLabel57.setForeground(Color.white);
        jLabel58.setForeground(Color.white);
        jLabel59.setForeground(Color.white);
        jLabel60.setForeground(Color.white);
        jLabel61.setForeground(Color.white);
        jLabel62.setForeground(Color.white);
        jLabel63.setForeground(Color.white);
        jLabel64.setForeground(Color.white);
        jLabel65.setForeground(Color.white);
        jLabel66.setForeground(Color.white);
        jLabel67.setForeground(Color.white);
        jLabel68.setForeground(Color.white);
        jLabel69.setForeground(Color.white);
        jLabel70.setForeground(Color.white);
        jLabel71.setForeground(Color.white);
        jLabel72.setForeground(Color.white);
        jLabel73.setForeground(Color.white);
        jLabel74.setForeground(Color.white);
        jLabel75.setForeground(Color.white);
        jLabel76.setForeground(Color.white);
        jLabel77.setForeground(Color.white);
        jLabel78.setForeground(Color.white);
        jLabel79.setForeground(Color.white);
        jLabel80.setForeground(Color.white);
        jLabel81.setForeground(Color.white);
        jLabel82.setForeground(Color.white);
        jLabel83.setForeground(Color.white);
        jLabel84.setForeground(Color.white);
        jLabel85.setForeground(Color.white);

        clientsDialog.setMinimumSize(new java.awt.Dimension(1239, 600));
        clientsDialog.setResizable(false);

        jPanel2.setMinimumSize(new java.awt.Dimension(1209, 695));

        jLabel2.setFont(new Font("Raleway", Font.PLAIN, 24));
        jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel2.setText("Работа с клиентами");

        clientDataTable.setModel(new javax.swing.table.DefaultTableModel(
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
        clientDataTable.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                clientDataTableMouseClicked(evt);
            }
        });
        clientDataTable.setFont(new Font("Raleway", Font.PLAIN, 14));
        clientDataTable.setRowHeight(30);
        jScrollPane1.setViewportView(clientDataTable);
        jScrollPane1.setMaximumSize(new Dimension(800, 500));

        searchProps2.addActionListener(this::searchClients);
        sortCheck2.addActionListener(this::sortByClientFullName);

        addClientButton.setFont(new Font("Raleway", Font.PLAIN, 16));
        addClientButton.setText("Добавить");
        addClientButton.setBackground(new Color(204, 204, 255));
        addClientButton.setPreferredSize(new Dimension(50, 50));
        addClientButton.setBorderPainted(false);
        addClientButton.addActionListener(this::addClientButtonActionPerformed);

        editClientButton.setFont(new Font("Raleway", Font.PLAIN, 16));
        editClientButton.setText("Изменить");
        editClientButton.setBorderPainted(false);
        editClientButton.setBackground(new Color(204, 204, 255));
        editClientButton.setPreferredSize(new Dimension(50, 50));
        editClientButton.setEnabled(false);
        editClientButton.addActionListener(this::editClient);

        deleteClientButton.setFont(new java.awt.Font("Raleway", Font.PLAIN, 16));
        deleteClientButton.setText("Удалить");
        deleteClientButton.setBorderPainted(false);
        deleteClientButton.setBackground(new Color(177, 220, 252));
        deleteClientButton.setPreferredSize(new Dimension(100, 50));
        deleteClientButton.setEnabled(false);
        deleteClientButton.addActionListener(this::deleteClient);

        returnFromClientsButton.setFont(new Font("Raleway", Font.PLAIN, 16));
        returnFromClientsButton.setText("Назад");
        returnFromClientsButton.setBorderPainted(false);
        returnFromClientsButton.setBackground(new Color(123, 161, 255));
        returnFromClientsButton.setPreferredSize(new Dimension(50, 50));
        returnFromClientsButton.addActionListener(this::returnFromClients);

        putClientsIntoFileButton.setFont(new Font("Raleway", Font.PLAIN, 16));
        putClientsIntoFileButton.setText("Выгрузить");
        putClientsIntoFileButton.setBorderPainted(false);
        putClientsIntoFileButton.setBackground(new Color(123, 161, 255));
        putClientsIntoFileButton.setPreferredSize(new Dimension(50, 50));
        putClientsIntoFileButton.addActionListener(this::putClientsIntoFile);

        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);                                                            //работа с клиентом
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jSeparator1)
                                        .addComponent(jLabel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(addClientButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, 150)
                                        .addComponent(editClientButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, 150)
                                        .addComponent(deleteClientButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, 150)
                                        .addComponent(putClientsIntoFileButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, 150)
                                        .addComponent(returnFromClientsButton, GroupLayout.DEFAULT_SIZE, 42, 150))
                                .addGap(80, 80, 80)
                                .addComponent(jScrollPane1)
                        )
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(170, 170, 170)
                                .addContainerGap()
                                .addComponent(searchInput2)
                                .addComponent(searchProps2)
                                .addGap(80, 80, 80)
                                .addComponent(sortCheck2))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(168, 168, 168)
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(228, 228, 228))

                                        .addGap(174, 174, 174)))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup()
                                        .addComponent(searchInput2)
                                        .addComponent(searchProps2)
                                        .addComponent(sortCheck2))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jScrollPane1, 340, 340, 340)
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(addClientButton, GroupLayout.DEFAULT_SIZE, 40, 150))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(editClientButton, GroupLayout.DEFAULT_SIZE, 40, 150))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(deleteClientButton, GroupLayout.DEFAULT_SIZE, 40, 150))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(putClientsIntoFileButton, GroupLayout.DEFAULT_SIZE, 40, 150))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(returnFromClientsButton, GroupLayout.DEFAULT_SIZE, 40, 150))
                                        ))
                                .addGap(18, 18, 18)
                                .addContainerGap(93, Short.MAX_VALUE))
        );

        GroupLayout clientsDialogLayout = new GroupLayout(clientsDialog.getContentPane());
        clientsDialog.getContentPane().setLayout(clientsDialogLayout);
        clientsDialogLayout.setHorizontalGroup(
                clientsDialogLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        clientsDialogLayout.setVerticalGroup(
                clientsDialogLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );

        addClientDialog.setMinimumSize(new java.awt.Dimension(583, 442));
        addClientDialog.setResizable(false);

        jPanel3.setMinimumSize(new java.awt.Dimension(570, 430));

        jLabel3.setFont(new Font("Raleway", Font.PLAIN, 18));
        jLabel3.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel3.setText("Добавление клиента");

        jLabel4.setFont(new Font("Raleway", Font.PLAIN, 16));
        jLabel4.setText("ID клиента");

        jLabel5.setFont(new Font("Raleway", Font.PLAIN, 16));
        jLabel5.setText("Логин");

        jLabel6.setFont(new Font("Raleway", Font.PLAIN, 16));
        jLabel6.setText("Пароль");

        jLabel7.setFont(new Font("Raleway", Font.PLAIN, 16));
        jLabel7.setText("ФИО");

        jLabel8.setFont(new Font("Raleway", Font.PLAIN, 16));
        jLabel8.setText("Паспорт");

        jLabel9.setFont(new Font("Raleway", Font.PLAIN, 16));
        jLabel9.setText("Номер телефона");

        jLabel10.setFont(new Font("Raleway", Font.PLAIN, 16));
        jLabel10.setText("Адрес");

        confirmAddingClientButton.setFont(new Font("Raleway", Font.PLAIN, 16));
        confirmAddingClientButton.setText("Добавить");
        confirmAddingClientButton.addActionListener(this::confirmAddingClient);

        addClientIDField.setFont(new Font("Raleway", Font.PLAIN, 16));
        addClientIDField.setEnabled(false);

        addClientLoginField.setFont(new Font("Raleway", Font.PLAIN, 16));

        addClientPasswordField.setText("password");
        addClientPasswordField.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                addClientPasswordFieldMouseClicked(evt);
            }
        });

        addClientFullNameField.setFont(new Font("Raleway", Font.PLAIN, 16));

        addClientPassportField.setFont(new Font("Raleway", Font.PLAIN, 16));

        addClientPhoneNumberField.setFont(new Font("Raleway", Font.PLAIN, 16));

        addClientAddressField.setFont(new Font("Raleway", Font.PLAIN, 16));

        GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(                                                                                //добавление клиента
                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel4)
                                                        .addComponent(jLabel5)
                                                        .addComponent(jLabel6)
                                                        .addComponent(jLabel7)
                                                        .addComponent(jLabel8)
                                                        .addComponent(jLabel9)
                                                        .addComponent(jLabel10))
                                                .addGap(60, 60, 60)
                                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(addClientLoginField)
                                                        .addComponent(addClientPasswordField)
                                                        .addComponent(addClientIDField)
                                                        .addComponent(addClientFullNameField)
                                                        .addComponent(addClientPassportField)
                                                        .addComponent(addClientPhoneNumberField)
                                                        .addComponent(addClientAddressField))))
                                .addContainerGap())
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(223, 223, 223)
                                .addComponent(confirmAddingClientButton)
                                .addContainerGap(227, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(addClientIDField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5)
                                        .addComponent(addClientLoginField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel6)
                                        .addComponent(addClientPasswordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel7)
                                        .addComponent(addClientFullNameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel8)
                                        .addComponent(addClientPassportField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel9)
                                        .addComponent(addClientPhoneNumberField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel10)
                                        .addComponent(addClientAddressField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(confirmAddingClientButton)
                                .addContainerGap(49, Short.MAX_VALUE))
        );

        GroupLayout addClientDialogLayout = new GroupLayout(addClientDialog.getContentPane());
        addClientDialog.getContentPane().setLayout(addClientDialogLayout);
        addClientDialogLayout.setHorizontalGroup(
                addClientDialogLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        addClientDialogLayout.setVerticalGroup(
                addClientDialogLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        editClientDialog.setMinimumSize(new java.awt.Dimension(553, 442));
        editClientDialog.setResizable(false);

        jPanel4.setMinimumSize(new java.awt.Dimension(540, 430));

        jLabel11.setFont(new Font("Raleway", Font.PLAIN, 18));
        jLabel11.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel11.setText("Редактирование пользовательской информации");

        jLabel12.setFont(new Font("Raleway", Font.PLAIN, 16));
        jLabel12.setText("ID Клиента");

        jLabel13.setFont(new Font("Raleway", Font.PLAIN, 16));
        jLabel13.setText("Логин");

        jLabel14.setFont(new Font("Raleway", Font.PLAIN, 16));
        jLabel14.setText("Пароль");

        jLabel15.setFont(new Font("Raleway", Font.PLAIN, 16));
        jLabel15.setText("ФИО");

        jLabel16.setFont(new Font("Raleway", Font.PLAIN, 16));
        jLabel16.setText("Паспорт");

        jLabel17.setFont(new Font("Raleway", Font.PLAIN, 16));
        jLabel17.setText("Номер телефона");

        jLabel18.setFont(new Font("Raleway", Font.PLAIN, 16));
        jLabel18.setText("Адрес");

        editClientIDField.setFont(new Font("Raleway", Font.PLAIN, 16));
        editClientIDField.setEnabled(false);

        editClientLoginField.setFont(new Font("Raleway", Font.PLAIN, 16));
        editClientLoginField.setEnabled(false);

        editClientPasswordField.setEnabled(false);

        editClientFullName.setFont(new Font("Raleway", Font.PLAIN, 16));

        editClientPassport.setFont(new Font("Raleway", Font.PLAIN, 16));

        editClientPhoneNumberField.setFont(new Font("Raleway", Font.PLAIN, 16));

        editClientAddressField.setFont(new Font("Raleway", Font.PLAIN, 16));

        confirmEditingClientButton.setFont(new Font("Raleway", Font.PLAIN, 16));
        confirmEditingClientButton.setText("Изменить");
        confirmEditingClientButton.addActionListener(this::confirmEditingClient);

        GroupLayout jPanel4Layout = new GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(                                                                                //редактирование клиента
                jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel11, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE)
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel12)
                                                        .addComponent(jLabel13)
                                                        .addComponent(jLabel14)
                                                        .addComponent(jLabel15)
                                                        .addComponent(jLabel16)
                                                        .addComponent(jLabel17)
                                                        .addComponent(jLabel18))
                                                .addGap(47, 47, 47)
                                                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(editClientIDField)
                                                        .addComponent(editClientLoginField)
                                                        .addComponent(editClientPasswordField)
                                                        .addComponent(editClientFullName)
                                                        .addComponent(editClientPassport)
                                                        .addComponent(editClientPhoneNumberField)
                                                        .addComponent(editClientAddressField))))
                                .addContainerGap())
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(218, 218, 218)
                                .addComponent(confirmEditingClientButton)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel11, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel12)
                                        .addComponent(editClientIDField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel13)
                                        .addComponent(editClientLoginField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel14)
                                        .addComponent(editClientPasswordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel15)
                                        .addComponent(editClientFullName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel16)
                                        .addComponent(editClientPassport, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel17)
                                        .addComponent(editClientPhoneNumberField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel18)
                                        .addComponent(editClientAddressField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(confirmEditingClientButton)
                                .addContainerGap(49, Short.MAX_VALUE))
        );

        GroupLayout editClientDialogLayout = new GroupLayout(editClientDialog.getContentPane());
        editClientDialog.getContentPane().setLayout(editClientDialogLayout);
        editClientDialogLayout.setHorizontalGroup(
                editClientDialogLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        editClientDialogLayout.setVerticalGroup(
                editClientDialogLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        employeesDialog.setMinimumSize(new java.awt.Dimension(1209, 630));
        employeesDialog.setResizable(false);

        jLabel19.setFont(new Font("Raleway", Font.PLAIN, 24));
        jLabel19.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel19.setText("Работа с сотрудниками");

        employeeDataTable.setModel(new javax.swing.table.DefaultTableModel(
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
        employeeDataTable.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                employeeDataTableMouseClicked(evt);
            }
        });

        employeeDataTable.setRowHeight(30);
        jScrollPane2.setViewportView(employeeDataTable);
        jScrollPane2.setMaximumSize(new Dimension(800, 500));

        searchProps1.addActionListener(this::searchEmployees);
        sortCheck1.addActionListener(this::sortByEmployeeFullName);
        sortCheck3.addActionListener(this::sortByRecruitmentDate);

        addEmployeeButton.setFont(new Font("Raleway", Font.PLAIN, 16));
        addEmployeeButton.setText("Добавить");
        addEmployeeButton.setBackground(new Color(204, 204, 255));
        addEmployeeButton.setPreferredSize(new Dimension(50, 50));
        addEmployeeButton.setBorderPainted(false);
        addEmployeeButton.addActionListener(this::addEmployee);

        editEmployeeButton.setFont(new Font("Raleway", Font.PLAIN, 16));
        editEmployeeButton.setText("Изменить");
        editEmployeeButton.setEnabled(false);
        editEmployeeButton.setBorderPainted(false);
        editEmployeeButton.setBackground(new Color(204, 204, 255));
        editEmployeeButton.setPreferredSize(new Dimension(50, 50));
        editEmployeeButton.addActionListener(this::editEmployee);

        deleteEmployeeButton.setFont(new Font("Raleway", Font.PLAIN, 16));
        deleteEmployeeButton.setText("Удалить");
        deleteEmployeeButton.setEnabled(false);
        deleteEmployeeButton.setBorderPainted(false);
        deleteEmployeeButton.setBackground(new Color(177, 220, 252));
        deleteEmployeeButton.setPreferredSize(new Dimension(50, 50));
        deleteEmployeeButton.addActionListener(this::deleteEmployee);

        returnFromEmployeesButton.setFont(new Font("Raleway", Font.PLAIN, 16));
        returnFromEmployeesButton.setText("Назад");
        returnFromEmployeesButton.setBorderPainted(false);
        returnFromEmployeesButton.setBackground(new Color(123, 161, 255));
        returnFromEmployeesButton.setPreferredSize(new Dimension(50, 50));
        returnFromEmployeesButton.addActionListener(this::returnFromEmployees);

        putEmployeesIntoFileButton.setFont(new Font("Raleway", Font.PLAIN, 16));
        putEmployeesIntoFileButton.setText("Выгрузить");
        putEmployeesIntoFileButton.setBorderPainted(false);
        putEmployeesIntoFileButton.setBackground(new Color(123, 161, 255));
        putEmployeesIntoFileButton.setPreferredSize(new Dimension(50, 50));
        putEmployeesIntoFileButton.addActionListener(this::putEmployeesIntoFile);


        GroupLayout jPanel5Layout = new GroupLayout(jPanel5);                                                            //работа с работниками
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
                jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jSeparator2)
                                        .addComponent(jLabel19, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(addEmployeeButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, 150)
                                        .addComponent(editEmployeeButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, 150)
                                        .addComponent(deleteEmployeeButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, 150)
                                        .addComponent(putEmployeesIntoFileButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, 150)
                                        .addComponent(returnFromEmployeesButton, GroupLayout.DEFAULT_SIZE, 42, 150))
                                .addGap(80, 80, 80)
                                .addComponent(jScrollPane2)
                        )
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(170, 170, 170)
                                .addContainerGap()
                                .addComponent(searchInput1)
                                .addComponent(searchProps1)
                                .addGap(80, 80, 80)
                                .addComponent(sortCheck1)
                                .addGap(80, 80, 80)
                                .addComponent(sortCheck3))
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(168, 168, 168)
                                .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addGap(228, 228, 228))

                                        .addGap(174, 174, 174)))
        );
        jPanel5Layout.setVerticalGroup(
                jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel19, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jSeparator2, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel5Layout.createParallelGroup()
                                        .addComponent(searchInput1)
                                        .addComponent(searchProps1)
                                        .addComponent(sortCheck1)
                                        .addComponent(sortCheck3))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jScrollPane2, 340, 340, 340)
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(addEmployeeButton, GroupLayout.DEFAULT_SIZE, 40, 150))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(editEmployeeButton, GroupLayout.DEFAULT_SIZE, 40, 150))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(deleteEmployeeButton, GroupLayout.DEFAULT_SIZE, 40, 150))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(putEmployeesIntoFileButton, GroupLayout.DEFAULT_SIZE, 40, 150))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(returnFromEmployeesButton, GroupLayout.DEFAULT_SIZE, 40, 150))
                                        ))
                                .addGap(18, 18, 18)
                                .addContainerGap(93, Short.MAX_VALUE))
        );

        GroupLayout employeesDialogLayout = new GroupLayout(employeesDialog.getContentPane());
        employeesDialog.getContentPane().setLayout(employeesDialogLayout);
        employeesDialogLayout.setHorizontalGroup(
                employeesDialogLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        employeesDialogLayout.setVerticalGroup(
                employeesDialogLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        addEmployeeDialog.setMinimumSize(new java.awt.Dimension(553, 494));
        addEmployeeDialog.setResizable(false);

        jPanel6.setMinimumSize(new java.awt.Dimension(540, 480));

        jLabel20.setFont(new Font("Raleway", Font.PLAIN, 18));
        jLabel20.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel20.setText("Добавление сотрудника");

        jLabel21.setFont(new Font("Raleway", Font.PLAIN, 16));
        jLabel21.setText("ID сотрудника");

        jLabel22.setFont(new Font("Raleway", Font.PLAIN, 16));
        jLabel22.setText("Логин");

        jLabel23.setFont(new Font("Raleway", Font.PLAIN, 16));
        jLabel23.setText("Пароль");

        jLabel24.setFont(new Font("Raleway", Font.PLAIN, 16));
        jLabel24.setText("ФИО");

        jLabel25.setFont(new Font("Raleway", Font.PLAIN, 16));
        jLabel25.setText("Номер контракта");

        jLabel26.setFont(new Font("Raleway", Font.PLAIN, 16));
        jLabel26.setText("Дата найма");

        jLabel27.setFont(new Font("Raleway", Font.PLAIN, 16));
        jLabel27.setText("Позиция");

        addEmployeeIDField.setFont(new Font("Raleway", Font.PLAIN, 16));
        addEmployeeIDField.setEnabled(false);

        addEmployeeLoginField.setFont(new Font("Raleway", Font.PLAIN, 16));

        addEmployeeFullNameField.setFont(new Font("Raleway", Font.PLAIN, 16));

        addEmployeeContractNumber.setFont(new Font("Raleway", Font.PLAIN, 16));

        addEmployeeYearField.setFont(new Font("Raleway", Font.PLAIN, 16));
        addEmployeeYearField.setText("2021");
        addEmployeeYearField.addActionListener(this::addEmployeeYearField);

        jLabel28.setText("-");

        addEmployeeMonthField.setFont(new Font("Raleway", Font.PLAIN, 16));
        addEmployeeMonthField.setText("11");
        addEmployeeMonthField.addActionListener(this::addEmployeeMonthField);

        jLabel29.setText("-");

        addEmployeeDayField.setFont(new Font("Raleway", Font.PLAIN, 16));
        addEmployeeDayField.setText("27");
        addEmployeeDayField.addActionListener(this::addEmployeeDayField);

        addEmployeePositionField.setFont(new Font("Raleway", Font.PLAIN, 16));
        addEmployeePositionField.setModel(new DefaultComboBoxModel<>(new String[]{"Консультант", "Администратор"}));

        confirmAddingEmployeeButton.setFont(new Font("Raleway", Font.PLAIN, 16));
        confirmAddingEmployeeButton.setText("Добавить");
        confirmAddingEmployeeButton.addActionListener(this::confirmAddingEmployee);

        GroupLayout jPanel6Layout = new GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(                                                                                //добавлние работника
                jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel20, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                                .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel21)
                                                        .addComponent(jLabel22)
                                                        .addComponent(jLabel23)
                                                        .addComponent(jLabel24)
                                                        .addComponent(jLabel25)
                                                        .addComponent(jLabel26)
                                                        .addComponent(jLabel27))
                                                .addGap(48, 48, 48)
                                                .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(addEmployeeIDField)
                                                        .addComponent(addEmployeeLoginField)
                                                        .addComponent(addEmployeePassword)
                                                        .addComponent(addEmployeeFullNameField)
                                                        .addComponent(addEmployeeContractNumber)
                                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                                                .addComponent(addEmployeeYearField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jLabel28)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(addEmployeeMonthField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jLabel29)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(addEmployeeDayField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                        .addComponent(addEmployeePositionField, 0, 340, Short.MAX_VALUE))))
                                .addContainerGap())
                        .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(224, 224, 224)
                                .addComponent(confirmAddingEmployeeButton)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
                jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel20, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel21)
                                        .addComponent(addEmployeeIDField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel22)
                                        .addComponent(addEmployeeLoginField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel23)
                                        .addComponent(addEmployeePassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel24)
                                        .addComponent(addEmployeeFullNameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel25)
                                        .addComponent(addEmployeeContractNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel26)
                                        .addComponent(addEmployeeYearField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel28)
                                        .addComponent(addEmployeeMonthField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel29)
                                        .addComponent(addEmployeeDayField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel27)
                                        .addComponent(addEmployeePositionField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(36, 36, 36)
                                .addComponent(confirmAddingEmployeeButton)
                                .addContainerGap(83, Short.MAX_VALUE))
        );

        GroupLayout addEmployeeDialogLayout = new GroupLayout(addEmployeeDialog.getContentPane());
        addEmployeeDialog.getContentPane().setLayout(addEmployeeDialogLayout);
        addEmployeeDialogLayout.setHorizontalGroup(
                addEmployeeDialogLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        addEmployeeDialogLayout.setVerticalGroup(
                addEmployeeDialogLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(addEmployeeDialogLayout.createSequentialGroup()
                                .addComponent(jPanel6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 27, Short.MAX_VALUE))
        );

        editEmployeeDialog.setMinimumSize(new java.awt.Dimension(555, 590));
        editEmployeeDialog.setResizable(false);

        jPanel7.setMinimumSize(new java.awt.Dimension(540, 590));

        jLabel30.setFont(new Font("Raleway", Font.PLAIN, 18));
        jLabel30.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel30.setText("Редактирование информации о сотруднике");

        jLabel31.setFont(new Font("Raleway", Font.PLAIN, 16));
        jLabel31.setText("ID сотрудника");

        jLabel32.setFont(new Font("Raleway", Font.PLAIN, 16));
        jLabel32.setText("Логин");

        jLabel33.setFont(new Font("Raleway", Font.PLAIN, 16));
        jLabel33.setText("Пароль");

        jLabel34.setFont(new Font("Raleway", Font.PLAIN, 16));
        jLabel34.setText("ФИО");

        jLabel35.setFont(new Font("Raleway", Font.PLAIN, 16));
        jLabel35.setText("Номер контракта");

        jLabel36.setFont(new Font("Raleway", Font.PLAIN, 16));
        jLabel36.setText("Дата найма");

        jLabel37.setFont(new Font("Raleway", Font.PLAIN, 16));
        jLabel37.setText("Позиция");

        editEmployeeIDField.setFont(new Font("Raleway", Font.PLAIN, 16));
        editEmployeeIDField.setEnabled(false);

        editEmployeeLoginField.setFont(new Font("Raleway", Font.PLAIN, 16));

        editEmployeePassword.setFont(new Font("Raleway", Font.PLAIN, 16));
        editEmployeePassword.setText("jPasswordField1");

        editEmployeeFullName.setFont(new Font("Raleway", Font.PLAIN, 16));

        editEmployeeContractNumber.setFont(new Font("Raleway", Font.PLAIN, 16));

        editEmployeeDate.setFont(new Font("Raleway", Font.PLAIN, 16));

        editEmployeePosition.setFont(new Font("Raleway", Font.PLAIN, 16));
        editEmployeePosition.setModel(new DefaultComboBoxModel<>(new String[]{"Консультант", "Администратор"}));

        confirmEditingEmployeeButton.setFont(new Font("Raleway", Font.PLAIN, 16));
        confirmEditingEmployeeButton.setText("Изменить");
        confirmEditingEmployeeButton.addActionListener(this::confirmEditingEmployee);

        GroupLayout jPanel7Layout = new GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(                                                                                //редактирование работников
                jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel30, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 525, Short.MAX_VALUE)
                                        .addGroup(jPanel7Layout.createSequentialGroup()
                                                .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel31)
                                                        .addComponent(jLabel32)
                                                        .addComponent(jLabel33)
                                                        .addComponent(jLabel34)
                                                        .addComponent(jLabel35)
                                                        .addComponent(jLabel36)
                                                        .addComponent(jLabel37))
                                                .addGap(45, 45, 45)
                                                .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(editEmployeeIDField)
                                                        .addComponent(editEmployeeLoginField)
                                                        .addComponent(editEmployeePassword)
                                                        .addComponent(editEmployeeFullName)
                                                        .addComponent(editEmployeeContractNumber)
                                                        .addComponent(editEmployeePosition, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(editEmployeeDate))))
                                .addContainerGap())
                        .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(225, 225, 225)
                                .addComponent(confirmEditingEmployeeButton)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
                jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel7Layout.createSequentialGroup()
                                                .addComponent(jLabel30, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel31)
                                                        .addComponent(editEmployeeIDField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel32)
                                                        .addComponent(editEmployeeLoginField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel33)
                                                        .addComponent(editEmployeePassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel34)
                                                        .addComponent(editEmployeeFullName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel35))
                                        .addComponent(editEmployeeContractNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel36)
                                        .addComponent(editEmployeeDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel37)
                                        .addComponent(editEmployeePosition, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(49, 49, 49)
                                .addComponent(confirmEditingEmployeeButton)
                                .addContainerGap(32, Short.MAX_VALUE))
        );

        GroupLayout editEmployeeDialogLayout = new GroupLayout(editEmployeeDialog.getContentPane());
        editEmployeeDialog.getContentPane().setLayout(editEmployeeDialogLayout);
        editEmployeeDialogLayout.setHorizontalGroup(
                editEmployeeDialogLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel7, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        editEmployeeDialogLayout.setVerticalGroup(
                editEmployeeDialogLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel7, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        contractsDialog.setMinimumSize(new java.awt.Dimension(1200, 600));
        contractsDialog.setResizable(false);

        jPanel8.setMinimumSize(new java.awt.Dimension(1100, 590));

        jLabel38.setFont(new Font("Raleway", Font.PLAIN, 24));
        jLabel38.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel38.setText("Информация о договорах");

        contractsTable.setModel(new javax.swing.table.DefaultTableModel(
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
        contractsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                contractsTableMouseClicked(evt);
            }
        });
        contractsTable.setRowHeight(30);
        jScrollPane3.setViewportView(contractsTable);
        jScrollPane3.setMaximumSize(new Dimension(800, 500));

        searchProps4.addActionListener(this::searchContracts);
        sortCheck4.addActionListener(this::sortByContractDate);

        addContractButton.setFont(new Font("Raleway", Font.PLAIN, 16));
        addContractButton.setText("Добавить");
        addContractButton.setBorderPainted(false);
        addContractButton.setBackground(new Color(204, 204, 255));
        addContractButton.setPreferredSize(new Dimension(50, 50));
        addContractButton.addActionListener(this::addContract);

        editContractButton.setFont(new Font("Raleway", Font.PLAIN, 16));
        editContractButton.setText("Изменить");
        editContractButton.setEnabled(false);
        editContractButton.setBackground(new Color(204, 204, 255));
        editContractButton.setPreferredSize(new Dimension(50, 50));
        editContractButton.setBorderPainted(false);
        editContractButton.addActionListener(this::editContract);

        deleteContractButton.setFont(new Font("Raleway", Font.PLAIN, 16));
        deleteContractButton.setText("Удалить");
        deleteContractButton.setBorderPainted(false);
        deleteContractButton.setBackground(new Color(123, 161, 255));
        deleteContractButton.setPreferredSize(new Dimension(50, 50));
        deleteContractButton.setEnabled(false);
        deleteContractButton.addActionListener(this::deleteContract);

        returnFromContractsButton.setFont(new Font("Raleway", Font.PLAIN, 16));
        returnFromContractsButton.setText("Назад");
        returnFromContractsButton.setBorderPainted(false);
        returnFromContractsButton.setBackground(new Color(123, 161, 255));
        returnFromContractsButton.setPreferredSize(new Dimension(50, 50));
        returnFromContractsButton.addActionListener(this::returnFromContracts);

        putContractsIntoFileButton.setFont(new Font("Raleway", Font.PLAIN, 16));
        putContractsIntoFileButton.setText("Выгрузить");
        putContractsIntoFileButton.setBorderPainted(false);
        putContractsIntoFileButton.setPreferredSize(new Dimension(100, 50));
        putContractsIntoFileButton.setBackground(new Color(177, 220, 252));
        putContractsIntoFileButton.addActionListener(this::putContractsIntoFile);


        GroupLayout jPanel8Layout = new GroupLayout(jPanel8);                                                            //работа с клиентом
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
                jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel8Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jSeparator3)
                                        .addComponent(jLabel38, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
                        .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(addContractButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, 150)
                                        .addComponent(editContractButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, 150)
                                        .addComponent(deleteContractButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, 150)
                                        .addComponent(putContractsIntoFileButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, 150)
                                        .addComponent(returnFromContractsButton, GroupLayout.DEFAULT_SIZE, 42, 150))
                                .addGap(80, 80, 80)
                                .addComponent(jScrollPane3)
                        )
                        .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addContainerGap()
                                .addComponent(searchInput4)
                                .addComponent(searchProps4)
                                .addGap(80, 80, 80)
                                .addComponent(sortCheck4))
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(168, 168, 168)
                                .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel8Layout.createSequentialGroup()
                                                .addGap(228, 228, 228))

                                        .addGap(174, 174, 174)))
        );
        jPanel8Layout.setVerticalGroup(
                jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel8Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel38, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jSeparator3, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel8Layout.createParallelGroup()
                                        .addComponent(searchInput4)
                                        .addComponent(searchProps4)
                                        .addComponent(sortCheck4))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jScrollPane3, 340, 340, 340)
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel8Layout.createSequentialGroup()
                                                .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(addContractButton, GroupLayout.DEFAULT_SIZE, 40, 150))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(editContractButton, GroupLayout.DEFAULT_SIZE, 40, 150))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(deleteContractButton, GroupLayout.DEFAULT_SIZE, 40, 150))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(putContractsIntoFileButton, GroupLayout.DEFAULT_SIZE, 40, 150))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(returnFromContractsButton, GroupLayout.DEFAULT_SIZE, 40, 150))
                                        ))
                                .addGap(18, 18, 18)
                                .addContainerGap(93, Short.MAX_VALUE))
        );

        GroupLayout contractsDialogLayout = new GroupLayout(contractsDialog.getContentPane());
        contractsDialog.getContentPane().setLayout(contractsDialogLayout);
        contractsDialogLayout.setHorizontalGroup(
                contractsDialogLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel8, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        contractsDialogLayout.setVerticalGroup(
                contractsDialogLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel8, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        addContractDialog.setMinimumSize(new java.awt.Dimension(590, 330));
        addContractDialog.setResizable(false);

        jPanel9.setMinimumSize(new java.awt.Dimension(570, 320));

        jLabel39.setFont(new Font("Raleway", Font.PLAIN, 18));
        jLabel39.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel39.setText("Добавление договора");

        jLabel40.setFont(new Font("Raleway", Font.PLAIN, 16));
        jLabel40.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel40.setText("Номер договора");

        addContractNumberField.setFont(new Font("Raleway", Font.PLAIN, 16));
        addContractNumberField.setEnabled(false);

        addDateOfSigningLabel.setFont(new Font("Raleway", Font.PLAIN, 16));
        addDateOfSigningLabel.setText("Дата подписи");

        addYearOfSigningField.setFont(new Font("Raleway", Font.PLAIN, 16));
        addYearOfSigningField.setText("2021");

        jLabel41.setText("-");

        addMonthOfSigningField.setFont(new Font("Raleway", Font.PLAIN, 16));
        addMonthOfSigningField.setText("12");

        jLabel42.setText("-");

        addDayOfSigningField.setFont(new Font("Raleway", Font.PLAIN, 16));
        addDayOfSigningField.setText("06");

        jLabel43.setFont(new Font("Raleway", Font.PLAIN, 16));
        jLabel43.setText("ID клиента");

        addContractClientID.setFont(new Font("Raleway", Font.PLAIN, 16));

        jLabel44.setFont(new Font("Raleway", Font.PLAIN, 16));
        jLabel44.setText("ID сотрудника");

        addContractsEmployeeIDField.setFont(new Font("Raleway", Font.PLAIN, 16));

        confirmAdditionContractButton.setFont(new Font("Raleway", Font.PLAIN, 16));
        confirmAdditionContractButton.setText("Добавить");
        confirmAdditionContractButton.addActionListener(this::confirmAdditionContract);

        GroupLayout jPanel9Layout = new GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(                                                                                //добавление контакта
                jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel9Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel39, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel9Layout.createSequentialGroup()
                                                .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel40)
                                                        .addComponent(addDateOfSigningLabel))
                                                .addGap(36, 36, 36)
                                                .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel9Layout.createSequentialGroup()
                                                                .addComponent(addYearOfSigningField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jLabel41)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(addMonthOfSigningField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jLabel42)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(addDayOfSigningField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                        .addComponent(addContractNumberField)))
                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                                                .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel43)
                                                        .addComponent(jLabel44))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(addContractClientID)
                                                        .addComponent(addContractsEmployeeIDField, GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE))))
                                .addContainerGap())
                        .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGap(224, 224, 224)
                                .addComponent(confirmAdditionContractButton)
                                .addContainerGap(243, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
                jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel9Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel39, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel40)
                                        .addComponent(addContractNumberField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(addDateOfSigningLabel)
                                        .addComponent(addYearOfSigningField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel41)
                                        .addComponent(addMonthOfSigningField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel42)
                                        .addComponent(addDayOfSigningField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel43)
                                        .addComponent(addContractClientID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel44)
                                        .addComponent(addContractsEmployeeIDField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(37, 37, 37)
                                .addComponent(confirmAdditionContractButton)
                                .addContainerGap(48, Short.MAX_VALUE))
        );

        GroupLayout addContractDialogLayout = new GroupLayout(addContractDialog.getContentPane());
        addContractDialog.getContentPane().setLayout(addContractDialogLayout);
        addContractDialogLayout.setHorizontalGroup(
                addContractDialogLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel9, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        addContractDialogLayout.setVerticalGroup(
                addContractDialogLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );

        editContractDialog.setMinimumSize(new java.awt.Dimension(570, 330));
        editContractDialog.setResizable(false);

        jPanel10.setMinimumSize(new java.awt.Dimension(555, 320));

        jLabel45.setFont(new Font("Raleway", Font.PLAIN, 18));
        jLabel45.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel45.setText("Редактирование договоров");

        jLabel46.setFont(new Font("Raleway", Font.PLAIN, 16));
        jLabel46.setText("Номер договора");

        jLabel47.setFont(new Font("Raleway", Font.PLAIN, 16));
        jLabel47.setText("Дата подписи");

        jLabel48.setFont(new Font("Raleway", Font.PLAIN, 16));
        jLabel48.setText("ID клиента");

        jLabel49.setFont(new Font("Raleway", Font.PLAIN, 16));
        jLabel49.setText("ID сотрудника");

        editContractNumberField.setEnabled(false);

        editDateOfSigning.setFont(new Font("Raleway", Font.PLAIN, 16));

        editContractClientIDField.setFont(new Font("Raleway", Font.PLAIN, 16));

        editContractEmployeeID.setFont(new Font("Raleway", Font.PLAIN, 16));

        confirmEditingContractButton.setFont(new Font("Raleway", Font.PLAIN, 16));
        confirmEditingContractButton.setText("Изменить");
        confirmEditingContractButton.addActionListener(this::confirmEditingContract);

        GroupLayout jPanel10Layout = new GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(                                                                               //редактирование контакта
                jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel10Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel45, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel10Layout.createSequentialGroup()
                                                .addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel46)
                                                        .addComponent(jLabel47)
                                                        .addComponent(jLabel48)
                                                        .addComponent(jLabel49))
                                                .addGap(53, 53, 53)
                                                .addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(editContractNumberField)
                                                        .addComponent(editDateOfSigning)
                                                        .addComponent(editContractClientIDField)
                                                        .addComponent(editContractEmployeeID))))
                                .addContainerGap())
                        .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGap(234, 234, 234)
                                .addComponent(confirmEditingContractButton)
                                .addContainerGap(231, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
                jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel10Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel45, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel46)
                                        .addComponent(editContractNumberField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel47)
                                        .addComponent(editDateOfSigning, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel48)
                                        .addComponent(editContractClientIDField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel49)
                                        .addComponent(editContractEmployeeID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addComponent(confirmEditingContractButton)
                                .addContainerGap(54, Short.MAX_VALUE))
        );

        GroupLayout editContractDialogLayout = new GroupLayout(editContractDialog.getContentPane());
        editContractDialog.getContentPane().setLayout(editContractDialogLayout);
        editContractDialogLayout.setHorizontalGroup(
                editContractDialogLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel10, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        editContractDialogLayout.setVerticalGroup(
                editContractDialogLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel10, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        depositTypesDialog.setMinimumSize(new java.awt.Dimension(1150, 600));
        depositTypesDialog.setResizable(false);

        jPanel11.setMinimumSize(new java.awt.Dimension(1000, 580));

        jLabel50.setFont(new Font("Raleway", Font.PLAIN, 24));
        jLabel50.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel50.setText("Типы вкладов");

        depositTypesTable.setModel(new javax.swing.table.DefaultTableModel(
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
        depositTypesTable.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                depositTypesTableMouseClicked(evt);
            }
        });
        depositTypesTable.setRowHeight(30);
        jScrollPane4.setViewportView(depositTypesTable);
        jScrollPane4.setMaximumSize(new Dimension(800, 500));

        searchProps5.addActionListener(this::searchDepTypes);
        sortCheck5.addActionListener(this::sortByTypePeriod);

        addDepTypeButton.setFont(new Font("Raleway", Font.PLAIN, 16));
        addDepTypeButton.setText("Добавить");
        addDepTypeButton.setBackground(new Color(204, 204, 255));
        addDepTypeButton.setPreferredSize(new Dimension(50, 50));
        addDepTypeButton.setBorderPainted(false);
        addDepTypeButton.addActionListener(this::addDepType);

        editDepTypeButton.setFont(new Font("Raleway", Font.PLAIN, 16));
        editDepTypeButton.setText("Изменить");
        editDepTypeButton.setEnabled(false);
        editDepTypeButton.setBorderPainted(false);
        editDepTypeButton.setBackground(new Color(204, 204, 255));
        editDepTypeButton.setPreferredSize(new Dimension(50, 50));
        editDepTypeButton.addActionListener(this::editDepType);

        deleteDepTypeButton.setFont(new Font("Raleway", Font.PLAIN, 16));
        deleteDepTypeButton.setText("Удалить");
        deleteDepTypeButton.setBorderPainted(false);
        deleteDepTypeButton.setBackground(new Color(177, 220, 252));
        deleteDepTypeButton.setPreferredSize(new Dimension(100, 50));
        deleteDepTypeButton.setEnabled(false);
        deleteDepTypeButton.addActionListener(this::deleteDepType);

        returnFromDepTypesButton.setFont(new Font("Raleway", Font.PLAIN, 16));
        returnFromDepTypesButton.setText("Назад");
        returnFromDepTypesButton.setBorderPainted(false);
        returnFromDepTypesButton.setBackground(new Color(123, 161, 255));
        returnFromDepTypesButton.setPreferredSize(new Dimension(50, 50));
        returnFromDepTypesButton.addActionListener(this::returnFromDepTypes);

        putDepTypesIntoFileButton.setFont(new Font("Raleway", Font.PLAIN, 16));
        putDepTypesIntoFileButton.setText("Выгрузить");
        putDepTypesIntoFileButton.setBorderPainted(false);
        putDepTypesIntoFileButton.setBackground(new Color(123, 161, 255));
        putDepTypesIntoFileButton.setPreferredSize(new Dimension(50, 50));
        putDepTypesIntoFileButton.addActionListener(this::putDepTypesIntoFile);


        GroupLayout jPanel11Layout = new GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
                jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel11Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jSeparator4)
                                        .addComponent(jLabel50, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
                        .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(addDepTypeButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, 150)
                                        .addComponent(editDepTypeButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, 150)
                                        .addComponent(deleteDepTypeButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, 150)
                                        .addComponent(putDepTypesIntoFileButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, 150)
                                        .addComponent(returnFromDepTypesButton, GroupLayout.DEFAULT_SIZE, 42, 150))
                                .addGap(80, 80, 80)
                                .addComponent(jScrollPane4)
                        )
                        .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addContainerGap()
                                .addComponent(searchInput5)
                                .addComponent(searchProps5)
                                .addGap(80, 80, 80)
                                .addComponent(sortCheck5))
                        .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGap(168, 168, 168)
                                .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel11Layout.createSequentialGroup()
                                                .addGap(228, 228, 228))

                                        .addGap(174, 174, 174)))
        );
        jPanel11Layout.setVerticalGroup(
                jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel11Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel50, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jSeparator4, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel11Layout.createParallelGroup()
                                        .addComponent(searchInput5)
                                        .addComponent(searchProps5)
                                        .addComponent(sortCheck5))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jScrollPane4, 340, 340, 340)
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel11Layout.createSequentialGroup()
                                                .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(addDepTypeButton, GroupLayout.DEFAULT_SIZE, 40, 150))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(editDepTypeButton, GroupLayout.DEFAULT_SIZE, 40, 150))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(deleteDepTypeButton, GroupLayout.DEFAULT_SIZE, 40, 150))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(putDepTypesIntoFileButton, GroupLayout.DEFAULT_SIZE, 40, 150))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(returnFromDepTypesButton, GroupLayout.DEFAULT_SIZE, 40, 150))
                                        ))
                                .addGap(18, 18, 18)
                                .addContainerGap(93, Short.MAX_VALUE))
        );

        GroupLayout depositTypesDialogLayout = new GroupLayout(depositTypesDialog.getContentPane());
        depositTypesDialog.getContentPane().setLayout(depositTypesDialogLayout);
        depositTypesDialogLayout.setHorizontalGroup(
                depositTypesDialogLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel11, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        depositTypesDialogLayout.setVerticalGroup(
                depositTypesDialogLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel11, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );

        addDepositTypeDialog.setMinimumSize(new java.awt.Dimension(580, 469));
        addDepositTypeDialog.setResizable(false);

        jPanel12.setMinimumSize(new java.awt.Dimension(550, 439));

        jLabel51.setFont(new Font("Raleway", Font.PLAIN, 18));
        jLabel51.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel51.setText("Добавление типа вклада");

        jLabel52.setFont(new Font("Raleway", Font.PLAIN, 16));
        jLabel52.setText("ID типа");

        jLabel53.setFont(new Font("Raleway", Font.PLAIN, 16));
        jLabel53.setText("Название типа");

        jLabel54.setFont(new Font("Raleway", Font.PLAIN, 16));
        jLabel54.setText("Минимальная сумма");

        jLabel55.setFont(new Font("Raleway", Font.PLAIN, 16));
        jLabel55.setText("Максимальная сумма");

        jLabel56.setFont(new Font("Raleway", Font.PLAIN, 16));
        jLabel56.setText("Период (мес.)");

        jLabel57.setFont(new Font("Raleway", Font.PLAIN, 16));
        jLabel57.setText("Капитализация");

        jLabel58.setFont(new Font("Raleway", Font.PLAIN, 16));
        jLabel58.setText("Процентная ставка");

        addTypeIDField.setFont(new Font("Raleway", Font.PLAIN, 16));
        addTypeIDField.setEnabled(false);

        addTypeNameField.setFont(new Font("Raleway", Font.PLAIN, 16));

        addTypeMinMoneyField.setFont(new Font("Raleway", Font.PLAIN, 16));

        addTypeMaxMoneyField.setFont(new Font("Raleway", Font.PLAIN, 16));

        addTypePeriodField.setFont(new Font("Raleway", Font.PLAIN, 16));

        addTypeCapitalizationField.setFont(new Font("Raleway", Font.PLAIN, 16));

        addTypePercentField.setFont(new Font("Raleway", Font.PLAIN, 16));

        confirmAddingTypeButton.setFont(new Font("Raleway", Font.PLAIN, 16));
        confirmAddingTypeButton.setText("Добавить");
        confirmAddingTypeButton.addActionListener(this::confirmAddingType);

        GroupLayout jPanel12Layout = new GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(                                                                               //добавление типов вкладов
                jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel12Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel51, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel12Layout.createSequentialGroup()
                                                .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel52)
                                                        .addComponent(jLabel53)
                                                        .addComponent(jLabel54)
                                                        .addComponent(jLabel55)
                                                        .addComponent(jLabel56)
                                                        .addComponent(jLabel57)
                                                        .addComponent(jLabel58))
                                                .addGap(37, 37, 37)
                                                .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel12Layout.createSequentialGroup()
                                                                .addComponent(confirmAddingTypeButton)
                                                                .addGap(0, 216, Short.MAX_VALUE))
                                                        .addComponent(addTypeIDField)
                                                        .addComponent(addTypeNameField)
                                                        .addComponent(addTypeMinMoneyField)
                                                        .addComponent(addTypeMaxMoneyField)
                                                        .addComponent(addTypePeriodField)
                                                        .addComponent(addTypeCapitalizationField)
                                                        .addComponent(addTypePercentField))))
                                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
                jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel12Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel51, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel52)
                                        .addComponent(addTypeIDField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel53)
                                        .addComponent(addTypeNameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel54)
                                        .addComponent(addTypeMinMoneyField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel55)
                                        .addComponent(addTypeMaxMoneyField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel56)
                                        .addComponent(addTypePeriodField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel57)
                                        .addComponent(addTypeCapitalizationField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel58)
                                        .addComponent(addTypePercentField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(confirmAddingTypeButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(34, Short.MAX_VALUE))
        );

        GroupLayout addDepositTypeDialogLayout = new GroupLayout(addDepositTypeDialog.getContentPane());
        addDepositTypeDialog.getContentPane().setLayout(addDepositTypeDialogLayout);
        addDepositTypeDialogLayout.setHorizontalGroup(
                addDepositTypeDialogLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel12, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        addDepositTypeDialogLayout.setVerticalGroup(
                addDepositTypeDialogLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel12, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        editDepTypeDialog.setMinimumSize(new java.awt.Dimension(580, 440));
        editDepTypeDialog.setResizable(false);

        jPanel13.setMinimumSize(new java.awt.Dimension(550, 430));

        jLabel59.setFont(new Font("Raleway", Font.PLAIN, 18));
        jLabel59.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel59.setText("Редактирование типа вклада");

        jLabel60.setFont(new Font("Raleway", Font.PLAIN, 16));
        jLabel60.setText("ID типа");

        jLabel61.setFont(new Font("Raleway", Font.PLAIN, 16));
        jLabel61.setText("Название типа");

        jLabel62.setFont(new Font("Raleway", Font.PLAIN, 16));
        jLabel62.setText("Минимальная сумма");

        jLabel63.setFont(new Font("Raleway", Font.PLAIN, 16));
        jLabel63.setText("Максимальная сумма");

        jLabel64.setFont(new Font("Raleway", Font.PLAIN, 16));
        jLabel64.setText("Период (мес.)");

        jLabel65.setFont(new Font("Raleway", Font.PLAIN, 16));
        jLabel65.setText("Капитализация");

        jLabel66.setFont(new Font("Raleway", Font.PLAIN, 16));
        jLabel66.setText("Процентная ставка");

        editTypeIDField.setFont(new Font("Raleway", Font.PLAIN, 16));
        editTypeIDField.setEnabled(false);

        editTypeNameField.setFont(new Font("Raleway", Font.PLAIN, 16));

        editTypeMinMonField.setFont(new Font("Raleway", Font.PLAIN, 16));
        editTypeMinMonField.setToolTipText("");

        editTypeMaxMonField.setFont(new Font("Raleway", Font.PLAIN, 16));

        editTypePeriodField.setFont(new Font("Raleway", Font.PLAIN, 16));

        editTypeCapitalizationField.setFont(new Font("Raleway", Font.PLAIN, 16));

        editTypePercentField.setFont(new Font("Raleway", Font.PLAIN, 16));

        confirmEditingTypeButton.setFont(new Font("Raleway", Font.PLAIN, 16));
        confirmEditingTypeButton.setText("Изменить");
        confirmEditingTypeButton.addActionListener(this::confirmEditingType);

        GroupLayout jPanel13Layout = new GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(                                                                               //редактирование типов вкладов
                jPanel13Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel13Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel59, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel13Layout.createSequentialGroup()
                                                .addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel60)
                                                        .addComponent(jLabel61)
                                                        .addComponent(jLabel62)
                                                        .addComponent(jLabel63)
                                                        .addComponent(jLabel64)
                                                        .addComponent(jLabel65)
                                                        .addComponent(jLabel66))
                                                .addGap(47, 47, 47)
                                                .addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(editTypeIDField)
                                                        .addComponent(editTypeNameField)
                                                        .addComponent(editTypeMinMonField)
                                                        .addComponent(editTypeMaxMonField)
                                                        .addComponent(editTypePeriodField)
                                                        .addComponent(editTypeCapitalizationField)
                                                        .addComponent(editTypePercentField))))
                                .addContainerGap())
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                                .addContainerGap(223, Short.MAX_VALUE)
                                .addComponent(confirmEditingTypeButton)
                                .addGap(222, 222, 222))
        );
        jPanel13Layout.setVerticalGroup(
                jPanel13Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel13Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel59, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel60)
                                        .addComponent(editTypeIDField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel61)
                                        .addComponent(editTypeNameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel62)
                                        .addComponent(editTypeMinMonField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel63)
                                        .addComponent(editTypeMaxMonField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel64)
                                        .addComponent(editTypePeriodField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel65)
                                        .addComponent(editTypeCapitalizationField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel66)
                                        .addComponent(editTypePercentField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(confirmEditingTypeButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(35, Short.MAX_VALUE))
        );

        GroupLayout editDepTypeDialogLayout = new GroupLayout(editDepTypeDialog.getContentPane());
        editDepTypeDialog.getContentPane().setLayout(editDepTypeDialogLayout);
        editDepTypeDialogLayout.setHorizontalGroup(
                editDepTypeDialogLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel13, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        editDepTypeDialogLayout.setVerticalGroup(
                editDepTypeDialogLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel13, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        depositsDialog.setMinimumSize(new java.awt.Dimension(1150, 600));
        depositsDialog.setResizable(false);

        jPanel14.setMinimumSize(new java.awt.Dimension(1000, 580));

        jLabel67.setFont(new Font("Raleway", Font.PLAIN, 24));
        jLabel67.setText("Информация о вкладах");

        depositsDataTable.setModel(new javax.swing.table.DefaultTableModel(
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
        depositsDataTable.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                depositsDataTableMouseClicked(evt);
            }
        });
        depositsDataTable.setRowHeight(30);
        jScrollPane5.setViewportView(depositsDataTable);
        jScrollPane5.setMaximumSize(new Dimension(800, 500));

        searchProps6.addActionListener(this::searchDeposits);
        sortCheck6.addActionListener(this::sortByDepositDate);

        addDepositButton.setFont(new Font("Raleway", Font.PLAIN, 16));
        addDepositButton.setText("Добавить");
        addDepositButton.setBackground(new Color(204, 204, 255));
        addDepositButton.setPreferredSize(new Dimension(50, 50));
        addDepositButton.setBorderPainted(false);
        addDepositButton.addActionListener(this::addDeposit);

        editDepositButton.setFont(new Font("Raleway", Font.PLAIN, 16));
        editDepositButton.setText("Изменить");
        editDepositButton.setBorderPainted(false);
        editDepositButton.setBackground(new Color(204, 204, 255));
        editDepositButton.setPreferredSize(new Dimension(50, 50));
        editDepositButton.setEnabled(false);
        editDepositButton.addActionListener(this::editDeposit);

        deleteDepositButton.setFont(new Font("Raleway", Font.PLAIN, 16));
        deleteDepositButton.setText("Удалить");
        deleteDepositButton.setEnabled(false);
        deleteDepositButton.setBorderPainted(false);
        deleteDepositButton.setBackground(new Color(123, 161, 255));
        deleteDepositButton.setPreferredSize(new Dimension(50, 50));
        deleteDepositButton.addActionListener(this::deleteDeposit);

        returnFromDepositsButton.setFont(new Font("Raleway", Font.PLAIN, 16));
        returnFromDepositsButton.setText("Назад");
        returnFromDepositsButton.setBorderPainted(false);
        returnFromDepositsButton.setBackground(new Color(177, 220, 252));
        returnFromDepositsButton.setPreferredSize(new Dimension(100, 50));
        returnFromDepositsButton.addActionListener(this::returnFromDeposits);

        putDepositsIntoFile.setFont(new Font("Raleway", Font.PLAIN, 16));
        putDepositsIntoFile.setText("Выгрузить");
        putDepositsIntoFile.setBorderPainted(false);
        putDepositsIntoFile.setBackground(new Color(123, 161, 255));
        putDepositsIntoFile.setPreferredSize(new Dimension(50, 50));
        putDepositsIntoFile.addActionListener(this::putDepositsIntoFile);

        drawACircleChartButton.setFont(new Font("Raleway", Font.PLAIN, 16));
        drawACircleChartButton.setText("Диаграмма");
        drawACircleChartButton.setBorderPainted(false);
        drawACircleChartButton.setPreferredSize(new Dimension(100, 50));
        drawACircleChartButton.setBackground(new Color(177, 220, 252));
        drawACircleChartButton.addActionListener(this::drawACircleChart);


        GroupLayout jPanel14Layout = new GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
                jPanel14Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel14Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jSeparator5)
                                        .addComponent(jLabel50, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
                        .addGroup(jPanel14Layout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(addDepositButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, 150)
                                        .addComponent(editDepositButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, 150)
                                        .addComponent(deleteDepositButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, 150)
                                        .addComponent(putDepositsIntoFile, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, 150)
                                        .addComponent(drawACircleChartButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, 150)
                                        .addComponent(returnFromDepositsButton, GroupLayout.DEFAULT_SIZE, 42, 150))
                                .addGap(80, 80, 80)
                                .addComponent(jScrollPane5)
                        )
                        .addGroup(jPanel14Layout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addContainerGap()
                                .addComponent(searchInput6)
                                .addComponent(searchProps6)
                                .addGap(110, 110, 110)
                                .addComponent(sortCheck6))
                        .addGroup(jPanel14Layout.createSequentialGroup()
                                .addGap(168, 168, 168)
                                .addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel14Layout.createSequentialGroup()
                                                .addGap(228, 228, 228))

                                        .addGap(174, 174, 174)))
        );
        jPanel14Layout.setVerticalGroup(
                jPanel14Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel14Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel50, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jSeparator5, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel14Layout.createParallelGroup()
                                        .addComponent(searchInput6)
                                        .addComponent(searchProps6)
                                        .addComponent(sortCheck6))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jScrollPane5, 340, 340, 340)
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel14Layout.createSequentialGroup()
                                                .addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(addDepositButton, GroupLayout.DEFAULT_SIZE, 40, 150))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(editDepositButton, GroupLayout.DEFAULT_SIZE, 40, 150))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(deleteDepositButton, GroupLayout.DEFAULT_SIZE, 40, 150))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(putDepositsIntoFile, GroupLayout.DEFAULT_SIZE, 40, 150))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(drawACircleChartButton, GroupLayout.DEFAULT_SIZE, 40, 150))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(returnFromDepositsButton, GroupLayout.DEFAULT_SIZE, 40, 150))
                                        ))
                                .addGap(18, 18, 18)
                                .addContainerGap(93, Short.MAX_VALUE))
        );


        GroupLayout depositsDialogLayout = new GroupLayout(depositsDialog.getContentPane());
        depositsDialog.getContentPane().setLayout(depositsDialogLayout);
        depositsDialogLayout.setHorizontalGroup(
                depositsDialogLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel14, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        depositsDialogLayout.setVerticalGroup(
                depositsDialogLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel14, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );

        addDepositDialog.setMinimumSize(new java.awt.Dimension(550, 500));
        addDepositDialog.setResizable(false);

        jPanel15.setMinimumSize(new java.awt.Dimension(530, 480));

        jLabel68.setFont(new Font("Raleway", Font.PLAIN, 18));
        jLabel68.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel68.setText("Добавление вклада");

        jLabel69.setFont(new Font("Raleway", Font.PLAIN, 16));
        jLabel69.setText("Номер вклада");

        jLabel70.setFont(new Font("Raleway", Font.PLAIN, 16));
        jLabel70.setText("Начальная сумма");

        jLabel71.setFont(new Font("Raleway", Font.PLAIN, 16));
        jLabel71.setText("Дата открытия");

        jLabel72.setFont(new Font("Raleway", Font.PLAIN, 16));
        jLabel72.setText("Планируемая сумма");

        jLabel73.setFont(new Font("Raleway", Font.PLAIN, 16));
        jLabel73.setText("ID типа вклада");

        jLabel74.setFont(new Font("Raleway", Font.PLAIN, 16));
        jLabel74.setText("Номер контракта");

        jLabel75.setFont(new Font("Raleway", Font.PLAIN, 16));
        jLabel75.setText("ID клиента");

        addDepositIDField.setFont(new Font("Raleway", Font.PLAIN, 16));
        addDepositIDField.setEnabled(false);

        addDepositInitialMoneyField.setFont(new Font("Raleway", Font.PLAIN, 16));

        addDepositYearField.setFont(new Font("Raleway", Font.PLAIN, 16));
        addDepositYearField.setText("2021");

        jLabel76.setText("-");

        addDepositMonthField.setFont(new Font("Raleway", Font.PLAIN, 16));
        addDepositMonthField.setText("12");

        jLabel77.setText("-");

        addDepositDayField.setFont(new Font("Raleway", Font.PLAIN, 16));
        addDepositDayField.setText("03");

        addDepositPlannedMoneyField.setFont(new Font("Raleway", Font.PLAIN, 16));
        addDepositPlannedMoneyField.setText("вычисляется автоматически");
        addDepositPlannedMoneyField.setEnabled(false);

        addDepositIDTypeField.setFont(new Font("Raleway", Font.PLAIN, 16));

        addDepositContractNumberField.setFont(new Font("Raleway", Font.PLAIN, 16));

        addDepositClientIDField.setFont(new Font("Raleway", Font.PLAIN, 16));

        confirmAddingDeposit.setFont(new Font("Raleway", Font.PLAIN, 16));
        confirmAddingDeposit.setText("Добавить");
        confirmAddingDeposit.setBackground(new Color(204, 204, 255));
        confirmAddingDeposit.addActionListener(this::confirmAddingDeposit);

        GroupLayout jPanel15Layout = new GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(                                                                                //добавление вкладов
                jPanel15Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel15Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel15Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel68, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                                                .addGroup(jPanel15Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel69)
                                                        .addComponent(jLabel70)
                                                        .addComponent(jLabel71)
                                                        .addComponent(jLabel72)
                                                        .addComponent(jLabel73)
                                                        .addComponent(jLabel74)
                                                        .addComponent(jLabel75))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                                                .addGroup(jPanel15Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(confirmAddingDeposit)
                                                        .addGroup(jPanel15Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(addDepositIDField)
                                                                .addComponent(addDepositInitialMoneyField)
                                                                .addGroup(jPanel15Layout.createSequentialGroup()
                                                                        .addComponent(addDepositYearField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(jLabel76)
                                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(addDepositMonthField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(jLabel77)
                                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(addDepositDayField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                                .addComponent(addDepositPlannedMoneyField, GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                                                                .addComponent(addDepositIDTypeField)
                                                                .addComponent(addDepositContractNumberField)
                                                                .addComponent(addDepositClientIDField)))))
                                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
                jPanel15Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel15Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel68, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel15Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel69)
                                        .addComponent(addDepositIDField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel15Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel70)
                                        .addComponent(addDepositInitialMoneyField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel15Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel71)
                                        .addComponent(addDepositYearField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel76)
                                        .addComponent(addDepositMonthField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel77)
                                        .addComponent(addDepositDayField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel15Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel72)
                                        .addComponent(addDepositPlannedMoneyField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel15Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel73)
                                        .addComponent(addDepositIDTypeField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel15Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel74)
                                        .addComponent(addDepositContractNumberField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel15Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel75)
                                        .addComponent(addDepositClientIDField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(confirmAddingDeposit, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(95, Short.MAX_VALUE))
        );

        GroupLayout addDepositDialogLayout = new GroupLayout(addDepositDialog.getContentPane());
        addDepositDialog.getContentPane().setLayout(addDepositDialogLayout);
        addDepositDialogLayout.setHorizontalGroup(
                addDepositDialogLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel15, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        addDepositDialogLayout.setVerticalGroup(
                addDepositDialogLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel15, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        editDepositDialog.setMinimumSize(new java.awt.Dimension(580, 500));
        editDepositDialog.setResizable(false);

        jPanel16.setMinimumSize(new java.awt.Dimension(550, 480));

        jLabel78.setFont(new Font("Raleway", Font.PLAIN, 18));
        jLabel78.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel78.setText("Редактирование вкладов");

        jLabel79.setFont(new Font("Raleway", Font.PLAIN, 16));
        jLabel79.setText("Номер вклада");

        jLabel80.setFont(new Font("Raleway", Font.PLAIN, 16));
        jLabel80.setText("Начальная сумма");

        jLabel81.setFont(new Font("Raleway", Font.PLAIN, 16));
        jLabel81.setText("Дата открытия");

        jLabel82.setFont(new Font("Raleway", Font.PLAIN, 16));
        jLabel82.setText("Планируемая сумма");

        jLabel83.setFont(new Font("Raleway", Font.PLAIN, 16));
        jLabel83.setText("ID типа");

        jLabel84.setFont(new Font("Raleway", Font.PLAIN, 16));
        jLabel84.setText("Номер договора");

        jLabel85.setFont(new Font("Raleway", Font.PLAIN, 16));
        jLabel85.setText("ID клиента");

        editDepositIDField.setFont(new Font("Raleway", Font.PLAIN, 16));
        editDepositIDField.setEnabled(false);

        editInitialMoneyField.setFont(new Font("Raleway", Font.PLAIN, 16));

        editDateOfOpeningField.setFont(new Font("Raleway", Font.PLAIN, 16));

        editFinalMoneyField.setFont(new Font("Raleway", Font.PLAIN, 16));
        editFinalMoneyField.setText("вычисляется автоматически");
        editFinalMoneyField.setEnabled(false);

        editDepositIDTypeField.setFont(new Font("Raleway", Font.PLAIN, 16));

        editDepositIDContractField.setFont(new Font("Raleway", Font.PLAIN, 16));

        editDepositIDClientField.setFont(new Font("Raleway", Font.PLAIN, 16));

        confirmToEditDepositsButton.setFont(new Font("Raleway", Font.PLAIN, 16));
        confirmToEditDepositsButton.setText("Изменить");
        confirmToEditDepositsButton.setBackground(new Color(204, 204, 255));
        confirmToEditDepositsButton.addActionListener(this::confirmToEditDeposits);


        GroupLayout jPanel16Layout = new GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(                                                                               //редактирование вкладов
                jPanel16Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel16Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel16Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel78, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                                                .addGroup(jPanel16Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel79)
                                                        .addComponent(jLabel80)
                                                        .addComponent(jLabel81)
                                                        .addComponent(jLabel82)
                                                        .addComponent(jLabel83)
                                                        .addComponent(jLabel84)
                                                        .addComponent(jLabel85))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                                                .addGroup(jPanel16Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(editDepositIDField)
                                                        .addComponent(editInitialMoneyField)
                                                        .addComponent(editDateOfOpeningField)
                                                        .addComponent(editFinalMoneyField, GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                                                        .addComponent(editDepositIDTypeField)
                                                        .addComponent(editDepositIDContractField)
                                                        .addComponent(editDepositIDClientField)
                                                        .addComponent(confirmToEditDepositsButton, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
                jPanel16Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel16Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel78, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel16Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel79)
                                        .addComponent(editDepositIDField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel16Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel80)
                                        .addComponent(editInitialMoneyField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel16Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel81)
                                        .addComponent(editDateOfOpeningField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel16Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel82)
                                        .addComponent(editFinalMoneyField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel16Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel83)
                                        .addComponent(editDepositIDTypeField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel16Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel84)
                                        .addComponent(editDepositIDContractField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel16Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel85)
                                        .addComponent(editDepositIDClientField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(38, 38, 38)
                                .addComponent(confirmToEditDepositsButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(75, Short.MAX_VALUE))
        );

        GroupLayout editDepositDialogLayout = new GroupLayout(editDepositDialog.getContentPane());
        editDepositDialog.getContentPane().setLayout(editDepositDialogLayout);
        editDepositDialogLayout.setHorizontalGroup(
                editDepositDialogLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel16, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        editDepositDialogLayout.setVerticalGroup(
                editDepositDialogLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel16, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        jLabel1.setText("Меню администратора");

        lookThroughClientsButton.setFont(new Font("Raleway", Font.PLAIN, 18));
        lookThroughClientsButton.setText("Клиенты");
        lookThroughClientsButton.setBackground(new Color(204, 204, 255));
        lookThroughClientsButton.setPreferredSize(new Dimension(50, 50));
        lookThroughClientsButton.setBorderPainted(false);
        lookThroughClientsButton.addActionListener(this::lookThroughClients);

        lookThroughEmployeesButton.setFont(new Font("Raleway", Font.PLAIN, 18));
        lookThroughEmployeesButton.setText("Сотрудники");
        lookThroughEmployeesButton.setBorderPainted(false);
        lookThroughEmployeesButton.setBackground(new Color(204, 204, 255));
        lookThroughEmployeesButton.setPreferredSize(new Dimension(50, 50));
        lookThroughEmployeesButton.addActionListener(this::lookThroughEmployees);

        lookThroughContractsButton.setFont(new Font("Raleway", Font.PLAIN, 18));
        lookThroughContractsButton.setText("Договоры");
        lookThroughContractsButton.setBorderPainted(false);
        lookThroughContractsButton.setBackground(new Color(177, 220, 252));
        lookThroughContractsButton.setPreferredSize(new Dimension(100, 50));
        lookThroughContractsButton.addActionListener(this::lookThroughContracts);

        lookThroughDepositTypesButton.setFont(new Font("Raleway", Font.PLAIN, 18));
        lookThroughDepositTypesButton.setText("Типы вкладов");
        lookThroughDepositTypesButton.setBorderPainted(false);
        lookThroughDepositTypesButton.setBackground(new Color(123, 161, 255));
        lookThroughDepositTypesButton.setPreferredSize(new Dimension(50, 50));
        lookThroughDepositTypesButton.addActionListener(this::lookThroughDepositTypes);

        lookThroughDepositsButton.setFont(new Font("Raleway", Font.PLAIN, 18));
        lookThroughDepositsButton.setText("Вклады");
        lookThroughDepositsButton.setBorderPainted(false);
        lookThroughDepositsButton.setBackground(new Color(123, 161, 255));
        lookThroughDepositsButton.setPreferredSize(new Dimension(50, 50));
        lookThroughDepositsButton.addActionListener(this::lookThroughDeposits);

        exitButton.setFont(new Font("Raleway", Font.PLAIN, 18));
        exitButton.setText("Выход");
        exitButton.setBorderPainted(false);
        exitButton.setPreferredSize(new Dimension(100, 50));
        exitButton.setBackground(new Color(177, 220, 252));
        exitButton.addActionListener(this::exitButtonActionPerformed);

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(                                                                                //меню админа
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(lookThroughDepositsButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, 300)
                                        .addComponent(lookThroughDepositTypesButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, 300)
                                        .addComponent(lookThroughContractsButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, 300)
                                        .addComponent(lookThroughEmployeesButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, 300)
                                        .addComponent(lookThroughClientsButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, 300)
                                        .addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
                                        .addComponent(exitButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, 300))
                                .addContainerGap())
        );

        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1,GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lookThroughClientsButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lookThroughEmployeesButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lookThroughContractsButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lookThroughDepositTypesButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lookThroughDepositsButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(exitButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(45, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    private void lookThroughEmployees(ActionEvent evt) {
        this.lookThroughEmployees();
        deleteEmployeeButton.setEnabled(false);
        editEmployeeButton.setEnabled(false);
        employeesDialog.setVisible(true);
        this.setVisible(false);
    }

    private void lookThroughClients() {
        String sqlString = "select * from clients";
        ArrayList<Client> clients = new ArrayList<>();
        SocketStream server = new SocketStream();
        server.sendInt(2);
        server.sendString(sqlString);
        try {
            int count = server.getInt();
            rows = count;
            for (int i = 0; i < count; i++) {
                int clientID = (int) Double.parseDouble(server.getString());
                clients.add(new ClientBuilder()
                        .buildClientId(clientID)
                        .buildLogin(server.getString())
                        .buildPassword(server.getString())
                        .buildFullName(server.getString())
                        .buildPassport(server.getString())
                        .buildPhoneNumber(server.getString())
                        .buildAddress(server.getString())
                        .build());
                lastID = clientID;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        model = new ClientsTableModel(clients);
        clientDataTable.setModel(model);
    }

    private void lookThroughEmployees() {
        String sqlString = "select * from employees";
        ArrayList<Employee> employee = new ArrayList<>();
        SocketStream server = new SocketStream();
        server.sendInt(10);
        server.sendString(sqlString);
        try {
            count = server.getInt();
            rows = count;
            for (int i = 0; i < count; i++) {
                int employeeID = (int) Double.parseDouble(server.getString());
                employee.add(new EmployeeBuilder()
                        .buildId(employeeID)
                        .buildLogin(server.getString())
                        .buildPassword(server.getString())
                        .buildFullName(server.getString())
                        .buildContractNumber((int) Double.parseDouble(server.getString()))
                        .buildDateOfRecruitment(server.getString())
                        .buildPosition((int) Double.parseDouble(server.getString()))
                        .build());
                lastID = employeeID;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        model = new EmployeesTableModel(employee);
        employeeDataTable.setModel(model);

    }

    private void lookThroughClients(ActionEvent evt) {
        deleteClientButton.setEnabled(false);
        editClientButton.setEnabled(false);
        this.lookThroughClients();
        clientsDialog.setVisible(true);
        this.setVisible(false);
    }

    private void returnFromClients(ActionEvent evt) {
        clientsDialog.setVisible(false);
        this.setVisible(true);
    }

    private void addClientButtonActionPerformed(ActionEvent evt) {
        addClientDialog.setVisible(true);
        clientsDialog.setVisible(false);
        lastID++;
        addClientIDField.setText("" + lastID);
    }

    private void confirmAddingClient(ActionEvent evt) {
        validator = true;
        SocketStream server = new SocketStream();
        int clientID = (int) Double.parseDouble(addClientIDField.getText());
        String clientLogin = addClientLoginField.getText();
        validator = valid.validateString(clientLogin);
        if (validator) {
            server.sendInt(15);
            server.sendString(clientLogin);
            int rez = 1;
            try {
                rez = (int) Double.parseDouble(server.getString());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            if (rez == 0) validator = false;
        }
        String clientPassword = new String(addClientPasswordField.getPassword());
        if (validator) validator = valid.validateString(clientPassword);
        String clientFullName = addClientFullNameField.getText();
        String clientPassport = addClientPassportField.getText();
        if (validator) validator = valid.validateString(clientPassport);
        String clientPhoneNumber = addClientPhoneNumberField.getText();
        if (validator) validator = valid.validateString(clientPhoneNumber);
        String clientAddress = addClientAddressField.getText();

        if (validator) {
            String sqlString = "insert into clients VALUES(" + clientID + ",'" + clientLogin + "','" + clientPassword + "','"
                    + clientFullName + "','" + clientPassport + "','" + clientPhoneNumber + "','" + clientAddress + "')";
            server.sendInt(7);
            server.sendString(sqlString);
            int result = 0;
            try {
                result = server.getInt();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            this.lookThroughClients();
            addClientDialog.setVisible(false);
            clientsDialog.setVisible(true);
            deleteClientButton.setEnabled(false);
            editClientButton.setEnabled(false);
        } else {
            JOptionPane.showMessageDialog(null, "Введенные данные некорректны!",
                    "Нажмите ОК для повторного ввода", JOptionPane.ERROR_MESSAGE);
            addClientDialog.setVisible(false);
            clientsDialog.setVisible(true);
        }
    }

    private void addClientPasswordFieldMouseClicked(MouseEvent evt) {
        addClientPasswordField.setText("");
    }

    private void clientDataTableMouseClicked(MouseEvent evt) {
        if (clientDataTable.getSelectedRowCount() > 0) {
            editClientButton.setEnabled(true);
            deleteClientButton.setEnabled(true);
        } else {
            editClientButton.setEnabled(false);
            deleteClientButton.setEnabled(false);
        }
    }

    private void deleteClient(ActionEvent evt) {
        int deleteClientByID = (int) clientDataTable.getValueAt(clientDataTable.getSelectedRow(), 0);
        String sqlString = "delete from clients where ClientID=" + deleteClientByID;
        SocketStream server = new SocketStream();
        server.sendInt(8);
        server.sendString(sqlString);
        int result = 0;
        try {
            result = server.getInt();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        if (result == 0) {
            JOptionPane.showMessageDialog(null, "Удаление невозможно!",
                    "Нажмите ОК.", JOptionPane.ERROR_MESSAGE);
        }
        this.lookThroughClients();
    }

    private void editClient(ActionEvent evt) {
        editClientDialog.setVisible(true);
        clientsDialog.setVisible(false);
        editClientIDField.setText("" + clientDataTable.getValueAt(clientDataTable.getSelectedRow(), 0));
        editClientLoginField.setText((String) clientDataTable.getValueAt(clientDataTable.getSelectedRow(), 1));
        editClientPasswordField.setText((String) clientDataTable.getValueAt(clientDataTable.getSelectedRow(), 2));
        editClientFullName.setText((String) clientDataTable.getValueAt(clientDataTable.getSelectedRow(), 3));
        editClientPassport.setText((String) clientDataTable.getValueAt(clientDataTable.getSelectedRow(), 4));
        editClientPhoneNumberField.setText((String) clientDataTable.getValueAt(clientDataTable.getSelectedRow(), 5));
        editClientAddressField.setText((String) clientDataTable.getValueAt(clientDataTable.getSelectedRow(), 6));
    }

    private void confirmEditingClient(ActionEvent evt) {
        String sqlString;
        validator = true;
        int clientID = (int) Double.parseDouble(editClientIDField.getText());
        String fullName = editClientFullName.getText();
        String passport = editClientPassport.getText();
        validator = valid.validateString(passport);
        String phone = editClientPhoneNumberField.getText();
        if (validator) validator = valid.validateString(phone);
        String address = editClientAddressField.getText();

        if (validator) {
            sqlString = "UPDATE clients SET ClientFullName = '" + fullName + "', ClientPassport = '" + passport
                    + "', ClientPhoneNumber = '" + phone + "', ClientAdress = '" + address + "' WHERE ClientID = " + clientID;
            SocketStream server = new SocketStream();
            server.sendInt(9);
            server.sendString(sqlString);
            int result = 0;
            try {
                result = server.getInt();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            if (result == 1) {
                this.lookThroughClients();
                editClientDialog.setVisible(false);
                clientsDialog.setVisible(true);
                editClientButton.setEnabled(false);
                deleteClientButton.setEnabled(false);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Данные некорректны!",
                    "Нажмите ОК.", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void returnFromEmployees(ActionEvent evt) {
        employeesDialog.setVisible(false);
        this.setVisible(true);
    }

    private void addEmployeeYearField(ActionEvent evt) {
        addEmployeeYearField.setText("");
    }

    private void addEmployeeMonthField(ActionEvent evt) {
        addEmployeeMonthField.setText("");
    }

    private void addEmployeeDayField(ActionEvent evt) {
        addEmployeeDayField.setText("");
    }

    private void addEmployee(ActionEvent evt) {
        addEmployeeDialog.setVisible(true);
        employeesDialog.setVisible(false);
        lastID++;
        addEmployeeIDField.setText(lastID + "");
    }

    private void confirmAddingEmployee(ActionEvent evt) {
        validator = true;
        SocketStream server = new SocketStream();
        int employeeID = (int) Double.parseDouble(addEmployeeIDField.getText());
        String employeeLogin = addEmployeeLoginField.getText();
        validator = valid.validateString(employeeLogin);
        if (validator) {
            server.sendInt(17);
            server.sendString(employeeLogin);
            int rez = 1;
            try {
                rez = (int) Double.parseDouble(server.getString());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            if (rez == 0) validator = false;
        }
        String employeePassword = new String(addEmployeePassword.getPassword());
        if (validator) validator = valid.validateString(employeePassword);
        String employeeFullName = addEmployeeFullNameField.getText();
        int employeeContractNumber = 0;
        try {
            employeeContractNumber = (int) Double.parseDouble(addEmployeeContractNumber.getText());
        } catch (Exception e) {
            validator = false;
        }
        if (validator) validator = valid.validateInt(employeeContractNumber);
        String employeeDateOfRecr = addEmployeeYearField.getText() + "-";
        employeeDateOfRecr += addEmployeeMonthField.getText() + "-";
        employeeDateOfRecr += addEmployeeDayField.getText();
        if (validator) validator = valid.validateDate(employeeDateOfRecr);
        int employeePosition;
        if (addEmployeePositionField.getSelectedItem() == "Администратор")
            employeePosition = 2;
        else employeePosition = 1;
        if (validator) {
            String sqlString = "insert into employees VALUES(" + employeeID + ",'" + employeeLogin + "','" + employeePassword + "','"
                    + employeeFullName + "'," + employeeContractNumber + ",'" + employeeDateOfRecr + "'," + employeePosition + ")";
            server = new SocketStream();
            server.sendInt(7);
            server.sendString(sqlString);
            int result = 0;
            try {
                result = server.getInt();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            this.lookThroughEmployees();
            addEmployeeDialog.setVisible(false);
            employeesDialog.setVisible(true);
            deleteEmployeeButton.setEnabled(false);
            editEmployeeButton.setEnabled(false);
        } else {
            JOptionPane.showMessageDialog(null, "Введенные данные некорректны!",
                    "Нажмите ОК для повторного ввода", JOptionPane.ERROR_MESSAGE);
            addEmployeeDialog.setVisible(false);
            employeesDialog.setVisible(true);
        }
    }

    private void editEmployee(ActionEvent evt) {
        editEmployeeDialog.setVisible(true);
        employeesDialog.setVisible(false);
        editEmployeeIDField.setText("" + employeeDataTable.getValueAt(employeeDataTable.getSelectedRow(), 0));
        editEmployeeLoginField.setText((String) employeeDataTable.getValueAt(employeeDataTable.getSelectedRow(), 1));
        previous = (String) employeeDataTable.getValueAt(employeeDataTable.getSelectedRow(), 1);
        editEmployeePassword.setText((String) employeeDataTable.getValueAt(employeeDataTable.getSelectedRow(), 2));
        editEmployeeFullName.setText((String) employeeDataTable.getValueAt(employeeDataTable.getSelectedRow(), 3));
        editEmployeeContractNumber.setText("" + (int) employeeDataTable.getValueAt(employeeDataTable.getSelectedRow(), 4)); //EditEmployeeYear
        editEmployeeDate.setText((String) employeeDataTable.getValueAt(employeeDataTable.getSelectedRow(), 5));
        int code = (int) employeeDataTable.getValueAt(employeeDataTable.getSelectedRow(), 6);
        if (code == 1) {
            editEmployeePosition.setSelectedItem("Консультант");
        } else {
            editEmployeePosition.setSelectedItem("Администратор");
        }
    }

    private void employeeDataTableMouseClicked(MouseEvent evt) {
        if (employeeDataTable.getSelectedRowCount() > 0) {
            editEmployeeButton.setEnabled(true);
            deleteEmployeeButton.setEnabled(true);
        } else {
            editEmployeeButton.setEnabled(false);
            deleteEmployeeButton.setEnabled(false);
        }
    }

    private void confirmEditingEmployee(ActionEvent evt) {
        validator = true;
        SocketStream server = new SocketStream();
        int employeeID = (int) Double.parseDouble(editEmployeeIDField.getText());
        String employeeLogin = editEmployeeLoginField.getText();
        validator = valid.validateString(employeeLogin);
        if (validator) {
            server.sendInt(18);
            server.sendString(employeeLogin);
            server.sendString(previous);
            int rez = 1;
            try {
                rez = (int) Double.parseDouble(server.getString());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            if (rez == 0) validator = false;
        }
        String employeePassword = new String(editEmployeePassword.getPassword());
        if (validator)
            validator = valid.validateString(employeePassword);
        String employeeFullName = editEmployeeFullName.getText();
        int employeeContractNumber = 0;

        try {
            employeeContractNumber = (int) Double.parseDouble(editEmployeeContractNumber.getText());
        } catch (Exception e) {
            validator = false;
        }

        if (validator)
            validator = valid.validateInt(employeeContractNumber);
        String employeeDateOfRecr = editEmployeeDate.getText();
        if (validator)
            validator = valid.validateDate(employeeDateOfRecr);
        int employeePosition;
        if (editEmployeePosition.getSelectedItem() == "Администратор")
            employeePosition = 2;
        else employeePosition = 1;
        if (validator) {
            String sqlString = "update employees SET employeeLogin='" + employeeLogin + "',employeePassword='"
                    + employeePassword + "',employeeFullName='" + employeeFullName + "',ContractNumber="
                    + employeeContractNumber + ",DateOfRecruitment='" + employeeDateOfRecr + "',Position=" + employeePosition + " WHERE employeeID=" + employeeID;
            server = new SocketStream();
            server.sendInt(9);
            server.sendString(sqlString);
            int result = 0;
            try {
                result = server.getInt();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            this.lookThroughEmployees();
            editEmployeeDialog.setVisible(false);
            employeesDialog.setVisible(true);
            deleteEmployeeButton.setEnabled(false);
            editEmployeeButton.setEnabled(false);
        } else {
            JOptionPane.showMessageDialog(null, "Введенные данные некорректны!",
                    "Нажмите ОК для повторного ввода", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void deleteEmployee(ActionEvent evt) {
        int deleteEmployeeByID = (int) employeeDataTable.getValueAt(employeeDataTable.getSelectedRow(), 0);
        int deletingPosition = (int) employeeDataTable.getValueAt(employeeDataTable.getSelectedRow(), 6);
        if (deletingPosition != 2) {
            String sqlString = "delete from employees where EmployeeID=" + deleteEmployeeByID;
            SocketStream server = new SocketStream();
            server.sendInt(8);
            server.sendString(sqlString);
            int result = 0;
            try {
                result = server.getInt();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            if (result == 0) {
                JOptionPane.showMessageDialog(null, "Удаление невозможно!",
                        "Нажмите ОК.", JOptionPane.ERROR_MESSAGE);
            }
            JOptionPane.showMessageDialog(null, "Удаление совершено!!",
                    "Нажмите ОК.", JOptionPane.INFORMATION_MESSAGE);
            this.lookThroughEmployees();
        } else {
            JOptionPane.showMessageDialog(null, "Удаление невозможно!",
                    "Нельзя удалить администратора системы!", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void lookThroughContracts() {
        String sqlString = "select * from contacts";
        ArrayList<Contract> contracts = new ArrayList<>();
        SocketStream server = new SocketStream();
        server.sendInt(4);
        server.sendString(sqlString);
        try {
            int count = server.getInt();
            rows = count;
            for (int i = 0; i < count; i++) {
                int contractNumber = (int) Double.parseDouble(server.getString());
                contracts.add(new ContractBuilder()
                        .buildContractNumber(contractNumber)
                        .buildDateOfSigning(server.getString())
                        .buildClientID((int) Double.parseDouble(server.getString()))
                        .buildEmployeeID((int) Double.parseDouble(server.getString()))
                        .build());
                lastID = contractNumber;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        model = new ContractsTableModel(contracts);
        contractsTable.setModel(model);
    }

    private void lookThroughContracts(ActionEvent evt) {
        deleteContractButton.setEnabled(false);
        editContractButton.setEnabled(false);
        this.lookThroughContracts();
        contractsDialog.setVisible(true);
        contractsDialog.setVisible(true);
        this.setVisible(false);
    }

    private void contractsTableMouseClicked(MouseEvent evt) {
        if (contractsTable.getSelectedRowCount() > 0) {
            editContractButton.setEnabled(true);
            deleteContractButton.setEnabled(true);
        } else {
            editContractButton.setEnabled(false);
            deleteContractButton.setEnabled(false);
        }
    }

    private void addContract(ActionEvent evt) {
        addContractDialog.setVisible(true);
        contractsDialog.setVisible(false);
        lastID++;
        addContractNumberField.setText(lastID + "");
    }

    private void confirmAdditionContract(ActionEvent evt) {
        validator = true;
        int contractNumber = (int) Double.parseDouble(addContractNumberField.getText());
        String dateOfSinging = addYearOfSigningField.getText() + "-";
        dateOfSinging += addMonthOfSigningField.getText() + "-";
        dateOfSinging += addDayOfSigningField.getText();
        validator = valid.validateDate(dateOfSinging);
        int clientID = 0;
        try {
            clientID = (int) Double.parseDouble(addContractClientID.getText());
        } catch (Exception e) {
            validator = false;
        }
        if (validator) validator = valid.validateInt(clientID);
        int employeeID = 0;
        try {
            employeeID = (int) Double.parseDouble(addContractsEmployeeIDField.getText());
        } catch (Exception e) {
            validator = false;
        }
        if (validator) validator = valid.validateInt(employeeID);
        if (validator) {
            String sqlString = "insert into contacts VALUES(" + contractNumber + ",'" + dateOfSinging + "'," + clientID + ","
                    + employeeID + ")";
            SocketStream server = new SocketStream();
            server.sendInt(7);
            server.sendString(sqlString);
            int result = 0;
            try {
                result = server.getInt();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            this.lookThroughContracts();
            addContractDialog.setVisible(false);
            contractsDialog.setVisible(true);
            deleteContractButton.setEnabled(false);
            editContractButton.setEnabled(false);
        } else {
            JOptionPane.showMessageDialog(null, "Введенные данные некорректны!",
                    "Нажмите ОК для повторного ввода", JOptionPane.ERROR_MESSAGE);
            addContractDialog.setVisible(false);
            contractsDialog.setVisible(true);
        }

    }

    private void returnFromContracts(ActionEvent evt) {
        contractsDialog.setVisible(false);
        this.setVisible(true);
    }

    private void editContract(ActionEvent evt) {
        editContractDialog.setVisible(true);
        contractsDialog.setVisible(false);
        editContractNumberField.setText("" + contractsTable.getValueAt(contractsTable.getSelectedRow(), 0));
        editDateOfSigning.setText((String) contractsTable.getValueAt(contractsTable.getSelectedRow(), 1));
        editContractClientIDField.setText("" + contractsTable.getValueAt(contractsTable.getSelectedRow(), 2));
        editContractEmployeeID.setText("" + contractsTable.getValueAt(contractsTable.getSelectedRow(), 3));
    }

    private void confirmEditingContract(ActionEvent evt) {
        validator = true;
        int contractNumber = (int) Double.parseDouble(editContractNumberField.getText());
        String dateOfSigning = editDateOfSigning.getText();
        validator = valid.validateDate(dateOfSigning);
        int clientID = 0;
        int employeeID = 0;
        try {
            clientID = (int) Double.parseDouble(editContractClientIDField.getText());
            employeeID = (int) Double.parseDouble(editContractEmployeeID.getText());
        } catch (Exception e) {
            validator = false;
        }

        if (validator) validator = valid.validateInt(clientID);
        if (validator) validator = valid.validateInt(employeeID);

        if (validator) {
            String sqlString = "update contacts SET DateOfSigning='" + dateOfSigning + "',ClientID="
                    + clientID + ",EmployeeID=" + employeeID + " WHERE ContractNumber=" + contractNumber;
            SocketStream server = new SocketStream();
            server.sendInt(9);
            server.sendString(sqlString);
            int result = 0;
            try {
                result = server.getInt();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            this.lookThroughContracts();
            editContractDialog.setVisible(false);
            contractsDialog.setVisible(true);
            deleteContractButton.setEnabled(false);
            editContractButton.setEnabled(false);
        } else {
            JOptionPane.showMessageDialog(null, "Введенные данные некорректны!",
                    "Нажмите ОК для повторного ввода", JOptionPane.ERROR_MESSAGE);
            addContractDialog.setVisible(false);
            contractsDialog.setVisible(true);
        }


    }

    private void deleteContract(ActionEvent evt) {
        int deleteContractByID = (int) contractsTable.getValueAt(contractsTable.getSelectedRow(), 0);
        String sqlString = "delete from contacts where ContractNumber=" + deleteContractByID;
        SocketStream server = new SocketStream();
        server.sendInt(8);
        server.sendString(sqlString);
        int result = 0;
        try {
            result = server.getInt();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        if (result == 0) {
            JOptionPane.showMessageDialog(null, "Удаление невозможно!",
                    "Нажмите ОК.", JOptionPane.ERROR_MESSAGE);
        }
        JOptionPane.showMessageDialog(null, "Удаление совершено!!",
                "Нажмите ОК.", JOptionPane.INFORMATION_MESSAGE);
        this.lookThroughContracts();

    }

    private void lookThroughDepositTypes() {
        String sqlString = "select * from depositTypes";
        ArrayList<DepositType> deptypes = new ArrayList<>();
        SocketStream server = new SocketStream();
        server.sendInt(6);
        server.sendString(sqlString);
        try {
            int count = server.getInt();
            rows = count;
            for (int i = 0; i < count; i++) {
                int typeID = (int) Double.parseDouble(server.getString());
                deptypes.add(new DepositTypeBuilder()
                        .buildId(typeID)
                        .buildName(server.getString())
                        .buildMinMoney((int) Double.parseDouble(server.getString()))
                        .buildMaxMoney((int) Double.parseDouble(server.getString()))
                        .buildPeriod((int) Double.parseDouble(server.getString()))
                        .buildCapitalization((int) Double.parseDouble(server.getString()))
                        .buildPercent((int) Double.parseDouble(server.getString()))
                        .build());
                lastID = typeID;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        model = new DepositTypesTableModel(deptypes);
        depositTypesTable.setModel(model);
    }

    private void lookThroughDepositTypes(ActionEvent evt) {
        deleteDepTypeButton.setEnabled(false);
        editDepTypeButton.setEnabled(false);
        this.lookThroughDepositTypes();
        depositTypesDialog.setVisible(true);
        this.setVisible(false);
    }

    private void returnFromDepTypes(ActionEvent evt) {
        depositTypesDialog.setVisible(false);
        this.setVisible(true);
    }

    private void addDepType(ActionEvent evt) {
        addDepositTypeDialog.setVisible(true);
        depositTypesDialog.setVisible(false);
        lastID++;
        addTypeIDField.setText("" + lastID);
    }

    private void confirmAddingType(ActionEvent evt) {
        validator = true;
        int typeID = (int) Double.parseDouble(addTypeIDField.getText());
        String typeName = addTypeNameField.getText();
        validator = valid.validateString(typeName);
        int typeMinMoney = 0;
        int typeMaxMoney = 0;
        int typePeriod = 0;
        int typeCapitalization = 0;
        int typePercent = 0;
        try {
            typeMinMoney = (int) Double.parseDouble(addTypeMinMoneyField.getText());
            typeMaxMoney = (int) Double.parseDouble(addTypeMaxMoneyField.getText());
            typePeriod = (int) Double.parseDouble(addTypePeriodField.getText());
            typeCapitalization = (int) Double.parseDouble(addTypeCapitalizationField.getText());
            typePercent = (int) Double.parseDouble(addTypePercentField.getText());
        } catch (Exception e) {
            validator = false;
        }

        if (validator) validator = valid.validateInt(typeMinMoney);
        if (validator) validator = valid.validateInt(typeMaxMoney);
        if (validator) validator = valid.validateInt(typePeriod);
        if (validator) validator = valid.validateInt(typeCapitalization);
        if (validator) validator = valid.validateInt(typePercent);

        if (typeMinMoney < typeMaxMoney && validator) {
            String sqlString = "insert into depositTypes VALUES(" + typeID + ",'" + typeName + "'," + typeMinMoney + ","
                    + typeMaxMoney + "," + typePeriod + "," + typeCapitalization + "," + typePercent + ")";
            SocketStream server = new SocketStream();
            server.sendInt(7);
            server.sendString(sqlString);
            int result = 0;
            try {
                result = server.getInt();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            this.lookThroughDepositTypes();
            addDepositTypeDialog.setVisible(false);
            depositTypesDialog.setVisible(true);

        } else {
            JOptionPane.showMessageDialog(null, "Введенные данные некорректны!",
                    "Нажмите ОК.", JOptionPane.ERROR_MESSAGE);
            addDepositTypeDialog.setVisible(false);
            depositTypesDialog.setVisible(true);
        }
    }

    private void depositTypesTableMouseClicked(MouseEvent evt) {
        if (depositTypesTable.getSelectedRowCount() > 0) {
            editDepTypeButton.setEnabled(true);
            deleteDepTypeButton.setEnabled(true);
        } else {
            editDepTypeButton.setEnabled(false);
            deleteDepTypeButton.setEnabled(false);
        }
    }

    private void editDepType(ActionEvent evt) {
        editTypeIDField.setText("" + depositTypesTable.getValueAt(depositTypesTable.getSelectedRow(), 0));
        editTypeNameField.setText((String) depositTypesTable.getValueAt(depositTypesTable.getSelectedRow(), 1));
        editTypeMinMonField.setText("" + depositTypesTable.getValueAt(depositTypesTable.getSelectedRow(), 2));
        editTypeMaxMonField.setText("" + depositTypesTable.getValueAt(depositTypesTable.getSelectedRow(), 3));
        editTypePeriodField.setText("" + depositTypesTable.getValueAt(depositTypesTable.getSelectedRow(), 4));
        editTypeCapitalizationField.setText("" + depositTypesTable.getValueAt(depositTypesTable.getSelectedRow(), 5));
        editTypePercentField.setText("" + depositTypesTable.getValueAt(depositTypesTable.getSelectedRow(), 6));
        editDepTypeDialog.setVisible(true);
        depositTypesDialog.setVisible(false);

    }

    private void confirmEditingType(ActionEvent evt) {
        validator = true;
        int typeID = (int) Double.parseDouble(editTypeIDField.getText());
        String typeName = editTypeNameField.getText();
        validator = valid.validateString(typeName);
        int typeMinMoney = 0;
        int typeMaxMoney = 0;
        int typePeriod = 0;
        int typeCapitalization = 0;
        int typePercent = 0;
        try {
            typeMinMoney = (int) Double.parseDouble(editTypeMinMonField.getText());
            typeMaxMoney = (int) Double.parseDouble(editTypeMaxMonField.getText());
            typePeriod = (int) Double.parseDouble(editTypePeriodField.getText());
            typeCapitalization = (int) Double.parseDouble(editTypeCapitalizationField.getText());
            typePercent = (int) Double.parseDouble(editTypePercentField.getText());
        } catch (Exception e) {
            validator = false;
        }

        if (validator) validator = valid.validateInt(typeMinMoney);
        if (validator) validator = valid.validateInt(typeMaxMoney);
        if (validator) validator = valid.validateInt(typePeriod);
        if (validator) validator = valid.validateInt(typeCapitalization);
        if (validator) validator = valid.validateInt(typePercent);

        if (typeMinMoney < typeMaxMoney && validator) {
            String sqlString = "UPDATE depositTypes SET TypeName='" + typeName + "',TypeMinMoney=" + typeMinMoney
                    + ",TypeMaxMoney=" + typeMaxMoney + ",TypePeriod=" + typePeriod
                    + ",TypeCapitalization=" + typeCapitalization + ",TypeInterestRate="
                    + typePercent + " WHERE TypeID=" + typeID;
            SocketStream server = new SocketStream();
            server.sendInt(9);
            server.sendString(sqlString);
            int result = 0;
            try {
                result = server.getInt();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            this.lookThroughDepositTypes();
            editDepTypeDialog.setVisible(false);
            depositTypesDialog.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Введенные данные некорректны!",
                    "Нажмите ОК.", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deleteDepType(ActionEvent evt) {
        int deleteDepTypeByID = (int) depositTypesTable.getValueAt(depositTypesTable.getSelectedRow(), 0);
        String sqlString = "delete from depositTypes where TypeID=" + deleteDepTypeByID;
        SocketStream server = new SocketStream();
        server.sendInt(8);
        server.sendString(sqlString);
        int result = 0;
        try {
            result = server.getInt();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        if (result == 0) {
            JOptionPane.showMessageDialog(null, "Удаление невозможно!",
                    "Нажмите ОК.", JOptionPane.ERROR_MESSAGE);
        }
        JOptionPane.showMessageDialog(null, "Удаление совершено!!",
                "Нажмите ОК.", JOptionPane.INFORMATION_MESSAGE);
        this.lookThroughDepositTypes();
    }

    private void lookThroughDeposits() {
        String sqlString = "select * from deposits";
        absInitialMoney = 0;
        absPlannedMoney = 0;
        ArrayList<Deposit> deps = new ArrayList<>();
        SocketStream server = new SocketStream();
        server.sendInt(5);
        server.sendString(sqlString);
        try {
            int count = server.getInt();
            rows = count;
            for (int i = 0; i < count; i++) {
                int depId = (int) Double.parseDouble(server.getString());
                int initMoney = (int) Double.parseDouble(server.getString());
                absInitialMoney += initMoney;
                String date = server.getString();
                int plannedMoney = (int) Double.parseDouble(server.getString());
                absPlannedMoney += plannedMoney;
                deps.add(new DepositBuilder()
                        .buildNumber(depId)
                        .buildInitialMoney(initMoney)
                        .buildDateOfOpening(date)
                        .buildPlannedAmountOfMoney(plannedMoney)
                        .buildTypeOfDeposit((int) Double.parseDouble(server.getString()))
                        .buildContractNumber((int) Double.parseDouble(server.getString()))
                        .buildClientId((int) Double.parseDouble(server.getString()))
                        .build());
                lastID = depId;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        model = new DepositsTableModel(deps);
        depositsDataTable.setModel(model);
    }

    private void lookThroughDeposits(ActionEvent evt) {
        deleteDepositButton.setEnabled(false);
        editDepositButton.setEnabled(false);
        this.lookThroughDeposits();
        depositsDialog.setVisible(true);
        this.setVisible(false);
    }

    private void addDeposit(ActionEvent evt) {
        addDepositDialog.setVisible(true);
        depositsDialog.setVisible(false);
        lastID++;
        addDepositIDField.setText("" + lastID);
    }

    private void confirmAddingDeposit(ActionEvent evt) {
        validator = true;
        int depositID = (int) Double.parseDouble(addDepositIDField.getText());
        int initialMoney = 0;
        int typeID = 0;
        int contractNumber = 0;
        int clientID = 0;
        try {
            initialMoney = (int) Double.parseDouble(addDepositInitialMoneyField.getText());
            typeID = (int) Double.parseDouble(addDepositIDTypeField.getText());
            contractNumber = (int) Double.parseDouble(addDepositContractNumberField.getText());
            clientID = (int) Double.parseDouble(addDepositClientIDField.getText());
        } catch (Exception e) {
            validator = false;
        }
        if (validator) validator = valid.validateInt(initialMoney);
        if (validator) validator = valid.validateInt(typeID);
        if (validator) validator = valid.validateInt(clientID);
        if (validator) validator = valid.validateInt(contractNumber);
        String dateOfOpening = addDepositYearField.getText() + "-";
        dateOfOpening += addDepositMonthField.getText() + "-";
        dateOfOpening += addDepositDayField.getText();
        if (validator) validator = valid.validateDate(dateOfOpening);
        int plannedMoney = 0;

        if (validator) {
            SocketStream server = new SocketStream();
            server.sendInt(11);
            server.sendInt(initialMoney);
            server.sendInt(typeID);
            try {
                plannedMoney = server.getInt();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            String sqlString = "insert into deposits VALUES(" + depositID + "," + initialMoney + ",'" + dateOfOpening + "',"
                    + plannedMoney + "," + typeID + "," + contractNumber + "," + clientID + ")";
            server.sendInt(7);
            server.sendString(sqlString);
            int result = 0;
            try {
                result = server.getInt();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            this.lookThroughDeposits();
            addDepositDialog.setVisible(false);
            depositsDialog.setVisible(true);
            deleteDepositButton.setEnabled(false);
            editDepositButton.setEnabled(false);
        } else {
            JOptionPane.showMessageDialog(null, "Введенные данные некорректны!",
                    "Нажмите ОК для повторного ввода", JOptionPane.ERROR_MESSAGE);
            addDepositDialog.setVisible(false);
            depositsDialog.setVisible(true);
        }

    }

    private void returnFromDeposits(ActionEvent evt) {
        depositsDialog.setVisible(false);
        this.setVisible(true);
    }

    private void depositsDataTableMouseClicked(MouseEvent evt) {
        if (depositsDataTable.getSelectedRowCount() > 0) {
            editDepositButton.setEnabled(true);
            deleteDepositButton.setEnabled(true);
        } else {
            editDepositButton.setEnabled(false);
            deleteDepositButton.setEnabled(false);
        }
    }

    private void editDeposit(ActionEvent evt) {
        editDepositIDField.setText("" + depositsDataTable.getValueAt(depositsDataTable.getSelectedRow(), 0));
        editInitialMoneyField.setText("" + depositsDataTable.getValueAt(depositsDataTable.getSelectedRow(), 1));
        editDateOfOpeningField.setText((String) depositsDataTable.getValueAt(depositsDataTable.getSelectedRow(), 2));
        editDepositIDTypeField.setText("" + depositsDataTable.getValueAt(depositsDataTable.getSelectedRow(), 4));
        editDepositIDContractField.setText("" + depositsDataTable.getValueAt(depositsDataTable.getSelectedRow(), 5));
        editDepositIDClientField.setText("" + depositsDataTable.getValueAt(depositsDataTable.getSelectedRow(), 6));
        editDepositDialog.setVisible(true);
        depositsDialog.setVisible(false);
    }

    private void confirmToEditDeposits(ActionEvent evt) {
        validator = true;
        int depositID = (int) Double.parseDouble(editDepositIDField.getText());
        int initialMoney = 0;
        int typeID = 0;
        int contractNumber = 0;
        int clientID = 0;
        try {
            initialMoney = (int) Double.parseDouble(editInitialMoneyField.getText());
            typeID = (int) Double.parseDouble(editDepositIDTypeField.getText());
            contractNumber = (int) Double.parseDouble(editDepositIDContractField.getText());
            clientID = (int) Double.parseDouble(editDepositIDClientField.getText());
        } catch (Exception e) {
            validator = false;
        }

        if (validator) validator = valid.validateInt(initialMoney);
        if (validator) validator = valid.validateInt(typeID);
        if (validator) validator = valid.validateInt(clientID);
        if (validator) validator = valid.validateInt(contractNumber);

        String dateOfOpening = editDateOfOpeningField.getText();
        if (validator) validator = valid.validateDate(dateOfOpening);
        int plannedMoney = 0;

        if (validator) {
            SocketStream server = new SocketStream();
            server.sendInt(11);
            server.sendInt(initialMoney);
            server.sendInt(typeID);
            try {
                plannedMoney = server.getInt();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            String sqlString = "UPDATE deposits SET InitialMoney=" + initialMoney + ",DateOfOpening='" + dateOfOpening
                    + "',PlannedFinalMoney=" + plannedMoney + ",TypeID=" + typeID
                    + ",ContractNumber=" + contractNumber + ",ClientID="
                    + clientID + " WHERE DepositNumber=" + depositID;
            server.sendInt(9);
            server.sendString(sqlString);
            int result = 0;
            try {
                result = server.getInt();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            this.lookThroughDeposits();
            editDepositDialog.setVisible(false);
            depositsDialog.setVisible(true);
            deleteDepositButton.setEnabled(false);
            editDepositButton.setEnabled(false);
        } else {
            JOptionPane.showMessageDialog(null, "Введенные данные некорректны!",
                    "Нажмите ОК для повторного ввода", JOptionPane.ERROR_MESSAGE);
        }


    }

    private void deleteDeposit(ActionEvent evt) {
        int deleteDepByID = (int) depositsDataTable.getValueAt(depositsDataTable.getSelectedRow(), 0);
        String sqlString = "delete from deposits where DepositNumber=" + deleteDepByID;
        SocketStream server = new SocketStream();
        server.sendInt(8);
        server.sendString(sqlString);
        int result = 0;
        try {
            result = server.getInt();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        if (result == 0) {
            JOptionPane.showMessageDialog(null, "Удаление невозможно!",
                    "Нажмите ОК.", JOptionPane.ERROR_MESSAGE);
        }
        JOptionPane.showMessageDialog(null, "Удаление совершено!!",
                "Нажмите ОК.", JOptionPane.INFORMATION_MESSAGE);
        this.lookThroughDeposits();
        this.setVisible(true);
    }

    private void putClientsIntoFile(ActionEvent evt) {
        try {
            FileWriter writer = new FileWriter("clients.txt", true);
            String first = "ID\tЛогин\tФИО\tПаспорт\tТелефон\tАдрес";
            writer.write(first);
            writer.append('\n');
            int numberOfRows = rows;
            for (int i = 0; i < rows; i++) {
                String clientID = "" + clientDataTable.getValueAt(i, 0);
                String clientLogin = (String) clientDataTable.getValueAt(i, 1);
                String fullName = (String) clientDataTable.getValueAt(i, 3);
                String passport = (String) clientDataTable.getValueAt(i, 4);
                String phoneNumber = (String) clientDataTable.getValueAt(i, 5);
                String address = (String) clientDataTable.getValueAt(i, 6);

                String result = clientID + "\t" + clientLogin + "\t" + fullName + "\t" + passport + "\t" + phoneNumber + "\t" + address;
                writer.write(result);
                writer.append('\n');
            }
            writer.flush();
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        JOptionPane.showMessageDialog(null, "Данные добавлены!",
                "Нажмите ОК.", JOptionPane.INFORMATION_MESSAGE);
    }

    private void putEmployeesIntoFile(ActionEvent evt) {
        try {
            FileWriter writer = new FileWriter("employees.txt", true);
            String first = "\tID\tЛогин\tФИО\tНомер договора\tДата найма\tПозиция\t";
            writer.write(first);
            writer.append('\n');
            int numberOfRows = rows;
            for (int i = 0; i < rows; i++) {
                String employeeID = "" + employeeDataTable.getValueAt(i, 0);
                String employeeLogin = (String) employeeDataTable.getValueAt(i, 1);
                String fullName = (String) employeeDataTable.getValueAt(i, 3);
                String contractNumber = "" + employeeDataTable.getValueAt(i, 4);
                String dateOfRecruitment = (String) employeeDataTable.getValueAt(i, 5);
                String position = "" + employeeDataTable.getValueAt(i, 6);

                String result = "\t" + employeeID + "\t" + employeeLogin + "\t" + fullName + "\t" + contractNumber + "\t" + dateOfRecruitment + "\t" + position + "\t";
                writer.write(result);
                writer.append('\n');
            }
            writer.flush();
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        JOptionPane.showMessageDialog(null, "Данные добавлены!",
                "Нажмите ОК.", JOptionPane.INFORMATION_MESSAGE);
    }

    private void putContractsIntoFile(ActionEvent evt) {
        try {
            FileWriter writer = new FileWriter("contracts.txt", true);
            String first = "\tНомер\tДата заключения\tID К.\tID С.\t";
            writer.write(first);
            writer.append('\n');
            int numberOfRows = rows;
            for (int i = 0; i < rows; i++) {
                String contractNumbet = "" + contractsTable.getValueAt(i, 0);
                String dateOfSigning = (String) contractsTable.getValueAt(i, 1);
                String clientID = "" + contractsTable.getValueAt(i, 2);
                String employeeID = "" + contractsTable.getValueAt(i, 3);

                String result = "\t" + contractNumbet + "\t" + dateOfSigning + "\t" + clientID + "\t" + employeeID + "\t";
                writer.write(result);
                writer.append('\n');
            }
            writer.flush();
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        JOptionPane.showMessageDialog(null, "Данные добавлены!",
                "Нажмите ОК.", JOptionPane.INFORMATION_MESSAGE);
    }

    private void putDepTypesIntoFile(ActionEvent evt) {
        try {
            FileWriter writer = new FileWriter("Deposits Types.txt", true);
            String first = "\tID\tНазвание\tМинимально\tМаксимально\tПериод\tКапитализация\tПроцент";
            writer.write(first);
            writer.append('\n');
            int numberOfRows = rows;
            for (int i = 0; i < rows; i++) {
                String typeID = "" + depositTypesTable.getValueAt(i, 0);
                String typeName = (String) depositTypesTable.getValueAt(i, 1);
                String typeMinMoney = "" + depositTypesTable.getValueAt(i, 2);
                String typeMaxMoney = "" + depositTypesTable.getValueAt(i, 3);
                String typePeriod = "" + depositTypesTable.getValueAt(i, 4);
                String typeCapitalization = "" + depositTypesTable.getValueAt(i, 5);
                String typePercent = "" + depositTypesTable.getValueAt(i, 6);

                String result = "\t" + typeID + "\t" + typeName + "\t" + typeMinMoney + "\t" + typeMaxMoney + "\t" + typePeriod + "\t" + typeCapitalization + "\t" + typePercent;
                writer.write(result);
                writer.append('\n');
            }
            writer.flush();
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        JOptionPane.showMessageDialog(null, "Данные добавлены!",
                "Нажмите ОК.", JOptionPane.INFORMATION_MESSAGE);
    }

    private void putDepositsIntoFile(ActionEvent evt) {
        try {
            FileWriter writer = new FileWriter("Deposits.txt", true);
            String first = "\tID\tНачально\tДата открытия\tПланируется\tТип\tДоговор\tКлиент";
            writer.write(first);
            writer.append('\n');
            int numberOfRows = rows;
            for (int i = 0; i < rows; i++) {
                String depNumber = "" + depositsDataTable.getValueAt(i, 0);
                String initialMoney = "" + depositsDataTable.getValueAt(i, 1);
                String dateOfOpening = (String) depositsDataTable.getValueAt(i, 2);
                String plannedMoney = "" + depositsDataTable.getValueAt(i, 3);
                String typeID = "" + depositsDataTable.getValueAt(i, 4);
                String contractNumber = "" + depositsDataTable.getValueAt(i, 5);
                String clientID = "" + depositsDataTable.getValueAt(i, 6);

                String result = "\t" + depNumber + "\t" + initialMoney + "\t" + dateOfOpening + "\t" + plannedMoney + "\t" + typeID + "\t" + contractNumber + "\t" + clientID;
                writer.write(result);
                writer.append('\n');
            }
            writer.flush();
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        JOptionPane.showMessageDialog(null, "Данные добавлены!",
                "Нажмите ОК.", JOptionPane.INFORMATION_MESSAGE);
    }

    private void drawACircleChart(ActionEvent evt) {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Начальные суммы, имеющиеся в распоряжении банка", absInitialMoney);
        dataset.setValue("Конечные суммы, возвращаемые вкладчикам", absPlannedMoney);
        JFreeChart chart = ChartFactory.createPieChart(
                "Начальные и конечные суммы",   // chart title
                dataset,          // data
                true,             // include legend
                true,
                false);
        JFrame graph = new JFrame("Прирост средств по вкладу");
        graph.getContentPane().add(new ChartPanel(chart));
        graph.setSize(400, 300);
        graph.setVisible(true);
    }

    private void exitButtonActionPerformed(ActionEvent evt) {
        this.setVisible(false);
        Authorization auth = new Authorization();
        auth.setVisible(true);
        auth.setLocationRelativeTo(null);
    }

    private void searchClients(ActionEvent event) {
        if (searchInput2.getText().isEmpty()) {
            return;
        }
        String sqlString;
        if (searchProps2.getSelectedItem().equals("Поиск по --")) {
            sqlString = "select * from clients";
            searchInput2.setText("");
        } else {
            Map<String, String> properties = new HashMap<>() {{
                put("Логин", "ClientLogin");
                put("Паспорт", "ClientPassport");
                put("Телефон", "ClientPhoneNumber");
            }};
            sqlString = "select * from clients WHERE " + properties.get(searchProps2.getSelectedItem()) + " = '" + searchInput2.getText() + "'";
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
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        model = new ClientsTableModel(client);
        clientDataTable.setModel(model);
        this.setVisible(false);
    }

    private void searchEmployees(ActionEvent event) {
        if (searchInput1.getText().isEmpty()) {
            return;
        }
        String sqlString;
        if (searchProps1.getSelectedItem().equals("Поиск по --")) {
            sqlString = "select * from employees";
            searchInput1.setText("");
        } else {
            Map<String, String> properties = new HashMap<>() {{
                put("Логин", "EmployeeLogin");
                put("Номер контракта", "ContractNumber");
            }};
            sqlString = "select * from employees WHERE " + properties.get(searchProps1.getSelectedItem()) + " = '" + searchInput1.getText() + "'";
        }
        ArrayList<Employee> employee = new ArrayList<>();
        SocketStream server = new SocketStream();
        server.sendInt(10);
        server.sendString(sqlString);
        try {
            count = server.getInt();
            rows = count;
            for (int i = 0; i < count; i++) {
                int employeeID = (int) Double.parseDouble(server.getString());
                employee.add(new EmployeeBuilder()
                        .buildId(employeeID)
                        .buildLogin(server.getString())
                        .buildPassword(server.getString())
                        .buildFullName(server.getString())
                        .buildContractNumber((int) Double.parseDouble(server.getString()))
                        .buildDateOfRecruitment(server.getString())
                        .buildPosition((int) Double.parseDouble(server.getString()))
                        .build());
                lastID = employeeID;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        model = new EmployeesTableModel(employee);
        employeeDataTable.setModel(model);
    }

    private void searchContracts(ActionEvent event) {
        if (searchInput4.getText().isEmpty()) {
            return;
        }
        String sqlString;
        if (searchProps4.getSelectedItem().equals("Поиск по --")) {
            sqlString = "SELECT * FROM contacts";
            searchInput4.setText("");
        } else {
            Map<String, String> properties = new HashMap<>() {{
                put("ID клиента", "ClientID");
                put("ID сотрудника", "EmployeeID");
            }};
            sqlString = "SELECT * FROM contacts WHERE " + properties.get(searchProps4.getSelectedItem()) + " = '" + searchInput4.getText() + "'";
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
        contractsTable.setModel(model);
        this.setVisible(false);
        contractsDialog.setVisible(true);
    }

    private void searchDepTypes(ActionEvent event) {
        if (searchInput5.getText().isEmpty()) {
            return;
        }
        String sqlString;
        if (searchProps5.getSelectedItem().equals("Поиск по --")) {
            sqlString = "select * from deposittypes";
            searchInput5.setText("");
        } else {
            Map<String, String> properties = new HashMap<>() {{
                put("Название", "TypeName");
                put("Минимальная сумма", "TypeMinMoney");
                put("Максимальная сумма", "TypeMaxMoney");
                put("Ставка процента", "TypeInterestRate");
            }};
            sqlString = "select * from deposittypes where " + properties.get(searchProps5.getSelectedItem()) + " = '" + searchInput5.getText() + "'";
        }
        ArrayList<DepositType> depositTypes = new ArrayList<>();
        SocketStream server = new SocketStream();
        server.sendInt(6);
        server.sendString(sqlString);
        try {
            int count = server.getInt();
            for (int i = 0; i < count; i++) {
                depositTypes.add(new DepositTypeBuilder()
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
        model = new DepositTypesTableModel(depositTypes);
        depositTypesDialog.setVisible(true);
        depositTypesTable.setModel(model);
        this.setVisible(false);
    }

    private void searchDeposits(ActionEvent event) {
        if (searchInput6.getText().isEmpty()) {
            searchInput6.setText("");
            return;
        }
        String sqlString;
        if (searchProps6.getSelectedItem().equals("Поиск по --")) {
            sqlString = "SELECT * FROM deposits";
        } else {
            Map<String, String> properties = new HashMap<>() {{
                put("Начальная сумма", "InitialMoney");
                put("Конечная сумма", "PlannedFinalMoney");
                put("Номер типа", "TypeID");
                put("Номер контракта", "ContractNumber");
                put("ID клиента", "ClientID");
            }};
            sqlString = "SELECT * FROM deposits WHERE " + properties.get(searchProps6.getSelectedItem()) + " = '" + searchInput6.getText() + "'";
        }
        ArrayList<Deposit> deposits = new ArrayList<>();
        SocketStream server = new SocketStream();
        server.sendInt(5);
        server.sendString(sqlString);
        try {
            int count = server.getInt();
            for (int i = 0; i < count; i++) {
                double depositNumber = Double.parseDouble(server.getString());
                double initialMoney = Double.parseDouble(server.getString());
                String dateOfSigning = server.getString();
                double finalMoney = Double.parseDouble(server.getString());
                double type = Double.parseDouble(server.getString());
                double contractNumber = Double.parseDouble(server.getString());
                double clientID = Double.parseDouble(server.getString());
                deposits.add(new Deposit((int) depositNumber, (int) initialMoney, dateOfSigning, (int) finalMoney, (int) type, (int) contractNumber, (int) clientID));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        model = new DepositsTableModel(deposits);
        depositsDataTable.setModel(model);
        this.setVisible(false);
        depositsDialog.setVisible(true);
    }

    private void sortByRecruitmentDate(ActionEvent event) {
        String sqlString;
        if (sortCheck3.isSelected()) {
            sqlString = "select * from employees ORDER BY DateOfRecruitment";
        } else {
            sqlString = "select * from employees";
        }
        ArrayList<Employee> employee = new ArrayList<>();
        SocketStream server = new SocketStream();
        server.sendInt(10);
        server.sendString(sqlString);
        try {
            count = server.getInt();
            rows = count;
            for (int i = 0; i < count; i++) {
                int employeeID = (int) Double.parseDouble(server.getString());
                employee.add(new EmployeeBuilder()
                        .buildId(employeeID)
                        .buildLogin(server.getString())
                        .buildPassword(server.getString())
                        .buildFullName(server.getString())
                        .buildContractNumber((int) Double.parseDouble(server.getString()))
                        .buildDateOfRecruitment(server.getString())
                        .buildPosition((int) Double.parseDouble(server.getString()))
                        .build());
                lastID = employeeID;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        model = new EmployeesTableModel(employee);
        employeeDataTable.setModel(model);
    }

    private void sortByEmployeeFullName(ActionEvent event) {
        String sqlString;
        if (sortCheck1.isSelected()) {
            sqlString = "select * from employees ORDER BY EmployeeFullName";
        } else {
            sqlString = "select * from employees";
        }
        ArrayList<Employee> employee = new ArrayList<>();
        SocketStream server = new SocketStream();
        server.sendInt(10);
        server.sendString(sqlString);
        try {
            count = server.getInt();
            rows = count;
            for (int i = 0; i < count; i++) {
                int employeeID = (int) Double.parseDouble(server.getString());
                String login = server.getString();
                String password = server.getString();
                String fullName = server.getString();
                int contractNumber = (int) Double.parseDouble(server.getString());
                String dateOfRecruitment = server.getString();
                int position = (int) Double.parseDouble(server.getString());
                employee.add(new Employee(employeeID, login, password, fullName, contractNumber, dateOfRecruitment, position));
                lastID = employeeID;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        model = new EmployeesTableModel(employee);
        employeeDataTable.setModel(model);
    }

    private void sortByClientFullName(ActionEvent event) {
        String sqlString;
        if (sortCheck2.isSelected()) {
            sqlString = "select * from clients ORDER BY ClientFullName";
        } else {
            sqlString = "select * from clients";
        }
        ArrayList<Client> client = new ArrayList<>();
        SocketStream server = new SocketStream();
        server.sendInt(2);
        server.sendString(sqlString);
        try {
            int count = server.getInt();
            for (int i = 0; i < count; i++) {
                int clientID = (int) Double.parseDouble(server.getString());
                client.add(new ClientBuilder()
                        .buildClientId(clientID)
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
        clientDataTable.setModel(model);
        this.setVisible(false);
    }

    private void sortByContractDate(ActionEvent event) {
        String sqlString;
        if (sortCheck4.isSelected()) {
            sqlString = "SELECT * FROM contacts ORDER BY DateOfSigning";
        } else {
            sqlString = "SELECT * FROM contacts";
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
        contractsTable.setModel(model);
        contractsDialog.setVisible(true);
    }

    private void sortByTypePeriod(ActionEvent event) {
        String sqlString;
        if (sortCheck5.isSelected()) {
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
        depositTypesTable.setModel(model);
        depositTypesDialog.setVisible(true);
        this.setVisible(false);
    }

    private void sortByDepositDate(ActionEvent event) {
        String sqlString;
        if (sortCheck6.isSelected()) {
            sqlString = "SELECT * FROM deposits ORDER BY DateOfOpening";
        } else {
            sqlString = "SELECT * FROM deposits";
        }
        ArrayList<Deposit> deposits = new ArrayList<>();
        SocketStream server = new SocketStream();
        server.sendInt(5);
        server.sendString(sqlString);
        try {
            int count = server.getInt();
            for (int i = 0; i < count; i++) {
                int depId = (int) Double.parseDouble(server.getString());
                int initMoney = (int) Double.parseDouble(server.getString());
                absInitialMoney += initMoney;
                String date = server.getString();
                int plannedMoney = (int) Double.parseDouble(server.getString());
                absPlannedMoney += plannedMoney;
                deposits.add(new DepositBuilder()
                        .buildNumber(depId)
                        .buildInitialMoney(initMoney)
                        .buildDateOfOpening(date)
                        .buildPlannedAmountOfMoney(plannedMoney)
                        .buildTypeOfDeposit((int) Double.parseDouble(server.getString()))
                        .buildContractNumber((int) Double.parseDouble(server.getString()))
                        .buildClientId((int) Double.parseDouble(server.getString()))
                        .build());
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        model = new DepositsTableModel(deposits);
        depositsDataTable.setModel(model);
        this.setVisible(false);
        depositsDialog.setVisible(true);
    }

    private JTextField addClientAddressField;
    private JButton addClientButton;
    private JDialog addClientDialog;
    private JTextField addClientFullNameField;
    private JTextField addClientIDField;
    private JTextField addClientLoginField;
    private JTextField addClientPassportField;
    private JPasswordField addClientPasswordField;
    private JTextField addClientPhoneNumberField;
    private JButton addContractButton;
    private JTextField addContractClientID;
    private JDialog addContractDialog;
    private JTextField addContractNumberField;
    private JTextField addContractsEmployeeIDField;
    private JLabel addDateOfSigningLabel;
    private JTextField addDayOfSigningField;
    private JButton addDepTypeButton;
    private JButton addDepositButton;
    private JTextField addDepositClientIDField;
    private JTextField addDepositContractNumberField;
    private JTextField addDepositDayField;
    private JDialog addDepositDialog;
    private JTextField addDepositIDField;
    private JTextField addDepositIDTypeField;
    private JTextField addDepositInitialMoneyField;
    private JTextField addDepositMonthField;
    private JTextField addDepositPlannedMoneyField;
    private JDialog addDepositTypeDialog;
    private JTextField addDepositYearField;
    private JButton addEmployeeButton;
    private JTextField addEmployeeContractNumber;
    private JTextField addEmployeeDayField;
    private JDialog addEmployeeDialog;
    private JTextField addEmployeeFullNameField;
    private JTextField addEmployeeIDField;
    private JTextField addEmployeeLoginField;
    private JTextField addEmployeeMonthField;
    private JPasswordField addEmployeePassword;
    private JComboBox<String> addEmployeePositionField;
    private JTextField addEmployeeYearField;
    private JTextField addMonthOfSigningField;
    private JTextField addTypeCapitalizationField;
    private JTextField addTypeIDField;
    private JTextField addTypeMaxMoneyField;
    private JTextField addTypeMinMoneyField;
    private JTextField addTypeNameField;
    private JTextField addTypePercentField;
    private JTextField addTypePeriodField;
    private JTextField addYearOfSigningField;
    private JTable clientDataTable;
    private JDialog clientsDialog;
    private JButton confirmAddingClientButton;
    private JButton confirmAddingDeposit;
    private JButton confirmAddingEmployeeButton;
    private JButton confirmAddingTypeButton;
    private JButton confirmAdditionContractButton;
    private JButton confirmEditingContractButton;
    private JButton confirmEditingEmployeeButton;
    private JButton confirmEditingTypeButton;
    private JButton confirmEditingClientButton;
    private JButton confirmToEditDepositsButton;
    private JDialog contractsDialog;
    private JTable contractsTable;
    private JButton deleteClientButton;
    private JButton deleteContractButton;
    private JButton deleteDepTypeButton;
    private JButton deleteDepositButton;
    private JButton deleteEmployeeButton;
    private JDialog depositTypesDialog;
    private JTable depositTypesTable;
    private JTable depositsDataTable;
    private JDialog depositsDialog;
    private JButton drawACircleChartButton;
    private JTextField editClientAddressField;
    private JButton editClientButton;
    private JDialog editClientDialog;
    private JTextField editClientFullName;
    private JTextField editClientIDField;
    private JTextField editClientLoginField;
    private JTextField editClientPassport;
    private JPasswordField editClientPasswordField;
    private JTextField editClientPhoneNumberField;
    private JButton editContractButton;
    private JTextField editContractClientIDField;
    private JDialog editContractDialog;
    private JTextField editContractEmployeeID;
    private JTextField editContractNumberField;
    private JTextField editDateOfOpeningField;
    private JTextField editDateOfSigning;
    private JButton editDepTypeButton;
    private JDialog editDepTypeDialog;
    private JButton editDepositButton;
    private JDialog editDepositDialog;
    private JTextField editDepositIDClientField;
    private JTextField editDepositIDContractField;
    private JTextField editDepositIDField;
    private JTextField editDepositIDTypeField;
    private JButton editEmployeeButton;
    private JTextField editEmployeeContractNumber;
    private JTextField editEmployeeDate;
    private JDialog editEmployeeDialog;
    private JTextField editEmployeeFullName;
    private JTextField editEmployeeIDField;
    private JTextField editEmployeeLoginField;
    private JPasswordField editEmployeePassword;
    private JComboBox<String> editEmployeePosition;
    private JTextField editFinalMoneyField;
    private JTextField editInitialMoneyField;
    private JTextField editTypeCapitalizationField;
    private JTextField editTypeIDField;
    private JTextField editTypeMaxMonField;
    private JTextField editTypeMinMonField;
    private JTextField editTypeNameField;
    private JTextField editTypePercentField;
    private JTextField editTypePeriodField;
    private JTable employeeDataTable;
    private JDialog employeesDialog;
    private JButton exitButton;
    private JButton putClientsIntoFileButton;
    private JButton putContractsIntoFileButton;
    private JButton putDepTypesIntoFileButton;
    private JButton putDepositsIntoFile;
    private JButton putEmployeesIntoFileButton;
    private JButton returnFromClientsButton;
    private JButton returnFromContractsButton;
    private JButton returnFromDepTypesButton;
    private JButton returnFromDepositsButton;
    private JButton returnFromEmployeesButton;
    private JButton to;
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
    private JLabel jLabel28;
    private JLabel jLabel29;
    private JLabel jLabel3;
    private JLabel jLabel30;
    private JLabel jLabel31;
    private JLabel jLabel32;
    private JLabel jLabel33;
    private JLabel jLabel34;
    private JLabel jLabel35;
    private JLabel jLabel36;
    private JLabel jLabel37;
    private JLabel jLabel38;
    private JLabel jLabel39;
    private JLabel jLabel4;
    private JLabel jLabel40;
    private JLabel jLabel41;
    private JLabel jLabel42;
    private JLabel jLabel43;
    private JLabel jLabel44;
    private JLabel jLabel45;
    private JLabel jLabel46;
    private JLabel jLabel47;
    private JLabel jLabel48;
    private JLabel jLabel49;
    private JLabel jLabel5;
    private JLabel jLabel50;
    private JLabel jLabel51;
    private JLabel jLabel52;
    private JLabel jLabel53;
    private JLabel jLabel54;
    private JLabel jLabel55;
    private JLabel jLabel56;
    private JLabel jLabel57;
    private JLabel jLabel58;
    private JLabel jLabel59;
    private JLabel jLabel6;
    private JLabel jLabel60;
    private JLabel jLabel61;
    private JLabel jLabel62;
    private JLabel jLabel63;
    private JLabel jLabel64;
    private JLabel jLabel65;
    private JLabel jLabel66;
    private JLabel jLabel67;
    private JLabel jLabel68;
    private JLabel jLabel69;
    private JLabel jLabel7;
    private JLabel jLabel70;
    private JLabel jLabel71;
    private JLabel jLabel72;
    private JLabel jLabel73;
    private JLabel jLabel74;
    private JLabel jLabel75;
    private JLabel jLabel76;
    private JLabel jLabel77;
    private JLabel jLabel78;
    private JLabel jLabel79;
    private JLabel jLabel8;
    private JLabel jLabel80;
    private JLabel jLabel81;
    private JLabel jLabel82;
    private JLabel jLabel83;
    private JLabel jLabel84;
    private JLabel jLabel85;
    private JLabel jLabel9;
    private JPanel jPanel1;
    private JPanel jPanel10;
    private JPanel jPanel11;
    private JPanel jPanel12;
    private JPanel jPanel13;
    private JPanel jPanel14;
    private JPanel jPanel15;
    private JPanel jPanel16;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JPanel jPanel5;
    private JPanel jPanel6;
    private JPanel jPanel7;
    private JPanel jPanel8;
    private JPanel jPanel9;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JScrollPane jScrollPane3;
    private JScrollPane jScrollPane4;
    private JScrollPane jScrollPane5;
    private JSeparator jSeparator1;
    private JSeparator jSeparator2;
    private JSeparator jSeparator3;
    private JSeparator jSeparator4;
    private JSeparator jSeparator5;
    private JButton lookThroughClientsButton;
    private JButton lookThroughContractsButton;
    private JButton lookThroughDepositTypesButton;
    private JButton lookThroughDepositsButton;
    private JButton lookThroughEmployeesButton;
    private JTextField searchInput1;
    private JComboBox<String> searchProps1;
    private JCheckBox sortCheck1;
    private JTextField searchInput2;
    private JComboBox<String> searchProps2;
    private JCheckBox sortCheck2;
    private JCheckBox sortCheck3;
    private JTextField searchInput4;
    private JComboBox<String> searchProps4;
    private JCheckBox sortCheck4;
    private JTextField searchInput5;
    private JComboBox<String> searchProps5;
    private JCheckBox sortCheck5;
    private JTextField searchInput6;
    private JComboBox<String> searchProps6;
    private JCheckBox sortCheck6;

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
            g.drawImage(image, 0, 0, null);
        }

    }

}
