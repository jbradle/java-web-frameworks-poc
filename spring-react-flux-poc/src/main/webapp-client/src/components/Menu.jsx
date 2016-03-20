import React from "react";
import {Link} from "react-router";

const Menu = (props) => {

    let linkParams = [{
        'id': 1,
        'to': '/',
        'description': 'Framework List'
    }, {
        'id': 2,
        'to': 'add',
        'description': 'Add Framework'
    }, {
        'id': 3,
        'to': 'search',
        'description': 'Search'
    }];

    let links = linkParams.map(linkParam =>
        <Link key={linkParam.id} to={linkParam.to}
              className={'list-group-item' + (linkParam.id === props.active ? ' active' : '') }
        >{linkParam.description}</Link>
    );

    return (
        <div className='col-md-3'>
            <div className='list-group'>
                {links}
            </div>
        </div>
    );
};

Menu.propTypes = {
    active: React.PropTypes.number
};

export default Menu;