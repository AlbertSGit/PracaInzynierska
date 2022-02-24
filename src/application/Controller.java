package application;

import com.database.DatabaseHelperImpl;
import com.encryption.Encrypt;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.model.*;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.print.PrinterJob;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

public class Controller extends DatabaseHelperImpl implements Initializable {


    @FXML
    private HBox payHbox1;

    @FXML
    private HBox payHbox2;

    @FXML
    private TextField inpUsername;

    @FXML
    private PasswordField inpPassword;

    @FXML
    private ComboBox<Role> drpRole;

    @FXML
    TableView<Branch> branchTable;

    @FXML
    private TextField inpBranch;

    @FXML
    private TextField inpLocation;

    @FXML
    private TextField inpPhone;

    @FXML
    private TextField inpState;

    @FXML
    private TextField inpBranchId;

    @FXML
    private Button btnBranchExport;

    @FXML
    private Button btnManagerExport;

    @FXML
    private Button btnMCusPoliExport;

    @FXML
    private TableView<Policy> policyTable;

    @FXML
    private TextField inpPID;

    @FXML
    private TextField inpPName;

    @FXML
    private TextField inpPTerm;

    @FXML
    private TextField inpPAmount;

    @FXML
    private TextField inpPFAmount;

    @FXML
    private TextField inpPI;

    @FXML
    private TextField inpBp;

    @FXML
    private TextField inpBRT;

    @FXML
    private TextField inpPolicyDesc;

    @FXML
    private Button btnResetP;

    @FXML
    private Button btnPExport;

    @FXML
    private HBox btnBranch;

    @FXML
    private HBox btnPolicy;

    @FXML
    private HBox btnManager;

    @FXML
    private HBox btnAgentMG;

    @FXML
    private HBox btnAgentPolicy;

    @FXML
    private HBox btnAgentCustomer;

    @FXML
    private HBox btnCusPoliStat;

    @FXML
    private HBox btnCusPolicy;

    @FXML
    private HBox btnCusAgent;

    @FXML
    private TabPane adminTabPane;

    @FXML
    private TabPane managerTabPane;

    @FXML
    private AnchorPane mAgentNavPane;

    @FXML
    private TabPane agentTabPane;

    @FXML
    private AnchorPane adminNavPanel;

    @FXML
    private AnchorPane agentNavPane;

    @FXML
    private AnchorPane custNavPane;

    @FXML
    private TabPane custTabPane;

    @FXML
    private AnchorPane loginForm;

    @FXML
    private TextField inpMId;

    @FXML
    private TextField inpMName;

    @FXML
    private TextField inpMAge;

    @FXML
    private TextField inpMFather;

    @FXML
    private TextField inpMPhone;

    @FXML
    private TextField inpMQuali;

    @FXML
    private TextField inpMAddr;

    @FXML
    private ComboBox<String> drpBranch;

    @FXML
    private PasswordField inpMPass;

    @FXML
    private RadioButton rdMale, rdFemale;

    @FXML
    private RadioButton rdMAgentMale, rdMAgentFemale;

    @FXML
    private TableView<User> managerTable;

    @FXML
    private TableView<User> agentManagerTable;

    @FXML
    private TableView<Policy> agentCustomerPolicyTable;

    @FXML
    private TableView<Policy> customerPolicyTable;

    @FXML
    private TableView<User> agentCustomerDetailsTable;

    @FXML
    private TableView<User> customerAgentTable;

    @FXML
    private TableView<Policy> custPoliStatTable;

    @FXML
    private Button btnAgentMGExport;

    @FXML
    private Button btnPoliExport;

    @FXML
    private Button btnCustExport;

    @FXML
    private Button btnCustPoliExport;

    @FXML
    private Button btnCusAgentExport;

    @FXML
    private TextField inpMAgentID;

    @FXML
    private TextField inpMContact;

    @FXML
    private TextField inpMAgentName;

    @FXML
    private TextField inpMFName;

    @FXML
    private TextField inpM_Age;

    @FXML
    private TextField inpMQua;

    @FXML
    private TextField inpMOcc;

    @FXML
    private TextField inpM_Addr;

    @FXML
    private TextField inpMDeposit;

    @FXML
    private ComboBox<User> drpMManager;

    @FXML
    private TextField inpMPassword;

    @FXML
    private TextField inpMCusID, inpMCusPhno, inpMCusName, inpMCusFname, inpMCusAge, inpMCusQua, inpMCusOcc, inpMCusAddr;

    @FXML
    private ComboBox<User> drpMCusAgent;

    @FXML
    private PasswordField inpMCusPass;

    @FXML
    private RadioButton rdCusMale, rdCusFemale;

    @FXML
    private Button btnMAgExport;

    @FXML
    private Button btnMCusExport;

    @FXML
    private TableView<User> managerAgentTable;

    @FXML
    private HBox btnMGAgent;

    @FXML
    private HBox btnMGCus;

    @FXML
    private HBox btnMGPoli;

    @FXML
    private HBox btnMGPayment;

    @FXML
    private TableView<User> managerCustomerTable;

    @FXML
    private TableView<Policy> managerCusPoliTable;

    @FXML
    private ImageView btnMin, btnMin1, btnMin11, btnMin111, btnMin2, btnMin3, btnMin4, btnMin5, btnMin51, btnMin511, btnMin512, btnMinMG1, btnMinMG2, btnMinMG3;

    @FXML
    private ImageView btnMax, btnMax1, btnMax11, btnMax111, btnMax2, btnMax3, btnMax4, btnMax5, btnMax51, btnMax511, btnMax512, btnMaxMG1, btnMaxMG2, btnMaxMG3;

    @FXML
    private ImageView btnClose, btnClose1, btnClose11, btnClose111, btnClose2, btnClose3, btnClose4, btnClose5, btnClose51, btnClose511, btnClose512, btnCloseMG1, btnCloseMG2, btnCloseMG3;

    @FXML
    private ComboBox<User> drpFrmMCUS;

    @FXML
    private ComboBox<Policy> drpFrmMPoli;

    @FXML
    private ComboBox<PolicyType> drpFrmMPoliType;

    @FXML
    private ComboBox<User> drpFrmMAgent;

    @FXML
    private TextField inpMCusPoliId, inpMCusPNom, inpMCusPRela, inpMCusPPAmt, inpMCusPRate, inpMCusPPrd, inpMCusPIntr, inpMCusPFaceAmt;

    @FXML
    private ComboBox<Long> drpMCusPPid;

    @FXML
    private TextField inpPCusName, inpCusPPid, inpCusPPamt, inpCusPPtype, inpCusPPaidAmt, inpCusPBamt, inpCusPayAmt;

    @FXML
    private RadioButton rdCus, rdManager, rdAgent, rdAdmin;

    @FXML
    private TextArea txtPayment;

    @FXML
    Button btnPrint;

    private ToggleGroup loginToggleGrp;
    private Encrypt encrypt;

    private final TableColumn<Branch, Long> ID_COLUMN = new TableColumn<>("Id");
    private final TableColumn<Branch, String> NAME_COLUMN = new TableColumn<>("Nazwa");
    private final TableColumn<Branch, String> LOCATION_COLUMN = new TableColumn<>("Lokalizacja");
    private final TableColumn<Branch, String> PHONE_COLUMN = new TableColumn<>("Telefon");
    private final TableColumn<Branch, String> STATE_COLUMN = new TableColumn<>("Kraj");

    private final TableColumn<Policy, Long> P_ID_COLUMN = new TableColumn<>("Id");
    private final TableColumn<Policy, String> P_PID_COLUMN = new TableColumn<>("PolisaID");
    private final TableColumn<Policy, String> P_PNAME_COLUMN = new TableColumn<>("Nazwa");
    private final TableColumn<Policy, String> P_TERM_COLUMN = new TableColumn<>("Termin polisy");
    private final TableColumn<Policy, String> P_AMOUNT_COLUMN = new TableColumn<>("Cena");
    private final TableColumn<Policy, String> P_FAMOUNT_COLUMN = new TableColumn<>("Kwota");
    private final TableColumn<Policy, String> P_INT_COLUMN = new TableColumn<>("Czas obowiązkowy");
    private final TableColumn<Policy, String> P_BP_COLUMN = new TableColumn<>("Bonus okres");
    private final TableColumn<Policy, String> P_BRT_COLUMN = new TableColumn<>("Bonus czas");
    private final TableColumn<Policy, String> P_DESC_COLUMN = new TableColumn<>("Opis");


    private final TableColumn<Policy, Long> CUS_P_ID_COLUMN = new TableColumn<>("Id");
    private final TableColumn<Policy, String> CUS_P_CUPID_COLUMN = new TableColumn<>("Klient_Polisa_ID");
    private final TableColumn<Policy, String> CUS_P_CID_COLUMN = new TableColumn<>("KlientID");
    private final TableColumn<Policy, String> CUS_P_PID_COLUMN = new TableColumn<>("PolisaID");
    private final TableColumn<Policy, PolicyType> CUS_P_TYPE_COLUMN = new TableColumn<>("Typ");
    private final TableColumn<Policy, String> CUS_P_AID_COLUMN = new TableColumn<>("AgentID");
    private final TableColumn<Policy, String> CUS_P_NOM_COLUMN = new TableColumn<>("Nominał");
    private final TableColumn<Policy, String> CUS_P_RELA_COLUMN = new TableColumn<>("Relacja");
    private final TableColumn<Policy, Double> CUS_P_AMOUNT_COLUMN = new TableColumn<>("Ilość");


    private final TableColumn<Policy, Long> P_ID_COLUMN1 = new TableColumn<>("ID");
    private final TableColumn<Policy, String> P_PID_COLUMN1 = new TableColumn<>("PolisaID");
    private final TableColumn<Policy, String> P_PNAME_COLUMN1 = new TableColumn<>("Nazwa");
    private final TableColumn<Policy, String> P_TERM_COLUMN1 = new TableColumn<>("Termin");
    private final TableColumn<Policy, String> P_AMOUNT_COLUMN1 = new TableColumn<>("Kwota");
    private final TableColumn<Policy, String> P_FAMOUNT_COLUMN1 = new TableColumn<>("Kwota ilość");
    private final TableColumn<Policy, String> P_INT_COLUMN1 = new TableColumn<>("Interes");
    private final TableColumn<Policy, String> P_BP_COLUMN1 = new TableColumn<>("Bonus czas");
    private final TableColumn<Policy, String> P_BRT_COLUMN1 = new TableColumn<>("Bonus cena");
    private final TableColumn<Policy, String> P_DESC_COLUMN1 = new TableColumn<>("Opis");


    private final TableColumn<Policy, String> P_PID_COLUMN2 = new TableColumn<>("PolisaID");
    private final TableColumn<Policy, String> P_PNAME_COLUMN2 = new TableColumn<>("Nazwa");
    private final TableColumn<Policy, String> P_AMOUNT_COLUMN2 = new TableColumn<>("Kwota");
    private final TableColumn<Policy, String> P_FAMOUNT_COLUMN2 = new TableColumn<>("Zapłacona kwota");
    private final TableColumn<Policy, String> P_TERM_COLUMN2 = new TableColumn<>("Termin");
    //private final TableColumn<Policy, String> P_FAMOUNT_COLUMN2 = new TableColumn<>("Face Amount");
    private final TableColumn<Policy, String> P_INT_COLUMN2 = new TableColumn<>("Interes");
    private final TableColumn<Policy, String> P_BP_COLUMN2 = new TableColumn<>("Okres");
    //private final TableColumn<Policy, String> P_BRT_COLUMN2 = new TableColumn<>("Rate");
    private final TableColumn<Policy, String> P_DESC_COLUMN2 = new TableColumn<>("Opis");


    private final TableColumn<Policy, String> P_PID_COLUMN3 = new TableColumn<>("PolisaID");
    private final TableColumn<Policy, String> P_PNAME_COLUMN3 = new TableColumn<>("Nazwa");
    private final TableColumn<Policy, String> P_AMOUNT_COLUMN3 = new TableColumn<>("Kwota");
    private final TableColumn<Policy, String> P_FAMOUNT_COLUMN3 = new TableColumn<>("Zapłacona kwota");

    private final TableColumn<User, Long> M_ID_COLUMN = new TableColumn<>("ID");
    private final TableColumn<User, String> M_NAME_COLUMN = new TableColumn<>("Nazwa");
    private final TableColumn<User, String> M_BRANCH_COLUMN = new TableColumn<>("Oddzial");
    private final TableColumn<User, String> M_PHONE_COLUMN = new TableColumn<>("Telefon");

    private final TableColumn<User, Long> M_ID_COLUMN1 = new TableColumn<>("ID");
    private final TableColumn<User, String> M_NAME_COLUMN1 = new TableColumn<>("Nazwa");
    private final TableColumn<User, String> M_BRANCH_COLUMN1 = new TableColumn<>("Oddzial");
    private final TableColumn<User, String> M_PHONE_COLUMN1 = new TableColumn<>("Telefon");

    private final TableColumn<User, Long> AG_CUST_ID = new TableColumn<>("ID");
    private final TableColumn<User, String> AG_CUST_CID = new TableColumn<>("KlientID");
    private final TableColumn<User, String> AG_CUST_NAME = new TableColumn<>("Nazwa");
    private final TableColumn<User, String> AG_CUST_F_NAME = new TableColumn<>("Imię Ojca");
    private final TableColumn<User, String> AG_CUST_AGE = new TableColumn<>("Wiek");
    private final TableColumn<User, String> AG_CUST_GEN = new TableColumn<>("Płeć");
    private final TableColumn<User, String> AG_CUST_QUA = new TableColumn<>("Kwartal");
    private final TableColumn<User, String> AG_CUST_CADD = new TableColumn<>("Adres");
    private final TableColumn<User, String> AG_CUST_OCC = new TableColumn<>("Zawód");
    private final TableColumn<User, String> AG_CUST_PHONE = new TableColumn<>("Telefon");

    private final TableColumn<User, Integer> CUST_AG_ID = new TableColumn<>("ID");
    private final TableColumn<User, String> CUST_AG_AID = new TableColumn<>("AgentID");
    private final TableColumn<User, String> CUST_AG_NAME = new TableColumn<>("Nazwa");
    private final TableColumn<User, String> CUST_AG_OCCU = new TableColumn<>("Pozycja");
    private final TableColumn<User, String> CUST_AG_PHNO = new TableColumn<>("Telefon");

    private final TableColumn<User, Integer> MG_AG_ID = new TableColumn<>("ID");
    private final TableColumn<User, String> MG_AG_AID = new TableColumn<>("AgentID");
    private final TableColumn<User, String> MG_AG_NAME = new TableColumn<>("Nazwa");
    private final TableColumn<User, String> MG_AG_FNAME = new TableColumn<>("Imię Ojca");
    private final TableColumn<User, String> MG_AG_AGE = new TableColumn<>("Wiek");
    private final TableColumn<User, String> MG_AG_GEN = new TableColumn<>("Płeć");
    private final TableColumn<User, String> MG_AG_OCCU = new TableColumn<>("Zawód");
    private final TableColumn<User, String> MG_AG_ADDR = new TableColumn<>("Adres");
    private final TableColumn<User, String> MG_AG_SEC = new TableColumn<>("Depozyt");
    private final TableColumn<User, Integer> MG_AG_MNAME = new TableColumn<>("ImieM");
    private final TableColumn<User, String> MG_AG_PHNO = new TableColumn<>("Telefon");

    private final TableColumn<User, Long> MG_CUST_ID = new TableColumn<>("ID");
    private final TableColumn<User, String> MG_CUST_CID = new TableColumn<>("KlientID");
    private final TableColumn<User, String> MG_CUST_NAME = new TableColumn<>("Nazwa");
    private final TableColumn<User, String> MG_CUST_F_NAME = new TableColumn<>("Imię Ojca");
    private final TableColumn<User, String> MG_CUST_AGE = new TableColumn<>("Wiek");
    private final TableColumn<User, String> MG_CUST_GEN = new TableColumn<>("Płeć");
    private final TableColumn<User, String> MG_CUST_QUA = new TableColumn<>("Kwartal");
    private final TableColumn<User, String> MG_CUST_CADD = new TableColumn<>("Adres");
    private final TableColumn<User, String> MG_CUST_OCC = new TableColumn<>("Zawód");
    private final TableColumn<User, String> MG_CUST_PHONE = new TableColumn<>("Telefon");

