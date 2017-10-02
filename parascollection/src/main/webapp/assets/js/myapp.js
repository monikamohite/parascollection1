$(function() {
	switch (menu) {
	case 'Contact':
		$('#contact').addClass('active');
		console.log('this is home ');
		break;
	case 'About':
		$('#about').addClass('active');
		break;
	case 'Home':
		$('#home').addClass('active');
		console.log('this is home ');
		break;
	case 'All Products':
		$('#products').addClass('active');
		break;

	case 'Manage Products':
		$('#manageProducts').addClass('active');
		break;
	default:

		$('#home').addClass('active');
				break;

	}
});