import React from "react";
import {Link} from "react-router";

const Menu = (props) => {

    let links = props.linkParams.map(linkParam =>
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
    active: React.PropTypes.number,
    linkParams: React.PropTypes.array
};

export default Menu;