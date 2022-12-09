package views;

import depositclient.builder.implementation.ClientBuilder;
import depositclient.builder.implementation.ContractBuilder;
import depositclient.builder.implementation.DepositBuilder;
import depositclient.entity.Client;
import depositclient.entity.Contract;
import depositclient.entity.Deposit;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.TableModel;

import depositclient.model.SocketStream;
import depositclient.model.Validator;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import tableModels.ClientsTableModel;
import tableModels.ContractsTableModel;
import tableModels.DepositsTableModel;

public class MainUserFrame extends JFrame {

    private String userLogin;
    private TableModel model;
    private final Validator valid;
    private boolean validator;
    private JFrame graph;

    public MainUserFrame(String login) {
        userLogin = login;
        validator = true;
        valid = new Validator();
        initComponents();
    }

    private void initComponents() {
        ChangePersonalDataDialog = new JDialog();
        jPanel3 = new ImagePanel(1);
        jLabel2 = new JLabel();
        PersonalDataTable = new JScrollPane();
        ClientDataTable = new JTable();
        ReturnFromChangingDataButton = new JButton();
        editPersonalDataButton = new JButton();
        ConfirmChangingDataDialog = new JDialog();
        jPanel4 = new ImagePanel(1);
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        changeLoginField = new JTextField();
        changePasswordLabel = new JLabel();
        changePasswordField = new JPasswordField();
        changePhoneNumberLabel = new JLabel();
        changePhoneNumberField = new JTextField();
        jScrollPane1 = new JScrollPane();
        jTextArea1 = new JTextArea();
        confirmChangingPersonalDataButton = new JButton();
        LookThroughContracts = new JDialog();
        jPanel5 = new ImagePanel(1);
        jLabel5 = new JLabel();
        ContractsDataTable = new JScrollPane();
        ContactsTable = new JTable();
        ReturnFromLookingThroughContractsButton = new JButton();
        LookThroughDepositsDialog = new JDialog();
        jPanel6 = new ImagePanel(1);
        jLabel6 = new JLabel();
        jScrollPane2 = new JScrollPane();
        DepositTable = new JTable();
        ReturnFromLookingThroughDepositsButton = new JButton();
        predictDepositDialog = new JDialog();
        jPanel7 = new ImagePanel(1);
        jLabel7 = new JLabel();
        jSeparator1 = new JSeparator();
        jLabel8 = new JLabel();
        jLabel9 = new JLabel();
        jLabel10 = new JLabel();
        InitialAmountField = new JTextField();
        NumberOfYearsField = new JTextField();
        CapitalizationField = new JTextField();
        makePredictionButton = new JButton();
        jSeparator2 = new JSeparator();
        jLabel11 = new JLabel();
        FinalAmountField = new JTextField();
        jLabel12 = new JLabel();
        PercentField = new JTextField();
        ReturnFromPredictionDepositButton = new JButton();
        jPanel1 = new ImagePanel(3);
        jPanel2 = new JPanel();
        jLabel1 = new JLabel();
        changePersonalDataButton = new JButton();
        lookThroughMyContractsButton = new JButton();
        lookThroughMyDeposits = new JButton();
        predictDepositButton = new JButton();
        exitButton = new JButton();

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


        searchInput1 = new JTextField();
        sortCheck1 = new JCheckBox("Cортировка по дате");
        searchProps1 = new JComboBox<>();
        searchInput2 = new JTextField();
        sortCheck2 = new JCheckBox("Cортировка по дате открытия");
        searchProps2 = new JComboBox<>();
        searchProps1.addItem("Поиск по --");
        searchProps1.addItem("ID клиента");
        searchProps1.addItem("ID сотрудника");

        searchProps2.addItem("Поиск по --");
        searchProps2.addItem("Начальная сумма");
        searchProps2.addItem("Конечная сумма");
        searchProps2.addItem("Номер типа");
        searchProps2.addItem("Номер контракта");
        searchProps2.addItem("ID клиента");

        searchInput1.setFont(new Font("Raleway", Font.PLAIN, 17));
        searchInput1.setPreferredSize(new Dimension(150, 32));
        searchInput1.setMinimumSize(new Dimension(150, 32));
        searchInput1.setMaximumSize(new Dimension(150, 32));

        searchInput2.setFont(new Font("Raleway", Font.PLAIN, 17));
        searchInput2.setPreferredSize(new Dimension(150, 32));
        searchInput2.setMinimumSize(new Dimension(150, 32));
        searchInput2.setMaximumSize(new Dimension(150, 32));

        sortCheck1.setPreferredSize(new Dimension(30, 30));
        sortCheck1.setSelected(false);
        sortCheck2.setPreferredSize(new Dimension(30, 30));
        sortCheck2.setSelected(false);

        searchProps1.setPreferredSize(new Dimension(100, 32));
        searchProps1.setMaximumSize(new Dimension(100, 32));
        searchProps1.setMinimumSize(new Dimension(100, 32));
        searchProps2.setPreferredSize(new Dimension(100, 32));
        searchProps2.setMaximumSize(new Dimension(100, 32));
        searchProps2.setMinimumSize(new Dimension(100, 32));

        ChangePersonalDataDialog.setMinimumSize(new Dimension(720, 256));
        ChangePersonalDataDialog.setResizable(false);

        jPanel3.setMinimumSize(new Dimension(720, 226));

        jLabel2.setFont(new Font("Raleway", Font.PLAIN, 24));
        jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel2.setText("Изменение персональных данных");

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
        ClientDataTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                clientDataTableMouseClicked(evt);
            }
        });
        PersonalDataTable.setViewportView(ClientDataTable);

        ReturnFromChangingDataButton.setFont(new Font("Raleway", Font.PLAIN, 16));
        ReturnFromChangingDataButton.setText("Назад");
        ReturnFromChangingDataButton.setBorderPainted(false);
        ReturnFromChangingDataButton.setPreferredSize(new Dimension(100, 50));
        ReturnFromChangingDataButton.setBackground(new Color(230, 244, 255));
        ReturnFromChangingDataButton.addActionListener(this::returnFromChangingData);

        editPersonalDataButton.setFont(new Font("Raleway", Font.PLAIN, 16));
        editPersonalDataButton.setText("Редактировать");
        editPersonalDataButton.setEnabled(false);
        editPersonalDataButton.setBorderPainted(false);
        editPersonalDataButton.setPreferredSize(new Dimension(100, 50));
        editPersonalDataButton.setBackground(new Color(177, 220, 252));
        editPersonalDataButton.addActionListener(this::editPersonalData);

        GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(ReturnFromChangingDataButton)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(editPersonalDataButton))
                                        .addComponent(PersonalDataTable, GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE))
                                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(PersonalDataTable, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(editPersonalDataButton)
                                        .addComponent(ReturnFromChangingDataButton))
                                .addContainerGap(21, Short.MAX_VALUE))
        );

        GroupLayout changePersonalDataDialogLayout = new GroupLayout(ChangePersonalDataDialog.getContentPane());
        ChangePersonalDataDialog.getContentPane().setLayout(changePersonalDataDialogLayout);
        changePersonalDataDialogLayout.setHorizontalGroup(
                changePersonalDataDialogLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );
        changePersonalDataDialogLayout.setVerticalGroup(
                changePersonalDataDialogLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(changePersonalDataDialogLayout.createSequentialGroup()
                                .addComponent(jPanel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );

        ConfirmChangingDataDialog.setMinimumSize(new Dimension(606, 328));

        jPanel4.setMinimumSize(new Dimension(606, 328));

        jLabel3.setFont(new Font("Raleway", Font.PLAIN, 24));
        jLabel3.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel3.setText("Изменение персональных данных");

        jLabel4.setFont(new Font("Raleway", Font.PLAIN, 16));
        jLabel4.setText("Логин");

        changeLoginField.setFont(new Font("Raleway", Font.PLAIN, 16));

        changePasswordLabel.setFont(new Font("Raleway", Font.PLAIN, 16));
        changePasswordLabel.setText("Пароль");

        changePhoneNumberLabel.setFont(new Font("Raleway", Font.PLAIN, 16));
        changePhoneNumberLabel.setText("Номер телефона");

        changePhoneNumberField.setFont(new Font("Raleway", Font.PLAIN, 16));

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new Font("Raleway", Font.PLAIN, 16));
        jTextArea1.setRows(5);
        jTextArea1.setText("Для редактирования прочей информации необходимо обратиться \nв отделение банка с соответствующими документами.");
        jTextArea1.setEnabled(false);
        jScrollPane1.setViewportView(jTextArea1);

        confirmChangingPersonalDataButton.setFont(new Font("Raleway", Font.PLAIN, 16));
        confirmChangingPersonalDataButton.setText("Изменить информацию");
        confirmChangingPersonalDataButton.setBorderPainted(false);
        confirmChangingPersonalDataButton.setPreferredSize(new Dimension(100, 50));
        confirmChangingPersonalDataButton.setBackground(new Color(177, 220, 252));
        confirmChangingPersonalDataButton.addActionListener(this::confirmChangingPersonalData);

        GroupLayout jPanel4Layout = new GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3, GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(jScrollPane1, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE)
                                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                                        .addComponent(changePhoneNumberLabel, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(changePasswordLabel, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(jLabel4, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                .addGap(36, 36, 36)
                                                                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(changeLoginField)
                                                                        .addComponent(changePasswordField)
                                                                        .addComponent(changePhoneNumberField, GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE))))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(192, 192, 192)
                                .addComponent(confirmChangingPersonalDataButton)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(changeLoginField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(changePasswordLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(changePasswordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(changePhoneNumberLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(changePhoneNumberField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(confirmChangingPersonalDataButton)
                                .addContainerGap(41, Short.MAX_VALUE))
        );

        GroupLayout confirmChangingDataDialogLayout = new GroupLayout(ConfirmChangingDataDialog.getContentPane());
        ConfirmChangingDataDialog.getContentPane().setLayout(confirmChangingDataDialogLayout);
        confirmChangingDataDialogLayout.setHorizontalGroup(
                confirmChangingDataDialogLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );
        confirmChangingDataDialogLayout.setVerticalGroup(
                confirmChangingDataDialogLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        LookThroughContracts.setMinimumSize(new Dimension(619, 654));
        LookThroughContracts.setResizable(false);

        jPanel5.setMinimumSize(new Dimension(619, 558));
        jPanel5.setPreferredSize(new Dimension(619, 558));

        jLabel5.setFont(new Font("Raleway", Font.PLAIN, 24));
        jLabel5.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel5.setText("Информация о договорах");

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
        ContractsDataTable.setViewportView(ContactsTable);

        ReturnFromLookingThroughContractsButton.setFont(new Font("Raleway", Font.PLAIN, 16));
        ReturnFromLookingThroughContractsButton.setText("Назад");
        ReturnFromLookingThroughContractsButton.setBorderPainted(false);
        ReturnFromLookingThroughContractsButton.setPreferredSize(new Dimension(100, 50));
        ReturnFromLookingThroughContractsButton.setBackground(new Color(177, 220, 252));
        ReturnFromLookingThroughContractsButton.addActionListener(this::returnFromLookingThroughContracts);

        searchProps1.addActionListener(this::searchContracts);
        sortCheck1.addActionListener(this::sortByContractDate);

        GroupLayout jPanel5Layout = new GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
                jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jLabel5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addGap(70, 70, 70)
                                                .addContainerGap()
                                                .addComponent(searchInput1)
                                                .addComponent(searchProps1)
                                                .addGap(80, 80, 80)
                                                .addComponent(sortCheck1))
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                                                .addGap(80, 80, 80)
                                                                .addComponent(ContractsDataTable, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(ReturnFromLookingThroughContractsButton)))
                                                .addGap(0, 64, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
                jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel5Layout.createParallelGroup()
                                        .addComponent(searchInput1)
                                        .addComponent(searchProps1)
                                        .addComponent(sortCheck1))
                                .addGap(18, 18, 18)
                                .addComponent(ContractsDataTable, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ReturnFromLookingThroughContractsButton)
                                .addContainerGap(45, Short.MAX_VALUE))
        );

        GroupLayout lookThroughContractsLayout = new GroupLayout(LookThroughContracts.getContentPane());
        LookThroughContracts.getContentPane().setLayout(lookThroughContractsLayout);
        lookThroughContractsLayout.setHorizontalGroup(
                lookThroughContractsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        lookThroughContractsLayout.setVerticalGroup(
                lookThroughContractsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel5, GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE)
        );

        LookThroughDepositsDialog.setMinimumSize(new Dimension(710, 629));
        LookThroughDepositsDialog.setResizable(false);

        jPanel6.setMinimumSize(new Dimension(690, 599));

        jLabel6.setFont(new Font("Raleway", Font.PLAIN, 24));
        jLabel6.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel6.setText("Информация о вкладах");

        DepositTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(DepositTable);

        ReturnFromLookingThroughDepositsButton.setFont(new Font("Raleway", Font.PLAIN, 16));
        ReturnFromLookingThroughDepositsButton.setText("Назад");
        ReturnFromLookingThroughDepositsButton.setBorderPainted(false);
        ReturnFromLookingThroughDepositsButton.setPreferredSize(new Dimension(100, 50));
        ReturnFromLookingThroughDepositsButton.setBackground(new Color(177, 220, 252));
        ReturnFromLookingThroughDepositsButton.addActionListener(this::returnFromLookingThroughDeposits);

        searchProps2.addActionListener(this::searchDeposits);
        sortCheck2.addActionListener(this::sortByDepositDate);

        GroupLayout jPanel6Layout = new GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
                jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jLabel6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                                .addGap(70, 70, 70)
                                                .addContainerGap()
                                                .addComponent(searchInput2)
                                                .addComponent(searchProps2)
                                                .addGap(110, 110, 110)
                                                .addComponent(sortCheck2))
                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                                .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(ReturnFromLookingThroughDepositsButton))
                                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                                                .addGap(71, 71, 71)
                                                                .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 568, GroupLayout.PREFERRED_SIZE)))
                                                .addGap(0, 36, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
                jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel6Layout.createParallelGroup()
                                        .addComponent(searchInput2)
                                        .addComponent(searchProps2)
                                        .addComponent(sortCheck2))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ReturnFromLookingThroughDepositsButton)
                                .addContainerGap(34, Short.MAX_VALUE))
        );

        GroupLayout lookThroughDepositsDialogLayout = new GroupLayout(LookThroughDepositsDialog.getContentPane());
        LookThroughDepositsDialog.getContentPane().setLayout(lookThroughDepositsDialogLayout);
        lookThroughDepositsDialogLayout.setHorizontalGroup(
                lookThroughDepositsDialogLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        lookThroughDepositsDialogLayout.setVerticalGroup(
                lookThroughDepositsDialogLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        predictDepositDialog.setMinimumSize(new Dimension(595, 481));
        predictDepositDialog.setResizable(false);

        jPanel7.setMinimumSize(new Dimension(595, 481));

        jLabel7.setFont(new Font("Raleway", Font.PLAIN, 24));
        jLabel7.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel7.setText("\"Спрогнозировать\" вклад");

        jLabel8.setFont(new Font("Raleway", Font.PLAIN, 18));
        jLabel8.setText("Начальная сумма (в руб.)");

        jLabel9.setFont(new Font("Raleway", Font.PLAIN, 18));
        jLabel9.setText("Срок (в годах)");

        jLabel10.setFont(new Font("Raleway", Font.PLAIN, 18));
        jLabel10.setText("Капитализация (раз в год)");

        InitialAmountField.setFont(new Font("Raleway", Font.PLAIN, 16));
        InitialAmountField.setText("10000");

        NumberOfYearsField.setFont(new Font("Raleway", Font.PLAIN, 16));
        NumberOfYearsField.setText("10");

        CapitalizationField.setFont(new Font("Raleway", Font.PLAIN, 16));
        CapitalizationField.setText("5");

        makePredictionButton.setFont(new Font("Raleway", Font.PLAIN, 16));
        makePredictionButton.setText("Спрогнозировать");
        makePredictionButton.setBorderPainted(false);
        makePredictionButton.setPreferredSize(new Dimension(100, 50));
        makePredictionButton.setBackground(new Color(177, 220, 252));
        makePredictionButton.addActionListener(this::makePrediction);

        jLabel11.setFont(new Font("Raleway", Font.PLAIN, 18));
        jLabel11.setText("Конечная сумма (в руб.)");

        FinalAmountField.setFont(new Font("Raleway", Font.PLAIN, 16));
        FinalAmountField.setText("16446,318");
        FinalAmountField.setEnabled(false);

        jLabel12.setFont(new Font("Raleway", Font.PLAIN, 18));
        jLabel12.setText("Процентная ставка (в %)");

        PercentField.setFont(new Font("Raleway", Font.PLAIN, 16));
        PercentField.setText("5");

        ReturnFromPredictionDepositButton.setFont(new Font("Raleway", Font.PLAIN, 16));
        ReturnFromPredictionDepositButton.setText("Назад");
        ReturnFromPredictionDepositButton.setBorderPainted(false);
        ReturnFromPredictionDepositButton.setPreferredSize(new Dimension(100, 50));
        ReturnFromPredictionDepositButton.setBackground(new Color(177, 220, 252));
        ReturnFromPredictionDepositButton.addActionListener(this::returnFromPredictionDeposit);

        GroupLayout jPanel7Layout = new GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
                jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(makePredictionButton)
                                .addGap(213, 213, 213))
                        .addGroup(jPanel7Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jSeparator1)
                                        .addComponent(jLabel7, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jSeparator2, GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel7Layout.createSequentialGroup()
                                                .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel7Layout.createSequentialGroup()
                                                                .addComponent(jLabel11, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(42, 42, 42)
                                                                .addComponent(FinalAmountField, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(jPanel7Layout.createSequentialGroup()
                                                                .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                                        .addComponent(jLabel12, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(jLabel10, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(jLabel9, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(jLabel8, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                .addGap(46, 46, 46)
                                                                .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(InitialAmountField, GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                                                                        .addComponent(NumberOfYearsField)
                                                                        .addComponent(CapitalizationField)
                                                                        .addComponent(PercentField)))
                                                        .addComponent(ReturnFromPredictionDepositButton))
                                                .addGap(0, 99, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
                jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel7, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel8)
                                        .addComponent(InitialAmountField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel9)
                                        .addComponent(NumberOfYearsField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel10)
                                        .addComponent(CapitalizationField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel12)
                                        .addComponent(PercentField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addComponent(makePredictionButton)
                                .addGap(18, 18, 18)
                                .addComponent(jSeparator2, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(FinalAmountField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel11))
                                .addGap(32, 32, 32)
                                .addComponent(ReturnFromPredictionDepositButton)
                                .addContainerGap(53, Short.MAX_VALUE))
        );

        GroupLayout predictDepositDialogLayout = new GroupLayout(predictDepositDialog.getContentPane());
        predictDepositDialog.getContentPane().setLayout(predictDepositDialogLayout);
        predictDepositDialogLayout.setHorizontalGroup(
                predictDepositDialogLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );
        predictDepositDialogLayout.setVerticalGroup(
                predictDepositDialogLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel7, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        jLabel1.setText("Меню клиента");

        changePersonalDataButton.setFont(new Font("Raleway", Font.PLAIN, 18));
        changePersonalDataButton.setText("Изменить личные данные");
        changePersonalDataButton.setBackground(new Color(204, 204, 255));
        changePersonalDataButton.setPreferredSize(new Dimension(50, 50));
        changePersonalDataButton.setBorderPainted(false);
        changePersonalDataButton.addActionListener(this::changePersonalData);

        lookThroughMyContractsButton.setFont(new Font("Raleway", Font.PLAIN, 18));
        lookThroughMyContractsButton.setText("Просмотреть договоры");
        lookThroughMyContractsButton.setBorderPainted(false);
        lookThroughMyContractsButton.setBackground(new Color(204, 204, 255));
        lookThroughMyContractsButton.setPreferredSize(new Dimension(50, 50));
        lookThroughMyContractsButton.addActionListener(this::lookThroughMyContracts);

        lookThroughMyDeposits.setFont(new Font("Raleway", Font.PLAIN, 18));
        lookThroughMyDeposits.setText("Просмотреть вклады");
        lookThroughMyDeposits.setBorderPainted(false);
        lookThroughMyDeposits.setBackground(new Color(177, 220, 252));
        lookThroughMyDeposits.setPreferredSize(new Dimension(100, 50));
        lookThroughMyDeposits.addActionListener(this::lookThroughMyDeposits);

        predictDepositButton.setFont(new Font("Raleway", Font.PLAIN, 18));
        predictDepositButton.setText("\"Спрогнозировать\" вклад");
        predictDepositButton.setBorderPainted(false);
        predictDepositButton.setBackground(new Color(123, 161, 255));
        predictDepositButton.setPreferredSize(new Dimension(50, 50));
        predictDepositButton.addActionListener(this::predictDeposit);

        exitButton.setFont(new Font("Raleway", Font.PLAIN, 18));
        exitButton.setText("Выход");
        exitButton.setBorderPainted(false);
        exitButton.setPreferredSize(new Dimension(100, 50));
        exitButton.setBackground(new Color(177, 220, 252));
        exitButton.addActionListener(this::exitButtonActionPerformed);

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(predictDepositButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, 300)
                                        .addComponent(lookThroughMyDeposits, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, 300)
                                        .addComponent(lookThroughMyContractsButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, 300)
                                        .addComponent(changePersonalDataButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, 300)
                                        .addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
                                        .addComponent(exitButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, 300))
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(changePersonalDataButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lookThroughMyContractsButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lookThroughMyDeposits, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(predictDepositButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(exitButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(78, Short.MAX_VALUE))
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

    private void changePersonalData(ActionEvent evt) {
        String sqlString = "select * from clients where ClientLogin = '" + userLogin + "'";
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
        ChangePersonalDataDialog.setVisible(true);
        ClientDataTable.setModel(model);
        this.setVisible(false);
    }

    private void returnFromChangingData(ActionEvent evt) {
        ChangePersonalDataDialog.setVisible(false);
        this.setVisible(true);
    }

    private void editPersonalData(ActionEvent evt) {
        ChangePersonalDataDialog.setVisible(false);
        ConfirmChangingDataDialog.setVisible(true);
        changeLoginField.setText((String) ClientDataTable.getValueAt(ClientDataTable.getSelectedRow(), 1));
        changePasswordField.setText((String) ClientDataTable.getValueAt(ClientDataTable.getSelectedRow(), 2));
        changePhoneNumberField.setText((String) ClientDataTable.getValueAt(ClientDataTable.getSelectedRow(), 5));
    }

    private void clientDataTableMouseClicked(MouseEvent evt) {
        editPersonalDataButton.setEnabled(ClientDataTable.getSelectedRowCount() > 0);
    }

    private void confirmChangingPersonalData(ActionEvent evt) {
        SocketStream server = new SocketStream();
        validator = true;
        String login;
        String password;
        String phone;
        login = changeLoginField.getText();
        validator = valid.validateString(login);
        if (validator) {
            server.sendInt(16);
            server.sendString(login);
            server.sendString(userLogin);
            int rez = 1;
            try {
                rez = (int) Double.parseDouble(server.getString());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            if (rez == 0) {
                validator = false;
            }
        }
        password = new String(changePasswordField.getPassword());
        if (validator) validator = valid.validateString(password);
        phone = changePhoneNumberField.getText();
        if (validator) validator = valid.validateString(phone);
        if (validator) {
            server = new SocketStream();
            server.sendInt(3);
            server.sendString(userLogin);
            server.sendString(login);
            server.sendString(password);
            server.sendString(phone);
            try {
                String result = server.getString();
                JOptionPane.showMessageDialog(null, "Данные обновлены!",
                        "Нажмите ОК для продолжения работы", JOptionPane.INFORMATION_MESSAGE);

                ConfirmChangingDataDialog.setVisible(false);
                this.setVisible(true);
                userLogin = login;
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Данные некорректны!",
                    "Нажмите ОК для продолжения работы", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void lookThroughMyContracts(ActionEvent evt) {
        String sqlString = "SELECT * FROM contacts INNER JOIN clients ON contacts.ClientID = clients.ClientID where clients.ClientLogin = '" + userLogin + "'";
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

    private void returnFromLookingThroughContracts(ActionEvent evt) {
        LookThroughContracts.setVisible(false);
        this.setVisible(true);
    }

    private void lookThroughMyDeposits(ActionEvent evt) {
        String sqlString = "SELECT * FROM deposits INNER JOIN clients ON deposits.ClientID = clients.ClientID where clients.ClientLogin = '" + userLogin + "'";
        ArrayList<Deposit> deposits = new ArrayList<>();
        SocketStream server = new SocketStream();
        server.sendInt(5);
        server.sendString(sqlString);
        try {
            int count = server.getInt();
            for (int i = 0; i < count; i++) {
                deposits.add(new DepositBuilder()
                        .buildNumber((int) Double.parseDouble(server.getString()))
                        .buildInitialMoney((int) Double.parseDouble(server.getString()))
                        .buildDateOfOpening(server.getString())
                        .buildPlannedAmountOfMoney((int) Double.parseDouble(server.getString()))
                        .buildTypeOfDeposit((int) Double.parseDouble(server.getString()))
                        .buildContractNumber((int) Double.parseDouble(server.getString()))
                        .buildClientId((int) Double.parseDouble(server.getString()))
                        .build());
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        model = new DepositsTableModel(deposits);
        DepositTable.setModel(model);
        this.setVisible(false);
        LookThroughDepositsDialog.setVisible(true);
    }

    private void returnFromLookingThroughDeposits(ActionEvent evt) {
        LookThroughDepositsDialog.setVisible(false);
        this.setVisible(true);
    }

    private void predictDeposit(ActionEvent evt) {
        predictDepositDialog.setVisible(true);
        this.setVisible(false);
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
            finalAmountOfMoney = finalAmountOfMoney / 100;

            FinalAmountField.setText("" + finalAmountOfMoney);

            XYSeries series = new XYSeries("Рост суммы вклада");
            for (double i = 0; i < numberOfYears; i += 0.01) {
                double finish = 0;
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
                    xyDataset,
                    PlotOrientation.VERTICAL,
                    true, true, true);
            graph = new JFrame("Увеличение суммы вклада со временем");
            graph.getContentPane().add(new ChartPanel(chart));
            graph.setSize(400, 300);
            graph.setVisible(true);
        }

    }

    private void returnFromPredictionDeposit(ActionEvent evt) {
        if (graph == null) {
            graph = new JFrame("Увеличение суммы вклада со временем");
            graph.setSize(400, 300);
        }
        predictDepositDialog.setVisible(false);
        graph.setVisible(false);
        this.setVisible(true);
    }

    private void exitButtonActionPerformed(ActionEvent evt) {
        this.setVisible(false);
        Authorization auth = new Authorization();
        auth.setVisible(true);
        auth.setLocationRelativeTo(null);
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
                    + userLogin + "' AND deposits." + properties.get(searchProps1.getSelectedItem()) + " = '" + searchInput1.getText() + "'";
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

    private void searchDeposits(ActionEvent event) {
        if (searchInput2.getText().isEmpty()) {
            searchInput2.setText("");
            return;
        }
        String sqlString;
        if (searchProps2.getSelectedItem().equals("Поиск по --")) {
            sqlString = "SELECT * FROM deposits INNER JOIN clients ON deposits.ClientID = clients.ClientID where clients.ClientLogin = '"
                    + userLogin + "'";
        } else {
            Map<String, String> properties = new HashMap<>() {{
                put("Начальная сумма", "InitialMoney");
                put("Конечная сумма", "PlannedFinalMoney");
                put("Номер типа", "TypeID");
                put("Номер контракта", "ContractNumber");
                put("ID клиента", "ClientID");
            }};
            sqlString = "SELECT * FROM deposits INNER JOIN clients ON deposits.ClientID = clients.ClientID where clients.ClientLogin = '"
                    + userLogin + "' AND deposits." + properties.get(searchProps2.getSelectedItem()) + " = '" + searchInput2.getText() + "'";
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
                int plannedMoney = (int) Double.parseDouble(server.getString());
                deposits.add(new DepositBuilder()
                        .buildNumber(depId)
                        .buildInitialMoney(initMoney)
                        .buildDateOfOpening(server.getString())
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
        DepositTable.setModel(model);
        this.setVisible(false);
        LookThroughDepositsDialog.setVisible(true);
    }

    private void sortByContractDate(ActionEvent event) {
        String sqlString;
        if (sortCheck2.isSelected()) {
            sqlString = "SELECT * FROM contacts INNER JOIN employees ON contacts.EmployeeID = employees.EmployeeID where employees.EmployeeLogin = '"
                    + userLogin + "' ORDER BY DateOfSigning";
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

    private void sortByDepositDate(ActionEvent event) {
        String sqlString;
        if (sortCheck2.isSelected()) {
            sqlString = "SELECT * FROM deposits INNER JOIN clients ON deposits.ClientID = clients.ClientID where clients.ClientLogin = '"
                    + userLogin + "' ORDER BY DateOfOpening";
        } else {
            sqlString = "SELECT * FROM deposits INNER JOIN clients ON deposits.ClientID = clients.ClientID where clients.ClientLogin = '"
                    + userLogin + "'";
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
        DepositTable.setModel(model);
        this.setVisible(false);
        LookThroughDepositsDialog.setVisible(true);
    }

    private JTextField CapitalizationField;
    private JDialog ChangePersonalDataDialog;
    private JTable ClientDataTable;
    private JDialog ConfirmChangingDataDialog;
    private JTable ContactsTable;
    private JScrollPane ContractsDataTable;
    private JTable DepositTable;
    private JButton exitButton;
    private JTextField FinalAmountField;
    private JTextField InitialAmountField;
    private JDialog LookThroughContracts;
    private JDialog LookThroughDepositsDialog;
    private JTextField NumberOfYearsField;
    private JTextField PercentField;
    private JScrollPane PersonalDataTable;
    private JButton ReturnFromChangingDataButton;
    private JButton ReturnFromLookingThroughDepositsButton;
    private JButton ReturnFromLookingThroughContractsButton;
    private JButton ReturnFromPredictionDepositButton;
    private JButton changePersonalDataButton;
    private JTextField changeLoginField;
    private JPasswordField changePasswordField;
    private JLabel changePasswordLabel;
    private JTextField changePhoneNumberField;
    private JLabel changePhoneNumberLabel;
    private JButton confirmChangingPersonalDataButton;
    private JButton editPersonalDataButton;
    private JLabel jLabel1;
    private JLabel jLabel10;
    private JLabel jLabel11;
    private JLabel jLabel12;
    private JLabel jLabel2;
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
    private JPanel jPanel7;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JSeparator jSeparator1;
    private JSeparator jSeparator2;
    private JTextArea jTextArea1;
    private JButton lookThroughMyContractsButton;
    private JButton lookThroughMyDeposits;
    private JButton makePredictionButton;
    private JButton predictDepositButton;
    private JDialog predictDepositDialog;
    private JTextField searchInput1;
    private JComboBox<String> searchProps1;
    private JCheckBox sortCheck1;
    private JTextField searchInput2;
    private JComboBox<String> searchProps2;
    private JCheckBox sortCheck2;

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
