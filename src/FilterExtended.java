import java.io.File;

import javax.swing.filechooser.FileFilter;

public class FilterExtended extends FileFilter {

	@Override
	public boolean accept(File f) {
		if(f.isDirectory() || f.getName().endsWith(".jpg") || f.getName().endsWith(".png")) {
			return true;
		}
		return false;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "Image";
	}

}
