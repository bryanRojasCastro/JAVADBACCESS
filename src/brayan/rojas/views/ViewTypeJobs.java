package brayan.rojas.views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JDialog;
import brayan.rojas.control.JobsController;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class ViewTypeJobs extends JDialog  {

	private JDialog dialog;
	private JComboBox comboJobs;

	public static void main(String[] args) {
		ViewTypeJobs vtjObject = new ViewTypeJobs();
	
	}

	public ViewTypeJobs() {
		initComponents();

	}

	private void initComponents() {
		dialog = new JDialog();
		dialog.setBounds(100, 100, 450, 300);
		dialog.getContentPane().setLayout(null);

		JobsController objCtrlJobs = new JobsController();

		comboJobs = new JComboBox();
		comboJobs.setModel(new DefaultComboBoxModel(objCtrlJobs.tipos()));
		comboJobs.setBounds(147, 106, 152, 20);
		comboJobs.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("esta seleccionado:->>" + comboJobs.getSelectedItem().toString());
				
			}
		});

		dialog.getContentPane().add(comboJobs);
		dialog.setVisible(true);
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}

}
