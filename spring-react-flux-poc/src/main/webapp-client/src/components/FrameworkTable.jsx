import React from "react";

const FrameworkTable = (props) => {

    let frameworks = props.items.map(item =>
        <tr>
            <td>Spring Web MVC</td>
            <td>Web Layer</td>
            <td>
                <a href="http://docs.spring.io/spring/docs/current/spring-framework-reference/html/beans.html">
                    <i className="fa fa-arrow-right fa-2x"/>
                </a>
            </td>
            <td>
                <a href="detail.html" title="Detail">
                    <i className="fa fa-folder-open fa-2x"/>
                </a>
                <a href="#" title="Edit">
                    <i className="fa fa-edit fa-2x"/>
                </a>
                <a href="#" title="Remove">
                    <i className="fa fa-remove fa-2x"/>
                </a>
            </td>
        </tr>
    );
    
    return (
        <table className="table table-hover">
            <thead>
            <tr>
                <th>Name</th>
                <th>Category</th>
                <th>Docs</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            {frameworks}
            </tbody>
        </table>
    );
};

FrameworkTable.propTypes = {
    loading: React.PropTypes.bool,
    items: React.PropTypes.array
};

export default FrameworkTable;