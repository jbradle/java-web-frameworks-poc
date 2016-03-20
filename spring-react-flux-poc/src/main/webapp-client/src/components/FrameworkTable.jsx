import React from "react";

const FrameworkTable = (props) => {
    
    let frameworks = props.frameworks.map(framework =>
        <tr key={framework.id}>
            <td>{framework.name}</td>
            <td>{framework.category.name}</td>
            <td>
                <a href={framework.documentationLink}>
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
    items: React.PropTypes.array
};

export default FrameworkTable;