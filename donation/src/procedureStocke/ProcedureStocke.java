package procedureStocke;

public class ProcedureStocke {
	public final static String INSERTUSER	= "{CALL INSERTUSER(?,?,?,?,?,?,?)}";
	public final static String DELETEUSER	= "{CALL DELETEUSER(?)}";
	public final static String UPDATEUSER 	= "{CALL UPDATEUSER(?,?,?,?,?,?,?,?)}";
	public final static String SELECTUSER	= "{CALL SELECTUSER(?,?,?,?,?,?,?,?)}";
	public final static String GETLISTUSER	= "{CALL GETLISTUSER(?)}";
	
	/**
	 * PROCEDURES STOCKEES POUR LA CLASSE ACTUALITEDAO
	 */
	public final static String INSERTACTUALITE 		= "{CALL INSERTACTUALITE(?,?,?)}";
	public final static String DELETEACTUALITE 		= "{CALL DELETEACTUALITE(?,?)}";
	public final static String UPDATEACTUALITE 		= "{CALL UPDATEACTUALITE(?,?,?,?)}";
	public final static String SELECTACTUALITE 		= "{CALL SELECTACTUALITE(?,?,?,?)}";
	public final static String GETLISTACTUALITE		= "{CALL GETLISTACTUALITE(?)}";
	
	/**
	 * PROCEDURES STOCKEES POUR LA CLASSE CATEGORIEDAO
	 */
	public final static String INSERTCATEGORIE 		= "{CALL INSERTCATEGORIE(?)}";
	public final static String DELETECATEGORIE 		= "{CALL DELETECATEGORIE(?)}";
	public final static String UPDATECATEGORIE 		= "{CALL UPDATECATEGORIE(?,?)}";
	public final static String SELECTCATEGORIE 		= "{CALL SELECTCATEGORIE(?,?)}";
	public final static String GETLISTCATEGORIE		= "{CALL GETLISTCATEGORIE(?)}";
	
	/**
	 * PROCEDURES STOCKEES POUR LA CLASSE SOUSCATEGORIEDAO
	 */
	public final static String INSERTSOUSCATEGORIE 	= "{CALL INSERTSOUSCATEGORIE(?,?,?)}";
	public final static String DELETESOUSCATEGORIE 	= "{CALL DELETESOUSCATEGORIE(?)}";
	public final static String UPDATESOUSCATEGORIE 	= "{CALL UPDATESOUSCATEGORIE(?,?,?,?)}";
	public final static String SELECTSOUSCATEGORIE 	= "{CALL SELECTSOUSCATEGORIE(?,?,?)}";
	public final static String GETLISTSOUSCATEGORIE	= "{CALL GETLISTSOUSCATEGORIE(?)}";
	
	/**
	 * PROCEDURES STOCKEES POUR LA CLASSE ARTICLEDAO
	 */
	public final static String INSERTARTICLE 			= "{CALL INSERTARTICLE(?,?,?,?,?)}";
	public final static String DELETEARTICLE 			= "{CALL DELETEARTICLE(?,?)}";
	public final static String UPDATEARTICLE			= "{CALL UPDATEARTICLE(?,?,?,?,?,?)}";
	public final static String SELECTARTICLE			= "{CALL SELECTARTICLE(?,?,?,?,?,?,?)}";
	public final static String GETLISTARTICLE   		= "{CALL GETLISTARTICLE(?)}";
	
	/**
	 * PROCEDURES STOCKEES POUR LA CLASSE COMMENTAIREDAO
	 */
	public final static String INSERTCOMMENTAIRE 	= "{CALL INSERTCOMMENTAIRE(?,?,?,?)}";
	public final static String DELETECOMMENTAIRE 	= "{CALL DELETECOMMENTAIRE(?,?)}";
	public final static String UPDATECOMMENTAIRE 	= "{CALL UPDATECOMMENTAIRE(?,?,?)}";
	public final static String SELECTCOMMENTAIRE 	= "{CALL SELECTCOMMENTAIRE(?,?,?,?,?)}";
	public final static String GETLISTCOMMENTAIRE	= "{CALL GETLISTCOMMENTAIRE(?)}";
	
	/**
	 * PROCEDURES STOCKEES POUR LA CLASSE HISTORIQUEDAO
	 */
	public final static String INSERTHISTORIQUE 	= "{CALL INSERTHISTORIQUE(?,?)}";
	public final static String DELETEHISTORIQUE 	= "{CALL DELETEHISTORIQUE(?,?)}";
	public final static String UPDATEHISTORIQUE 	= "{CALL UPDATEHISTORIQUE(?,?,?)}";
	public final static String SELECTHISTORIQUE 	= "{CALL SELECTHISTORIQUE(?,?,?)}";
	public final static String GETLISTHISTORIQUE	= "{CALL GETLISTHISTORIQUE(?)}";
}