    private Branch selectedBranch;
    private Policy selectedPolicy;
    private User selectedManager;
    private User selectedAgent;
    private User selectedCustomer;
    private ToggleGroup toggleGroup;
    private ToggleGroup managerAgentToggleGroup;
    private int loginStatus;
    private int branchStatus;
    private int policyStatus;
    private int managerStatus;
    private int customerStatus;
    private int managerAgentStatus;
    private int managerCustomerPolicyStatus;
    private DirectoryChooser directoryChooser;
    private User loggedInUser;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadAppData();
    }

    @SuppressWarnings("unchecked")
    public void loadAppData() {
        encrypt = new Encrypt();
        txtPayment.setEditable(false);
        txtPayment.setPrefColumnCount(2);
        txtPayment.setPrefRowCount(100);
        payHbox1.setVisible(false);
        payHbox2.setVisible(false);
        drpRole.getItems().addAll(Role.values());
        inpBranchId.setDisable(true);
        inpPID.setDisable(true);
        inpMId.setDisable(true);
        inpMAgentID.setDisable(true);
        inpMCusID.setDisable(true);
        inpMCusPoliId.setDisable(true);
        inpMCusPIntr.setDisable(true);
        inpMCusPRate.setDisable(true);
        inpMCusPPrd.setDisable(true);
        inpMCusPFaceAmt.setDisable(true);

        inpPCusName.setDisable(true);
        inpCusPPid.setDisable(true);
        inpCusPPamt.setDisable(true);
        inpCusPPtype.setDisable(true);
        inpCusPPaidAmt.setDisable(true);
        inpCusPBamt.setDisable(true);

        // Later will move to the Customer Login only
        loadAgentsToDropDown();
        loadManagerCustomerPolicyFormDropDownData();
        loadManagerCustomerPaymentPolicyData();

        btnAgentMGExport.setText("Eksport danych");
        btnBranchExport.setText("Eksport danych");
        btnCusAgentExport.setText("Eksport danych");
        btnCustExport.setText("Eksport danych");
        btnCustPoliExport.setText("Eksport danych");
        btnMAgExport.setText("Eksport danych");
        btnManagerExport.setText("Eksport danych");
        btnMCusExport.setText("Eksport danych");
        btnMCusPoliExport.setText("Eksport danych");
        btnPoliExport.setText("Eksport danych");
        btnPExport.setText("Eksport danych");

        // Admin->Branch
        ID_COLUMN.setCellValueFactory(new PropertyValueFactory<>("id"));
        NAME_COLUMN.setCellValueFactory(new PropertyValueFactory<>("name"));
        LOCATION_COLUMN.setCellValueFactory(new PropertyValueFactory<>("location"));
        PHONE_COLUMN.setCellValueFactory(new PropertyValueFactory<>("phone"));
        STATE_COLUMN.setCellValueFactory(new PropertyValueFactory<>("state"));

        NAME_COLUMN.prefWidthProperty().bind(branchTable.widthProperty().multiply(0.3));
        LOCATION_COLUMN.prefWidthProperty().bind(branchTable.widthProperty().multiply(0.3));
        PHONE_COLUMN.prefWidthProperty().bind(branchTable.widthProperty().multiply(0.2));
        STATE_COLUMN.prefWidthProperty().bind(branchTable.widthProperty().multiply(0.3));

        branchTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        branchTable.getColumns().addAll(new TableColumn[]{ID_COLUMN, NAME_COLUMN, LOCATION_COLUMN, PHONE_COLUMN, STATE_COLUMN});

        // Admin->Policy

        P_ID_COLUMN.setCellValueFactory(new PropertyValueFactory<>("id"));
        P_PID_COLUMN.setCellValueFactory(new PropertyValueFactory<>("pid"));
        P_PNAME_COLUMN.setCellValueFactory(new PropertyValueFactory<>("pname"));
        P_TERM_COLUMN.setCellValueFactory(new PropertyValueFactory<>("pterm"));
        P_AMOUNT_COLUMN.setCellValueFactory(new PropertyValueFactory<>("pamt"));
        P_FAMOUNT_COLUMN.setCellValueFactory(new PropertyValueFactory<>("pfamt"));
        P_INT_COLUMN.setCellValueFactory(new PropertyValueFactory<>("pint"));
        P_BP_COLUMN.setCellValueFactory(new PropertyValueFactory<>("pbper"));
        P_BRT_COLUMN.setCellValueFactory(new PropertyValueFactory<>("prat"));
        P_DESC_COLUMN.setCellValueFactory(new PropertyValueFactory<>("opis"));

        P_ID_COLUMN1.setCellValueFactory(new PropertyValueFactory<>("id"));
        P_PID_COLUMN1.setCellValueFactory(new PropertyValueFactory<>("pid"));
        P_PNAME_COLUMN1.setCellValueFactory(new PropertyValueFactory<>("pname"));
        P_TERM_COLUMN1.setCellValueFactory(new PropertyValueFactory<>("pterm"));
        P_AMOUNT_COLUMN1.setCellValueFactory(new PropertyValueFactory<>("pamt"));
        P_FAMOUNT_COLUMN1.setCellValueFactory(new PropertyValueFactory<>("pfamt"));
        P_INT_COLUMN1.setCellValueFactory(new PropertyValueFactory<>("pint"));
        P_BP_COLUMN1.setCellValueFactory(new PropertyValueFactory<>("pbper"));
        P_BRT_COLUMN1.setCellValueFactory(new PropertyValueFactory<>("prat"));
        P_DESC_COLUMN1.setCellValueFactory(new PropertyValueFactory<>("desc"));


        P_PID_COLUMN2.setCellValueFactory(new PropertyValueFactory<>("pid"));
        P_PNAME_COLUMN2.setCellValueFactory(new PropertyValueFactory<>("pname"));
        P_TERM_COLUMN2.setCellValueFactory(new PropertyValueFactory<>("pterm"));
        P_AMOUNT_COLUMN2.setCellValueFactory(new PropertyValueFactory<>("pamt"));
        P_FAMOUNT_COLUMN2.setCellValueFactory(new PropertyValueFactory<>("pfamt"));
        P_INT_COLUMN2.setCellValueFactory(new PropertyValueFactory<>("pint"));
        P_BP_COLUMN2.setCellValueFactory(new PropertyValueFactory<>("pbper"));
        P_DESC_COLUMN2.setCellValueFactory(new PropertyValueFactory<>("desc"));

        P_PID_COLUMN3.setCellValueFactory(new PropertyValueFactory<>("pid"));
        P_PNAME_COLUMN3.setCellValueFactory(new PropertyValueFactory<>("pname"));
        P_AMOUNT_COLUMN3.setCellValueFactory(new PropertyValueFactory<>("pamt"));
        P_FAMOUNT_COLUMN3.setCellValueFactory(new PropertyValueFactory<>("pfamt"));

        policyTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        policyTable.getColumns().addAll(new TableColumn[]{P_ID_COLUMN, P_PID_COLUMN, P_PNAME_COLUMN, P_TERM_COLUMN, P_AMOUNT_COLUMN, P_FAMOUNT_COLUMN, P_INT_COLUMN, P_BP_COLUMN, P_BRT_COLUMN, P_DESC_COLUMN});

        agentCustomerPolicyTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        agentCustomerPolicyTable.getColumns().addAll(new TableColumn[]{P_ID_COLUMN1, P_PID_COLUMN1, P_PNAME_COLUMN1, P_TERM_COLUMN1, P_AMOUNT_COLUMN1, P_FAMOUNT_COLUMN1, P_INT_COLUMN1, P_BP_COLUMN1, P_BRT_COLUMN1, P_DESC_COLUMN1});

        customerPolicyTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        customerPolicyTable.getColumns().addAll(new TableColumn[]{P_PID_COLUMN2, P_PNAME_COLUMN2, P_AMOUNT_COLUMN2, P_FAMOUNT_COLUMN2, P_TERM_COLUMN2, P_INT_COLUMN2, P_BP_COLUMN2, P_DESC_COLUMN2});

        custPoliStatTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        custPoliStatTable.getColumns().addAll(new TableColumn[]{P_PID_COLUMN3, P_PNAME_COLUMN3, P_AMOUNT_COLUMN3, P_FAMOUNT_COLUMN3});


        CUS_P_ID_COLUMN.setCellValueFactory(new PropertyValueFactory<>("id"));
        CUS_P_CUPID_COLUMN.setCellValueFactory(new PropertyValueFactory<>("cupid"));
        CUS_P_CID_COLUMN.setCellValueFactory(new PropertyValueFactory<>("cid"));
        CUS_P_PID_COLUMN.setCellValueFactory(new PropertyValueFactory<>("pid"));
        CUS_P_TYPE_COLUMN.setCellValueFactory(new PropertyValueFactory<>("policeType"));
        CUS_P_AID_COLUMN.setCellValueFactory(new PropertyValueFactory<>("aid"));
        CUS_P_NOM_COLUMN.setCellValueFactory(new PropertyValueFactory<>("nom"));
        CUS_P_RELA_COLUMN.setCellValueFactory(new PropertyValueFactory<>("rela"));
        CUS_P_AMOUNT_COLUMN.setCellValueFactory(new PropertyValueFactory<>("pamt"));

        managerCusPoliTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        managerCusPoliTable.getColumns().addAll(new TableColumn[]{CUS_P_ID_COLUMN, CUS_P_CUPID_COLUMN, CUS_P_CID_COLUMN, CUS_P_PID_COLUMN, CUS_P_TYPE_COLUMN, CUS_P_AID_COLUMN, CUS_P_NOM_COLUMN, CUS_P_RELA_COLUMN, CUS_P_AMOUNT_COLUMN});

        // Admin->Manager

        M_ID_COLUMN.setCellValueFactory(new PropertyValueFactory<>("mid"));
        M_NAME_COLUMN.setCellValueFactory(new PropertyValueFactory<>("name"));
        M_BRANCH_COLUMN.setCellValueFactory(new PropertyValueFactory<>("bname"));
        M_PHONE_COLUMN.setCellValueFactory(new PropertyValueFactory<>("phone"));
        M_ID_COLUMN1.setCellValueFactory(new PropertyValueFactory<>("mid"));
        M_NAME_COLUMN1.setCellValueFactory(new PropertyValueFactory<>("name"));
        M_BRANCH_COLUMN1.setCellValueFactory(new PropertyValueFactory<>("bname"));
        M_PHONE_COLUMN1.setCellValueFactory(new PropertyValueFactory<>("phone"));

        managerTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        managerTable.getColumns().addAll(new TableColumn[]{M_ID_COLUMN, M_NAME_COLUMN, M_BRANCH_COLUMN, M_PHONE_COLUMN});
        agentManagerTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        agentManagerTable.getColumns().addAll(new TableColumn[]{M_ID_COLUMN1, M_NAME_COLUMN1, M_BRANCH_COLUMN1, M_PHONE_COLUMN1});

        AG_CUST_ID.setCellValueFactory(new PropertyValueFactory<>("id"));
        AG_CUST_CID.setCellValueFactory(new PropertyValueFactory<>("cid"));
        AG_CUST_NAME.setCellValueFactory(new PropertyValueFactory<>("name"));
        AG_CUST_F_NAME.setCellValueFactory(new PropertyValueFactory<>("fname"));
        AG_CUST_AGE.setCellValueFactory(new PropertyValueFactory<>("age"));
        AG_CUST_GEN.setCellValueFactory(new PropertyValueFactory<>("gen"));
        AG_CUST_QUA.setCellValueFactory(new PropertyValueFactory<>("qua"));
        AG_CUST_CADD.setCellValueFactory(new PropertyValueFactory<>("cadd"));
        AG_CUST_OCC.setCellValueFactory(new PropertyValueFactory<>("occ"));
        AG_CUST_PHONE.setCellValueFactory(new PropertyValueFactory<>("phno"));

        agentCustomerDetailsTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        agentCustomerDetailsTable.getColumns().addAll(new TableColumn[]{AG_CUST_ID, AG_CUST_CID, AG_CUST_NAME, AG_CUST_F_NAME, AG_CUST_AGE, AG_CUST_GEN, AG_CUST_QUA, AG_CUST_CADD, AG_CUST_OCC, AG_CUST_PHONE});

        CUST_AG_ID.setCellValueFactory(new PropertyValueFactory<>("id"));
        CUST_AG_AID.setCellValueFactory(new PropertyValueFactory<>("aid"));
        CUST_AG_NAME.setCellValueFactory(new PropertyValueFactory<>("name"));
        CUST_AG_OCCU.setCellValueFactory(new PropertyValueFactory<>("occu"));
        CUST_AG_PHNO.setCellValueFactory(new PropertyValueFactory<>("phno"));

        customerAgentTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        customerAgentTable.getColumns().addAll(new TableColumn[]{CUST_AG_ID, CUST_AG_AID, CUST_AG_NAME, CUST_AG_OCCU, CUST_AG_PHNO});

        MG_AG_ID.setCellValueFactory(new PropertyValueFactory<>("id"));
        MG_AG_AID.setCellValueFactory(new PropertyValueFactory<>("aid"));
        MG_AG_NAME.setCellValueFactory(new PropertyValueFactory<>("name"));
        MG_AG_FNAME.setCellValueFactory(new PropertyValueFactory<>("fname"));
        MG_AG_AGE.setCellValueFactory(new PropertyValueFactory<>("age"));
        MG_AG_GEN.setCellValueFactory(new PropertyValueFactory<>("gen"));
        MG_AG_OCCU.setCellValueFactory(new PropertyValueFactory<>("occ"));
        MG_AG_ADDR.setCellValueFactory(new PropertyValueFactory<>("addr"));
        MG_AG_SEC.setCellValueFactory(new PropertyValueFactory<>("sec"));
        MG_AG_MNAME.setCellValueFactory(new PropertyValueFactory<>("mname"));
        MG_AG_PHNO.setCellValueFactory(new PropertyValueFactory<>("phno"));

        managerAgentTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        managerAgentTable.getColumns().addAll(new TableColumn[]{MG_AG_ID, MG_AG_AID, MG_AG_NAME, MG_AG_FNAME, MG_AG_AGE, MG_AG_GEN, MG_AG_OCCU, MG_AG_ADDR, MG_AG_SEC, MG_AG_MNAME, MG_AG_PHNO});

        MG_CUST_ID.setCellValueFactory(new PropertyValueFactory<>("id"));
        MG_CUST_CID.setCellValueFactory(new PropertyValueFactory<>("cid"));
        MG_CUST_NAME.setCellValueFactory(new PropertyValueFactory<>("name"));
        MG_CUST_F_NAME.setCellValueFactory(new PropertyValueFactory<>("fname"));
        MG_CUST_AGE.setCellValueFactory(new PropertyValueFactory<>("age"));
        MG_CUST_GEN.setCellValueFactory(new PropertyValueFactory<>("gen"));
        MG_CUST_QUA.setCellValueFactory(new PropertyValueFactory<>("qua"));
        MG_CUST_CADD.setCellValueFactory(new PropertyValueFactory<>("cadd"));
        MG_CUST_OCC.setCellValueFactory(new PropertyValueFactory<>("occ"));
        MG_CUST_PHONE.setCellValueFactory(new PropertyValueFactory<>("phno"));

        managerCustomerTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        managerCustomerTable.getColumns().addAll(new TableColumn[]{MG_CUST_ID, MG_CUST_CID, MG_CUST_NAME, MG_CUST_F_NAME, MG_CUST_AGE, MG_CUST_GEN, MG_CUST_QUA, MG_CUST_CADD, MG_CUST_OCC, MG_CUST_PHONE});

        toggleGroup = new ToggleGroup();
        toggleGroup.getToggles().add(rdMale);
        toggleGroup.getToggles().add(rdFemale);

        loginToggleGrp = new ToggleGroup();
        toggleGroup.getToggles().add(rdCus);
        toggleGroup.getToggles().add(rdAgent);
        toggleGroup.getToggles().add(rdAdmin);
        toggleGroup.getToggles().add(rdManager);

        managerAgentToggleGroup = new ToggleGroup();
        managerAgentToggleGroup.getToggles().add(rdMAgentMale);
        managerAgentToggleGroup.getToggles().add(rdMAgentFemale);

        directoryChooser = new DirectoryChooser();

        rdCus.setSelected(true);

    }

    public void login() {
        if (validateLogin()) {
            String strUsername = inpUsername.getText();
            String strPassword = inpPassword.getText();

            if (rdCus.isSelected()) {
                drpRole.getSelectionModel().select(Role.valueOf(rdCus.getText()));
            } else if (rdManager.isSelected()) {
                drpRole.getSelectionModel().select(Role.valueOf(rdManager.getText()));
            } else if (rdAgent.isSelected()) {
                drpRole.getSelectionModel().select(Role.valueOf(rdAgent.getText()));
            } else if (rdAdmin.isSelected()) {
                drpRole.getSelectionModel().select(Role.valueOf(rdAdmin.getText()));
            }

            Role role = drpRole.getSelectionModel().getSelectedItem();
            System.out.println(role.name());

            User uiUser = new User();
            uiUser.setName(strUsername);
            uiUser.setPassword(strPassword);
            uiUser.setRole(role);

            enableDisableLoginForm(true);

            Thread thread = new Thread(() -> {
                loginStatus = login(uiUser);
                loggedInUser = getUser(uiUser);
                System.out.println(loggedInUser);
                Platform.runLater(() -> {
                    Alert alert;
                    enableDisableLoginForm(false);
                    switch (loginStatus) {
                        case 1:
                            alert = new Alert(AlertType.INFORMATION);
                            alert.setTitle("Sukces");
                            alert.setContentText("Witaj " + uiUser.getName());
                            alert.show();
                            changeUIBasedOnRole(role);
                            break;
                        case 2:
                            alert = new Alert(AlertType.ERROR);
                            alert.setTitle("Błąd autoryzacji");
                            alert.setContentText("Złe hasło");
                            alert.show();
                            break;
                        case 3:
                            alert = new Alert(AlertType.ERROR);
                            alert.setTitle("Błąd autoryzacji");
                            alert.setContentText("Zła nazwa użytkownika");
                            alert.show();
                            break;
                        case 4:
                        case -1:
                        case 0:
                            alert = new Alert(AlertType.ERROR);
                            alert.setTitle("Błąd autoryzacji");
                            alert.setContentText("Zła nazwa użytkownika i hasło");
                            alert.show();
                            break;
                    }
                });
            });

            thread.start();
        }
    }

    public void enableDisableLoginForm(boolean isEnable) {
        inpUsername.setDisable(isEnable);
        inpPassword.setDisable(isEnable);
        drpRole.setDisable(isEnable);
    }

    public boolean validateLogin() {
        return true;
    }

    public void changeAdminTabs(MouseEvent mouseEvent) {
        HBox box = (HBox) mouseEvent.getSource();
        if (box.equals(btnBranch)) {
            adminTabPane.getSelectionModel().select(0);
            btnBranch.setStyle("-fx-background-color:#16D2A5");
            btnPolicy.setStyle("-fx-background-color:transparent");
            btnManager.setStyle("-fx-background-color:transparent");
            loadBranchDataToTable();
        } else if (box.equals(btnPolicy)) {
            adminTabPane.getSelectionModel().select(1);
            btnBranch.setStyle("-fx-background-color:transparent");
            btnPolicy.setStyle("-fx-background-color:#16D2A5");
            btnManager.setStyle("-fx-background-color:transparent");
            loadPolicyDataToTable();
        } else if (box.equals(btnManager)) {
            loadBranches();
            loadManagerDataToTable();
            adminTabPane.getSelectionModel().select(2);
            btnBranch.setStyle("-fx-background-color:transparent");
            btnPolicy.setStyle("-fx-background-color:transparent");
            btnManager.setStyle("-fx-background-color:#16D2A5");
        }
    }

    public void changeAgentTabs(MouseEvent mouseEvent) {
        HBox box = (HBox) mouseEvent.getSource();
        if (box.equals(btnAgentMG)) {
            loadAgentManagerDataToTable();
            agentTabPane.getSelectionModel().select(0);
            btnAgentMG.setStyle("-fx-background-color:#16D2A5");
            btnAgentPolicy.setStyle("-fx-background-color:transparent");
            btnAgentCustomer.setStyle("-fx-background-color:transparent");
        } else if (box.equals(btnAgentPolicy)) {
            loadAgentPolicyDataToTable();
            agentTabPane.getSelectionModel().select(1);
            btnAgentMG.setStyle("-fx-background-color:transparent");
            btnAgentPolicy.setStyle("-fx-background-color:#16D2A5");
            btnAgentCustomer.setStyle("-fx-background-color:transparent");
        } else if (box.equals(btnAgentCustomer)) {
            loadAgentCustomerDataToTable();
            agentTabPane.getSelectionModel().select(2);
            btnAgentMG.setStyle("-fx-background-color:transparent");
            btnAgentPolicy.setStyle("-fx-background-color:transparent");
            btnAgentCustomer.setStyle("-fx-background-color:#16D2A5");
        }
    }

    public void changeCustomerTabs(MouseEvent mouseEvent) {
        HBox box = (HBox) mouseEvent.getSource();
        if (box.equals(btnCusAgent)) {
            loadAgentDataToTable();
            custTabPane.getSelectionModel().select(0);
            btnCusAgent.setStyle("-fx-background-color:#16D2A5");
            btnCusPolicy.setStyle("-fx-background-color:transparent");
            btnCusPoliStat.setStyle("-fx-background-color:transparent");
        } else if (box.equals(btnCusPolicy)) {
            loadCustomerPolicyData();
            custTabPane.getSelectionModel().select(1);
            btnCusAgent.setStyle("-fx-background-color:transparent");
            btnCusPolicy.setStyle("-fx-background-color:#16D2A5");
            btnCusPoliStat.setStyle("-fx-background-color:transparent");
        } else if (box.equals(btnCusPoliStat)) {
            loadCustomerPolicyStatusDataToTable();
            custTabPane.getSelectionModel().select(2);
            btnCusAgent.setStyle("-fx-background-color:transparent");
            btnCusPolicy.setStyle("-fx-background-color:transparent");
            btnCusPoliStat.setStyle("-fx-background-color:#16D2A5");
        }
    }


    public void changeManagerTabs(MouseEvent mouseEvent) {
        HBox box = (HBox) mouseEvent.getSource();
        if (box.equals(btnMGAgent)) {
            loadManagerAgentDataToTable();
            loadManagersToDropDowm();
            managerTabPane.getSelectionModel().select(0);
            btnMGAgent.setStyle("-fx-background-color:#16D2A5");
            btnMGCus.setStyle("-fx-background-color:transparent");
            btnMGPoli.setStyle("-fx-background-color:transparent");
            btnMGPayment.setStyle("-fx-background-color:transparent");
        } else if (box.equals(btnMGCus)) {
            loadManagerCustomerDataToTable();
            managerTabPane.getSelectionModel().select(1);
            btnMGCus.setStyle("-fx-background-color:#16D2A5");
            btnMGAgent.setStyle("-fx-background-color:transparent");
            btnMGPoli.setStyle("-fx-background-color:transparent");
            btnMGPayment.setStyle("-fx-background-color:transparent");
        } else if (box.equals(btnMGPoli)) {
            loadAgentsToDropDown();
            loadManagerCustomerPolicyFormDropDownData();
            loadManagerCustomerPolicyToTable();
            managerTabPane.getSelectionModel().select(2);
            btnMGPoli.setStyle("-fx-background-color:#16D2A5");
            btnMGCus.setStyle("-fx-background-color:transparent");
            btnMGAgent.setStyle("-fx-background-color:transparent");
            btnMGPayment.setStyle("-fx-background-color:transparent");
        } else if (box.equals(btnMGPayment)) {
            loadManagerCustomerPaymentPolicyData();
            clearPaymentForm();
            managerTabPane.getSelectionModel().select(3);
            btnMGPayment.setStyle("-fx-background-color:#16D2A5");
            btnMGCus.setStyle("-fx-background-color:transparent");
            btnMGAgent.setStyle("-fx-background-color:transparent");
            btnMGPoli.setStyle("-fx-background-color:transparent");
        }
    }

    public void loadPaymentDataToForm(ActionEvent actionEvent) {
        clearPaymentForm();
        if (drpMCusPPid.getSelectionModel().getSelectedIndex() >= 0) {
            Policy policy = new Policy();
            policy.setCupid(String.valueOf(drpMCusPPid.getSelectionModel().getSelectedItem()));
            Payment payment = getPolicyPaymentDetails(policy);
            Platform.runLater(() -> {
                inpPCusName.setText(payment.getStrCusName());
                inpCusPPid.setText(payment.getPolicyId());
                inpCusPPamt.setText(payment.getPolicyAmount());
                inpCusPPtype.setText(payment.getPolicType().name());
                inpCusPPaidAmt.setText(payment.getStrPaidAmt());
                inpCusPBamt.setText(payment.getStrBalAmt());

                String textToPrint = "Płatność końcowa\n" + "\n" + "Imie     :  " + payment.getStrCusName() + "\n" + "ID            :  " + payment.getPolicyId() + "\n" + "Ilość        :  " + payment.getPolicyAmount() + "\n" + "Typ          :  " + payment.getStrPaidAmt() + "\n" + "Balans       :  " + payment.getStrBalAmt() + "\n\n" + "Dziękuję...";
                txtPayment.setText(textToPrint);
            });
        }
    }

    public void doPayment(ActionEvent actionEvent) {
        if (validatePaymentForm()) {
            Thread thread = new Thread(() -> {
                Policy policy = new Policy();
                double amountToPay = Double.parseDouble(inpCusPayAmt.getText());
                policy.setCupid(String.valueOf(drpMCusPPid.getSelectionModel().getSelectedItem()));
                Payment payment = payPolictAndFetchPaymentDetails(policy, amountToPay);
                Platform.runLater(() -> {
                    inpPCusName.setText(payment.getStrCusName());
                    inpCusPPid.setText(payment.getPolicyId());
                    inpCusPPamt.setText(payment.getPolicyAmount());
                    inpCusPPtype.setText("payment.getPolicType().name()");
                    inpCusPPaidAmt.setText(payment.getStrPaidAmt());
                    inpCusPBamt.setText(payment.getStrBalAmt());

                    String textToPrint = "Płatność końcowa\n" + "\n" + "Imie           :-  " + payment.getStrCusName() + "\n" + "ID                 :-  " + payment.getPolicyId() + "\n" + "Kwota       :-  " + payment.getPolicyAmount() + "\n" + "Typ             :-  " + payment.getPolicType().name() + "\n" + "Ilosc zaplacona :-  " + payment.getStrPaidAmt() + "\n" + "Balans        :-  " + payment.getStrBalAmt() + "\n\n" + "Dziękuję...";
                    txtPayment.setText(textToPrint);

                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Sukces");
                    alert.setContentText("Oplata zakonczona....");
                    alert.show();

                    print();
                });
            });
            thread.start();
        }
    }

    private boolean validatePaymentForm() {
        boolean isValiddrpMCusPPid, isValidinpCusPayAmt;
        if (drpMCusPPid.getSelectionModel().getSelectedIndex() < 0) {
            drpMCusPPid.setStyle("-fx-border-color:red");
            drpMCusPPid.requestFocus();
            isValiddrpMCusPPid = false;
        } else {
            drpMCusPPid.setStyle("-fx-border-color:green");
            isValiddrpMCusPPid = true;
        }
        if (inpCusPayAmt.getText().equals("")) {
            inpCusPayAmt.requestFocus();
            inpCusPayAmt.setStyle("-fx-border-color:red");
            isValidinpCusPayAmt = false;
        } else {
            try {
                double value = Double.parseDouble(inpCusPayAmt.getText());
                inpCusPayAmt.setStyle("-fx-border-color:green");
                isValidinpCusPayAmt = true;
            } catch (Exception exception) {
                inpCusPayAmt.setStyle("-fx-border-color:red");
                isValidinpCusPayAmt = false;
            }
        }
        return isValiddrpMCusPPid && isValidinpCusPayAmt;
    }

    private void loadManagerCustomerDataToTable() {
        Thread thread = new Thread(() -> {
            ArrayList<User> customerData = getAllCustomers();
            Platform.runLater(() -> {
                managerCustomerTable.getItems().clear();
                managerCustomerTable.getItems().addAll(customerData);
            });
        });
        thread.start();
    }

    private void loadManagerCustomerPolicyToTable() {
        Thread thread = new Thread(() -> {
            ArrayList<Policy> policies = getCustomerPolicies();
            Platform.runLater(() -> {
                managerCusPoliTable.getItems().clear();
                managerCusPoliTable.getItems().addAll(policies);
            });
        });
        thread.start();
    }

    private void loadAgentCustomerDataToTable() {
        Thread thread = new Thread(() -> {
            ArrayList<User> customers = getAllCustomers();
            Platform.runLater(() -> {
                agentCustomerDetailsTable.getItems().clear();
                agentCustomerDetailsTable.getItems().addAll(customers);
            });
        });
        thread.start();
    }

    private void loadAgentPolicyDataToTable() {
        Thread thread = new Thread(() -> {
            ArrayList<Policy> policyS = getAllPolicies();
            Platform.runLater(() -> {
                agentCustomerPolicyTable.getItems().clear();
                agentCustomerPolicyTable.getItems().addAll(policyS);
            });
        });
        thread.start();
    }

    private void loadCustomerPolicyData() {
        Thread thread = new Thread(() -> {
            ArrayList<Policy> policies = getPolicyStatus(loggedInUser);
            Platform.runLater(() -> {
                customerPolicyTable.getItems().clear();
                customerPolicyTable.getItems().addAll(policies);
            });
        });
        thread.start();


    }

    private void loadAgentManagerDataToTable() {
        Thread thread = new Thread(() -> {
            ArrayList<User> managers = getManagers();
            Platform.runLater(() -> {
                agentManagerTable.getItems().clear();
                agentManagerTable.getItems().addAll(managers);
            });
        });
        thread.start();
    }

    private void loadBranches() {
        drpBranch.getItems().clear();
        Thread thread = new Thread(() -> {
            ArrayList<Branch> branchs = getAllBranches();
            ArrayList<String> branchData = new ArrayList<String>();
            Platform.runLater(() -> {
                for (Branch branch : branchs) {
                    branchData.add(branch.getName());
                }
                drpBranch.getItems().addAll(branchData);
            });
        });
        thread.start();
    }

    public void loadManagersToDropDowm() {
        drpMManager.getItems().clear();
        Thread thread = new Thread(() -> {
            ArrayList<User> managers = getManagers();
            Platform.runLater(() -> {
                drpMManager.getItems().addAll(managers);
            });
        });
        thread.start();
    }

    public void loadAgentsToDropDown() {
        drpMCusAgent.getItems().clear();
        Thread thread = new Thread(() -> {
            ArrayList<User> agents = getAllAgents();
            Platform.runLater(() -> {
                drpMCusAgent.getItems().addAll(agents);
            });
        });
        thread.start();
    }

    public void loadManagerCustomerPaymentPolicyData() {
        drpMCusPPid.getItems().clear();
        Thread thread = new Thread(() -> {
            ArrayList<Policy> policies = getCustomerPolicies();
            Platform.runLater(() -> {
                for (Policy policy : policies) {
                    drpMCusPPid.getItems().add(Long.valueOf(policy.getCupid()));
                }
            });
        });
        thread.start();
    }

    public void loadManagerCustomerPolicyFormDropDownData() {
        drpFrmMCUS.getItems().clear();
        drpFrmMPoli.getItems().clear();
        drpFrmMPoliType.getItems().clear();
        drpFrmMAgent.getItems().clear();

        Thread thread = new Thread(() -> {
            ArrayList<User> customers = getAllCustomers();
            ArrayList<User> agents = getAllAgents();
            ArrayList<Policy> policies = getAllPolicies();

            Platform.runLater(() -> {
                drpFrmMCUS.getItems().addAll(customers);
                drpFrmMPoli.getItems().addAll(policies);
                drpFrmMPoliType.getItems().addAll(PolicyType.values());
                drpFrmMAgent.getItems().addAll(agents);
            });
        });
        thread.start();
    }

    // Branch
    public void loadBranchDataToTable() {
        Thread thread = new Thread(() -> {
            ArrayList<Branch> branchs = getAllBranches();
            Platform.runLater(() -> {
                branchTable.getItems().clear();
                branchTable.getItems().addAll(branchs);
            });
        });
        thread.start();
    }

    // Policy
    public void loadPolicyDataToTable() {
        Thread thread = new Thread(() -> {
            ArrayList<Policy> policyS = getAllPolicies();
            Platform.runLater(() -> {
                policyTable.getItems().clear();
                policyTable.getItems().addAll(policyS);
            });
        });
        thread.start();
    }

    public void loadManagerDataToTable() {
        Thread thread = new Thread(() -> {
            ArrayList<User> managers = getManagers();
            Platform.runLater(() -> {
                managerTable.getItems().clear();
                managerTable.getItems().addAll(managers);
            });
        });
        thread.start();
    }

    public void loadAgentDataToTable() {
        Thread thread = new Thread(() -> {
            ArrayList<User> agents = getAllAgents();
            Platform.runLater(() -> {
                customerAgentTable.getItems().clear();
                customerAgentTable.getItems().addAll(agents);
            });
        });
        thread.start();
    }

    public void loadManagerAgentDataToTable() {
        Thread thread = new Thread(() -> {
            ArrayList<User> agents = getAllAgents();
            Platform.runLater(() -> {
                managerAgentTable.getItems().clear();
                managerAgentTable.getItems().addAll(agents);
            });
        });
        thread.start();
    }

    public void loadCustomerPolicyStatusDataToTable() {
        Thread thread = new Thread(() -> {
            ArrayList<Policy> policies = getPolicyStatus(loggedInUser);
            Platform.runLater(() -> {
                custPoliStatTable.getItems().clear();
                custPoliStatTable.getItems().addAll(policies);
            });
        });
        thread.start();
    }

    public void loadBranchDataToForm(MouseEvent event) {
        selectedBranch = branchTable.getSelectionModel().getSelectedItem();

        inpBranch.clear();
        inpLocation.clear();
        inpPhone.clear();
        inpState.clear();

        if (selectedBranch != null) {
            inpBranchId.setText(selectedBranch.getId() + "");
            inpBranch.setText(selectedBranch.getName());
            inpLocation.setText(selectedBranch.getLocation());
            inpPhone.setText(selectedBranch.getPhone());
            inpState.setText(selectedBranch.getState());
        }
    }

    public void clearManagerCustomerPolicyForm(ActionEvent actionEvent) {
        managerCusPoliTable.getSelectionModel().clearSelection();

        inpMCusPoliId.clear();
        drpFrmMCUS.getSelectionModel().clearSelection();
        drpFrmMAgent.getSelectionModel().clearSelection();
        drpFrmMPoli.getSelectionModel().clearSelection();
        drpFrmMPoliType.getSelectionModel().clearSelection();
        inpMCusPNom.clear();
        inpMCusPRela.clear();
        inpMCusPPAmt.clear();
        inpMCusPRate.clear();
        inpMCusPPrd.clear();
        inpMCusPIntr.clear();
        inpMCusPFaceAmt.clear();
    }

    public void clearManagerCustomerForm(ActionEvent actionEvent) {
        managerCustomerTable.getSelectionModel().clearSelection();
        inpMCusID.clear();
        inpMCusPhno.clear();
        inpMCusName.clear();
        inpMCusFname.clear();
        rdCusMale.setSelected(false);
        rdCusFemale.setSelected(false);
        inpMCusQua.clear();
        inpMCusOcc.clear();
        inpMCusAddr.clear();
        inpMCusAge.clear();
        drpMCusAgent.getSelectionModel().clearSelection();
        inpMCusPass.clear();
    }

    public void loadManagerCustomerPolicyDataToForm(MouseEvent mouseEvent) {
        selectedPolicy = managerCusPoliTable.getSelectionModel().getSelectedItem();

        inpMCusPoliId.clear();
        drpFrmMCUS.getSelectionModel().clearSelection();
        drpFrmMAgent.getSelectionModel().clearSelection();
        drpFrmMPoli.getSelectionModel().clearSelection();
        drpFrmMPoliType.getSelectionModel().clearSelection();
        inpMCusPNom.clear();
        inpMCusPRela.clear();
        inpMCusPPAmt.clear();
        inpMCusPRate.clear();
        inpMCusPPrd.clear();
        inpMCusPIntr.clear();
        if (selectedPolicy != null) {
            Thread thread = new Thread(() -> {
                Policy dbPolicy = getPolicy(selectedPolicy);
                Platform.runLater(() -> {

                    inpMCusPoliId.setText(selectedPolicy.getCupid());
                    for (User user : drpFrmMCUS.getItems()) {
                        if (user.getCid().equals(selectedPolicy.getCid())) {
                            drpFrmMCUS.getSelectionModel().select(user);
                            break;
                        }
                    }

                    for (User user : drpFrmMAgent.getItems()) {
                        if (user.getAid() == Long.valueOf(selectedPolicy.getAid())) {
                            drpFrmMAgent.getSelectionModel().select(user);
                            break;
                        }
                    }

                    for (Policy policy : drpFrmMPoli.getItems()) {
                        if (policy.getPid() == selectedPolicy.getPid()) {
                            drpFrmMPoli.getSelectionModel().select(policy);
                            break;
                        }
                    }
                    inpMCusPRate.setText(String.valueOf(dbPolicy.getPrat()));
                    inpMCusPIntr.setText(String.valueOf(dbPolicy.getPint()));
                    inpMCusPPrd.setText(String.valueOf(dbPolicy.getPbper()));
                    inpMCusPFaceAmt.setText(String.valueOf(dbPolicy.getPfamt()));
                    inpMCusPNom.setText(selectedPolicy.getNom());
                    inpMCusPRela.setText(selectedPolicy.getRela());
                    inpMCusPPAmt.setText(selectedPolicy.getPamt() + "");
                    drpFrmMPoliType.getSelectionModel().select(selectedPolicy.getPoliceType());
                });
            });
            thread.start();
        }
    }

    public void loadManagerCustomerDataToForm(MouseEvent mouseEvent) {
        selectedCustomer = managerCustomerTable.getSelectionModel().getSelectedItem();

        inpMCusID.clear();
        inpMCusPhno.clear();
        inpMCusName.clear();
        inpMCusFname.clear();
        rdCusMale.setSelected(false);
        rdCusFemale.setSelected(false);
        inpMCusQua.clear();
        inpMCusOcc.clear();
        inpMCusAddr.clear();
        inpMCusAge.clear();
        drpMCusAgent.getSelectionModel().clearSelection();
        inpMCusPass.clear();

        if (selectedCustomer != null) {
            inpMCusID.setText(selectedCustomer.getCid() + "");
            inpMCusPhno.setText(selectedCustomer.getPhno());
            inpMCusName.setText(selectedCustomer.getName());
            inpMCusFname.setText(selectedCustomer.getFname());
            inpMCusAge.setText(selectedCustomer.getAge());
            inpMCusQua.setText(selectedCustomer.getQua());
            inpMCusOcc.setText(selectedCustomer.getOcc());
            inpMCusPass.setText(selectedCustomer.getPassword());
            inpMCusAddr.setText(selectedCustomer.getCadd());
            if (selectedCustomer.getGender().equals(Gender.Male)) {
                rdCusMale.setSelected(true);
                rdCusFemale.setSelected(false);
            } else {
                rdCusMale.setSelected(false);
                rdCusFemale.setSelected(true);
            }
        }
    }


    public void loadManagerAgentDataToForm(MouseEvent event) {
        selectedAgent = managerAgentTable.getSelectionModel().getSelectedItem();

        inpMAgentID.clear();
        inpMContact.clear();
        inpMAgentName.clear();
        inpMFName.clear();
        inpM_Age.clear();
        inpMQua.clear();
        inpMOcc.clear();
        inpM_Addr.clear();
        inpMDeposit.clear();
        drpMManager.getSelectionModel().clearSelection();
        inpMPassword.clear();
        rdMAgentMale.setSelected(false);
        rdMAgentFemale.setSelected(false);

        if (selectedAgent != null) {
            inpMAgentID.setText(selectedAgent.getAid() + "");
            inpMContact.setText(selectedAgent.getPhno());
            inpMAgentName.setText(selectedAgent.getName());
            inpMFName.setText(selectedAgent.getFname());
            inpM_Age.setText(selectedAgent.getAge());
            inpMQua.setText(selectedAgent.getQua());
            inpMOcc.setText(selectedAgent.getOcc());
            inpM_Addr.setText(selectedAgent.getAddr());
            inpMDeposit.setText(selectedAgent.getSec());
            inpMPassword.setText(selectedAgent.getPassword());
            if (selectedAgent.getGender().equals(Gender.Male)) {
                rdMAgentMale.setSelected(true);
                rdMAgentFemale.setSelected(false);
            } else {
                rdMAgentMale.setSelected(false);
                rdMAgentFemale.setSelected(true);
            }
        }
    }

    public void loadManagerDataToForm(MouseEvent mouseEvent) {
        selectedManager = managerTable.getSelectionModel().getSelectedItem();

        inpMId.clear();
        inpMName.clear();
        inpMAge.clear();
        inpMFather.clear();
        inpMPhone.clear();
        inpMQuali.clear();
        inpMAddr.clear();
        inpMPass.clear();
        rdMale.setSelected(false);
        rdFemale.setSelected(false);

        if (selectedManager != null) {
            inpMId.setText(selectedManager.getMid() + "");
            inpMName.setText(selectedManager.getName());
            inpMAge.setText(selectedManager.getAge() + "");
            inpMFather.setText(selectedManager.getFname());
            inpMPhone.setText(selectedManager.getPhone());
            inpMQuali.setText(selectedManager.getQua());
            inpMAddr.setText(selectedManager.getAddd());
            int index = drpBranch.getItems().indexOf(selectedManager.getBname());
            drpBranch.getSelectionModel().select(index);
            inpMPass.setText(selectedManager.getPassword());
            if (selectedManager.getGender().equals(Gender.Male)) {
                rdMale.setSelected(true);
                rdFemale.setSelected(false);
            } else {
                rdMale.setSelected(false);
                rdFemale.setSelected(true);
            }
        }
    }

    public void loadPolicyDataToForm(MouseEvent event) {
        selectedPolicy = policyTable.getSelectionModel().getSelectedItem();

        inpPID.clear();
        inpPName.clear();
        inpPTerm.clear();
        inpPAmount.clear();
        inpPFAmount.clear();
        inpPI.clear();
        inpBp.clear();
        inpBRT.clear();
        inpPolicyDesc.clear();

        if (selectedPolicy != null) {
            inpPID.setText(selectedPolicy.getPid() + "");
            inpPName.setText(selectedPolicy.getPname());
            inpPTerm.setText(selectedPolicy.getPterm());
            inpPAmount.setText(selectedPolicy.getPamt() + "");
            inpPFAmount.setText(selectedPolicy.getPfamt() + "");
            inpPI.setText(selectedPolicy.getPint() + "");
            inpBp.setText(selectedPolicy.getPbper() + "");
            inpBRT.setText(selectedPolicy.getPrat() + "");
            inpPolicyDesc.setText(selectedPolicy.getDesc());
        }
    }

    public void clearBranchForm(ActionEvent actionEvent) {
        branchTable.getSelectionModel().clearSelection();
        inpBranch.clear();
        inpLocation.clear();
        inpPhone.clear();
        inpState.clear();
        inpBranchId.clear();
    }

    public void clearManagerAgentForm(ActionEvent event) {
        managerAgentTable.getSelectionModel().clearSelection();
        inpMAgentID.clear();
        inpMContact.clear();
        inpMAgentName.clear();
        inpMFName.clear();
        inpM_Age.clear();
        inpMQua.clear();
        inpMOcc.clear();
        inpM_Addr.clear();
        inpMDeposit.clear();
        drpMManager.getSelectionModel().clearSelection();
        inpMPassword.clear();
        rdMAgentMale.setSelected(false);
        rdMAgentFemale.setSelected(false);
    }

    public void clearPolicyForm(ActionEvent actionEvent) {
        policyTable.getSelectionModel().clearSelection();
        inpPID.clear();
        inpPName.clear();
        inpPTerm.clear();
        inpPAmount.clear();
        inpPFAmount.clear();
        inpPI.clear();
        inpBp.clear();
        inpBRT.clear();
        inpPolicyDesc.clear();
    }

    public void clearManagerForm(ActionEvent actionEvent) {
        managerTable.getSelectionModel().clearSelection();
        inpMId.clear();
        inpMName.clear();
        inpMAge.clear();
        inpMFather.clear();
        inpMPhone.clear();
        inpMQuali.clear();
        inpMAddr.clear();
        drpBranch.getSelectionModel().clearSelection();
        inpMPass.clear();
        rdMale.setSelected(false);
        rdFemale.setSelected(false);
    }

    public void exportDataToExcel(ActionEvent actionEvent) {
        Button btnExport = (Button) actionEvent.getSource();
        Stage thisStage = (Stage) (btnExport.getScene().getWindow());
        File selectedDirectory = directoryChooser.showDialog(thisStage);

        Alert fileFormatAlert = new Alert(AlertType.CONFIRMATION);
        fileFormatAlert.setTitle("Eksportuj format pliku");
        fileFormatAlert.setHeaderText("Wybierz format pliku");

        ButtonType pdf = new ButtonType("Pdf");
        ButtonType excel = new ButtonType("Excel/CSV");

        // Remove default ButtonTypes
        fileFormatAlert.getButtonTypes().clear();

        fileFormatAlert.getButtonTypes().addAll(pdf, excel);

        // option != null.
        Optional<ButtonType> option = fileFormatAlert.showAndWait();

        option.get();

        if (option.get() == pdf) {
            try {
                if (btnExport.equals(btnBranchExport)) {
                    if (selectedDirectory != null) {
                        Document my_pdf_report = new Document();
                        PdfWriter.getInstance(my_pdf_report, new FileOutputStream(selectedDirectory + "\\Dane_Oddzialu.pdf"));
                        my_pdf_report.open();

                        PdfPTable my_report_table = new PdfPTable(branchTable.getColumns().size());

                        for (int j = 0; j < branchTable.getColumns().size(); j++) {
                            my_report_table.addCell(branchTable.getColumns().get(j).getText());
                        }
                        for (int i = 0; i < branchTable.getItems().size(); i++) {
                            PdfPCell idCell = new PdfPCell(new Phrase(String.valueOf(branchTable.getItems().get(i).getId())));
                            my_report_table.addCell(idCell);
                            PdfPCell nameCell = new PdfPCell(new Phrase(String.valueOf(branchTable.getItems().get(i).getName())));
                            my_report_table.addCell(nameCell);
                            PdfPCell locationCell = new PdfPCell(new Phrase(String.valueOf(branchTable.getItems().get(i).getLocation())));
                            my_report_table.addCell(locationCell);
                            PdfPCell phoneCell = new PdfPCell(new Phrase(String.valueOf(branchTable.getItems().get(i).getPhone())));
                            my_report_table.addCell(phoneCell);
                            PdfPCell stateCell = new PdfPCell(new Phrase(String.valueOf(branchTable.getItems().get(i).getState())));
                            my_report_table.addCell(stateCell);
                        }
                        my_pdf_report.add(my_report_table);
                        my_pdf_report.close();
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Sukces");
                        alert.setContentText("Raport oddziału został wygenerowany pomyślnie");
                        alert.show();
                    } else {
                        Alert alert = new Alert(AlertType.ERROR);
                        alert.setTitle("Błąd");
                        alert.setContentText("Operacja anulowana");
                        alert.show();
                    }
                } else if (btnExport.equals(btnPExport)) {
                    if (selectedDirectory != null) {
                        try {
                            Document my_pdf_report = new Document();
                            PdfWriter.getInstance(my_pdf_report, new FileOutputStream(selectedDirectory + "\\Dane_Polisy.pdf"));
                            my_pdf_report.open();

                            PdfPTable my_report_table = new PdfPTable(policyTable.getColumns().size());

                            for (int j = 0; j < policyTable.getColumns().size(); j++) {
                                my_report_table.addCell(policyTable.getColumns().get(j).getText());
                            }
                            for (int i = 0; i < policyTable.getItems().size(); i++) {
                                PdfPCell idCell = new PdfPCell(new Phrase(String.valueOf(policyTable.getItems().get(i).getId())));
                                my_report_table.addCell(idCell);
                                PdfPCell pidCell = new PdfPCell(new Phrase(String.valueOf(policyTable.getItems().get(i).getPid())));
                                my_report_table.addCell(pidCell);
                                PdfPCell nameCell = new PdfPCell(new Phrase(String.valueOf(policyTable.getItems().get(i).getPname())));
                                my_report_table.addCell(nameCell);
                                PdfPCell termCell = new PdfPCell(new Phrase(String.valueOf(policyTable.getItems().get(i).getPterm())));
                                my_report_table.addCell(termCell);
                                PdfPCell amountCell = new PdfPCell(new Phrase(String.valueOf(policyTable.getItems().get(i).getPamt())));
                                my_report_table.addCell(amountCell);
                                PdfPCell faceAmountCell = new PdfPCell(new Phrase(String.valueOf(policyTable.getItems().get(i).getPfamt())));
                                my_report_table.addCell(faceAmountCell);
                                PdfPCell intrCell = new PdfPCell(new Phrase(String.valueOf(policyTable.getItems().get(i).getPint())));
                                my_report_table.addCell(intrCell);
                                PdfPCell bonusPCell = new PdfPCell(new Phrase(String.valueOf(policyTable.getItems().get(i).getPbper())));
                                my_report_table.addCell(bonusPCell);
                                PdfPCell bonusRCell = new PdfPCell(new Phrase(String.valueOf(policyTable.getItems().get(i).getPrat())));
                                my_report_table.addCell(bonusRCell);
                            }
                            my_pdf_report.add(my_report_table);
                            my_pdf_report.close();
                            Alert alert = new Alert(AlertType.INFORMATION);
                            alert.setTitle("Sukces");
                            alert.setContentText("Raport dotyczący zasad został pomyślnie wygenerowany");
                            alert.show();
                        } catch (DocumentException | FileNotFoundException e) {
                            e.printStackTrace();
                        }
                    } else {
                        Alert alert = new Alert(AlertType.ERROR);
                        alert.setTitle("Błąd");
                        alert.setContentText("Operacja anulowana");
                        alert.show();
                    }
                } else if (btnExport.equals(btnManagerExport)) {
                    if (selectedDirectory != null) {
                        Document my_pdf_report = new Document();
                        PdfWriter.getInstance(my_pdf_report, new FileOutputStream(selectedDirectory + "\\ManagerData.pdf"));
                        my_pdf_report.open();

                        PdfPTable my_report_table = new PdfPTable(managerTable.getColumns().size());

                        for (int j = 0; j < managerTable.getColumns().size(); j++) {
                            my_report_table.addCell(managerTable.getColumns().get(j).getText());
                        }
                        for (int i = 0; i < managerTable.getItems().size(); i++) {
                            PdfPCell idCell = new PdfPCell(new Phrase(String.valueOf(managerTable.getItems().get(i).getId())));
                            my_report_table.addCell(idCell);
                            PdfPCell nameCell = new PdfPCell(new Phrase(String.valueOf(managerTable.getItems().get(i).getName())));
                            my_report_table.addCell(nameCell);
                            PdfPCell branchCell = new PdfPCell(new Phrase(String.valueOf(managerTable.getItems().get(i).getBname())));
                            my_report_table.addCell(branchCell);
                            PdfPCell phoneCell = new PdfPCell(new Phrase(String.valueOf(managerTable.getItems().get(i).getPhone())));
                            my_report_table.addCell(phoneCell);
                        }
                        my_pdf_report.add(my_report_table);
                        my_pdf_report.close();
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Sukces");
                        alert.setContentText("Raport menedżera został wygenerowany pomyślnie");
                        alert.show();
                    } else {
                        Alert alert = new Alert(AlertType.ERROR);
                        alert.setTitle("Błąd");
                        alert.setContentText("Operacja anulowana");
                        alert.show();
                    }
                } else if (btnExport.equals(btnAgentMGExport)) {
                    if (selectedDirectory != null) {
                        Document my_pdf_report = new Document();
                        PdfWriter.getInstance(my_pdf_report, new FileOutputStream(selectedDirectory + "\\AgentManagerData.pdf"));
                        my_pdf_report.open();

                        PdfPTable my_report_table = new PdfPTable(agentManagerTable.getColumns().size());
                        for (int j = 0; j < agentManagerTable.getColumns().size(); j++) {
                            my_report_table.addCell(agentManagerTable.getColumns().get(j).getText());
                        }
                        for (int i = 0; i < agentManagerTable.getItems().size(); i++) {
                            PdfPCell idCell = new PdfPCell(new Phrase(String.valueOf(agentManagerTable.getItems().get(i).getMid())));
                            my_report_table.addCell(idCell);
                            PdfPCell nameCell = new PdfPCell(new Phrase(String.valueOf(agentManagerTable.getItems().get(i).getName())));
                            my_report_table.addCell(nameCell);
                            PdfPCell branchCell = new PdfPCell(new Phrase(String.valueOf(agentManagerTable.getItems().get(i).getBname())));
                            my_report_table.addCell(branchCell);
                            PdfPCell phoneCell = new PdfPCell(new Phrase(String.valueOf(agentManagerTable.getItems().get(i).getPhone())));
                            my_report_table.addCell(phoneCell);
                        }
                        my_pdf_report.add(my_report_table);
                        my_pdf_report.close();
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Sukces");
                        alert.setContentText("Raport menedżera został wygenerowany pomyślnie");
                        alert.show();
                    } else {
                        Alert alert = new Alert(AlertType.ERROR);
                        alert.setTitle("Błąd");
                        alert.setContentText("Operacja anulowana");
                        alert.show();
                    }
                } else if (btnExport.equals(btnPoliExport)) {
                    if (selectedDirectory != null) {

                        Document my_pdf_report = new Document();
                        PdfWriter.getInstance(my_pdf_report, new FileOutputStream(selectedDirectory + "\\Agent_Polisa_Data.pdf"));
                        my_pdf_report.open();

                        PdfPTable my_report_table = new PdfPTable(agentCustomerPolicyTable.getColumns().size());
                        for (int j = 0; j < agentCustomerPolicyTable.getColumns().size(); j++) {
                            my_report_table.addCell(agentCustomerPolicyTable.getColumns().get(j).getText());
                        }
                        for (int i = 0; i < agentCustomerPolicyTable.getItems().size(); i++) {
                            PdfPCell idCell = new PdfPCell(new Phrase(String.valueOf(agentCustomerPolicyTable.getItems().get(i).getId())));
                            my_report_table.addCell(idCell);
                            PdfPCell pidCell = new PdfPCell(new Phrase(String.valueOf(agentCustomerPolicyTable.getItems().get(i).getPid())));
                            my_report_table.addCell(pidCell);
                            PdfPCell pNameCell = new PdfPCell(new Phrase(String.valueOf(agentCustomerPolicyTable.getItems().get(i).getPname())));
                            my_report_table.addCell(pNameCell);
                            PdfPCell pTermCell = new PdfPCell(new Phrase(String.valueOf(agentCustomerPolicyTable.getItems().get(i).getPterm())));
                            my_report_table.addCell(pTermCell);
                            PdfPCell pAmtCell = new PdfPCell(new Phrase(String.valueOf(agentCustomerPolicyTable.getItems().get(i).getPamt())));
                            my_report_table.addCell(pAmtCell);
                            PdfPCell pFamtCell = new PdfPCell(new Phrase(String.valueOf(agentCustomerPolicyTable.getItems().get(i).getPfamt())));
                            my_report_table.addCell(pFamtCell);
                            PdfPCell pIntrCell = new PdfPCell(new Phrase(String.valueOf(agentCustomerPolicyTable.getItems().get(i).getPint())));
                            my_report_table.addCell(pIntrCell);
                            PdfPCell pbBPerCell = new PdfPCell(new Phrase(String.valueOf(agentCustomerPolicyTable.getItems().get(i).getPbper())));
                            my_report_table.addCell(pbBPerCell);
                            PdfPCell pRatCell = new PdfPCell(new Phrase(String.valueOf(agentCustomerPolicyTable.getItems().get(i).getPrat())));
                            my_report_table.addCell(pRatCell);
                            PdfPCell pDescCell = new PdfPCell(new Phrase(String.valueOf(agentCustomerPolicyTable.getItems().get(i).getDesc())));
                            my_report_table.addCell(pDescCell);
                        }
                        my_pdf_report.add(my_report_table);
                        my_pdf_report.close();
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Sukces");
                        alert.setContentText("Raport dotyczący polis został pomyślnie wygenerowany");
                        alert.show();
                    } else {
                        Alert alert = new Alert(AlertType.ERROR);
                        alert.setTitle("Błąd");
                        alert.setContentText("Operacja anulowana");
                        alert.show();
                    }
                } else if (btnExport.equals(btnCustExport)) {
                    if (selectedDirectory != null) {
                        Document my_pdf_report = new Document();
                        PdfWriter.getInstance(my_pdf_report, new FileOutputStream(selectedDirectory + "\\Agent_Klient_Dane.pdf"));
                        my_pdf_report.open();

                        PdfPTable my_report_table = new PdfPTable(agentCustomerDetailsTable.getColumns().size());
                        for (int j = 0; j < agentCustomerDetailsTable.getColumns().size(); j++) {
                            my_report_table.addCell(agentCustomerDetailsTable.getColumns().get(j).getText());
                        }

                        for (int i = 0; i < agentCustomerDetailsTable.getItems().size(); i++) {
                            PdfPCell idCell = new PdfPCell(new Phrase(String.valueOf(agentCustomerDetailsTable.getItems().get(i).getId())));
                            my_report_table.addCell(idCell);
                            PdfPCell cidCell = new PdfPCell(new Phrase(String.valueOf(agentCustomerDetailsTable.getItems().get(i).getCid())));
                            my_report_table.addCell(cidCell);
                            PdfPCell fnameCell = new PdfPCell(new Phrase(String.valueOf(agentCustomerDetailsTable.getItems().get(i).getFname())));
                            my_report_table.addCell(fnameCell);
                            PdfPCell ageCell = new PdfPCell(new Phrase(String.valueOf(agentCustomerDetailsTable.getItems().get(i).getAge())));
                            my_report_table.addCell(ageCell);
                            PdfPCell genCell = new PdfPCell(new Phrase(agentCustomerDetailsTable.getItems().get(i).getGender().name()));
                            my_report_table.addCell(genCell);
                            PdfPCell quaCell = new PdfPCell(new Phrase(String.valueOf(agentCustomerDetailsTable.getItems().get(i).getQua())));
                            my_report_table.addCell(quaCell);
                            PdfPCell caddCell = new PdfPCell(new Phrase(String.valueOf(agentCustomerDetailsTable.getItems().get(i).getCadd())));
                            my_report_table.addCell(caddCell);
                            PdfPCell occCell = new PdfPCell(new Phrase(String.valueOf(agentCustomerDetailsTable.getItems().get(i).getOcc())));
                            my_report_table.addCell(occCell);
                            PdfPCell agNameCell = new PdfPCell(new Phrase(String.valueOf(agentCustomerDetailsTable.getItems().get(i).getAgname())));
                            my_report_table.addCell(agNameCell);
                            PdfPCell phnoCell = new PdfPCell(new Phrase(String.valueOf(agentCustomerDetailsTable.getItems().get(i).getPhno())));
                            my_report_table.addCell(phnoCell);
                        }
                        my_pdf_report.add(my_report_table);
                        my_pdf_report.close();

                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Sukces");
                        alert.setContentText("Raport klienta został wygenerowany pomyślnie");
                        alert.show();
                    } else {
                        Alert alert = new Alert(AlertType.ERROR);
                        alert.setTitle("Bład");
                        alert.setContentText("Operacja anulowana");
                        alert.show();
                    }
                } else if (btnExport.equals(btnCusAgentExport)) {
                    if (selectedDirectory != null) {

                        Document my_pdf_report = new Document();
                        PdfWriter.getInstance(my_pdf_report, new FileOutputStream(selectedDirectory + "\\Klient_Agent_Data.pdf"));
                        my_pdf_report.open();

                        PdfPTable my_report_table = new PdfPTable(customerAgentTable.getColumns().size());
                        for (int j = 0; j < customerAgentTable.getColumns().size(); j++) {
                            my_report_table.addCell(customerAgentTable.getColumns().get(j).getText());
                        }

                        for (int i = 0; i < customerAgentTable.getItems().size(); i++) {
                            PdfPCell idCell = new PdfPCell(new Phrase(String.valueOf(customerAgentTable.getItems().get(i).getId())));
                            my_report_table.addCell(idCell);
                            PdfPCell aidCell = new PdfPCell(new Phrase(String.valueOf(customerAgentTable.getItems().get(i).getAid())));
                            my_report_table.addCell(aidCell);
                            PdfPCell nameCell = new PdfPCell(new Phrase(String.valueOf(customerAgentTable.getItems().get(i).getName())));
                            my_report_table.addCell(nameCell);
                            PdfPCell posCell = new PdfPCell(new Phrase(String.valueOf(customerAgentTable.getItems().get(i).getOccu())));
                            my_report_table.addCell(posCell);
                            PdfPCell phnoCell = new PdfPCell(new Phrase(String.valueOf(customerAgentTable.getItems().get(i).getPhno())));
                            my_report_table.addCell(phnoCell);
                        }
                        my_pdf_report.add(my_report_table);
                        my_pdf_report.close();

                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Sukces");
                        alert.setContentText("Raport agenta został wygenerowany pomyślnie");
                        alert.show();
                    } else {
                        Alert alert = new Alert(AlertType.ERROR);
                        alert.setTitle("Błąd");
                        alert.setContentText("Operacja anulowana");
                        alert.show();
                    }
                } else if (btnExport.equals(btnCustPoliExport)) {
                    if (selectedDirectory != null) {
                        Document my_pdf_report = new Document();
                        PdfWriter.getInstance(my_pdf_report, new FileOutputStream(selectedDirectory + "\\Klient_Polisa_Data.pdf"));
                        my_pdf_report.open();

                        PdfPTable my_report_table = new PdfPTable(customerPolicyTable.getColumns().size());
                        for (int j = 0; j < customerPolicyTable.getColumns().size(); j++) {
                            my_report_table.addCell(customerPolicyTable.getColumns().get(j).getText());
                        }
                        for (int i = 0; i < customerPolicyTable.getItems().size(); i++) {
                            PdfPCell idCell = new PdfPCell(new Phrase(String.valueOf(customerPolicyTable.getItems().get(i).getId())));
                            my_report_table.addCell(idCell);
                            PdfPCell pidCell = new PdfPCell(new Phrase(String.valueOf(customerPolicyTable.getItems().get(i).getPid())));
                            my_report_table.addCell(pidCell);
                            PdfPCell pNameCell = new PdfPCell(new Phrase(String.valueOf(customerPolicyTable.getItems().get(i).getPname())));
                            my_report_table.addCell(pNameCell);
                            PdfPCell pTermCell = new PdfPCell(new Phrase(String.valueOf(customerPolicyTable.getItems().get(i).getPterm())));
                            my_report_table.addCell(pTermCell);
                            PdfPCell pAmtCell = new PdfPCell(new Phrase(String.valueOf(customerPolicyTable.getItems().get(i).getPamt())));
                            my_report_table.addCell(pAmtCell);
                            PdfPCell pFamtCell = new PdfPCell(new Phrase(String.valueOf(customerPolicyTable.getItems().get(i).getPfamt())));
                            my_report_table.addCell(pFamtCell);
                            PdfPCell pIntrCell = new PdfPCell(new Phrase(String.valueOf(customerPolicyTable.getItems().get(i).getPint())));
                            my_report_table.addCell(pIntrCell);
                            PdfPCell pbBPerCell = new PdfPCell(new Phrase(String.valueOf(customerPolicyTable.getItems().get(i).getPbper())));
                            my_report_table.addCell(pbBPerCell);
                            PdfPCell pRatCell = new PdfPCell(new Phrase(String.valueOf(customerPolicyTable.getItems().get(i).getPrat())));
                            my_report_table.addCell(pRatCell);
                        }
                        my_pdf_report.add(my_report_table);
                        my_pdf_report.close();
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Sukces");
                        alert.setContentText("Raport dotyczący polis został pomyślnie wygenerowany");
                        alert.show();
                    } else {
                        Alert alert = new Alert(AlertType.ERROR);
                        alert.setTitle("Błąd");
                        alert.setContentText("Operacja anulowana");
                        alert.show();
                    }
                } else if (btnExport.equals(btnMAgExport)) {
                    if (selectedDirectory != null) {
                        Document my_pdf_report = new Document();
                        PdfWriter.getInstance(my_pdf_report, new FileOutputStream(selectedDirectory + "\\Menadzer_Agent.pdf"));
                        my_pdf_report.open();

                        PdfPTable my_report_table = new PdfPTable(managerAgentTable.getColumns().size());
                        for (int j = 0; j < managerAgentTable.getColumns().size(); j++) {
                            my_report_table.addCell(managerAgentTable.getColumns().get(j).getText());
                        }

                        for (int i = 0; i < managerAgentTable.getItems().size(); i++) {
                            PdfPCell idCell = new PdfPCell(new Phrase(String.valueOf(managerAgentTable.getItems().get(i).getId())));
                            my_report_table.addCell(idCell);
                            PdfPCell aidCell = new PdfPCell(new Phrase(String.valueOf(managerAgentTable.getItems().get(i).getAid())));
                            my_report_table.addCell(aidCell);
                            PdfPCell nameCell = new PdfPCell(new Phrase(String.valueOf(managerAgentTable.getItems().get(i).getName())));
                            my_report_table.addCell(nameCell);
                            PdfPCell fnameCell = new PdfPCell(new Phrase(String.valueOf(managerAgentTable.getItems().get(i).getFname())));
                            my_report_table.addCell(fnameCell);
                            PdfPCell ageCell = new PdfPCell(new Phrase(String.valueOf(managerAgentTable.getItems().get(i).getAge())));
                            my_report_table.addCell(ageCell);
                            PdfPCell genCell = new PdfPCell(new Phrase(managerAgentTable.getItems().get(i).getGender().name()));
                            my_report_table.addCell(genCell);
                            PdfPCell quaCell = new PdfPCell(new Phrase(String.valueOf(managerAgentTable.getItems().get(i).getOcc())));
                            my_report_table.addCell(quaCell);
                            PdfPCell caddCell = new PdfPCell(new Phrase(String.valueOf(managerAgentTable.getItems().get(i).getAddr())));
                            my_report_table.addCell(caddCell);
                            PdfPCell depoCell = new PdfPCell(new Phrase(String.valueOf(managerAgentTable.getItems().get(i).getSec())));
                            my_report_table.addCell(depoCell);
                            PdfPCell mnameCell = new PdfPCell(new Phrase(String.valueOf(managerAgentTable.getItems().get(i).getMname())));
                            my_report_table.addCell(mnameCell);
                            PdfPCell phnoCell = new PdfPCell(new Phrase(String.valueOf(managerAgentTable.getItems().get(i).getPhno())));
                            my_report_table.addCell(phnoCell);
                        }
                        my_pdf_report.add(my_report_table);
                        my_pdf_report.close();

                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Sukces");
                        alert.setContentText("Raport Agenta, menedżera został pomyślnie wygenerowany");
                        alert.show();
                    } else {
                        Alert alert = new Alert(AlertType.ERROR);
                        alert.setTitle("Błąd");
                        alert.setContentText("Operacja anulowana");
                        alert.show();
                    }
                } else if (btnExport.equals(btnMCusExport)) {
                    if (selectedDirectory != null) {

                        Document my_pdf_report = new Document();
                        PdfWriter.getInstance(my_pdf_report, new FileOutputStream(selectedDirectory + "\\Menadzer_Klient_Dane.pdf"));
                        my_pdf_report.open();

                        PdfPTable my_report_table = new PdfPTable(managerCustomerTable.getColumns().size());
                        for (int j = 0; j < managerCustomerTable.getColumns().size(); j++) {
                            my_report_table.addCell(managerCustomerTable.getColumns().get(j).getText());
                        }

                        for (int i = 0; i < managerCustomerTable.getItems().size(); i++) {
                            PdfPCell idCell = new PdfPCell(new Phrase(String.valueOf(managerCustomerTable.getItems().get(i).getId())));
                            my_report_table.addCell(idCell);
                            PdfPCell cidCell = new PdfPCell(new Phrase(String.valueOf(managerCustomerTable.getItems().get(i).getCid())));
                            my_report_table.addCell(cidCell);
                            PdfPCell nameCell = new PdfPCell(new Phrase(String.valueOf(managerCustomerTable.getItems().get(i).getName())));
                            my_report_table.addCell(nameCell);
                            PdfPCell fnameCell = new PdfPCell(new Phrase(String.valueOf(managerCustomerTable.getItems().get(i).getFname())));
                            my_report_table.addCell(fnameCell);
                            PdfPCell ageCell = new PdfPCell(new Phrase(String.valueOf(managerCustomerTable.getItems().get(i).getAge())));
                            my_report_table.addCell(ageCell);
                            PdfPCell genCell = new PdfPCell(new Phrase(managerCustomerTable.getItems().get(i).getGender().name()));
                            my_report_table.addCell(genCell);
                            PdfPCell quaCell = new PdfPCell(new Phrase(String.valueOf(managerCustomerTable.getItems().get(i).getQua())));
                            my_report_table.addCell(quaCell);
                            PdfPCell caddCell = new PdfPCell(new Phrase(String.valueOf(managerCustomerTable.getItems().get(i).getCadd())));
                            my_report_table.addCell(caddCell);
                            PdfPCell occCell = new PdfPCell(new Phrase(String.valueOf(managerCustomerTable.getItems().get(i).getOcc())));
                            my_report_table.addCell(occCell);
                            PdfPCell phnoCell = new PdfPCell(new Phrase(String.valueOf(managerCustomerTable.getItems().get(i).getPhno())));
                            my_report_table.addCell(phnoCell);
                        }
                        my_pdf_report.add(my_report_table);
                        my_pdf_report.close();

                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Sukces");
                        alert.setContentText("Raport dla klienta został wygenerowany pomyślnie");
                        alert.show();
                    } else {
                        Alert alert = new Alert(AlertType.ERROR);
                        alert.setTitle("Błąd");
                        alert.setContentText("Operacja anulowana");
                        alert.show();
                    }
                } else if (btnExport.equals(btnMCusPoliExport)) {
                    if (selectedDirectory != null) {

                        Document my_pdf_report = new Document();
                        PdfWriter.getInstance(my_pdf_report, new FileOutputStream(selectedDirectory + "\\Menadzer_Klient_Dane_Polisy.pdf"));
                        my_pdf_report.open();

                        PdfPTable my_report_table = new PdfPTable(managerCusPoliTable.getColumns().size());
                        for (int j = 0; j < managerCusPoliTable.getColumns().size(); j++) {
                            my_report_table.addCell(managerCusPoliTable.getColumns().get(j).getText());
                        }

                        for (int i = 0; i < managerCusPoliTable.getItems().size(); i++) {
                            for (int j = 0; j < managerCusPoliTable.getColumns().size(); j++) {
                                if (managerCusPoliTable.getColumns().get(j).getCellData(i) != null) {
                                    PdfPCell cell = new PdfPCell(new Phrase(managerCusPoliTable.getColumns().get(j).getCellData(i).toString()));
                                    my_report_table.addCell(cell);
                                }
                            }
                        }
                        my_pdf_report.add(my_report_table);
                        my_pdf_report.close();

                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Sukces");
                        alert.setContentText("Raport Polisy, Klienta został wygenerowany pomyślnie");
                        alert.show();
                    } else {
                        Alert alert = new Alert(AlertType.ERROR);
                        alert.setTitle("Błąd");
                        alert.setContentText("Operacja anulowana");
                        alert.show();
                    }
                }
            } catch (DocumentException | FileNotFoundException e) {
                e.printStackTrace();
            }
        } else if (option.get() == excel) {
            if (btnExport.equals(btnBranchExport)) {
                if (selectedDirectory != null) {
                    @SuppressWarnings("resource") Workbook workbook = new HSSFWorkbook();
                    Sheet spreadsheet = workbook.createSheet("Dane oddział");
                    Row row = spreadsheet.createRow(0);
                    for (int j = 0; j < branchTable.getColumns().size(); j++) {
                        row.createCell(j).setCellValue(branchTable.getColumns().get(j).getText());
                    }
                    for (int i = 0; i < branchTable.getItems().size(); i++) {
                        row = spreadsheet.createRow(i + 1);
                        for (int j = 0; j < branchTable.getColumns().size(); j++) {
                            if (branchTable.getColumns().get(j).getCellData(i) != null) {
                                row.createCell(j).setCellValue(branchTable.getColumns().get(j).getCellData(i).toString());
                            } else {
                                row.createCell(j).setCellValue("");
                            }
                        }
                    }
                    FileOutputStream fileOut;
                    try {
                        fileOut = new FileOutputStream(selectedDirectory + "\\Oddzial_Dane.xls");
                        workbook.write(fileOut);
                        fileOut.close();
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Sukces");
                        alert.setContentText("Raport oddziału został wygenerowany poprawnie");
                        alert.show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Błąd");
                    alert.setContentText("Operacja anulowana");
                    alert.show();
                }
            } else if (btnExport.equals(btnPExport)) {
                if (selectedDirectory != null) {
                    @SuppressWarnings("resource") Workbook workbook = new HSSFWorkbook();
                    Sheet spreadsheet = workbook.createSheet("Dane polisy");
                    Row row = spreadsheet.createRow(0);
                    for (int j = 0; j < policyTable.getColumns().size(); j++) {
                        row.createCell(j).setCellValue(policyTable.getColumns().get(j).getText());
                    }
                    for (int i = 0; i < policyTable.getItems().size(); i++) {
                        row = spreadsheet.createRow(i + 1);
                        for (int j = 0; j < policyTable.getColumns().size(); j++) {
                            if (policyTable.getColumns().get(j).getCellData(i) != null) {
                                row.createCell(j).setCellValue(policyTable.getColumns().get(j).getCellData(i).toString());
                            } else {
                                row.createCell(j).setCellValue("");
                            }
                        }
                    }
                    FileOutputStream fileOut;
                    try {
                        fileOut = new FileOutputStream(selectedDirectory + "\\Dane_Polisy.xls");
                        workbook.write(fileOut);
                        fileOut.close();
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Sukces");
                        alert.setContentText("Raport polisy został wygenerowany poprawnie");
                        alert.show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Błąd");
                    alert.setContentText("Operacja anulowana");
                    alert.show();
                }
            } else if (btnExport.equals(btnManagerExport)) {
                if (selectedDirectory != null) {
                    @SuppressWarnings("resource") Workbook workbook = new HSSFWorkbook();
                    Sheet spreadsheet = workbook.createSheet("Dane Menadzer");
                    Row row = spreadsheet.createRow(0);
                    for (int j = 0; j < managerTable.getColumns().size(); j++) {
                        row.createCell(j).setCellValue(managerTable.getColumns().get(j).getText());
                    }
                    for (int i = 0; i < managerTable.getItems().size(); i++) {
                        row = spreadsheet.createRow(i + 1);
                        for (int j = 0; j < managerTable.getColumns().size(); j++) {
                            if (managerTable.getColumns().get(j).getCellData(i) != null) {
                                row.createCell(j).setCellValue(managerTable.getColumns().get(j).getCellData(i).toString());
                            } else {
                                row.createCell(j).setCellValue("");
                            }
                        }
                    }
                    FileOutputStream fileOut;
                    try {
                        fileOut = new FileOutputStream(selectedDirectory + "\\Menager_Dane.xls");
                        workbook.write(fileOut);
                        fileOut.close();
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Sukces");
                        alert.setContentText("Raport menadżera został wygenerowany poprawnie");
                        alert.show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Błąd");
                    alert.setContentText("Operacja anulowana");
                    alert.show();
                }
            } else if (btnExport.equals(btnAgentMGExport)) {
                if (selectedDirectory != null) {
                    @SuppressWarnings("resource") Workbook workbook = new HSSFWorkbook();
                    Sheet spreadsheet = workbook.createSheet("Agent Menadżer Dane");
                    Row row = spreadsheet.createRow(0);
                    for (int j = 0; j < agentManagerTable.getColumns().size(); j++) {
                        row.createCell(j).setCellValue(agentManagerTable.getColumns().get(j).getText());
                    }
                    for (int i = 0; i < agentManagerTable.getItems().size(); i++) {
                        row = spreadsheet.createRow(i + 1);
                        for (int j = 0; j < agentManagerTable.getColumns().size(); j++) {
                            if (agentManagerTable.getColumns().get(j).getCellData(i) != null) {
                                row.createCell(j).setCellValue(agentManagerTable.getColumns().get(j).getCellData(i).toString());
                            } else {
                                row.createCell(j).setCellValue("");
                            }
                        }
                    }
                    FileOutputStream fileOut;
                    try {
                        fileOut = new FileOutputStream(selectedDirectory + "\\Agent_Menadzer_Dane.xls");
                        workbook.write(fileOut);
                        fileOut.close();
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Sukces");
                        alert.setContentText("Raport menadżera został wygenerowany poprawnie");
                        alert.show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Błąd");
                    alert.setContentText("Operacja anulowana");
                    alert.show();
                }
            } else if (btnExport.equals(btnPoliExport)) {
                if (selectedDirectory != null) {
                    @SuppressWarnings("resource") Workbook workbook = new HSSFWorkbook();
                    Sheet spreadsheet = workbook.createSheet("Dane Polisy");
                    Row row = spreadsheet.createRow(0);
                    for (int j = 0; j < agentCustomerPolicyTable.getColumns().size(); j++) {
                        row.createCell(j).setCellValue(agentCustomerPolicyTable.getColumns().get(j).getText());
                    }
                    for (int i = 0; i < agentCustomerPolicyTable.getItems().size(); i++) {
                        row = spreadsheet.createRow(i + 1);
                        for (int j = 0; j < agentCustomerPolicyTable.getColumns().size(); j++) {
                            if (agentCustomerPolicyTable.getColumns().get(j).getCellData(i) != null) {
                                row.createCell(j).setCellValue(agentCustomerPolicyTable.getColumns().get(j).getCellData(i).toString());
                            } else {
                                row.createCell(j).setCellValue("");
                            }
                        }
                    }
                    FileOutputStream fileOut;
                    try {
                        fileOut = new FileOutputStream(selectedDirectory + "\\Agent_Polisa_Dane.xls");
                        workbook.write(fileOut);
                        fileOut.close();
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Sukces");
                        alert.setContentText("Raport polisy został wygenerowany poprawnie");
                        alert.show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Błąd");
                    alert.setContentText("Operacja anulowana");
                    alert.show();
                }
            } else if (btnExport.equals(btnCustExport)) {
                if (selectedDirectory != null) {
                    @SuppressWarnings("resource") Workbook workbook = new HSSFWorkbook();
                    Sheet spreadsheet = workbook.createSheet("Agent Klient Dane");
                    Row row = spreadsheet.createRow(0);
                    for (int j = 0; j < agentCustomerDetailsTable.getColumns().size(); j++) {
                        row.createCell(j).setCellValue(agentCustomerDetailsTable.getColumns().get(j).getText());
                    }
                    for (int i = 0; i < agentCustomerDetailsTable.getItems().size(); i++) {
                        row = spreadsheet.createRow(i + 1);
                        for (int j = 0; j < agentCustomerDetailsTable.getColumns().size(); j++) {
                            if (agentCustomerDetailsTable.getColumns().get(j).getCellData(i) != null) {
                                row.createCell(j).setCellValue(agentCustomerDetailsTable.getColumns().get(j).getCellData(i).toString());
                            } else {
                                row.createCell(j).setCellValue("");
                            }
                        }
                    }
                    FileOutputStream fileOut;
                    try {
                        fileOut = new FileOutputStream(selectedDirectory + "\\Agent_Klient_Dane.xls");
                        workbook.write(fileOut);
                        fileOut.close();
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Sukces");
                        alert.setContentText("Raport klienta został wygenerowany poprawnie");
                        alert.show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Błąd");
                    alert.setContentText("Operacja anulowana");
                    alert.show();
                }
            } else if (btnExport.equals(btnCusAgentExport)) {
                if (selectedDirectory != null) {
                    @SuppressWarnings("resource") Workbook workbook = new HSSFWorkbook();
                    Sheet spreadsheet = workbook.createSheet("Klient Agent Dane");
                    Row row = spreadsheet.createRow(0);
                    for (int j = 0; j < customerAgentTable.getColumns().size(); j++) {
                        row.createCell(j).setCellValue(customerAgentTable.getColumns().get(j).getText());
                    }
                    for (int i = 0; i < customerAgentTable.getItems().size(); i++) {
                        row = spreadsheet.createRow(i + 1);
                        for (int j = 0; j < customerAgentTable.getColumns().size(); j++) {
                            if (customerAgentTable.getColumns().get(j).getCellData(i) != null) {
                                row.createCell(j).setCellValue(customerAgentTable.getColumns().get(j).getCellData(i).toString());
                            } else {
                                row.createCell(j).setCellValue("");
                            }
                        }
                    }
                    FileOutputStream fileOut;
                    try {
                        fileOut = new FileOutputStream(selectedDirectory + "\\Klient_Agent_Dane.xls");
                        workbook.write(fileOut);
                        fileOut.close();
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Sukces");
                        alert.setContentText("Raport agenta został wygenerowany poprawnie");
                        alert.show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Błąd");
                    alert.setContentText("Operacja anulowana");
                    alert.show();
                }
            } else if (btnExport.equals(btnCustPoliExport)) {
                if (selectedDirectory != null) {
                    @SuppressWarnings("resource") Workbook workbook = new HSSFWorkbook();
                    Sheet spreadsheet = workbook.createSheet("Klient Agent Dane");
                    Row row = spreadsheet.createRow(0);
                    for (int j = 0; j < customerPolicyTable.getColumns().size(); j++) {
                        row.createCell(j).setCellValue(customerPolicyTable.getColumns().get(j).getText());
                    }
                    for (int i = 0; i < customerPolicyTable.getItems().size(); i++) {
                        row = spreadsheet.createRow(i + 1);
                        for (int j = 0; j < customerPolicyTable.getColumns().size(); j++) {
                            if (customerPolicyTable.getColumns().get(j).getCellData(i) != null) {
                                row.createCell(j).setCellValue(customerPolicyTable.getColumns().get(j).getCellData(i).toString());
                            } else {
                                row.createCell(j).setCellValue("");
                            }
                        }
                    }
                    FileOutputStream fileOut;
                    try {
                        fileOut = new FileOutputStream(selectedDirectory + "\\Klient_Polisa_Dane.xls");
                        workbook.write(fileOut);
                        fileOut.close();
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Sukces");
                        alert.setContentText("Raport polisy został wygenerowany poprawnie");
                        alert.show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Błąd");
                    alert.setContentText("Operacja anulowana");
                    alert.show();
                }
            } else if (btnExport.equals(btnMAgExport)) {
                if (selectedDirectory != null) {
                    @SuppressWarnings("resource") Workbook workbook = new HSSFWorkbook();
                    Sheet spreadsheet = workbook.createSheet("Menadzer Agent Dane");
                    Row row = spreadsheet.createRow(0);
                    for (int j = 0; j < managerAgentTable.getColumns().size(); j++) {
                        row.createCell(j).setCellValue(managerAgentTable.getColumns().get(j).getText());
                    }
                    for (int i = 0; i < managerAgentTable.getItems().size(); i++) {
                        row = spreadsheet.createRow(i + 1);
                        for (int j = 0; j < managerAgentTable.getColumns().size(); j++) {
                            if (managerAgentTable.getColumns().get(j).getCellData(i) != null) {
                                row.createCell(j).setCellValue(managerAgentTable.getColumns().get(j).getCellData(i).toString());
                            } else {
                                row.createCell(j).setCellValue("");
                            }
                        }
                    }
                    FileOutputStream fileOut;
                    try {
                        fileOut = new FileOutputStream(selectedDirectory + "\\Menadzer_Agent_Dane.xls");
                        workbook.write(fileOut);
                        fileOut.close();
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Sukces");
                        alert.setContentText("Raport agenta został wygenerowany poprawnie");
                        alert.show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Błąd");
                    alert.setContentText("Operacja anulowana");
                    alert.show();
                }
            } else if (btnExport.equals(btnMCusExport)) {
                if (selectedDirectory != null) {
                    @SuppressWarnings("resource") Workbook workbook = new HSSFWorkbook();
                    Sheet spreadsheet = workbook.createSheet("Menadzer Klient Dane");
                    Row row = spreadsheet.createRow(0);
                    for (int j = 0; j < managerCustomerTable.getColumns().size(); j++) {
                        row.createCell(j).setCellValue(managerCustomerTable.getColumns().get(j).getText());
                    }
                    for (int i = 0; i < managerCustomerTable.getItems().size(); i++) {
                        row = spreadsheet.createRow(i + 1);
                        for (int j = 0; j < managerCustomerTable.getColumns().size(); j++) {
                            if (managerCustomerTable.getColumns().get(j).getCellData(i) != null) {
                                row.createCell(j).setCellValue(managerCustomerTable.getColumns().get(j).getCellData(i).toString());
                            } else {
                                row.createCell(j).setCellValue("");
                            }
                        }
                    }
                    FileOutputStream fileOut;
                    try {
                        fileOut = new FileOutputStream(selectedDirectory + "\\Menadzer_Klient_Dane_Polisy.xls");
                        workbook.write(fileOut);
                        fileOut.close();
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Sukces");
                        alert.setContentText("Raport polisy klienta został wygenerowany poprawnie");
                        alert.show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Błąd");
                    alert.setContentText("Operacja anulowana");
                    alert.show();
                }
            } else if (btnExport.equals(btnMCusPoliExport)) {
                if (selectedDirectory != null) {
                    @SuppressWarnings("resource") Workbook workbook = new HSSFWorkbook();
                    Sheet spreadsheet = workbook.createSheet("Menadzer Klient Dane Polisy");
                    Row row = spreadsheet.createRow(0);
                    for (int j = 0; j < managerCusPoliTable.getColumns().size(); j++) {
                        row.createCell(j).setCellValue(managerCusPoliTable.getColumns().get(j).getText());
                    }
                    for (int i = 0; i < managerCusPoliTable.getItems().size(); i++) {
                        row = spreadsheet.createRow(i + 1);
                        for (int j = 0; j < managerCusPoliTable.getColumns().size(); j++) {
                            if (managerCusPoliTable.getColumns().get(j).getCellData(i) != null) {
                                row.createCell(j).setCellValue(managerCusPoliTable.getColumns().get(j).getCellData(i).toString());
                            } else {
                                row.createCell(j).setCellValue("");
                            }
                        }
                    }
                    FileOutputStream fileOut;
                    try {
                        fileOut = new FileOutputStream(selectedDirectory + "\\Menadzer_Klient_Dane_Polisy.xls");
                        workbook.write(fileOut);
                        fileOut.close();
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Sukces");
                        alert.setContentText("Raport polisy klienta został wygenerowany poprawnie");
                        alert.show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Błąd");
                    alert.setContentText("Operacja anulowana");
                    alert.show();
                }
            }
        }
    }


    public void updateManagerCustomerPolicyData(ActionEvent actionEvent) {
        if (validateManagerCustomerPolicyForm()) {
            Policy policy = new Policy();
            policy.setCupid(inpMCusPoliId.getText());
            policy.setPname(drpFrmMPoli.getSelectionModel().getSelectedItem().getPname());
            policy.setCid(drpFrmMCUS.getSelectionModel().getSelectedItem().getCid());
            policy.setPid(drpFrmMPoli.getSelectionModel().getSelectedItem().getPid());
            policy.setPoliceType(drpFrmMPoliType.getSelectionModel().getSelectedItem());
            policy.setAid(String.valueOf(drpFrmMAgent.getSelectionModel().getSelectedItem().getAid()));
            policy.setNom(inpMCusPNom.getText());
            policy.setRela(inpMCusPRela.getText());
            policy.setPamt(Double.valueOf(inpMCusPPAmt.getText()));
            Thread thread = new Thread(() -> {
                policyStatus = updateCustomerPolicy(policy);
                loadManagerCustomerPolicyToTable();
                Platform.runLater(() -> {
                    Alert alert;
                    switch (policyStatus) {
                        case 1:
                            alert = new Alert(AlertType.INFORMATION);
                            alert.setTitle("Sukces");
                            alert.setContentText("Polisa " + policy.getPname() + " dane zaktualizowane");
                            alert.show();
                            clearBranchForm(actionEvent);
                            break;
                        case 0:
                        case -1:
                            alert = new Alert(AlertType.INFORMATION);
                            alert.setTitle("Sukces");
                            alert.setContentText("Polisa dodana...");
                            alert.show();
                            break;
                    }
                });
            });
            thread.start();
        }
    }


    public void insertManagerCustomerPolicyData(ActionEvent actionEvent) {
        if (validateManagerCustomerPolicyForm()) {
            Policy policy = new Policy();
            policy.setPname(drpFrmMPoli.getSelectionModel().getSelectedItem().getPname());
            policy.setCid(drpFrmMCUS.getSelectionModel().getSelectedItem().getCid());
            policy.setPid(drpFrmMPoli.getSelectionModel().getSelectedItem().getPid());
            policy.setPoliceType(drpFrmMPoliType.getSelectionModel().getSelectedItem());
            policy.setAid(String.valueOf(drpFrmMAgent.getSelectionModel().getSelectedItem().getAid()));
            policy.setNom(inpMCusPNom.getText());
            policy.setRela(inpMCusPRela.getText());
            policy.setPamt(Double.valueOf(inpMCusPPAmt.getText()));
            Thread thread = new Thread(() -> {
                managerCustomerPolicyStatus = addCustomerPolicy(policy);
                loadManagerCustomerPolicyToTable();
                Platform.runLater(() -> {
                    Alert alert;
                    switch (managerCustomerPolicyStatus) {
                        case 1:
                            alert = new Alert(AlertType.INFORMATION);
                            alert.setTitle("Sukces");
                            alert.setContentText("Nowa polisa klienta " + policy.getPname() + " stworzona");
                            alert.show();
                            clearManagerCustomerPolicyForm(actionEvent);
                            break;
                        case 2:
                            alert = new Alert(AlertType.INFORMATION);
                            alert.setTitle("Sukces");
                            alert.setContentText("Polisa " + policy.getPname() + " istnieje dla " + policy.getCid());
                            alert.show();
                            break;
                        case 0:
                        case -1:
                            alert = new Alert(AlertType.INFORMATION);
                            alert.setTitle("Sukces");
                            alert.setContentText("Poprawne dodanie polisy...");
                            alert.show();
                            break;
                    }
                });
            });
            thread.start();
        }
    }


    public void deleteManagerPolicyData(ActionEvent actionEvent) {
        if (validateManagerCustomerPolicyForm()) {
            Policy policy = new Policy();
            policy.setPname(drpFrmMPoli.getSelectionModel().getSelectedItem().getPname());
            policy.setCupid(inpMCusPoliId.getText());
            Alert confirm = new Alert(AlertType.CONFIRMATION);
            confirm.setTitle("Pytanie");
            confirm.setContentText("Na pewno chcesz usunąć klienta ?");

            Optional<ButtonType> option = confirm.showAndWait();
            if (option.get() == ButtonType.OK) {
                Thread thread = new Thread(() -> {
                    managerStatus = deleteCustomerPolicyData(policy);
                    loadManagerCustomerPolicyToTable();
                    Platform.runLater(() -> {
                        Platform.runLater(() -> {
                            Alert alert;
                            switch (managerStatus) {
                                case 1:
                                    alert = new Alert(AlertType.INFORMATION);
                                    alert.setTitle("Sukces");
                                    alert.setContentText("Polisa " + policy.getPname() + " usunięta");
                                    alert.show();
                                    clearManagerCustomerForm(actionEvent);
                                    break;
                                case 0:
                                case -1:
                                    alert = new Alert(AlertType.ERROR);
                                    alert.setTitle("Błąd");
                                    alert.setContentText("Coś poszło nie tak...");
                                    alert.show();
                                    break;
                            }
                        });
                    });
                });
                thread.start();
            }
        }
    }


    private boolean validateManagerCustomerPolicyForm() {

        boolean isValidDrpFrmMCUS, isValiddrpFrmMPoli, isValidPolicyType, isValidAgent, isValidNom, isValidRela, isValidPolicyAmount;

        if (drpFrmMCUS.getSelectionModel().getSelectedIndex() < 0) {
            drpFrmMCUS.requestFocus();
            drpFrmMCUS.setStyle("-fx-border-color:red");
            isValidDrpFrmMCUS = false;
        } else {
            drpFrmMCUS.setStyle("-fx-border-color:green");
            isValidDrpFrmMCUS = true;
        }

        if (drpFrmMPoli.getSelectionModel().getSelectedIndex() < 0) {
            drpFrmMPoli.requestFocus();
            drpFrmMPoli.setStyle("-fx-border-color:red");
            isValiddrpFrmMPoli = false;
        } else {
            drpFrmMPoli.setStyle("-fx-border-color:green");
            isValiddrpFrmMPoli = true;
        }

        if (drpFrmMPoliType.getSelectionModel().getSelectedIndex() < 0) {
            drpFrmMPoliType.requestFocus();
            drpFrmMPoliType.setStyle("-fx-border-color:red");
            isValidPolicyType = false;
        } else {
            drpFrmMPoliType.setStyle("-fx-border-color:green");
            isValidPolicyType = true;
        }

        if (drpFrmMAgent.getSelectionModel().getSelectedIndex() < 0) {
            drpFrmMAgent.requestFocus();
            drpFrmMAgent.setStyle("-fx-border-color:red");
            isValidAgent = false;
        } else {
            drpFrmMAgent.setStyle("-fx-border-color:green");
            isValidAgent = true;
        }

        if (inpMCusPNom.getText().equals("")) {
            inpMCusPNom.requestFocus();
            inpMCusPNom.setStyle("-fx-border-color:red");
            isValidNom = false;
        } else {
            inpMCusPNom.setStyle("-fx-border-color:green");
            isValidNom = true;
        }

        if (inpMCusPRela.getText().equals("")) {
            inpMCusPRela.requestFocus();
            inpMCusPRela.setStyle("-fx-border-color:red");
            isValidRela = false;
        } else {
            inpMCusPRela.setStyle("-fx-border-color:green");
            isValidRela = true;
        }

        if (inpMCusPPAmt.getText().equals("")) {
            inpMCusPPAmt.requestFocus();
            inpMCusPPAmt.setStyle("-fx-border-color:red");
            isValidPolicyAmount = false;
        } else {
            try {
                double amount = Double.parseDouble(inpMCusPPAmt.getText());
                inpMCusPPAmt.setStyle("-fx-border-color:green");
                isValidPolicyAmount = true;
            } catch (Exception exception) {
                inpMCusPPAmt.setStyle("-fx-border-color:red");
                isValidPolicyAmount = false;
            }
        }

        return isValidDrpFrmMCUS && isValiddrpFrmMPoli && isValidPolicyType && isValidAgent && isValidNom && isValidRela && isValidPolicyAmount;
    }

    public void insertManagerCustomerData(ActionEvent actionEvent) {
        if (validateManagerCustomerForm()) {
            User customer = new User();
            customer.setName(inpMCusName.getText());
            customer.setPhno(inpMCusPhno.getText());
            customer.setFname(inpMCusFname.getText());
            customer.setAge(inpMCusAge.getText());
            if (rdCusMale.isSelected()) {
                customer.setGender(Gender.Male);
            } else {
                customer.setGender(Gender.Female);
            }
            customer.setQua(inpMCusQua.getText());
            customer.setOcc(inpMCusOcc.getText());
            customer.setCadd(inpMCusAddr.getText());
            customer.setAgname(Math.toIntExact(drpMCusAgent.getSelectionModel().getSelectedItem().getId()));
            customer.setPassword(inpMCusPass.getText());
            Thread thread = new Thread(() -> {
                customerStatus = addCustomer(customer);
                loadManagerCustomerDataToTable();
                Platform.runLater(() -> {
                    Alert alert;
                    switch (customerStatus) {
                        case 1:
                            alert = new Alert(AlertType.INFORMATION);
                            alert.setTitle("Sukces");
                            alert.setContentText("Nowy klient " + customer.getName() + " stworzony");
                            alert.show();
                            clearManagerForm(actionEvent);
                            break;
                        case 2:
                            alert = new Alert(AlertType.ERROR);
                            alert.setTitle("Błąd");
                            alert.setContentText("Klient " + customer.getName() + " istnieje");
                            alert.show();
                            break;
                        case 0:
                        case -1:
                            alert = new Alert(AlertType.ERROR);
                            alert.setTitle("Błąd");
                            alert.setContentText("Coś poszło nie tak...");
                            alert.show();
                            break;
                    }
                });
            });
            thread.start();
        }
    }

    private boolean validateManagerCustomerForm() {

        boolean isValidContact, isValidName, isValidFname, isValidAge, isValidQua, isValidOcc, isValidAddr, isValidAgent, isValidPass, iaValidGender;

        if (inpMCusPhno.getText().equals("")) {
            inpMCusPhno.requestFocus();
            inpMCusPhno.setStyle("-fx-border-color:red");
            isValidContact = false;
        } else {
            try {
                long value = Long.parseLong(inpMCusPhno.getText());
                inpMCusPhno.setStyle("-fx-border-color:green");
                isValidContact = true;
            } catch (Exception exception) {
                inpMCusPhno.setStyle("-fx-border-color:red");
                isValidContact = false;
            }
        }

        if (inpMCusName.getText().equals("")) {
            inpMCusName.requestFocus();
            inpMCusName.setStyle("-fx-border-color:red");
            isValidName = false;
        } else {
            inpMCusName.setStyle("-fx-border-color:green");
            isValidName = true;
        }


        if (inpMCusFname.getText().equals("")) {
            inpMCusFname.requestFocus();
            inpMCusFname.setStyle("-fx-border-color:red");
            isValidFname = false;
        } else {
            inpMCusFname.setStyle("-fx-border-color:green");
            isValidFname = true;
        }

        if (inpMCusAge.getText().equals("")) {
            inpMCusAge.requestFocus();
            inpMCusAge.setStyle("-fx-border-color:red");
            isValidAge = false;
        } else {
            try {
                int value = Integer.parseInt(inpMCusAge.getText());
                inpMCusAge.setStyle("-fx-border-color:green");
                isValidAge = true;
            } catch (Exception exception) {
                inpMCusAge.setStyle("-fx-border-color:red");
                isValidAge = false;
            }
        }

        if (inpMCusOcc.getText().equals("")) {
            inpMCusOcc.requestFocus();
            inpMCusOcc.setStyle("-fx-border-color:red");
            isValidOcc = false;
        } else {
            inpMCusOcc.setStyle("-fx-border-color:green");
            isValidOcc = true;
        }


        if (inpMCusQua.getText().equals("")) {
            inpMCusQua.requestFocus();
            inpMCusQua.setStyle("-fx-border-color:red");
            isValidQua = false;
        } else {
            inpMCusQua.setStyle("-fx-border-color:green");
            isValidQua = true;
        }

        if (inpMCusAddr.getText().equals("")) {
            inpMCusAddr.requestFocus();
            inpMCusAddr.setStyle("-fx-border-color:red");
            isValidAddr = false;
        } else {
            inpMCusAddr.setStyle("-fx-border-color:green");
            isValidAddr = true;
        }

        if (drpMCusAgent.getSelectionModel().getSelectedIndex() < 0) {
            drpMCusAgent.requestFocus();
            drpMCusAgent.setStyle("-fx-border-color:red");
            isValidAgent = false;
        } else {
            drpMCusAgent.setStyle("-fx-border-color:green");
            isValidAgent = true;
        }


        if (inpMCusPass.getText().equals("")) {
            inpMCusPass.requestFocus();
            inpMCusPass.setStyle("-fx-border-color:red");
            isValidPass = false;
        } else {
            inpMCusPass.setStyle("-fx-border-color:green");
            isValidPass = true;
        }

        if (!rdCusMale.isSelected() && !rdCusFemale.isSelected()) {
            rdCusMale.setStyle("-fx-border-color:red");
            rdCusFemale.setStyle("-fx-border-color:red");
            iaValidGender = false;
        } else {
            rdCusMale.setStyle("-fx-border-color:green");
            rdCusFemale.setStyle("-fx-border-color:green");
            iaValidGender = true;
        }

        return isValidContact && isValidName && isValidFname && isValidAge && isValidQua && isValidOcc && isValidAddr && isValidAgent && isValidPass && iaValidGender;
    }

    public void insertManagerData(ActionEvent actionEvent) {
        if (validateManagerForm()) {
            User manager = new User();
            manager.setName(inpMName.getText());
            manager.setFname(inpMFather.getText());
            RadioButton selectedRadioButton = (RadioButton) toggleGroup.getSelectedToggle();
            manager.setGender(Gender.valueOf(selectedRadioButton.getText()));
            manager.setAge(inpMAge.getText());
            manager.setQua(inpMQuali.getText());
            manager.setAddd(inpMAddr.getText());
            manager.setBname(drpBranch.getSelectionModel().getSelectedItem());
            manager.setPassword(inpMPass.getText());
            manager.setPhone(inpMPhone.getText());

            Thread thread = new Thread(() -> {
                managerStatus = addManager(manager);
                loadManagerDataToTable();
                Platform.runLater(() -> {
                    Alert alert;
                    switch (managerStatus) {
                        case 1:
                            alert = new Alert(AlertType.INFORMATION);
                            alert.setTitle("Sukces");
                            alert.setContentText("Nowy menadżer " + manager.getName() + " stworzony");
                            alert.show();
                            clearManagerForm(actionEvent);
                            break;
                        case 2:
                            alert = new Alert(AlertType.ERROR);
                            alert.setTitle("Błąd");
                            alert.setContentText("Menadżer " + manager.getName() + " istnieje");
                            alert.show();
                            break;
                        case 0:
                        case -1:
                            alert = new Alert(AlertType.ERROR);
                            alert.setTitle("Błąd");
                            alert.setContentText("Coś poszło nie tak...");
                            alert.show();
                            break;
                    }
                });
            });
            thread.start();



        }
    }

    public void insertManagerAgentData(ActionEvent actionEvent) {
        if (validateManagerAgentForm()) {
            User mAgent = new User();
            mAgent.setPhno(inpMContact.getText());
            mAgent.setName(inpMAgentName.getText());
            mAgent.setFname(inpMFName.getText());
            mAgent.setAge(inpM_Age.getText());
            if (rdMAgentMale.isSelected()) {
                mAgent.setGender(Gender.Male);
            } else {
                mAgent.setGender(Gender.Female);
            }
            mAgent.setQua(inpMQua.getText());
            mAgent.setOccu(inpMOcc.getText());
            mAgent.setAddd(inpM_Addr.getText());
            mAgent.setSec(inpMDeposit.getText());
            mAgent.setMname(drpMManager.getSelectionModel().getSelectedItem().getId() + "");
            mAgent.setPassword(inpMPassword.getText());

            Thread thread = new Thread(() -> {
                managerAgentStatus = addAgent(mAgent);
                loadManagerAgentDataToTable();
                Platform.runLater(() -> {
                    Alert alert;
                    switch (managerAgentStatus) {
                        case 1:
                            alert = new Alert(AlertType.INFORMATION);
                            alert.setTitle("Sukces");
                            alert.setContentText("Nowy agent " + mAgent.getName() + " stworzony");
                            alert.show();
                            clearManagerForm(actionEvent);
                            break;
                        case 2:
                            alert = new Alert(AlertType.ERROR);
                            alert.setTitle("Błąd");
                            alert.setContentText("Agent " + mAgent.getName() + " istnieje");
                            alert.show();
                            break;
                        case 0:
                        case -1:
                            alert = new Alert(AlertType.ERROR);
                            alert.setTitle("Błąd");
                            alert.setContentText("Coś poszło nie tak...");
                            alert.show();
                            break;
                    }
                });
            });
            thread.start();
        }
    }

    public boolean validateManagerAgentForm() {
        boolean isValidContact, isValidName, isValidFName, isValidAge, isValidGender, isValidQua, isValidOccu, isValidAddr, isValidDepo, isValidManager, isValidPass;

        if (inpMContact.getText().equals("")) {
            inpMContact.requestFocus();
            inpMContact.setStyle("-fx-border-color:red");
            isValidContact = false;
        } else {
            inpMContact.setStyle("-fx-border-color:green");
            isValidContact = true;
        }

        if (inpMAgentName.getText().equals("")) {
            inpMAgentName.requestFocus();
            inpMAgentName.setStyle("-fx-border-color:red");
            isValidName = false;
        } else {
            inpMAgentName.setStyle("-fx-border-color:green");
            isValidName = true;
        }

        if (inpMFName.getText().equals("")) {
            inpMFName.requestFocus();
            inpMFName.setStyle("-fx-border-color:red");
            isValidFName = false;
        } else {
            inpMFName.setStyle("-fx-border-color:green");
            isValidFName = true;
        }

        if (inpM_Age.getText().equals("")) {
            inpM_Age.requestFocus();
            inpM_Age.setStyle("-fx-border-color:red");
            isValidAge = false;
        } else {
            try {
                int age = Integer.parseInt(inpM_Age.getText());
                inpM_Age.setStyle("-fx-border-color:green");
                isValidAge = true;
            } catch (Exception exception) {
                inpM_Age.setStyle("-fx-border-color:red");
                isValidAge = false;
            }
        }

        if (!rdMAgentMale.isSelected() && !rdMAgentFemale.isSelected()) {
            rdMAgentMale.setStyle("-fx-border-color:red");
            rdMAgentFemale.setStyle("-fx-border-color:red");
            isValidGender = false;
        } else {
            rdMAgentMale.setStyle("-fx-border-color:green");
            rdMAgentFemale.setStyle("-fx-border-color:green");
            isValidGender = true;
        }
        if (inpMQua.getText().equals("")) {
            inpMQua.requestFocus();
            inpMQua.setStyle("-fx-border-color:red");
            isValidQua = false;
        } else {
            inpMQua.setStyle("-fx-border-color:green");
            isValidQua = true;
        }

        if (inpMOcc.getText().equals("")) {
            inpMOcc.requestFocus();
            inpMOcc.setStyle("-fx-border-color:red");
            isValidOccu = false;
        } else {
            inpMOcc.setStyle("-fx-border-color:green");
            isValidOccu = true;
        }

        if (inpM_Addr.getText().equals("")) {
            inpM_Addr.requestFocus();
            inpM_Addr.setStyle("-fx-border-color:red");
            isValidAddr = false;
        } else {
            inpM_Addr.setStyle("-fx-border-color:green");
            isValidAddr = true;
        }

        if (inpMDeposit.getText().equals("")) {
            inpMDeposit.requestFocus();
            inpMDeposit.setStyle("-fx-border-color:red");
            isValidDepo = false;
        } else {
            try {
                double value = Double.parseDouble(inpMDeposit.getText());
                inpMDeposit.setStyle("-fx-border-color:green");
                isValidDepo = true;
            } catch (Exception exception) {
                inpMDeposit.setStyle("-fx-border-color:red");
                isValidDepo = false;
            }
        }

        if (drpMManager.getSelectionModel().getSelectedIndex() < 0) {
            drpMManager.requestFocus();
            drpMManager.setStyle("-fx-border-color:red");
            isValidManager = false;
        } else {
            drpMManager.setStyle("-fx-border-color:green");
            isValidManager = true;
        }

        if (inpMPassword.getText().equals("")) {
            inpMPassword.requestFocus();
            inpMPassword.setStyle("-fx-border-color:red");
            isValidPass = false;
        } else {
            inpMPassword.setStyle("-fx-border-color:green");
            isValidPass = true;
        }
        return isValidContact && isValidName && isValidFName && isValidAge && isValidGender && isValidQua && isValidOccu && isValidAddr && isValidDepo && isValidManager && isValidPass;
    }

    private boolean validateManagerForm() {
        return true;
    }

    public void insertPolicy(ActionEvent actionEvent) {
        if (validatePolicyForm()) {
            Policy policy = new Policy();
            policy.setPname(inpPName.getText());
            policy.setPterm(inpPTerm.getText());
            policy.setPamt(Long.valueOf(inpPAmount.getText()));
            policy.setPfamt(Long.valueOf(inpPFAmount.getText()));
            policy.setPint(Long.valueOf(inpPI.getText()));
            policy.setPbper(Long.valueOf(inpBp.getText()));
            policy.setPrat(Long.valueOf(inpBRT.getText()));
            policy.setDesc(inpPolicyDesc.getText());

            Thread thread = new Thread(() -> {
                policyStatus = addPolicy(policy);
                loadPolicyDataToTable();
                Platform.runLater(() -> {
                    Alert alert;
                    switch (policyStatus) {
                        case 1:
                            alert = new Alert(AlertType.INFORMATION);
                            alert.setTitle("Sukces");
                            alert.setContentText("Nowa polisa " + policy.getPname() + " stworzona");
                            alert.show();
                            clearBranchForm(actionEvent);
                            break;
                        case 2:
                            alert = new Alert(AlertType.ERROR);
                            alert.setTitle("Błąd");
                            alert.setContentText("Polisa " + policy.getPname() + " istnieje");
                            alert.show();
                            break;
                        case 0:
                        case -1:
                            alert = new Alert(AlertType.ERROR);
                            alert.setTitle("Błąd");
                            alert.setContentText("Coś poszło nie tak...");
                            alert.show();
                            break;
                    }
                });
            });
            thread.start();
        }
    }

    public void updateManagerAgent(ActionEvent actionEvent) {
        if (validateManagerAgentForm()) {
            User mAgent = new User();
            mAgent.setAid(Long.parseLong(inpMAgentID.getText()));
            mAgent.setPhno(inpMContact.getText());
            mAgent.setName(inpMAgentName.getText());
            mAgent.setFname(inpMFName.getText());
            mAgent.setAge(inpM_Age.getText());
            if (rdMAgentMale.isSelected()) {
                mAgent.setGender(Gender.Male);
            } else {
                mAgent.setGender(Gender.Female);
            }
            mAgent.setQua(inpMQua.getText());
            mAgent.setOccu(inpMOcc.getText());
            mAgent.setAddd(inpM_Addr.getText());
            mAgent.setSec(inpMDeposit.getText());
            mAgent.setMname(drpMManager.getSelectionModel().getSelectedItem().getId() + "");
            mAgent.setPassword(inpMPassword.getText());

            Thread thread = new Thread(() -> {
                customerStatus = updateAgent(mAgent);
                loadPolicyDataToTable();
                Platform.runLater(() -> {
                    Alert alert;
                    switch (customerStatus) {
                        case 1:
                            alert = new Alert(AlertType.INFORMATION);
                            alert.setTitle("Sukces");
                            alert.setContentText("Agent " + mAgent.getName() + " dane zaktualizowane");
                            alert.show();
                            clearBranchForm(actionEvent);
                            break;
                        case 0:
                        case -1:
                            alert = new Alert(AlertType.ERROR);
                            alert.setTitle("Błąd");
                            alert.setContentText("Coś poszło nie tak...");
                            alert.show();
                            break;
                    }
                });
            });
            thread.start();
        }
    }

    public void updateManagerCustomer(ActionEvent actionEvent) {
        if (validateManagerCustomerForm()) {
            User customer = new User();
            customer.setCid(inpMCusID.getText());
            customer.setName(inpMCusName.getText());
            customer.setPhno(inpMCusPhno.getText());
            customer.setFname(inpMCusFname.getText());
            customer.setAge(inpMCusAge.getText());
            if (rdCusMale.isSelected()) {
                customer.setGender(Gender.Male);
            } else {
                customer.setGender(Gender.Female);
            }
            customer.setQua(inpMCusQua.getText());
            customer.setOcc(inpMCusOcc.getText());
            customer.setCadd(inpMCusAddr.getText());
            customer.setAgname(Math.toIntExact(drpMCusAgent.getSelectionModel().getSelectedItem().getId()));
            customer.setPassword(inpMCusPass.getText());

            Thread thread = new Thread(() -> {
                customerStatus = updateCustomer(customer);
                loadPolicyDataToTable();
                Platform.runLater(() -> {
                    Alert alert;
                    switch (customerStatus) {
                        case 1:
                            alert = new Alert(AlertType.INFORMATION);
                            alert.setTitle("Sukces");
                            alert.setContentText("Klient " + customer.getName() + " dane zaktualizowane");
                            alert.show();
                            clearBranchForm(actionEvent);
                            break;
                        case 0:
                        case -1:
                            alert = new Alert(AlertType.ERROR);
                            alert.setTitle("Błąd");
                            alert.setContentText("Coś poszło nie tak...");
                            alert.show();
                            break;
                    }
                });
            });
            thread.start();
        }
    }

    public void updatePolicyUI(ActionEvent actionEvent) {
        if (validatePolicyForm()) {
            Policy policy = new Policy();
            policy.setPname(inpPName.getText());
            policy.setPterm(inpPTerm.getText());
            policy.setPamt(Double.valueOf(inpPAmount.getText()));
            policy.setPfamt(Double.valueOf(inpPFAmount.getText()));
            policy.setPint(Double.valueOf(inpPI.getText()));
            policy.setPbper(Double.valueOf(inpBp.getText()));
            policy.setPrat(Double.valueOf(inpBRT.getText()));
            policy.setPid(Long.valueOf(inpPID.getText()));
            policy.setDesc(inpPolicyDesc.getText());

            Thread thread = new Thread(() -> {
                policyStatus = updatePolicy(policy);
                loadPolicyDataToTable();
                Platform.runLater(() -> {
                    Alert alert;
                    switch (policyStatus) {
                        case 1:
                            alert = new Alert(AlertType.INFORMATION);
                            alert.setTitle("Sukces");
                            alert.setContentText("Polisa " + policy.getPname() + " dane zaktualizowane");
                            alert.show();
                            clearBranchForm(actionEvent);
                            break;
                        case 0:
                        case -1:
                            alert = new Alert(AlertType.ERROR);
                            alert.setTitle("Błąd");
                            alert.setContentText("Coś poszło nie tak...");
                            alert.show();
                            break;
                    }
                });
            });
            thread.start();
        }
    }

    private boolean validatePolicyForm() {
        return true;
    }

    public void insertBranch(ActionEvent actionEvent) {
        if (validateBranchForm()) {
            Branch branch = new Branch();
            branch.setLocation(inpLocation.getText());
            branch.setName(inpBranch.getText());
            branch.setPhone(inpPhone.getText());
            branch.setState(inpState.getText());

            Thread thread = new Thread(() -> {
                branchStatus = addBranch(branch);
                loadBranchDataToTable();
                Platform.runLater(() -> {
                    Alert alert;
                    switch (branchStatus) {
                        case 1:
                            alert = new Alert(AlertType.INFORMATION);
                            alert.setTitle("Sukces");
                            alert.setContentText("Nowy oddział " + branch.getName() + " stworzony");
                            alert.show();
                            clearBranchForm(actionEvent);
                            break;
                        case 2:
                            alert = new Alert(AlertType.ERROR);
                            alert.setTitle("Błąd");
                            alert.setContentText("Oddział " + branch.getName() + " istnieje");
                            alert.show();
                            break;
                        case 0:
                        case -1:
                            alert = new Alert(AlertType.ERROR);
                            alert.setTitle("Błąd");
                            alert.setContentText("Coś poszło nie tak...");
                            alert.show();
                            break;
                    }
                });
            });
            thread.start();
        }
    }

    public void insertAgent(ActionEvent actionEvent) {
        if (validateManagerAgentForm()) {

        }
    }

    public void updateBranch(ActionEvent actionEvent) {
        if (validateBranchForm()) {
            Branch branch = new Branch();
            branch.setLocation(inpLocation.getText());
            branch.setName(inpBranch.getText());
            branch.setPhone(inpPhone.getText());
            branch.setState(inpState.getText());
            branch.setId(Long.parseLong(inpBranchId.getText()));

            Thread thread = new Thread(() -> {
                branchStatus = updateBranch(branch);
                loadBranchDataToTable();
                Platform.runLater(() -> {
                    Alert alert;
                    switch (branchStatus) {
                        case 1:
                            alert = new Alert(AlertType.INFORMATION);
                            alert.setTitle("Sukces");
                            alert.setContentText("Oddział " + branch.getName() + " Dane zaktualizowane");
                            alert.show();
                            clearBranchForm(actionEvent);
                            break;
                        case 0:
                        case -1:
                            alert = new Alert(AlertType.ERROR);
                            alert.setTitle("Błąd");
                            alert.setContentText("Coś poszło nie tak...");
                            alert.show();
                            break;
                    }
                });
            });
            thread.start();
        }
    }

    public void updateManager(ActionEvent actionEvent) {
        if (validateManagerForm()) {
            User manager = new User();
            manager.setName(inpMName.getText());
            manager.setFname(inpMFather.getText());
            RadioButton selectedRadioButton = (RadioButton) toggleGroup.getSelectedToggle();
            manager.setGender(Gender.valueOf(selectedRadioButton.getText()));
            manager.setAge(inpMAge.getText());
            manager.setQua(inpMQuali.getText());
            manager.setAddd(inpMAddr.getText());
            manager.setBname(drpBranch.getSelectionModel().getSelectedItem());
            manager.setPassword(inpMPass.getText());
            manager.setPhone(inpMPhone.getText());
            manager.setMid(Long.valueOf(inpMId.getText()));

            Thread thread = new Thread(() -> {
                branchStatus = updateManager(manager);
                loadManagerDataToTable();
                Platform.runLater(() -> {
                    Alert alert;
                    switch (branchStatus) {
                        case 1:
                            alert = new Alert(AlertType.INFORMATION);
                            alert.setTitle("Sukces");
                            alert.setContentText("Menadżer " + manager.getName() + " dane zaktualizowane");
                            alert.show();
                            clearManagerForm(actionEvent);
                            break;
                        case 0:
                        case -1:
                            alert = new Alert(AlertType.ERROR);
                            alert.setTitle("Błąd");
                            alert.setContentText("Coś poszło nie tak...");
                            alert.show();
                            break;
                    }
                });
            });
            thread.start();
        }
    }

    public void deleteManagerCustomer(ActionEvent actionEvent) {
        if (validateManagerCustomerForm()) {
            User customer = new User();
            customer.setCid(inpMCusID.getText());
            customer.setName(inpMCusName.getText());
            Alert confirm = new Alert(AlertType.CONFIRMATION);
            confirm.setTitle("Pytane");
            confirm.setContentText("Na pewno chcesz usunąć klienta ?");

            Optional<ButtonType> option = confirm.showAndWait();
            if (option.get() == ButtonType.OK) {
                Thread thread = new Thread(() -> {
                    managerStatus = deleteCustomer(customer);
                    loadManagerCustomerDataToTable();
                    Platform.runLater(() -> {
                        Platform.runLater(() -> {
                            Alert alert;
                            switch (managerStatus) {
                                case 1:
                                    alert = new Alert(AlertType.INFORMATION);
                                    alert.setTitle("Sukces");
                                    alert.setContentText("Klient " + customer.getName() + " usunięty");
                                    alert.show();
                                    clearManagerCustomerForm(actionEvent);
                                    break;
                                case 0:
                                case -1:
                                    alert = new Alert(AlertType.ERROR);
                                    alert.setTitle("Błąd");
                                    alert.setContentText("Coś poszło nie tak...");
                                    alert.show();
                                    break;
                            }
                        });
                    });
                });
                thread.start();
            }
        }
    }


    public void deletePolicyUI(ActionEvent actionEvent) {
        if (validatePolicyForm()) {
            Policy policy = new Policy();
            policy.setPid(Long.valueOf(inpPID.getText()));
            policy.setPname(inpPName.getText());
            policy.setPterm(inpPTerm.getText());
            policy.setPamt(Long.valueOf(inpPAmount.getText()));
            policy.setPfamt(Long.valueOf(inpPFAmount.getText()));
            policy.setPint(Long.valueOf(inpPI.getText()));
            policy.setPbper(Long.valueOf(inpBp.getText()));
            policy.setPrat(Long.valueOf(inpBRT.getText()));
            Alert confirm = new Alert(AlertType.CONFIRMATION);
            confirm.setTitle("Pytanie");
            confirm.setContentText("Na pewno chcesz usunąć polise ?");

            Optional<ButtonType> option = confirm.showAndWait();
            if (option.get() == ButtonType.OK) {
                Thread thread = new Thread(() -> {
                    policyStatus = deletePolicy(policy);
                    loadPolicyDataToTable();
                    Platform.runLater(() -> {
                        Platform.runLater(() -> {
                            Alert alert;
                            switch (policyStatus) {
                                case 1:
                                    alert = new Alert(AlertType.INFORMATION);
                                    alert.setTitle("Sukces");
                                    alert.setContentText("Polisa " + policy.getPname() + " usunięta");
                                    alert.show();
                                    clearBranchForm(actionEvent);
                                    break;
                                case 0:
                                case -1:
                                    alert = new Alert(AlertType.ERROR);
                                    alert.setTitle("Błąd");
                                    alert.setContentText("Coś poszło nie tak...");
                                    alert.show();
                                    break;
                            }
                        });
                    });
                });
                thread.start();
            }
        }
    }

    public void deleteManagerAgent(ActionEvent actionEvent) {
        if (validateManagerAgentForm()) {
            User mAgent = new User();
            mAgent.setAid(Long.valueOf(inpMAgentID.getText()));
            mAgent.setName(inpMAgentName.getText());
            Alert confirm = new Alert(AlertType.CONFIRMATION);
            confirm.setTitle("Pytanie");
            confirm.setContentText("Na pewno chcesz usunąć Agenta ?");

            Optional<ButtonType> option = confirm.showAndWait();
            if (option.get() == ButtonType.OK) {
                Thread thread = new Thread(() -> {
                    managerAgentStatus = deleteAgent(mAgent);
                    loadManagerAgentDataToTable();
                    Platform.runLater(() -> {
                        Platform.runLater(() -> {
                            Alert alert;
                            switch (managerAgentStatus) {
                                case 1:
                                    alert = new Alert(AlertType.INFORMATION);
                                    alert.setTitle("Sukces");
                                    alert.setContentText("Agent " + mAgent.getName() + " usunięty");
                                    alert.show();
                                    clearManagerForm(actionEvent);
                                    break;
                                case 0:
                                case -1:
                                    alert = new Alert(AlertType.ERROR);
                                    alert.setTitle("Błąd");
                                    alert.setContentText("Coś poszło nie tak...");
                                    alert.show();
                                    break;
                            }
                        });
                    });
                });
                thread.start();
            }
        }
    }

    public void deleteManager(ActionEvent actionEvent) {
        if (validateManagerForm()) {
            User manager = new User();
            manager.setName(inpMName.getText());
            manager.setFname(inpMFather.getText());
            RadioButton selectedRadioButton = (RadioButton) toggleGroup.getSelectedToggle();
            manager.setGender(Gender.valueOf(selectedRadioButton.getText()));
            manager.setAge(inpMAge.getText());
            manager.setQua(inpMQuali.getText());
            manager.setAddd(inpMAddr.getText());
            manager.setBname(drpBranch.getSelectionModel().getSelectedItem());
            manager.setPassword(inpMPass.getText());
            manager.setPhone(inpMPhone.getText());
            manager.setMid(Long.valueOf(inpMId.getText()));
            Alert confirm = new Alert(AlertType.CONFIRMATION);
            confirm.setTitle("Pytanie");
            confirm.setContentText("Na pewno chcesz usunąć menadżera ?");

            Optional<ButtonType> option = confirm.showAndWait();
            if (option.get() == ButtonType.OK) {
                Thread thread = new Thread(() -> {
                    managerStatus = deleteManager(manager);
                    loadManagerDataToTable();
                    Platform.runLater(() -> {
                        Platform.runLater(() -> {
                            Alert alert;
                            switch (managerStatus) {
                                case 1:
                                    alert = new Alert(AlertType.INFORMATION);
                                    alert.setTitle("Sukces");
                                    alert.setContentText("Menadżer " + manager.getName() + " usunięty");
                                    alert.show();
                                    clearManagerForm(actionEvent);
                                    break;
                                case 0:
                                case -1:
                                    alert = new Alert(AlertType.ERROR);
                                    alert.setTitle("Błąd");
                                    alert.setContentText("Coś poszło nie tak...");
                                    alert.show();
                                    break;
                            }
                        });
                    });
                });
                thread.start();
            }
        }
    }

    public void deleteBranchUI(ActionEvent actionEvent) {
        if (validateBranchForm()) {
            Branch branch = new Branch();
            branch.setLocation(inpLocation.getText());
            branch.setName(inpBranch.getText());
            branch.setPhone(inpPhone.getText());
            branch.setState(inpState.getText());
            branch.setId(Long.parseLong(inpBranchId.getText()));

            Alert confirm = new Alert(AlertType.CONFIRMATION);
            confirm.setTitle("Pytanie");
            confirm.setContentText("Na pewno chcesz usunąć oddział ?");
            Optional<ButtonType> option = confirm.showAndWait();
            if (option.get() == ButtonType.OK) {
                Thread thread = new Thread(() -> {
                    branchStatus = deleteBranch(branch);
                    loadBranchDataToTable();
                    Platform.runLater(() -> {
                        Platform.runLater(() -> {
                            Alert alert;
                            switch (branchStatus) {
                                case 1:
                                    alert = new Alert(AlertType.INFORMATION);
                                    alert.setTitle("Sukces");
                                    alert.setContentText("Oddział " + branch.getName() + " usnięty");
                                    alert.show();
                                    clearBranchForm(actionEvent);
                                    break;
                                case 0:
                                case -1:
                                    alert = new Alert(AlertType.ERROR);
                                    alert.setTitle("Błąd");
                                    alert.setContentText("Coś poszło nie tak...");
                                    alert.show();
                                    break;
                            }
                        });
                    });
                });
                thread.start();
            }
        }
    }

    public boolean validateBranchForm() {
        return true;
    }

    public void logout(MouseEvent mouseEvent) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Wylogowanie");
        alert.setContentText("Pomyślnie wylogowano z systemu");
        alert.show();
        rdCus.setSelected(true);
        changeUIBasedOnRole(Role.NONE);
        clearLoginForm();
    }



    public void changeUIBasedOnRole(Role role) {
        switch (role) {
            case Admin:
                adminTabPane.setVisible(true);
                adminNavPanel.setVisible(true);
                agentTabPane.setVisible(false);
                agentNavPane.setVisible(false);
                custNavPane.setVisible(false);
                custTabPane.setVisible(false);
                loginForm.setVisible(false);
                managerTabPane.setVisible(false);
                mAgentNavPane.setVisible(false);
                loadManagerDataToTable();
                loadBranchDataToTable();
                loadPolicyDataToTable();
                break;
            case Agent:
                agentTabPane.setVisible(true);
                agentNavPane.setVisible(true);
                adminTabPane.setVisible(false);
                adminNavPanel.setVisible(false);
                custNavPane.setVisible(false);
                custTabPane.setVisible(false);
                managerTabPane.setVisible(false);
                mAgentNavPane.setVisible(false);
                loginForm.setVisible(false);
                loadAgentManagerDataToTable();
                loadAgentPolicyDataToTable();
                loadAgentCustomerDataToTable();
                break;
            case Klient:
                custNavPane.setVisible(true);
                custTabPane.setVisible(true);
                agentTabPane.setVisible(false);
                agentNavPane.setVisible(false);
                adminTabPane.setVisible(false);
                adminNavPanel.setVisible(false);
                managerTabPane.setVisible(false);
                mAgentNavPane.setVisible(false);
                loginForm.setVisible(false);
                loadAgentDataToTable();
                loadCustomerPolicyData();
                loadCustomerPolicyStatusDataToTable();
                break;
            case Menadżer:
                agentTabPane.setVisible(false);
                agentNavPane.setVisible(false);
                adminTabPane.setVisible(false);
                adminNavPanel.setVisible(false);
                custNavPane.setVisible(false);
                custTabPane.setVisible(false);
                managerTabPane.setVisible(true);
                mAgentNavPane.setVisible(true);
                loginForm.setVisible(false);
                loadManagersToDropDowm();
                loadAgentsToDropDown();
                loadManagerAgentDataToTable();
                break;
            default:
                adminTabPane.setVisible(false);
                adminNavPanel.setVisible(false);
                agentTabPane.setVisible(false);
                agentNavPane.setVisible(false);
                custNavPane.setVisible(false);
                custTabPane.setVisible(false);
                loginForm.setVisible(true);
                break;
        }
    }

    public void clearLoginForm() {
        inpUsername.clear();
        inpPassword.clear();
        drpRole.getSelectionModel().clearSelection();
    }

    public void minMaxClose(MouseEvent mouseEvent) {
        if (mouseEvent.getSource() instanceof ImageView) {
            ImageView btnSrc = (ImageView) mouseEvent.getSource();
            if (btnSrc.equals(btnMin) || btnSrc.equals(btnMin1) || btnSrc.equals(btnMin11) || btnSrc.equals(btnMin111) || btnSrc.equals(btnMin2) || btnSrc.equals(btnMin3) || btnSrc.equals(btnMin4) || btnSrc.equals(btnMin5) || btnSrc.equals(btnMin51) || btnSrc.equals(btnMin511) || btnSrc.equals(btnMin512)
                    || btnSrc.equals(btnMinMG1) || btnSrc.equals(btnMinMG2) || btnSrc.equals(btnMinMG3)) {
                Stage stage = (Stage) btnSrc.getScene().getWindow();
                stage.setIconified(true);
            } else if (btnSrc.equals(btnMax) || btnSrc.equals(btnMax1) || btnSrc.equals(btnMax11) || btnSrc.equals(btnMax111) || btnSrc.equals(btnMax2) || btnSrc.equals(btnMax3) || btnSrc.equals(btnMax4) || btnSrc.equals(btnMax5) || btnSrc.equals(btnMax51) || btnSrc.equals(btnMax511) || btnSrc.equals(btnMax512)
                    || btnSrc.equals(btnMaxMG1) || btnSrc.equals(btnMaxMG2) || btnSrc.equals(btnMaxMG3)) {
                Stage stage = (Stage) btnSrc.getScene().getWindow();
                if (!stage.isMaximized()) {
                    stage.setMaximized(true);
                } else {
                    stage.setMaximized(false);
                }
            } else if (btnSrc.equals(btnClose) || btnSrc.equals(btnClose1) || btnSrc.equals(btnClose11) || btnSrc.equals(btnClose111) || btnSrc.equals(btnClose2) || btnSrc.equals(btnClose3) || btnSrc.equals(btnClose4) || btnSrc.equals(btnClose5) || btnSrc.equals(btnClose51) || btnSrc.equals(btnClose511) || btnSrc.equals(btnClose512)
                    || btnSrc.equals(btnCloseMG1) || btnSrc.equals(btnCloseMG2) || btnSrc.equals(btnCloseMG3)) {
                Alert alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Informacja");
                alert.setContentText("Na pewno chcesz wyjść ?");
                Optional<ButtonType> option = alert.showAndWait();
                if (option.get() == ButtonType.OK) {
                    System.exit(0);
                }
            }
        }
    }

    public void clearPaymentForm() {
        inpPCusName.clear();
        inpCusPPid.clear();
        inpCusPPamt.clear();
        inpCusPPtype.clear();
        inpCusPPaidAmt.clear();
        inpCusPBamt.clear();
        inpCusPayAmt.clear();
        txtPayment.clear();
    }

    public void print() {
        System.out.println("Tworzenie zadania wydruku...");
        PrinterJob job = PrinterJob.createPrinterJob();
        if (job != null && job.showPrintDialog(txtPayment.getScene().getWindow())) {
            System.out.println(job.jobStatusProperty().asString());
            boolean printed = job.printPage(txtPayment);
            if (printed) {
                job.endJob();
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Drukowanie");
                alert.setContentText("Drukowanie skończone..");
                alert.show();
            } else {
                System.out.println("Drukowanie nie powiodło się.");
            }
        } else {
            System.out.println("Nie można utworzyć zadania wydruku.");
        }
    }


}
